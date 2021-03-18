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
	public Set<String> translateWord (String parolaAliena) {
		
		if(mappaParole.get(parolaAliena)!=null)
		return mappaParole.get(parolaAliena.toLowerCase());
		
		else if(parolaAliena.contains("?")) {
			
			Set <String> temp = new HashSet <>();
			
			for(String s : mappaParole.keySet()) {
				int x=0;
				   for(int i=0; i<parolaAliena.length();i++) {
					    if(i<s.length()) {
					    	if(s.charAt(i)==parolaAliena.charAt(i))
					    		x++;
						
					}
					    else
					    	break;
			}
			
			if(x==parolaAliena.length()-1)
				temp.add(s.toLowerCase());
				
			
		}
			if(temp!=null)
				return temp;
		
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
