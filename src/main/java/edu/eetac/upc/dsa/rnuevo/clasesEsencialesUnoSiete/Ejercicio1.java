package edu.eetac.upc.dsa.rnuevo.clasesEsencialesUnoSiete;

import java.io.*;
import javax.swing.JFileChooser;
import java.lang.NumberFormatException;

public class Ejercicio1 {
	public static void main(String[] args) {
		File archivo = null;
		FileReader leer = null;
		BufferedReader leido = null;

		try {
			JFileChooser elegirArchivo = new JFileChooser();
			int respuesta = elegirArchivo.showOpenDialog(null);
			if (respuesta == JFileChooser.APPROVE_OPTION) {
				archivo = elegirArchivo.getSelectedFile();
			}
			leer = new FileReader(archivo);
			leido = new BufferedReader(leer);
			String linea;

			while ((linea = leido.readLine()) != null) {
				System.out.println(Integer.valueOf(linea));
			}

		} catch (NumberFormatException e) {
			System.out.println("El fichero contiene caracteres que no son numericos: " + e.getMessage());
		} catch (FileNotFoundException e) {
			System.out.println("No se puede encontrar el archivo especificado: "+ e.getMessage());
		} catch (IOException e) {
			System.out.println("No se puede leer el fichero: " + e.getMessage());
		} catch (NullPointerException e){
			System.out.println("No se ha seleccionado ningun fichero ");
		}
	}
}
