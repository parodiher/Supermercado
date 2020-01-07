package com.xappia.entities;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

public class ItemPK implements Serializable {
    private Carrito carrito;
    private Producto producto;

    @ManyToOne
    @JoinColumn(name="idCarrito")
    public Carrito getCarrito() {
        return carrito;
    }

    public void setCarrito(Carrito carrito) {
        this.carrito = carrito;
    }

    @ManyToOne
    @JoinColumn(name="idProducto")
    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemPK that = (ItemPK) o;
        if (carrito != null ? !carrito.equals(that.carrito) : that.carrito != null) return false;
        if (producto != null ? !producto.equals(that.producto) : that.producto != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        result = (carrito != null ? carrito.hashCode() : 0);
        result = 31 * result + (producto != null ? producto.hashCode() : 0);
        return result;
    }
}
