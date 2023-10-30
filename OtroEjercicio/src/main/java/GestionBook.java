import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

public class GestionBook {
    public GestionBook() {
    }
    public static int menu() {
        int opcion;
            Scanner reader = new Scanner(System.in);
            System.out.println("Menú de Libros:");
            System.out.println("1. Agregar un nuevo libro");
            System.out.println("2. Buscar libro por título");
            System.out.println("3. Buscar libro por autor");
            System.out.println("4. Ver la lista de todos los libros");
            System.out.println("0. Salir");
            System.out.print("Elije una opción: ");
            opcion = reader.nextInt();
            reader.nextLine();

        return opcion;
    }
    public static void escribirListaBookJSON(List<Book> libros, Path ruta) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
            System.out.println("Escribiendo en el archivo JSON...");
            objectMapper.writeValue(ruta.toFile(), libros);
            System.out.println("Escritura completa.");

        } catch (IOException e) {
            System.out.println("El fichero no existe");
        }
    }
    public static List<Book> devuelveArrayObjetosJson(Path ruta) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(ruta.toFile(), new TypeReference<List<Book>>() { });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void buscarLibroPorTitulo(List<Book> libros, String tituloBuscado) {
        boolean encontrado = false;
        for (Book libro : libros) {
            if (libro.getTitulo().equalsIgnoreCase(tituloBuscado)) {
                System.out.println(libro);
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("Libro no encontrado.");
        }
    }

    public static void buscarLibroPorAutor(List<Book> libros, String autorBuscado) {
        boolean encontrado = false;
        for (Book libro : libros) {
            if (libro.getAutor().equalsIgnoreCase(autorBuscado)) {
                System.out.println(libro);
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("Libro no encontrado.");
        }
    }
}
