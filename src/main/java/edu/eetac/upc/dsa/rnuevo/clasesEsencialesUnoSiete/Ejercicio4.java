package edu.eetac.upc.dsa.rnuevo.clasesEsencialesUnoSiete;

import java.io.*;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import java.util.Date;
import java.text.SimpleDateFormat;

public class Ejercicio4 {
	public static void main(String[] args) {
		File archivo = null;
		FileReader leer = null;
		FileWriter escribir = null;
		BufferedReader leido = null;
		BufferedWriter escrito = null;
		File guardarArchivo= new File("D:\\registro.txt");
		int contador = 0;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		String date = sdf.format(new Date());
		
		try {
			JFileChooser elegirArchivo = new JFileChooser();
			int respuesta = elegirArchivo.showOpenDialog(null);
			if (respuesta == JFileChooser.APPROVE_OPTION) {
				archivo = elegirArchivo.getSelectedFile();
			}
			leer = new FileReader(archivo);
			leido = new BufferedReader(leer);
			while (leido.read() != -1) {
				contador = contador +1;
			}
			
			
			escribir = new FileWriter(guardarArchivo.getAbsoluteFile(), true);
			escrito = new BufferedWriter(escribir);
			escrito.write("El fichero " + archivo.getName() + " contiene " +contador + " caracteres a la fecha de " +date +"\r\n");
			escrito.close(); 
			System.out.println("El numero de caracteres que contiene el fichero es " + contador);
			
		} catch (FileNotFoundException e) {
			System.out.println("No se puede encontrar el archivo especificado: "+ e.getMessage());
		} catch (IOException e) {
			System.out.println("No se puede leer el fichero: " + e.getMessage());
		} catch (NullPointerException e){
			System.out.println("No se ha seleccionado ningun fichero ");
		}
	}
}
