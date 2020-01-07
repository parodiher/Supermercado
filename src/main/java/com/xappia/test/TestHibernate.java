package com.xappia.test;

import com.xappia.entities.Carrito;
import com.xappia.entities.Item;
import com.xappia.entities.Producto;
import com.xappia.entities.Usuario;
import com.xappia.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class TestHibernate {
    public static void main(String[] args) {
        Usuario user = new Usuario("Juan","Perez","juankpo@gmail.com","juancito10",null);
        Producto prod = new Producto("Pescado",350);
        /* Producto prod2 = new Producto("TV",22000);
        Producto prod3 = new Producto("Ojo de bife",500); */

        Carrito carr = new Carrito();
        carr.setUsuario(user);

        Item item = new Item();
        item.setCarrito(carr);
        item.setProducto(prod);
        item.setCantidad(8);

        carr.getItems().add(item);

        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session=sf.openSession();

        Transaction tx = session.beginTransaction();

        try {
            session.save(prod);
            session.save(carr);
            session.save(item);
            tx.commit();
        } catch (Exception e) {
            System.out.println(e);
            tx.rollback();
        }


        session.close();
        sf.close();
    }
}
