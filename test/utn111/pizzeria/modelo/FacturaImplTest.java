package utn111.pizzeria.modelo;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

public class FacturaImplTest {
  @Test
  public void testFacturaAlmacenaPedidoCorrectamente(){
    PedidoImpl pedido = createAndSetPedidoImpl(1);
    FacturaImpl factura = createFacturaImpl(pedido);
    assertSame(pedido, factura.getPedido());
  }

  @Test
  public void testFacturaAlmacenaNumeroClienteDaoCorrectamente(){
    FacturaDao facturaDao = createAndSetFacturaDao(200, 1);
    FacturaImpl factura = createFacturaImpl(facturaDao);
    assertEquals(1, factura.getPedido().getCliente().getNroCliente());
  }

  @Test
  public void testFacturaAlmacenaTotal() {
    FacturaImpl factura = createFacturaImpl();
    assertEquals(200, factura.getTotal(), 0);
  }

  @Test
  public void testFacturaAlmacenaFechaDeCompraCorrectamente(){
    //FIXME agregar codigo para comparar fechas.
  }

  private FacturaImpl createFacturaImpl() {
    FacturaDao facturaDao = createAndSetFacturaDao(200, 1);
    PedidoImpl pedido = createAndSetPedidoImpl(1);
    return new FacturaImpl(facturaDao, pedido);
  }

  private FacturaImpl createFacturaImpl(FacturaDao facturaDao) {
    PedidoImpl pedido = createAndSetPedidoImpl(1);
    return new FacturaImpl(facturaDao, pedido);
  }

  private FacturaImpl createFacturaImpl(PedidoImpl pedido) {
    FacturaDao facturaDao = createAndSetFacturaDao(200, 1);
    return new FacturaImpl(facturaDao, pedido);
  }

  private FacturaDao createAndSetFacturaDao(float total, int pedido){
    FacturaDao facturaDao = new FacturaDao();
    facturaDao.setTotal(total);
    facturaDao.setPedido(pedido);
    return facturaDao;
  }

  private PedidoImpl createAndSetPedidoImpl(int numeroCliente){
    ClienteDao clienteDao = new ClienteDao();
    clienteDao.setNroCliente(1);
    ClienteImpl cliente = new ClienteImpl(clienteDao);
    Date pedidoALas = getDate(10);
    Date entregadoALas = getDate(40);
    PedidoImpl pedido = new PedidoImpl(cliente, pedidoALas, entregadoALas, Pedido.Estado.PEDIDA);
    pedido.setItems(createItems(pedido));
    return pedido;
  }

  private Date getDate(int minutesForConstructor){
    Calendar calendarDate = Calendar.getInstance();
    calendarDate.set(2000,Calendar.FEBRUARY,20,22,minutesForConstructor,20);
    return calendarDate.getTime();
  }

  private Pedido.Item[] createItems(Pedido pedido){
    List<Pedido.Item> itemList = new ArrayList<>(1);
    PizzaDao pizzaDao = new PizzaDao();
    pizzaDao.setId(10);
    pizzaDao.setNombre("muzzarella");
    itemList.add(new PedidoImpl.ItemImpl(pedido, new PizzaImpl(pizzaDao), "pequeña", 4));
    return itemList.toArray(new Pedido.Item[1]);
  }
}