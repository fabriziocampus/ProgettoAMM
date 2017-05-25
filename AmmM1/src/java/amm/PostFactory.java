/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;


public class PostFactory {

    //Pattern Design Singleton
    private static PostFactory singleton;

    public static PostFactory getInstance() {
        if (singleton == null) {
            singleton = new PostFactory();
        }
        return singleton;
    }
    
    //Gestione DB
    private String connectionString;
    
    public void setConnectionString(String s){
	this.connectionString = s;
    }
    
    public String getConnectionString(){
            return this.connectionString;
    }
    //Fine gestione DB

    //private ArrayList<Post> listaPost = new ArrayList<Post>();


    public Post getPostById(int id) {        
        UtenteRegistratoFactory utenteFactory = UtenteRegistratoFactory.getInstance();
        
        try {
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "fabrizio", "fabrizio");
            
            String query = 
                      "select * from Post "
                    + "join PostType on Post.type = PostType.PostType_id "
                    + "where Post_id = ?";
            
            // Prepared Statement
            PreparedStatement stmt = conn.prepareStatement(query);
            
            // Si associano i valori
            stmt.setInt(1, id);
            
            // Esecuzione query
            ResultSet res = stmt.executeQuery();

            // ciclo sulle righe restituite
            if (res.next()) {
                Post current = new Post();
                //imposto id del post
                current.setId(res.getInt("Post_id"));
                
                //impost il contenuto del post
                current.setContenuto(res.getString("Contenuto"));
                
                //imposto il tipo del post
                current.setPostType(this.postTypeFromString(res.getString("PostType_name")));
                
                //imposto l'autore del post
                UtenteRegistrato autore = utenteFactory.getUtenteById(res.getInt("Author"));
                current.setUser(autore);

                stmt.close();
                conn.close();
                return current;
            }

            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
        
    }

    public List getPostList(UtenteRegistrato ut) {
        List<Post> listaPost = new ArrayList<Post>();
        
        try {
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "fabrizio", "fabrizio");
            
            String query = 
                      "select * from Post "
                    + "join PostType on Post.Type = PostType.PostType_id "
                    + "where author = ?";
            
            // Prepared Statement
            PreparedStatement stmt = conn.prepareStatement(query);
            
            // Si associano i valori
            stmt.setInt(1, ut.getId());
            
            // Esecuzione query
            ResultSet res = stmt.executeQuery();

            // ciclo sulle righe restituite
            while (res.next()) {
                
                Post current = new Post();
                //imposto id del post
                current.setId(res.getInt("Post_id"));
                
                //impost il contenuto del post
                current.setContenuto(res.getString("Contenuto"));
                
                //imposto il tipo del post
                current.setPostType(this.postTypeFromString(res.getString("PostType_name")));

                //imposto l'autore del post
                current.setUser(ut);
                
                listaPost.add(current);
            }

            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listaPost;
    }
    
    public void addNewPost(Post post){
        try {
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "fabrizio", "fabrizio");
            
            String query = 
                      "insert into Post (Post_id, Contenuto, Type, Author) "
                    + "values (default, ? , ? , ? )";
            
            // Prepared Statement
            PreparedStatement stmt = conn.prepareStatement(query);
            
            // Si associano i valori
            stmt.setString(1, post.getContenuto());

            stmt.setInt(2, this.postTypeFromEnum(post.getPostType()));
            
            stmt.setInt(3, post.getUser().getId());
            
            // Esecuzione query
            stmt.executeUpdate();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    private Post.Type postTypeFromString(String type){
        
        if(type.equals("IMAGE"))
            return Post.Type.IMAGE;
        if(type.equals("LINK"))
            return Post.Type.LINK;
        
        return Post.Type.TEXT;
    }
    
    private int postTypeFromEnum(Post.Type type){
        //È realizzabile in modo più robusto rispetto all'hardcoding degli indici
        if(type == Post.Type.TEXT)
                return 1;
        if(type == Post.Type.IMAGE)
                return 2;
        
        return 3;
    }
}

