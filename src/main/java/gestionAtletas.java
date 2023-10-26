import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public class gestionAtletas {
    public static void escribirListaObjetosXml(ListaAtletas listaAtletas, Path ruta)  { //Mapear la lista de objetos AtletaFemenina a un archivo XML llamado atletas_femeninas.xml
     try {
            XmlMapper xmlMapper = new XmlMapper();
            // La siguiente línea es opcional, pero hace que el JSON se muestre con formato
            xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);
            xmlMapper.writeValue(ruta.toFile(), listaAtletas);
        } catch (IOException e) {
            System.out.println("El fichero no existe");
        }
    }

    public static List<AtletaFemenina> devuelveListaObjetosXml(Path ruta) {
        try {
            XmlMapper xmlMapper = new XmlMapper();
            return xmlMapper.readValue(ruta.toFile(), new TypeReference<List<AtletaFemenina>>() { });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
