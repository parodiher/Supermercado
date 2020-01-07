package com.xappia.repositories;

import com.xappia.entities.Carrito;
import com.xappia.entities.Item;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class CarritoR{
    private Session session;

    public CarritoR(Session session){
        this.session=session;
    }

    public void save(Carrito carrito){
        if(carrito==null)return;
        Transaction tx=session.beginTransaction();
        try {
            session.save(carrito);
            carrito.getItems().forEach(item -> session.save(item));
            tx.commit();
        } catch (Exception ex) {
            System.out.println(ex);
            tx.rollback();
        }
    }

    public void remove(Carrito carrito){
        if(carrito==null)return;
        Transaction tx=session.beginTransaction();
        try {
            session.delete(carrito);
            carrito.getItems().forEach(item -> session.delete(item));
            tx.commit();
        } catch (Exception ex) {
            System.out.println(ex);
            tx.rollback();
        }
    }

    public void update(Carrito carrito){
        if(carrito==null)return;
        Transaction tx=session.beginTransaction();
        try {
            session.update(carrito);
            carrito.getItems().forEach(item -> session.update(item));
            tx.commit();
        } catch (Exception ex) {
            System.out.println(ex);
            tx.rollback();
        }
    }

    public Carrito getById(int id){
        return session.get(Carrito.class,id);
    }

    public List<Carrito> getAll(){
        return session.createQuery("from "+Carrito.class.getName()).list();
    }

    public List<Carrito> getByFiltro(String filtro){
        return session.createQuery("from "+Carrito.class.getName()+" where "+filtro).list();
    }

    private List<Item> getItems(int idCarrito){
        List<Item> items= new ArrayList<Item>();
        String filtro="Carrito where idCarrito='"+idCarrito+"'";
        session.createQuery("from"+filtro)
                .getResultList()
                .forEach(item ->items.add(
                        session.get(Item.class, ((Item) item).getPk().getCarrito().getIdCarrito()
                        )));
        return items;
    }

    public List<Item> getItems(Carrito carrito){
        return getItems(carrito.getIdCarrito());
    }



}
