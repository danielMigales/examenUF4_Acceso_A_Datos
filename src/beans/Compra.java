package beans;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.Serializable;
import javax.swing.JOptionPane;

/**
 *
 * @author daniel migales puertas
*
 */
public class Compra implements Serializable, PropertyChangeListener {//bean receptor{

   private String articulo;
   private Comentario comentario; //objeto de la clase bean Comentario
   private String usuario;

    public Compra() {
    }

    public Compra(String articulo, Comentario comentario, String usuario) {
        this.articulo = articulo;
        this.comentario = comentario;
        this.usuario = usuario;
    }

    public String getArticulo() {
        return articulo;
    }

    public void setArticulo(String articulo) {
        this.articulo = articulo;
    }

    public Comentario getComentario() {
        return comentario;
    }

    public void setComentario(Comentario comentario) {
        this.comentario = comentario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
       
         //en caso de que se produzca un evento aqui procederé a actuar (aviso de evento)
        System.out.println("BEAN RECEPTOR: El comentario esta fuera de lugar.");
        //se imprimen los valores anterior y nuevo (informacion extra)
        System.out.printf("Comentario anterior: %d%n", evt.getOldValue());
        System.out.printf("Se ha detectado esta palabrota: %d%n", evt.getNewValue());
        //se imprime mensaje indicando la accion que va a tomar como medida
        System.out.println("BEAN RECEPTOR: Intente realizar una compra sin comentarios malsonantes como este: "
                + comentario.getComentario()+ "\n");

        JOptionPane.showMessageDialog(null, 
                "BEAN RECEPTOR: Pasamos su comentario a revision: " + comentario.getComentario(),"Gracias",
                JOptionPane.WARNING_MESSAGE);
        
        
        //llamada al metodo para guardar el comentario
        
    }
   
   
    
    

}
