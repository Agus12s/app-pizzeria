package utn111.pizzeria.modelo;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

public class PedidoImplTest {
  @Test
  public void testPedidoAlmacenaClienteCorrectamente() {
    ClienteDao clienteDao = new ClienteDao();
    ClienteImpl cliente = new ClienteImpl(clienteDao);
    PedidoImpl pedido = createAndSetPedidoImpl(cliente);
    assertSame(cliente, pedido.getCliente());
  }

  public void testGetTiempoEstimadoDeEspera() {
    //FIXME agregar codigo junto al contenido del metodo getTiempoEstimadoEspera()
  }

  @Test
  public void testPedidoAlmacenaFechaPedidoRealizadoCorrectamente() {
    Date pedidoALas = getDate(10);
    Date entregadoALas = getDate(40);
    PedidoImpl pedido = createAndSetPedidoImpl(pedidoALas, entregadoALas);
    assertSame(pedidoALas, pedido.getPedidoALas());
  }

  @Test
  public void testPedidoAlmacenaFechaEntregadoCorrectamente() {
    Date pedidoALas = getDate(10);
    Date entregadoALas = getDate(40);
    PedidoImpl pedido = createAndSetPedidoImpl(pedidoALas, entregadoALas);
    assertSame(entregadoALas, pedido.getEntregadoALas());
  }

  @Test
  public void testPedidoAlmacenaTodosLosItems() {
    PedidoImpl pedido = null;
    Pedido.Item[] items = createItems(pedido);
    pedido = createAndSetPedidoImpl(items);
    assertEquals(items.length, pedido.getItems().length);
    assertSame(items, pedido.getItems());
  }

  private PedidoImpl createAndSetPedidoImpl(Date pedidoALas, Date entregadoALas) {
    ClienteImpl cliente = new ClienteImpl(createDao());
    PedidoImpl pedido = null;
    pedido = new PedidoImpl(cliente, pedidoALas, entregadoALas, Pedido.Estado.PEDIDA, createItems(pedido));
    return pedido;
  }

  private PedidoImpl createAndSetPedidoImpl(Pedido.Item[] items){
    ClienteImpl cliente = new ClienteImpl(createDao());
    Date pedidoALas = getDate(10);
    Date entregadoALas = getDate(40);
    PedidoImpl pedido = null;
    pedido = new PedidoImpl(cliente, pedidoALas, entregadoALas, Pedido.Estado.PEDIDA, items);
    return pedido;
  }

  private PedidoImpl createAndSetPedidoImpl(){
    ClienteImpl cliente = new ClienteImpl(createDao());
    Date pedidoALas = getDate(10);
    Date entregadoALas = getDate(40);
    PedidoImpl pedido = null;
    pedido = new PedidoImpl(cliente, pedidoALas, entregadoALas, Pedido.Estado.PEDIDA, createItems(pedido));
    return pedido;
  }

  private PedidoImpl createAndSetPedidoImpl(ClienteImpl cliente){
    Date pedidoALas = getDate(10);
    Date entregadoALas = getDate(40);
    PedidoImpl pedido = null;
    pedido = new PedidoImpl(cliente, pedidoALas, entregadoALas, Pedido.Estado.PEDIDA, createItems(pedido));
    return pedido;
  }

  private ClienteDao createDao() {
    ClienteDao clienteDao = new ClienteDao();
    clienteDao.setNroCliente(11);
    clienteDao.setNombre("pepe");
    return clienteDao;
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