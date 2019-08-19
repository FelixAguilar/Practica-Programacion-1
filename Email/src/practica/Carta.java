package practica;

/**
 *
 * @authors Stefan Dimitrov & Felix Aguilar
 */
public class Carta {

    private Palabra tipo;
    private Palabra codigo;

    public Carta() {
        tipo = new Palabra();
        codigo = new Palabra();
    }

    public void sacarTipo(char[] lin) {
        tipo.leerPalabra(lin, 0);
    }

    public Palabra getCodigo(char[] linea) {
        sacarTipo(linea);
        codigo.leerPalabra(linea,tipo.getLongitud());
        return codigo;
    }

    public Palabra getTipo() {
        return tipo;
    }
}
