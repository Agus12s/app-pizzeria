package utn111.pizzeria.modelo.dao;

import java.util.Date;

public class Menues {

  private int pizza;
  private int tama�o;
  private float precio;
  private Date tiempo; // VERIFICAR TIPO DE DATO

  public Menues() {
  }

  public int getPizza() {
    return pizza;
  }

  public void setPizza(int pizza) {
    this.pizza = pizza;
  }

  public int getTama�o() {
    return tama�o;
  }

  public void setTama�o(int tama�o) {
    this.tama�o = tama�o;
  }

  public float getPrecio() {
    return precio;
  }

  public void setPrecio(float precio) {
    this.precio = precio;
  }

  public Date getTiempo() {
    return tiempo;
  }

  public void setTiempo(Date tiempo) {
    this.tiempo = tiempo;
  }
}
