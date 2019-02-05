package CRUD;

import CRUD.usuario.ServicioUsuario;
import CRUD.usuario.Usuario;
import com.fasterxml.jackson.databind.ObjectMapper;

import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;
import static spark.Spark.put;
import static spark.Spark.delete;
import java.util.List;




public class Main {

        private static ServicioUsuario usuarioServicio = new ServicioUsuario();
        private static ObjectMapper om = new ObjectMapper();

        public static void main(String[] args) {

            // Start embedded server at this port
            port(8080);

            // Main Page, welcome
            get("/", (request, response) -> "Bienvenido");

            // POST - Add an user
            post("/usuario/add", (request, response) -> {

                String nombre = request.queryParams("nombre");
                String correo = request.queryParams("correo");
                Usuario usuario = usuarioServicio.add(nombre, correo);
                response.status(201); // 201 Created
                return om.writeValueAsString(usuario);

            });

            // GET - Give me user with this id
            get("/usuario/:id", (request, response) -> {
                Usuario usuario = usuarioServicio.findById(request.params(":id"));
                if (usuario != null) {
                    return om.writeValueAsString(usuario);
                } else {
                    response.status(404); // 404 Not found
                    return om.writeValueAsString("usuario no encontrado");
                }
            });

            // Get - Give me all users
            get("/usuario", (request, response) -> {
                List result = usuarioServicio.findAll();
                if (result.isEmpty()) {
                    return om.writeValueAsString("usuario no encontrado");
                } else {
                    return om.writeValueAsString(usuarioServicio.findAll());
                }
            });

            // PUT - Update user
            put("/usuario/:id", (request, response) -> {
                String id = request.params(":id");
                Usuario user = usuarioServicio.findById(id);
                if (user != null) {
                    String name = request.queryParams("name");
                    String email = request.queryParams("email");
                    usuarioServicio.update(id, name, email);
                    return om.writeValueAsString("usuario con id" + id + " fue actualizado!");
                } else {
                    response.status(404);
                    return om.writeValueAsString("usuario no encontrado");
                }
            });

            // DELETE - delete user
            delete("/usuario/:id", (request, response) -> {
                String id = request.params(":id");
                Usuario usuario = usuarioServicio.findById(id);
                if (usuario != null) {
                    usuarioServicio.delete(id);
                    return om.writeValueAsString("usuario con id " + id + " fue eliminado!");
                } else {
                    response.status(404);
                    return om.writeValueAsString("usuario no encontrado");
                }
            });

        }

}


