package practica;

import java.io.IOException;

/**
 *
 * @authors Stefan Dimitrov & Felix Aguilar
 */
public class Practica {

    public void inicio() {
        try {
            Presentacion();
            Fichero in = new Fichero("Entrada.txt",true);
            char[] lineaE = in.leerLinea();
            while (lineaE != null) {
                Carta car = new Carta();
                Cliente cli = new Cliente();
                Fichero client = new Fichero("Clientes.txt",true);
                char[] linCli = client.leerLinea();
                boolean encontrado = false;
                while (linCli != null && encontrado == false) {
                    if (car.getCodigo(lineaE).palabrasIguales(cli.getCodigo(linCli))) {
                        cli.getCliente(linCli);
                        Fichero salida = new Fichero(cli.getNombre()+".txt",false);
                        salida.crearFichero(cli,car);
                        encontrado = true;
                        salida.cerrarE();
                    }
                    linCli = client.leerLinea();
                }
                if (encontrado = false) {
                    System.out.println("No ha sido encontrado ningún cliente con tal código.");
                }
                client.cerrarL();
                lineaE = in.leerLinea();
            }
            in.cerrarL();
        } catch (IOException ex) {
            System.out.println("No ha sido encontrado ningún fichero con este nombre.");
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Practica e = new Practica();
        e.inicio();
    }

    private void Presentacion() {
        System.out.println("Buenos días, esta es nuestra práctica de fin de curso."
                + "\nA continuación, se crearán los ficheros (uno para cada cliente)"
                + " en la carpeta del proyecto.");
    }
}
