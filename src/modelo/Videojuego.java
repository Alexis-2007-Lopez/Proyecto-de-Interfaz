package modelo;
public class Videojuego {

    private String nombre;
    private String genero;
    private String plataforma;
    private String enLinea;

    public Videojuego(String nombre,
                      String genero,
                      String plataforma,
                      String enLinea) {

        this.nombre = nombre;
        this.genero = genero;
        this.plataforma = plataforma;
        this.enLinea = enLinea;
    }

    public String getNombre() {
        return nombre;
    }

    public String getGenero() {
        return genero;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public String getEnLinea() {
        return enLinea;
    }
}
