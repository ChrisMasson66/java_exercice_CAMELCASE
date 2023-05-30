package com.camel.drom;

import java.io.InputStream;



public class camel_main {

	
	public static void main(String[] args) {
		
		String intro="Le camel case (de l'anglais, littéralement « casse de chameau »)\n"
				+ "est une notation consistant à écrire un ensemble de mots\n"
				+ "en les liant sans espace ni ponctuation,\n"
				+ "et en mettant en capitale la première lettre de chaque mot.\n"
				+ "Le mode demandé est Camel Case Dromadaire où tout le texte est collé\n"
				+ "prennant en compte que la première lettre est en minuscule avec alternance\n "
				+ "dans le texte.\n";
		
	      System.out.println(intro);
	      
	      System.out.println("le texte de sortie est le suivant:\n");
	    	
	      //appel du stream pour charger le fichier texte
	       camel_stream stream = new camel_stream();
	       
	        //on charge le fichier 
		   InputStream istream = stream.getFileAsIOStream("input.txt");
		   
		    //affichage du résultat dans la console
		   stream.printFileContent(istream);
		   


	}


}
