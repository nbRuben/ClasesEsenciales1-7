package edu.eetac.upc.dsa.rnuevo.clasesEsencialesUnoSiete;

import java.io.Serializable;;

public class Dato implements Serializable{
	
	private int id;
	private String nombre;
	private char letra;
	
	public Dato (int id, String nombre, char letra){
		this.id= id;
		this.nombre=nombre;
		this.letra=letra;
	}
	
	public String toString(){
		
		return id + " " + nombre + " " + letra;
	}
	

}
