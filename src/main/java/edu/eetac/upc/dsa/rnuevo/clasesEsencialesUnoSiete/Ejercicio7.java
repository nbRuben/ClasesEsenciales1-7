package edu.eetac.upc.dsa.rnuevo.clasesEsencialesUnoSiete;

import java.io.*;

public class Ejercicio7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	
	      try {
	    	  
	    	 Dato d = new Dato(1,"Objeto1", 'r');
	    	 Dato d2 = new Dato(2,"Objeto2", 'n');
	    	 Dato d3 = new Dato (3,"Objeto3", 'b');
	    	 
	         FileOutputStream out = new FileOutputStream("D:\\t.tmp");
	         ObjectOutputStream oout = new ObjectOutputStream(out);

	         oout.writeObject(d);
	         oout.writeObject(d2);
	         oout.writeObject(d3);
	         oout.close();
	         
	         ObjectInputStream ois = new ObjectInputStream(new FileInputStream("D:\\t.tmp"));
	         
	         Object aux = ois.readObject();
	         while(aux != null){
	        	 if (aux instanceof Dato){
	        		 System.out.println(aux);
		         }
	        	 aux = ois.readObject();
	         }

	      } catch (Exception ex) {}
	}

}
