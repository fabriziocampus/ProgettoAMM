/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm;
import java.util.List;
import java.util.ArrayList;
/**
 *
 * @author Fabrizio
 */
public class PostFactory {
    
     private static PostFactory singleton;

    public static PostFactory getInstance() {
        if (singleton == null) {
            singleton = new PostFactory();
        }
        return singleton;
    }
    
     private ArrayList<Post> listaPost = new ArrayList<Post>();

    private PostFactory() {
        
        UtenteRegistratoFactory utenteFactory = UtenteRegistratoFactory.getInstance();

        //Creazione Post
        Post post1 = new Post();
        post1.setContenuto("Oggi è una bella giornata");
        post1.setId(0);
        post1.setUser(utenteFactory.getUtenteById(0));

        Post post2 = new Post();
        post2.setContenuto("anatra.jpg");
        post2.setId(1);
        post2.setUser(utenteFactory.getUtenteById(0));
        post2.setPostType(Post.Type.IMAGE);

        Post post3 = new Post();
        post3.setContenuto("http://www.unica.it/");
        post3.setId(2);
        post3.setUser(utenteFactory.getUtenteById(0));
        post3.setPostType(Post.Type.LINK);

        Post post4 = new Post();
        post4.setContenuto("Let's go, let's go");
        post4.setId(0);
        post4.setUser(utenteFactory.getUtenteById(1));

        listaPost.add(post1);
        listaPost.add(post2);
        listaPost.add(post3);
        listaPost.add(post4);
    }

    public Post getPostById(int id) {
        for (Post post : this.listaPost) {
            if (post.getId() == id) {
                return post;
            }
        }
        return null;
    }

    public List getPostList(UtenteRegistrato ut) {

        List<Post> listaPost = new ArrayList<Post>();

        for (Post post : this.listaPost) {
            if (post.getUser().equals(ut)) {
                listaPost.add(post);
            }
        }
        return listaPost;
    }
    
}
