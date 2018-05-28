package utn111.pizzeria.modelo;

import java.util.Date;

public class FacturaImpl implements Factura {
  private FacturaDao factura;
  private PedidoImpl pedido;

  public FacturaImpl(FacturaDao factura, PedidoImpl pedido) {
    this.factura = factura;
    this.pedido = pedido;
  }

  @Override
  public Cliente getCliente() {
    return pedido.getCliente();
  }

  @Override
  public Pedido getPedido() {
    return pedido;
  }

  @Override
  public Date getFechaDeCompra() {
    return pedido.getPedidoALas();
  }

  @Override
  public float getTotal() {
    return factura.getTotal();
  }
}
