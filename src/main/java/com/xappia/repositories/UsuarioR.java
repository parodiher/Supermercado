package com.xappia.repositories;

import com.xappia.entities.Carrito;
import com.xappia.entities.Usuario;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class UsuarioR<E> extends GenericR<E> {

    public UsuarioR(Session session){
        super(session, Usuario.class);
    }

    public List<Usuario> getByNombre(String nombre){
        String filtro ="nombre='"+nombre+"'";
        return (List<Usuario>)getByFiltro(filtro);
    }

    public List<Usuario> getByApellido(String apellido){
        String filtro ="apellido='"+apellido+"'";
        return (List<Usuario>)getByFiltro(filtro);
    }

    public List<Usuario> getLikeNombre(String nombre){
        String filtro ="nombre like'"+nombre+"'";
        return (List<Usuario>)getByFiltro(filtro);
    }

    /*public List<Usuario> getLikeApellido(String apellido){
        String filtro ="where apellido like '"+apellido+"'";
        return session.createQuery("from "+clazz.getName()+ filtro).list();
    }*/

    public List<Usuario> getLikeApellido(String apellido){
        String filtro="apellido like '"+apellido+"'";
        return (List<Usuario>) getByFiltro(filtro);
    }

    public List<Usuario> getByNombreApellido(String nombre, String apellido){
        String filtro ="nombre='"+nombre+
                        "' and  apellido='"+apellido+"'";
        return (List<Usuario>)getByFiltro(filtro);
    }

    public List<Usuario> getByEmail(String email){
        String filtro ="email='"+email+"'";
        return (List<Usuario>)getByFiltro(filtro);
    }

    public List<Usuario> getLikeEmail(String email){
        String filtro ="email like'"+email+"'";
        return (List<Usuario>)getByFiltro(filtro);
    }

    private List<Carrito> getCarritos(int idUsuario){
        List<Carrito> carritos= new ArrayList<Carrito>();
        String filtro="Carrito where idUsuario='"+idUsuario+"'";
        session.createQuery("from"+filtro)
                .getResultList()
                .forEach(item ->carritos.add(
                        session.get(Carrito.class, ((Carrito) item).getIdCarrito()
                        )));
        return carritos;
    }

    public List<Carrito> getCarritos(Usuario usuario){
        return getCarritos(usuario.getIdUsuario());
    }

    public boolean checkUserPass(String user, String pass){
        String filtro="usuario='"+ user + "' and password='"+pass+"'";
        boolean result=(getByFiltro(filtro)!=null) ? true : false;
        return result;
    }




}
