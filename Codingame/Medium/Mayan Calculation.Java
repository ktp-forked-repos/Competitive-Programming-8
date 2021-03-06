import java.io.*;
import java.math.*;
class Solution {
	public static void main(String args[]) {
		// Static new input
	Scanner in = new Scanner(System.in);
		int largeur = in.nextInt();
		int hauteur = in.nextInt();
		in.nextLine();
		String nombre[][];
		nombre = new String[20][hauteur];
		for(int i=0; i<hauteur ; i++){
		    String line = in.nextLine();
		    while(line.length() < (20*largeur)){
		        line = line +" ";
		    }
		    for(int j = 0; j < 20 ; j++){
		        String nombreLigne = line.substring(j*largeur,j*largeur+largeur);
		        nombre[j][i] = nombreLigne;
		    }
		}
		int hauteurChiffre1 = in.nextInt();
		in.nextLine();
		String[] ligneChiffre1= new String[hauteurChiffre1];
		
		for(int i=0; i<hauteurChiffre1 ; i++){
		    ligneChiffre1[i] = in.nextLine();    
		}
		int hauteurChiffre2 = in.nextInt();
		in.nextLine();
		String[] ligneChiffre2= new String[hauteurChiffre2];
		
		for(int i=0; i<hauteurChiffre2 ; i++){
		    ligneChiffre2[i] = in.nextLine();
		}
		int chiffre1 = nombreMaya(nombre, ligneChiffre1,hauteur);
		int chiffre2 = nombreMaya(nombre, ligneChiffre2,hauteur);
		String line = in.nextLine();
		long resultLong = calculMaya(line, chiffre1,chiffre2);
		double valeurPuissance = 0;
		
		if(resultLong == 0l){
		    valeurPuissance = 0;
		}else {
		    valeurPuissance = puissanceDuNombre(resultLong,20);
		}
		
		nombreLangMaya(valeurPuissance,resultLong,hauteur,nombre);
	}
	
	public static void nombreLangMaya(double valeurPuissance,long result,int hauteur,String nombre[][]){
	   if(valeurPuissance >=0 && valeurPuissance <1){
	        for(int i=0; i<hauteur;i++){
    		    System.out.println(nombre[(int)result][i]);
    	    }
	    }else{
    	   int puissanceInt = (int)valeurPuissance;
    	   Long[] valeur = new Long[puissanceInt+1];
    	   valeur[0] = result/(int)Math.pow(20,puissanceInt);
    	   valeur[puissanceInt] = result%20;
    	   long resteResult = result-valeur[0]*(int)Math.pow(20,puissanceInt);
    	   for(int i = 1; i<(puissanceInt); i++){
    	       valeur[i] = resteResult/(int)Math.pow(20,puissanceInt-i);
    	       resteResult -= valeur[i]*(int)Math.pow(20,puissanceInt-i);
    	   }
    	   for (int j = 0; j < (puissanceInt+1); j++){
                int valeurInt = valeur[j].intValue();
                for(int i=0; i<hauteur;i++){
        		    System.out.println(nombre[valeurInt][i]);
        	    }
    	   } 
	    }
	}
	
	public static double puissanceDuNombre(long valeurX,int puissance){
	    double valeurPuissance = Math.log(valeurX)/Math.log(puissance);
	    
	    return valeurPuissance;
	}
	
	public static long calculMaya(String line, int chiffre1, int chiffre2){
	    long resultat = 0l;
	    switch(line){
	        case "+" :
	            resultat = (long)chiffre1 + (long)chiffre2;
	            break;
	            
	       case "-" :
	            resultat = (long)chiffre1 - (long)chiffre2;
	            break;
	            
	       case "*" :
	            resultat = (long)chiffre1 * (long)chiffre2;
	            break;
	            
	       case "/" :
	            resultat = (long)chiffre1 / (long)chiffre2;
	            break;
	      
	
	 default :
	            break;
	    }
	    return resultat;
	}
	
	public static int nombreMaya(String nombre[][], String[] ligneChiffre, int hauteur){
	    int nombreM = 0;
	    int nombreChiffre = ligneChiffre.length/hauteur;
	    for(int i = 0; i<nombreChiffre ; i++){
    	    for(int j = 0; j < 20 ; j++){

		        int nombreOk = 0;
		        for(int k=0; k<hauteur; k++){
		            if( (nombre[j][k].equals(ligneChiffre[k+hauteur*i]))){
		                nombreOk++;
		            } 
		        }
		        
		        if(nombreOk == hauteur){
    		        nombreM += j*(int)Math.pow(20,nombreChiffre-1-i);
    		        break;
		        }
		        
		        
    		 }
	    }
	    return nombreM;
	}
	
}
