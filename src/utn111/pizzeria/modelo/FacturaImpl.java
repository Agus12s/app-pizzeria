package utn111.pizzeria.modelo;

import java.util.Date;

public class FacturaImpl implements Factura {
  private FacturaDao factura;
  private ClienteDao clienteDao;

  public FacturaImpl(FacturaDao factura, ClienteDao clienteDao) {
    this.factura = factura;
    this.clienteDao = clienteDao;
  }

  @Override
  public Cliente getCliente() {
    return new ClienteImpl(clienteDao);
  }

  @Override
  public Pedido getPedido() {
    return new PedidoImpl();
  }

  @Override
  public Date getFechaDeCompra() {
    return null;
  }

  @Override
  public float getTotal() {
    return factura.getTotal();
  }
}
