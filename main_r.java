package Ricerca;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/*
 * 2)Utilizzare il file "nomi.txt" e cercare un nome attraverso lo scanner input
3)Utilizzare il file cognomi.txt" e cercare un cognome attraverso lo scanner input
 * */

public class main_r {
	
	public static void trovato(String what, int where) {
		System.out.println("\nHo trovato!\n"+what+" � presente, alla riga "+where); }

	public static void main(String[] args) {
		System.out.println("Vuoi cercare un nome (digita 1) o un cognome(digita 2)?"
				+ "\nSe vuoi terminare il programma digita 0.\n\n");
		Scanner scanner=new Scanner(System.in);
		int scelta = scanner.nextInt();
		
		while(true) {
			boolean flag=true;
			switch(scelta) {
			case 1:
				String myFile=""; //insert path to nomi.txt here 
		        System.out.println("Digita il nome che vuoi cercare: ");
		        Scanner scan_search_1 = new Scanner(System.in);
		        String nome_search = scan_search_1.next();
		        nome_search=nome_search.toLowerCase();		      
		        System.out.println(nome_search);
	            try {
	                File file = new File(myFile);
	                FileReader fr=new FileReader(file); 
	                BufferedReader br=new BufferedReader(fr);  //creates a buffering character input stream  
	                String fileContent = "";
	                int posizione=1;
	                while((fileContent=br.readLine())!=null) { 
	                	if((fileContent.toLowerCase()).equals(nome_search)) {
	                		trovato(nome_search, posizione);
	                		flag=false;
	                	}
	                	posizione++;
	                }
	                if(flag) System.out.println("\n"+nome_search+" non � presente :(\n");
	            }catch(IOException e) {
	            	System.out.println("\nFile non trovato: \n"+e.getStackTrace());
	            }
				break;
			case 2:
		        myFile=""; //insert path to cognomi.txt here
		        System.out.println("Digita il cognome che vuoi cercare: ");
		        Scanner scan_search_2 = new Scanner(System.in);
		        String cognome_search = scan_search_2.next();
		        cognome_search=cognome_search.toLowerCase();		      
		        System.out.println(cognome_search);
	            try {
	                File file = new File(myFile);
	                FileReader fr=new FileReader(file); 
	                BufferedReader br=new BufferedReader(fr);  
	                String fileContent = "";
	                int posizione=1;
	                while((fileContent=br.readLine())!=null) {
	                	if((fileContent.toLowerCase()).equals(cognome_search)) {
	                		trovato(cognome_search, posizione);
	                		flag=false;
	                	}
	                	posizione++;
	                }
	                if(flag)System.out.println("\n"+cognome_search+" non � presente :(\n");
	            }catch(IOException e) {
	            	System.out.println("\nFile non trovato: \n"+e.getStackTrace());
	            }
				break;
			}
		}
	}

}
