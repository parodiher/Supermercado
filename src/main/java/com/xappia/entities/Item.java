package com.xappia.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table (name="CarritoProducto")
@AssociationOverrides({
        @AssociationOverride( name = "pk.carrito",
                joinColumns = @JoinColumn( name = "idCarrito")),
        @AssociationOverride( name = "pk.producto",
                joinColumns = @JoinColumn( name = "idProducto"))
})
public class Item implements Serializable {

    private ItemPK pk= new ItemPK();
    private int cantidad;


    public Item() {
    }

    @EmbeddedId
    public ItemPK getPk() {
        return pk;
    }

    public void setPk(ItemPK pk) {
        this.pk = pk;
    }

    @Transient
    @Column (name="idCarrito")
    public Carrito getCarrito() {
        return getPk().getCarrito();
    }

    public void setCarrito(Carrito carrito) {
        getPk().setCarrito(carrito);
    }

    @Transient
    @Column (name="idProducto")
    public Producto getProducto() {
        return getPk().getProducto();
    }

    public void setProducto(Producto producto) {
        getPk().setProducto(producto);
    }

    @Column(name="Cantidad")
    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}


