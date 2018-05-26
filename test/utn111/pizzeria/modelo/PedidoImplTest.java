import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

import utn111.pizzeria.modelo.ClienteDao;
import utn111.pizzeria.modelo.Pedido;
import utn111.pizzeria.modelo.PedidoImpl;
import utn111.pizzeria.modelo.PedidoImpl.ItemImpl;
import utn111.pizzeria.modelo.Pizza;
import utn111.pizzeria.modelo.PizzaDao;
import utn111.pizzeria.modelo.PizzaImpl;

public class PedidoImplTest {
  @Test
  public void testPedidoAlmacenaClienteCorrectamente() {

  }

  private PedidoImpl createPedido() {
    return new PedidoImpl();
  }

  private ClienteDao createDao() {
    ClienteDao clienteDao = new ClienteDao();
    clienteDao.setNroCliente(11);
    clienteDao.setNombre("pepe");
    return clienteDao;
  }

  private Pedido.Item createItem(Pedido pedido, String tamaño, String nombre, int cantidad){
    PizzaDao pizzaDao = new PizzaDao();
    PizzaImpl pizza = new PizzaImpl(pizzaDao);
    return new ItemImpl(pedido, pizza, nombre, tamaño, cantidad);
  }

  private Date getDate(int minutesForConstructor){
    Calendar calendarDate = Calendar.getInstance();
    calendarDate.set(2000,Calendar.FEBRUARY,20,22,minutesForConstructor,20);
    return calendarDate.getTime();
  }
}