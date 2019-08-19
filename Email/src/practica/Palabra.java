package practica;

/**
 *
 * @authors Stefan Dimitrov & Felix Aguilar
 */
public class Palabra {

    private final char blanc = ' ';
    private int longitud;
    private char[] letras;
    private int idx;

    public Palabra() {
        longitud = 0;
        idx = 0;
        letras = new char[20];
    }

    public Palabra(int larg) {
        longitud = larg;
        letras = new char[larg];
    }

    public void leerPalabra(char[] lin, int ind) {
        idx = ind;
        saltarEspacios(lin);
        for (longitud = 0; idx < lin.length && longitud < letras.length && lin[idx] != ' '; idx++, longitud++) {
            letras[longitud] = lin[idx];
        }
    }

    public void saltarEspacios(char[] linea) {
        while (linea[idx] == blanc && idx < linea.length) {
            idx++;
        }
    }

    public int getLongitud() {
        return longitud;
    }

    public void setLongitud(int longitud) {
        this.longitud = longitud;
    }

    public char[] getLetras() {
        return letras;
    }

    public void setLetras(char[] letras) {
        this.letras = letras;
    }

    public int getIdx() {
        return idx;
    }

    public void setIdx(int idx) {
        this.idx = idx;
    }

    public boolean palabrasIguales(Palabra p) {
        if(p.getLongitud() != this.longitud){
            return false;
        } else {
            for(int ind = 0; ind < this.longitud; ind++) {
                if (this.letras[ind] != p.letras[ind]) {
                    return false;
                }
            }
            return true;
        }
    }
}
