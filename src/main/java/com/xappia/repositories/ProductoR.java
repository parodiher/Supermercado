package com.xappia.repositories;

import com.xappia.entities.Producto;
import org.hibernate.Session;

import java.util.List;

public class ProductoR<E> extends GenericR<E> {

    public ProductoR(Session session){
        super(session, Producto.class);
    }

    public List<Producto> getByNombre(String nombre){
        String filtro ="nombre='"+nombre+"'";
        return (List<Producto>)getByFiltro(filtro);
    }

    public List<Producto> getLikeNombre(String nombre){
        String filtro = "nombre='" + nombre + "'";
        return (List<Producto>)getByFiltro(filtro);
    }

    public List<Producto> getPrecioMayorIgual(float precio){
        String filtro = "precio >= '" + precio + "'";
        return (List<Producto>)getByFiltro(filtro);
    }

    public List<Producto> getPrecioMenorIgual(float precio){
        String filtro = "precio <= '" + precio + "'";
        return (List<Producto>)getByFiltro(filtro);
    }

}
