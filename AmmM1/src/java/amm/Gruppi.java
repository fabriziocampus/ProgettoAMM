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
public class Gruppi {

     
    public enum Type{
        TEXT,IMAGE,LINK;
    }
    
   private int idGruppo;
   private String nomeGruppo;
   private UtenteRegistrato membro[];
   private Post post;
   
   public Gruppi(){
       idGruppo=0;
       nomeGruppo="";
   }
   
  
    /**
     * @return the idGruppo
     */
    public int getIdGruppo() {
        return idGruppo;
    }

    /**
     * @param idGruppo the idGruppo to set
     */
    public void setIdGruppo(int idGruppo) {
        this.idGruppo = idGruppo;
    }

    /**
     * @return the nomeGruppo
     */
    public String getNomeGruppo() {
        return nomeGruppo;
    }

    /**
     * @param nomeGruppo the nomeGruppo to set
     */
    public void setNomeGruppo(String nomeGruppo) {
        this.nomeGruppo = nomeGruppo;
    }

    /**
     * @return the membro
     */
    public UtenteRegistrato[] getMembro() {
        return membro;
    }

    /**
     * @param membro the membro to set
     */
    public void setMembro(UtenteRegistrato[] membro) {
        this.membro = membro;
    }

    /**
     * @return the post
     */
    public Post getPost() {
        return post;
    }

    /**
     * @param post the post to set
     */
    public void setPost(Post post) {
        this.post = post;
    } 
    
}
