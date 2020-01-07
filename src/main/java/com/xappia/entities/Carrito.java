package com.xappia.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="Carrito")
public class Carrito {

    private int idCarrito;
    private String date;
    private Usuario usuario;
    private List<Item> items = new ArrayList<Item>();

    public Carrito() {
        LocalDate fecha = LocalDate.now();
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String strDate = fecha.format(dateFormat);
        this.date = strDate;
    }

    public Carrito(Usuario usuario, ArrayList<Item> items) {
        LocalDate fecha = LocalDate.now();
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String strDate = fecha.format(dateFormat);
        this.date = strDate;
        this.usuario = usuario;
        this.items=items;
    }

    public Carrito(int idCarrito,Usuario usuario,ArrayList<Item> items) {
        LocalDate fecha = LocalDate.now();
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String strDate = fecha.format(dateFormat);
        this.idCarrito=idCarrito;
        this.date = strDate;
        this.usuario = usuario;
        this.items=items;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idCarrito")
    public int getIdCarrito() {
        return idCarrito;
    }

    public void setIdCarrito(int idCarrito) {
        this.idCarrito = idCarrito;
    }

    @Column(name="fecha")
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @ManyToOne (cascade = CascadeType.ALL)
    @JoinColumn(name="idUsuario")
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario=usuario;
    }

    @OneToMany(mappedBy = "pk.carrito")
    public List<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }
}
