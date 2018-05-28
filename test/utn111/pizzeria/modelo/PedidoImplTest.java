package utn111.pizzeria.modelo;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import utn111.pizzeria.modelo.ClienteDao;
import utn111.pizzeria.modelo.ClienteImpl;
import utn111.pizzeria.modelo.Pedido;
import utn111.pizzeria.modelo.PedidoImpl;
import utn111.pizzeria.modelo.PedidoImpl.ItemImpl;
import utn111.pizzeria.modelo.Pizza;
import utn111.pizzeria.modelo.PizzaDao;
import utn111.pizzeria.modelo.PizzaImpl;

import static org.junit.Assert.assertSame;

public class PedidoImplTest {
  @Test
  public void testPedidoAlmacenaClienteCorrectamente() {
    ClienteDao clienteDao = new ClienteDao();
    ClienteImpl cliente = new ClienteImpl(clienteDao);
    PedidoImpl pedido = createAndSetPedidoImpl(cliente);
    assertSame(cliente, pedido.getCliente());
  }

  private PedidoImpl createAndSetPedidoImpl(){
    ClienteDao clienteDao = new ClienteDao();
    ClienteImpl cliente = new ClienteImpl(clienteDao);
    Date pedidoALas = getDate(10);
    Date entregadoALas = getDate(40);
    PedidoImpl pedido = new PedidoImpl(cliente, pedidoALas, entregadoALas, Pedido.Estado.PEDIDA);
    pedido.setItems(createItems(pedido));
    return pedido;
  }

  private PedidoImpl createAndSetPedidoImpl(ClienteImpl cliente){
    Date pedidoALas = getDate(10);
    Date entregadoALas = getDate(40);
    PedidoImpl pedido = new PedidoImpl(cliente, pedidoALas, entregadoALas, Pedido.Estado.PEDIDA);
    pedido.setItems(createItems(pedido));
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