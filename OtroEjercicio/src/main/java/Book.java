import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;


import java.io.Serializable;
@JacksonXmlRootElement(localName = "libro")

public class Book implements Serializable {
    @JacksonXmlProperty(isAttribute = true)
    private String isbn;
    private String titulo;
    private String autor;
    private int num_pags;
    private int anyo;

    public Book(String isbn, String titulo, String autor, int num_pags, int anyo) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.num_pags = num_pags;
        this.anyo = anyo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getNum_pags() {
        return num_pags;
    }

    public void setNum_pags(int num_pags) {
        this.num_pags = num_pags;
    }

    public int getAnyo() {
        return anyo;
    }

    public void setAnyo(int anyo) {
        this.anyo = anyo;
    }

    @Override
    public String toString() {
        return "Book{" +
                "isbn='" + isbn + '\'' +
                ", titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", num_pags=" + num_pags +
                ", anyo=" + anyo +
                '}';
    }
}
