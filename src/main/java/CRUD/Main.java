package CRUD;

import spark.Spark;
import static spark.Spark.staticFiles;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.Version;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        staticFiles.location("/Templates");

        final Configuration configuration = new Configuration(new Version(2, 3, 0));
        configuration.setClassForTemplateLoading(Main.class, "/");

        ArrayList<Estudiante> listaDeEstudiantes = new ArrayList<Estudiante>();
        Spark.get("/", (request, response) -> {
            Template plantillaPaginaInicio = configuration.getTemplate("Templates/Inicio.ftl");
            StringWriter writer = new StringWriter();

            Map<String, Object> attributes = new HashMap<>();
            attributes.put("listaDeEstudiantes", listaDeEstudiantes);
            attributes.put("tamanoLista", listaDeEstudiantes.size() > 0);
            plantillaPaginaInicio.process(attributes, writer);
            return writer;
        });

        Spark.get("/Agregar", (request, response) -> {
            Template plantillaPaginaInicio = configuration.getTemplate("Templates/agregarEstudiante.ftl");
            return plantillaPaginaInicio;
        });

        Spark.post("/AgregarALaListadeEstudiantes", (request, response) -> {
            StringWriter writer = new StringWriter();
            try {
                String matricula = request.queryParams("matricula");
                String nombre = request.queryParams("nombre");
                String apellido = request.queryParams("apellido");
                String telefono = request.queryParams("telefono");
                listaDeEstudiantes.add(new Estudiante(Integer.parseInt(matricula), nombre, apellido, telefono));
                response.redirect("/");
            }catch (Exception e){
                System.out.println(e);
                response.redirect("/Agregar");
            }
            return writer;
        });

        Spark.get("/EliminarDeLaListaDeEstudiantes/:id", (request, response) -> {
            StringWriter writer = new StringWriter();
            int id = Integer.parseInt(request.params("id"));

            listaDeEstudiantes.remove(id);
            response.redirect("/");
            return writer;
        });

        Spark.get("/Modificar/:id", (request, response) -> {
            Template resultTemplate = configuration.getTemplate("Templates/modificarEstudiante.ftl");
            StringWriter writer = new StringWriter();

            int id = Integer.parseInt(request.params("id"));

            Map<String, Object> atributos = new HashMap<>();
            atributos.put("EstudianteX", listaDeEstudiantes.get(id));

            resultTemplate.process(atributos, writer);
            return writer;
        });

        Spark.post("/ModificarEnLaListaDeEstudiantes", (request, response) -> {
            StringWriter writer = new StringWriter();

            try {
                String matricula = request.queryParams("matricula");
                String nombre = request.queryParams("nombre");
                String apellido = request.queryParams("apellido");
                String telefono = request.queryParams("telefono");
                Estudiante estudiante = new Estudiante(Integer.parseInt(matricula), nombre, apellido, telefono);
                for (Estudiante estudianteX: listaDeEstudiantes)
                {
                    if(estudianteX.getMatricula() == estudiante.getMatricula())
                    {
                        estudianteX.setNombre(estudiante.getNombre());
                        estudianteX.setApellido(estudiante.getApellido());
                        estudianteX.setMatricula(estudiante.getMatricula());
                        estudianteX.setTelefono(estudiante.getTelefono());
                        break;
                    }
                }
                response.redirect("/");
            }catch (Exception e){
                System.out.println("Hubo un error en la modificacion del estudiante " + e.toString());
                response.redirect("/");
            }
            return writer;
        });

        Spark.get("/VisualizarEstudiante/:id", (request, response) -> {
            Template resultTemplate = configuration.getTemplate("Templates/verEstudiante.ftl");
            StringWriter writer = new StringWriter();

            int id = Integer.parseInt(request.params("id"));

            Map<String, Object> atributos = new HashMap<>();
            atributos.put("EstudianteX", listaDeEstudiantes.get(id));

            resultTemplate.process(atributos, writer);
            return writer;
        });
    }
}


