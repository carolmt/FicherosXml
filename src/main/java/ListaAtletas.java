import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.List;
@JacksonXmlRootElement(localName = "atletas_femeninas") //esto sirve para cambiar la etiqueta principal del xml
public class ListaAtletas {
    @JacksonXmlElementWrapper(useWrapping = false) //esto se tiene q poner si o si
    @JacksonXmlProperty(localName = "atleta")// sustituye item
    private List<AtletaFemenina> atletas;

    public ListaAtletas(List<AtletaFemenina> atletas) {
        this.atletas = atletas;
    }

    @Override
    public String toString() {
        return "ListaLenguajes{" +
                "lenguajes=" + atletas +
                '}';
    }
}

