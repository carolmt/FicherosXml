    import java.nio.file.Path;
    import java.util.ArrayList;
    import java.util.List;
    import java.util.Scanner;

    public class Main {
        public static void main(String[] args) {
            int opcion = 6;
            Scanner reader = new Scanner(System.in);
            Path ruta = Path.of(".", "src", "main","resources", "archivolibros.json");
            List<Book> libros = new ArrayList<>();

            libros.add(new Book("9788408096375", "El alquimista", "Paulo Coelho", 192, 1988));
            libros.add(new Book("9788408004349", "Marina","Carlos Ruiz Zafon", 304, 2012));
            libros.add(new Book("9788467593945", "Campo de fresas","Jordi Sierra I Fabra", 136, 2017));

            GestionBook.escribirListaBookJSON(libros, ruta);

            do  {
                opcion = GestionBook.menu();

                switch (opcion) {
                    case 1:
                        System.out.print("ISBN: ");
                        String isbn = reader.nextLine();
                        System.out.print("Título: ");
                        String titulo = reader.nextLine();
                        System.out.print("Autor: ");
                        String autor = reader.nextLine();
                        System.out.print("Número de páginas: ");
                        int num_pags = reader.nextInt();
                        System.out.print("Año: ");
                        int anyo = reader.nextInt();
                        reader.nextLine();

                        Book nuevoLibro = new Book(isbn, titulo, autor, num_pags, anyo);
                        libros.add(nuevoLibro);

                        GestionBook.escribirListaBookJSON(libros, ruta);
                        System.out.println("Libro añadido.");
                        break;

                    case 2:
                        System.out.print("Ingrese el título del libro a buscar: ");
                        String tituloBuscado = reader.nextLine();

                        GestionBook.buscarLibroPorTitulo(libros, tituloBuscado);
                        break;

                    case 3:
                        System.out.print("Ingrese el autor del libro a buscar: ");
                        String autorBuscado = reader.nextLine();

                        GestionBook.buscarLibroPorAutor(libros, autorBuscado);
                        break;

                    case 4:
                        System.out.println("Lista de libros:");
                        for (Book libro : libros) {
                            System.out.println(libro);
                        }
                        break;

                    case 0:
                        List<Book>libros_de_json = GestionBook.devuelveArrayObjetosJson(ruta);
                        libros_de_json.forEach(System.out::println);
                        System.out.println("Fin del programa.");
                        break;

                    default:
                        System.out.println("Opción no válida. Inténtalo de nuevo.");
                }
            }while(opcion != 0);
        }

    }
