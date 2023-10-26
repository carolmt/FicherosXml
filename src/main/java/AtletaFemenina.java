
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.io.Serializable;
import java.util.List;
public class AtletaFemenina implements Serializable {
    private String nombre;
    private int edad;
    private String pais_origen;
    @JacksonXmlElementWrapper(localName = "pruebas")
    @JacksonXmlProperty(localName = "prueba")
    private List<String>pruebas;

    public AtletaFemenina(String nombre, String pais_origen, int edad, List<String> pruebas) {
        this.nombre = nombre;
        this.pais_origen = pais_origen;
        this.edad = edad;
        this.pruebas = pruebas;
    }
    public AtletaFemenina() {

    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPais_origen() {
        return pais_origen;
    }

    public void setPais_origen(String pais_origen) {
        this.pais_origen = pais_origen;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public List<String> getPruebas() {
        return pruebas;
    }

    public void setPruebas(List<String> pruebas) {
        this.pruebas = pruebas;
    }

    @Override
    public String toString() {
        return "AtletaFemenina{" +
                "nombre='" + nombre + '\'' +
                ", pais_origen='" + pais_origen + '\'' +
                ", edad=" + edad +
                ", pruebas=" + pruebas +
                '}';
    }
}