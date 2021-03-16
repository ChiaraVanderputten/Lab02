package it.polito.tdp.alien;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DizionarioAlieno {
	
	private Map <String, Set<String> > mappaParole;
	
	public DizionarioAlieno() {
		mappaParole = new HashMap <> ();
	}
	
	public void addWord (String parolaAliena, String traduzione) {
		
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
	
	public Set<String> translateWord (String parolaAliena) {
		
		return mappaParole.get(parolaAliena.toLowerCase());
		
	}

}
