package com.camel.drom;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.FileWriter;


public class camel_stream {
	
	//hop, on déclare ...
	private StringBuilder SB = null;
	
	private static final  String CHAR_SEPARATOR = " ";
	
	
	public camel_stream()
	{
		//constructeur vide ...
	}
		
	//chargement du fichier
    public InputStream getFileAsIOStream(final String fileName) 
    {       
    	InputStream ioStream = this.getClass().getClassLoader().getResourceAsStream(fileName);
       
        if (ioStream == null) 
        
        {
            throw new IllegalArgumentException(fileName + " non trouvé");
        }
        return ioStream;
    }
        
  //affiche le résultat
    public void printFileContent(InputStream istream) 
    {
    	
    try { 
    	
	    	//init la stringbuilder SB_write qui va récupérer tout le flux
	    	//on écrira le tout d'une seule fois.
	    	StringBuilder SB_write=new StringBuilder();
    	
    	
    		//lancement du stream avec le buffer pour récup du fichier
	    	InputStreamReader ireader = new InputStreamReader(istream);
	        //init buffer
	        BufferedReader buffer = new BufferedReader(ireader);
	        
	       //vairable d erécup du flux
	        String line = "";
	        
         //parcours du fichier dans le buffer      
        while ((line = buffer.readLine()) != null) 
        {
        	SB_write.append(line+"\n");//récup de la ligne d'origine
        	        	        	
        	//split en tableau
        	//remise à neuf du texte: tout en minuscule 
        	//par sécurité d'éventuelles erreurs de frappe au milieu d'un mot 	
        	String[] words = line.trim().toLowerCase().split(CHAR_SEPARATOR);
    	
        	//System.out.println(Arrays.toString(words));
        	
        	if(words != null)
        	{        		            	
            		SB = camel_composer.composeText(words);//pour affichage sortant du résultat            		
            		SB_write.append(SB+"\n\n");//on ajoute la ligne camel drom
        	}
        	 
        	//affichage du text au fur et à mesure de la line lue
        	 System.out.println(SB);
        }
        
        //System.out.println(SB_write);                
        //Ecriture dans le fichier qui est créé auto si non existant
        this.WriteTextIntoFile("data/output.txt", SB_write);        
        
        //coupe le flux
        buffer.close();

        	
       } 
      catch (IOException e) 
      {
      
        e.printStackTrace();
        
       }

    }

    
    //Fonction pour écrire le texte dans le fichier
    public void WriteTextIntoFile(String fileName, StringBuilder textToWrite)
    {
    	//System.out.println(textToWrite);
    	
    	//init buffer pour l'écriture
    	BufferedWriter writer = null;
    	
    	//dans un try catch pour gestion d'erreur
        try {
        	//init du writer 
            writer = new BufferedWriter(new FileWriter(fileName));
            
            //on dump la stringbuilder et écrire le texte dans le fichier
            writer.append(textToWrite);
        
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        } 
        finally 
        {
            try {
                // fermeture du flux
                writer.close();
	            } 
	            catch (Exception e) 
	            {
	            	
	            }
        }
    }
    	

}
