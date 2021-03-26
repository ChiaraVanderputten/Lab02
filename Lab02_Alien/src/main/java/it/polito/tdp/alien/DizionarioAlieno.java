package it.polito.tdp.alien;


import java.util.HashMap;
import java.util.HashSet;

import java.util.Map;
import java.util.Set;

public class DizionarioAlieno {
	
	//primo punto Map <String,String> mappaParole
	private Map <String, Set<String> > mappaParole;
	
	public DizionarioAlieno() {
		mappaParole = new HashMap <> ();
	}
	
	public void addWord (String parolaAliena, String traduzione) {
		
		//per il primo punto 
		//mappaParole.put(parolaAliena.toLowerCase(),traduione.toLowerCase());
		
		//per il secondo punto
		
		HashSet <String> parole =new HashSet <String>();
		
		if(mappaParole.get(parolaAliena.toLowerCase())==null)
			parole.add(traduzione.toLowerCase());
		else {
		parole.addAll(mappaParole.get(parolaAliena.toLowerCase()));
		parole.add(traduzione.toLowerCase());
		mappaParole.get(parolaAliena).clear();
		}
		
		mappaParole.put(parolaAliena.toLowerCase(),parole);
		
	}

	//primo punto String
	public String translateWord (String parolaAliena) {
		
		if(mappaParole.get(parolaAliena.toLowerCase())!=null) {
			String y="";
			for(String s : mappaParole.get(parolaAliena.toLowerCase()) )
				y+=s+" \n";
			
			return y;
		}
		
		else if(parolaAliena.contains("?")) {
			
			Set <String> temp = new HashSet <>();     //creo una lista temporanea
			
			for(String s : mappaParole.keySet()) {   //itero tutte le parole aliene         
				int x=0;
				   for(int i=0; i<parolaAliena.length();i++) {   //scannarizzo lettera per lettera la parola aliena contente "?"
					    if(parolaAliena.length()==s.length()) {  //le due parole devono avere lo stesso numero di caratteri                   
					    	if(s.charAt(i)==parolaAliena.toLowerCase().charAt(i))  //se le lettere coincidono
					    		x++;                                 //incremento il contatore che mi dice quante lettere sono simili a quelle di parolaAliena
						
					}
					    else   break;   //se le due parole non hanno stessa lunghezza passo allaprossima
					    	
			}
			
			if(x==parolaAliena.length()-1) //se il n° di lettere uguali è pari a quello della parola aliena eccetto una -> ioè il "?"
				temp.addAll(mappaParole.get(s));
				
			
		}
			if(temp.isEmpty()) 
				return null;
			else {
				String x="";
				for(String s : temp )
					x+=s+" \n";
				
				return x;
			}
			
		}
		return null;
		
		
	}
	
	public Map<String, Set<String>> getMappaParole() {
		return mappaParole;
	}

	public void ripulisci() {
		mappaParole.clear();
	}

	

}
