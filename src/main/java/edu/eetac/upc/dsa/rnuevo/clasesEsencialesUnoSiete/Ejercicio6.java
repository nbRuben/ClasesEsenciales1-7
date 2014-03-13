package edu.eetac.upc.dsa.rnuevo.clasesEsencialesUnoSiete;

import java.io.*;

import javax.swing.JFileChooser;

import java.util.*;

public class Ejercicio6 {
	public static void main(String[] args) {
		File archivo = null;
		FileReader leer = null;
		BufferedReader leido = null;
		int maxBytes = 0;
		int maxCaracteres = 0;
		String ficheroBytes = null;
		String ficheroCaracteres = null;
		String palabra[] = null;
		ArrayList<String[]> lineas = new ArrayList<String[]>();
		int i=0;
		try {
			JFileChooser elegirArchivo = new JFileChooser();
			int respuesta = elegirArchivo.showOpenDialog(null);
			if (respuesta == JFileChooser.APPROVE_OPTION) {
				archivo = elegirArchivo.getSelectedFile();
			}
			leer = new FileReader(archivo);
			leido = new BufferedReader(leer);
			String linea;
			while ((linea=leido.readLine()) != null) {
				lineas.add(linea.split(" "));
			}
			
			for(i=0; i < lineas.size(); i++){
				palabra = lineas.get(i);
				for(int j=0; j < palabra.length-2; j++){
					if(palabra[j].toString().equals("contiene") && palabra[j+2].toString().equals("bytes")){
						if(maxBytes < Integer.valueOf(palabra[j+1])){
							maxBytes=Integer.valueOf(palabra[j+1]);
							ficheroBytes = palabra[j-1];
						}
					}
					if(palabra[j].toString().equals("contiene") && palabra[j+2].toString().equals("caracteres")){
						if(maxCaracteres < Integer.valueOf(palabra[j+1])){
							maxCaracteres=Integer.valueOf(palabra[j+1]);
							ficheroCaracteres = palabra[j-1];
						}
					}
				}
			}
			
			if(maxBytes > maxCaracteres){
				System.out.println("El fichero que contiene mas bytes es " + ficheroBytes + " con " + maxBytes +" bytes");
			}else if(maxBytes < maxCaracteres){
				System.out.println("El fichero que contiene mas caracteres es " + ficheroCaracteres + " con " + maxCaracteres +" caracteres");
			}else{
				System.out.println("El fichero que contiene mas bytes es " + ficheroBytes + " con " + maxBytes +" bytes" + " y el fichero que contiene mas caracteres es " + ficheroCaracteres + " con " + maxCaracteres +" caracteres");
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("No se puede encontrar el archivo especificado: "+ e.getMessage());
		} catch (IOException e) {
			System.out.println("No se puede leer el fichero: " + e.getMessage());
		}catch (NullPointerException e){
			System.out.println("No se ha seleccionado ningun fichero ");
		}
	}
}
