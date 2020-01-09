package com.xappia.entities;


import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="Usuario")
public class Usuario implements Serializable {

    private int idUsuario;
    private String nombre;
    private String apellido;
    private String email;
    private String password;
    private List<Carrito> carritos = new ArrayList<Carrito>();

    public Usuario() {
    }

    public Usuario(int idUsuario,String nombre, String apellido, String email, String password,ArrayList<Carrito> carritos) {
        this.idUsuario=idUsuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.password = password;
        this.carritos=carritos;
    }

    public Usuario(String nombre, String apellido, String email, String password, ArrayList<Carrito> carritos) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.password = password;
        this.carritos=carritos;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name="idUsuario")
    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Column (name="nombre")
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Column (name="apellido")
    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Column (name="email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    @Column (name="password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @OneToMany
    public List<Carrito> getCarritos() {
        return (List<Carrito>) carritos;
    }

    public void setCarritos(List<Carrito> carritos) {
        this.carritos = carritos;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "idUsuario=" + idUsuario +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password+
                '}';
    }
}
