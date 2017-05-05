/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm;
import java.util.ArrayList;
/**
 *
 * @author Fabrizio
 */
public class UtenteRegistratoFactory {
    
    
    private static UtenteRegistratoFactory singleton;

    public static UtenteRegistratoFactory getInstance() {
        if (singleton == null) {
            singleton = new UtenteRegistratoFactory();
        }
        return singleton;
    }

    private ArrayList<UtenteRegistrato> listaUtenti = new ArrayList<UtenteRegistrato>();

    private UtenteRegistratoFactory() {
        
        UtenteRegistrato ut1 = new UtenteRegistrato();
        ut1.setId(0);
        ut1.setNome("Simone");
        ut1.setCognome("Padoin");
        ut1.setData("18/09/1980");
        ut1.setUrlimg("prof.jpeg");
        ut1.setFrase("Chi la fa, la spesa");
        ut1.setEmail("SP20@email.com");
        ut1.setPassword("ciaociao");
        ut1.setConfermapsw("ciaociao");

        
        UtenteRegistrato ut2 = new UtenteRegistrato();
        ut2.setId(1);
        ut2.setNome("Ezequiel");
        ut2.setCognome("Schelotto");
        ut2.setData("23/10/1984");
        ut2.setUrlimg("prof.png");
        ut2.setFrase("Tanto va la gatta al lardo che se lo mangia");
        ut2.setEmail("ES14@email.com");
        ut2.setPassword("schelotto");
        ut2.setConfermapsw("schelotto");
       
        UtenteRegistrato ut3 = new UtenteRegistrato();
        ut3.setId(2);
        ut3.setNome("Ronaldo");
        ut3.setCognome("De Assis Moreira 'Ronaldinho'");
        ut3.setData("29-04-1978");
        ut3.setUrlimg("prof.jpg");
        ut3.setFrase("Tutturuturututtu");
        ut3.setEmail("RR10@email.com");
        ut3.setPassword("pallone");
        ut3.setConfermapsw("pallone");

  
       

        listaUtenti.add(ut1);
        listaUtenti.add(ut2);
        listaUtenti.add(ut3);
    }

    public UtenteRegistrato getUtenteById(int id) {
        for (UtenteRegistrato utente : this.listaUtenti) {
            if (utente.getId() == id) {
                return utente;
            }
        }
        return null;
    }
    
    public int getIdByUserAndPassword(String user, String password){
        for(UtenteRegistrato utente : this.listaUtenti){
            if(utente.getNome().equals(user) && utente.getPassword().equals(password)){
                return utente.getId();
            }
        }
        return -1;
    }
}
