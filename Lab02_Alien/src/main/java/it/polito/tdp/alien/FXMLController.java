package it.polito.tdp.alien;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {

	DizionarioAlieno dd = new DizionarioAlieno();
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtInserisci;

    @FXML
    private Button btnTranslate;

    @FXML
    private TextArea txtRisultato;
    
    @FXML
    private Button btnReset;
 
    
    @FXML
    void doTranslate(ActionEvent event) {
    	
    	txtRisultato.clear();
    	String parole = txtInserisci.getText();
    	int spazio=0;
    	
    	for(int i=0; i<parole.length();i++) {
    		char c = parole.charAt(i);
    		if(c==' ') {
    		spazio=i;
    		break;
    		}       
    		}
    	
    	String pattern = "[a-zA-Z]*";
    	
    	if(spazio!=0) {    //se le parole sono 2 -> una è la parola aliena e l'altra è la traduzione
    		
    	String parolaAliena=parole.substring(0, spazio);
    	String traduzione=parole.substring(spazio+1, parole.length());
    	    	
    	if( !parolaAliena.matches(pattern) || !traduzione.matches(pattern) ) {
    	    		txtRisultato.setText("ERRORE: La parola non contiene solo lettere");
    	    		return;
    	    	}
    	
    	dd.addWord(parolaAliena, traduzione);
    	//txtRisultato.setText("ho aggiunto:"+parolaAliena+""+traduzione);
    	  	
    	}
    	else  {    //altrimenti se è solo 1 è perchè cerco la traduzione
    		
    		if( !parole.matches("[a-zA-Z?]*")) {
	    		txtRisultato.setText("ERRORE: La parola non contiene solo lettere");
	    		return;
	    	}
    		  		
    		else if (parole.matches("[a-zA-Z?]*")){    
    			
    			int numPuntiDomanda = 0;              //verifico che ci sia un solo punto di domanda
    			for(int i=0; i<parole.length(); i++) 
    				if(parole.charAt(i)=='?')
    					numPuntiDomanda++;
    			
    			if(numPuntiDomanda>1)
    				txtRisultato.setText("Troppe lettere incognite per trovare una traduzione");
    			else if(dd.translateWord(parole)==null)
    				txtRisultato.setText("La parola non ha traduzione nel dizionario");
    			else 
    			 txtRisultato.setText(dd.translateWord(parole).toString());
//    			if(parole.contains("?")) {	
//    			}
    		}
    	}
    	
    		txtInserisci.clear();
    }

    @FXML
    void doReset(ActionEvent event) {
    	
    dd.ripulisci();
    txtRisultato.clear();
    txtInserisci.clear();

    }

    
    @FXML
    void initialize() {
    	   assert txtInserisci != null : "fx:id=\"txtInserisci\" was not injected: check your FXML file 'Scene.fxml'.";
           assert btnTranslate != null : "fx:id=\"btnTranslate\" was not injected: check your FXML file 'Scene.fxml'.";
           assert txtRisultato != null : "fx:id=\"txtRisultato\" was not injected: check your FXML file 'Scene.fxml'.";
           assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";

    }
}