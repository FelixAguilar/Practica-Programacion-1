package practica;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @authors Stefan Dimitrov & Felix Aguilar
 */
public class Fichero {

    private final String endLine = System.getProperty("line.separator");
    private FileReader input;
    private BufferedReader reader;
    private FileWriter output;
    private BufferedWriter writer;

    public Fichero(String nom, boolean leerNoEscribir) throws IOException {
        if (leerNoEscribir) {
            input = new FileReader(nom);
            reader = new BufferedReader(input);
        } else if (!leerNoEscribir) {
            output = new FileWriter(nom);
            writer = new BufferedWriter(output);
        }
    }

    public char[] leerLinea() throws IOException {
        char[] lin = null;
        String linea = " ";
        linea = reader.readLine();
        if (linea != null) {
            lin = linea.toCharArray();
        }
        return lin;
    }

    public void crearFichero(Cliente cli, Carta card) throws IOException {
        writer.write("EMPRESA Zombotech" + endLine
                + "Av. Alexandre Rossello, 20" + endLine
                + "07002 PALMA DE MALLORCA" + endLine
                + "NIF: F12345678" + endLine);
        writer.write(endLine + escribirCliente(cli) + endLine);
        Date fecha = new Date();
        SimpleDateFormat dateF = new SimpleDateFormat();
        String fechaSys = dateF.format(fecha);
        writer.write(endLine + fechaSys + endLine);
        writer.write(endLine + escribirCarta(card) + endLine);
    }

    public void cerrarL() throws IOException {
        reader.close();
        input.close();
    }

    public void cerrarE() throws IOException {
        writer.close();
        output.close();
    }

    public String escribirCliente(Cliente cli) {
        return cli.getNombre() + endLine + cli.getDireccion();
    }

    public String escribirCarta(Carta card) throws IOException {
        String nom = "";
        for (int ind = 0; ind < card.getTipo().getLongitud(); ind++) {
            nom = nom + card.getTipo().getLetras()[ind];
        }
        nom = nom + ".txt";
        Fichero fcarta = new Fichero(nom, true);
        String carta = "";
        int valor = fcarta.reader.read();
        while (valor != -1) {
            char c = (char) valor;
            carta = carta + c;
            valor = fcarta.reader.read();
        }
        fcarta.cerrarL();
        return carta;
    }
}
