package com.camel.drom;


public class camel_composer {

	//récup du tableau des mots et de la ligne
public static StringBuilder composeText(String[] words) 
{
	//init StringBuilder
	StringBuilder SB =new StringBuilder();
	
	String newWord ="";//pour construire la phrase camel
	
	//puis on traite les majuscules et les minuscules
	for(int i=0; i<=words.length-1;i++)
	{
		
		if (i % 2 == 0) //on commence par une lettre minuscule
			 {
				//on concat les mots
				newWord += words[i].toLowerCase();
				
			 }
		 else //lettre majuscule et on concat
			 {
				newWord += words[i].substring(0, 1).toUpperCase()+words[i].substring(1);
			
			 }

	}
	

	//chaine stringbuilder que l'on va renvoyer
	SB.append(newWord);
	
	return SB;
	
	}	

}
