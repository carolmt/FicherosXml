import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class main {
    public static void main (String[] args)  {
        Path ruta = Path.of(".", "src", "main","resources", "atletas_femeninas.xml");
        gestionAtletas gestion = new gestionAtletas();
        List<AtletaFemenina>atletas = new ArrayList<AtletaFemenina>();
        ListaAtletas listaAtletas = new ListaAtletas(atletas);

        atletas.add(new AtletaFemenina("Sandra", "España", 22, List.of("Nadar")));
        atletas.add(new AtletaFemenina("Andrea", "Rumanía", 24, List.of("Nadar", "Salto de altura")));
        atletas.add(new AtletaFemenina("Paola", "Francia", 25, List.of("500 metros")));

        gestionAtletas.escribirListaObjetosXml(listaAtletas, ruta);

        List<AtletaFemenina>atletas_de_xml = new ArrayList<AtletaFemenina>();

        atletas_de_xml = gestion.devuelveListaObjetosXml(ruta);
        atletas_de_xml.forEach(System.out::println);
    }
}
