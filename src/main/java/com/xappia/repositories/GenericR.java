package com.xappia.repositories;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public abstract class GenericR<E> {
    protected Session session;
    protected Class clazz;

    public GenericR(Session session,Class clazz) {
        this.session = session;
        this.clazz=clazz;
    }

    public void save(E e){
        if(e==null)return;
        Transaction tx=session.beginTransaction();
        try {
            session.save(e);
            tx.commit();
        } catch (Exception ex) {
            System.out.println(ex);
            tx.rollback();
        }
    }

    public void remove(E e){
        if(e==null)return;
        Transaction tx=session.beginTransaction();
        try {
            session.delete(e);
            tx.commit();
        } catch (Exception ex) {
            System.out.println(ex);
            tx.rollback();
        }
    }

    public void update(E e){
        if(e==null)return;
        Transaction tx=session.beginTransaction();
        try {
            session.update(e);
            tx.commit();
        } catch (Exception ex) {
            System.out.println(ex);
            tx.rollback();
        }
    }

    public E getById(int id){
        return (E)session.get(clazz,id);
    }

    public List<E> getAll(){
        return session.createQuery("from "+clazz.getName()).list();
    }

    public List<E> getByFiltro(String filtro){
        return session.createQuery("from "+clazz.getName()+" where "+filtro).list();
    }
}
