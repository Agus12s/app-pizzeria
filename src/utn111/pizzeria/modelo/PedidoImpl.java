package utn111.pizzeria.modelo;

import java.time.Duration;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class PedidoImpl implements Pedido {
  private ClienteImpl cliente;
  private Date pedidoALas;
  private Date entregadoALas;
  private Estado estado;
  private Item[] items;

  public PedidoImpl(ClienteImpl cliente, Date pedidoALas, Date entregadoALas, Estado estado) {
    this.cliente = cliente;
    this.pedidoALas = pedidoALas;
    this.entregadoALas = entregadoALas;
    this.estado = estado;
  }

  public void setItems(Item[] items) {
    this.items = items;
  }

  @Override
  public Cliente getCliente() {
    return cliente;
  }

  @Override
  public Item[] getItems() {
    return items;
  }

  @Override
  public Date getPedidoALas() {
    return pedidoALas;
  }

  @Override
  public Date getEntregadoALas() {
    return entregadoALas;
  }

  @Override
  public Duration getTiempoEstimadoEspera() {
    //FIXME AGREGAR CODIGO.
    return null;
  }

  @Override
  public Duration getTiempoTotalEspera() {
    long diffInMillies = Math.abs(entregadoALas.getTime() - pedidoALas.getTime());
    long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
    return Duration.ofDays(diff);
  }

  @Override
  public Estado getEstado() {
    return estado;
  }

  public static class ItemImpl implements Pedido.Item {
    private Pedido pedido;
    private Pizza pizza;
    private String tamaño;
    private int cantidad;

    public ItemImpl(Pedido pedido, Pizza pizza, String tamaño, int cantidad) {
    }

    @Override
    public Pedido getPedido() {
      return pedido;
    }

    @Override
    public Pizza getPizza() {
      return pizza;
    }

    @Override
    public String getNombrePizza() {
      return pizza.getNombre();
    }

    @Override
    public String getTamaño() {
      return tamaño;
    }

    @Override
    public int getCantidad() {
      return cantidad;
    }
  }
}