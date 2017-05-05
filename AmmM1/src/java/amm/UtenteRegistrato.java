/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm;

/**
 *
 * @author Fabrizio
 */
public class UtenteRegistrato {
     private int id;
    private String nome;
    private String cognome;
    private String data;
    private String urlimg;
    private String frase;
    private String email;
    private String password;
    private String confermapsw;
    
    public UtenteRegistrato(){
        id=0;
        nome ="";
        cognome ="";
        data="";
        cognome = "";
        data="";
        urlimg="";
        frase="";
        email="";
        password="";
        confermapsw="";
    }
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the cognome
     */
    public String getCognome() {
        return cognome;
    }

    /**
     * @param cognome the cognome to set
     */
    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    /**
     * @return the data
     */
    public String getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(String data) {
        this.data = data;
    }

    /**
     * @return the urlimg
     */
    public String getUrlimg() {
        return urlimg;
    }

    /**
     * @param urlimg the urlimg to set
     */
    public void setUrlimg(String urlimg) {
        this.urlimg = urlimg;
    }

    /**
     * @return the frase
     */
    public String getFrase() {
        return frase;
    }

    /**
     * @param frase the frase to set
     */
    public void setFrase(String frase) {
        this.frase = frase;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the confermapsw
     */
    public String getConfermapsw() {
        return confermapsw;
    }

    /**
     * @param confermapsw the confermapsw to set
     */
    public void setConfermapsw(String confermapsw) {
        this.confermapsw = confermapsw;
    }
    
   
    @Override
    public boolean equals(Object altroUtente) {
        if (altroUtente instanceof UtenteRegistrato)
            if (this.getId() == ((UtenteRegistrato)altroUtente).getId()) return true;
        return false;
    }
    
}
