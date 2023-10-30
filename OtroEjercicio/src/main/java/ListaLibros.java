import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.List;

@JacksonXmlRootElement(localName = "libros")
public class ListaLibros {
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "libro")
    private List<Book> libros;

    public ListaLibros(List<Book> libros) { this.libros = libros; }

}
