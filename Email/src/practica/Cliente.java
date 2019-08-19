package practica;


/**
 *
 * @authors Stefan Dimitrov & Felix Aguilar
 */
public class Cliente {

    private Palabra codigo;
    private char[] nombre;
    private char[] direccion;
    final int MAXNOM = 40;
    final int MAXDIR = 60;
    int idx;
    int longnombre;
    int longdireccion;
    
    public Cliente (){
        codigo = new Palabra();
        nombre = new char[MAXNOM];
        direccion = new char[MAXDIR];
        longnombre = 0;
        longdireccion = 0;
    }

    //Metodo sacar nombre cliente y otro sacar direccion.recorrido

    public String getNombre() {
        String n = "";
        for(int ind = 0; ind < longnombre; ind++){
            n = n + nombre[ind];
        }
        return n;
    }

    public void setNombre(char[] nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        String d = "";
        for(int ind = 0; ind < longdireccion; ind++){
            d = d + direccion[ind];
        }
        return d;
    }

    public void setDireccion(char[] direccion) {
        this.direccion = direccion;
    }

    public Palabra getCodigo(char[] linCli) {
        codigo.leerPalabra(linCli,0);
        return codigo;
    }
    
    public void sacarDatosCli(char[] linCli) {
        while (linCli[idx] != '#' && linCli[idx+1] != 'n') {
            idx++;
        }
        idx = idx + 3;
        int ind;
        for (ind = 0; linCli[idx+1] != '#' || linCli[idx+2] != 'd'; idx++,ind++) {
            nombre[ind] = linCli[idx];
            longnombre++;
        }
        idx = idx + 4;
        for (ind = 0; idx < linCli.length; idx++,ind++) {
            direccion[ind] = linCli[idx];
            longdireccion++;
        }
    }
    
    public void getCliente(char[] linCli) {
        idx = 0;
        sacarDatosCli(linCli);
    }
}
