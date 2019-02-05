package CRUD.usuario;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class ServicioUsuario {

    public static Map usuarios = new HashMap<>();
    private static final AtomicInteger count = new AtomicInteger(0);

    public Usuario findById(String id) {

        return (Usuario) usuarios.get(id);
    }

    public Usuario add(String nombre, String correo) {
        int id = count.incrementAndGet();
        Usuario usuario = new Usuario(id,nombre, correo);

        usuarios.put(String.valueOf(id), usuario);
        return usuario;
    }

    public Usuario update(String id, String nombre, String correo) {

        Usuario user = (Usuario) usuarios.get(id);
        if (nombre != null) {
            user.setNombre(nombre);
        }

        if (correo != null) {
            user.setCorreo(correo);
        }
        usuarios.put(id, user);

        return user;

    }


    public void delete(String id) {
        usuarios.remove(id);
    }

    public List findAll() {
        return new ArrayList<>(usuarios.values());
    }

    public ServicioUsuario() {
    }


}
