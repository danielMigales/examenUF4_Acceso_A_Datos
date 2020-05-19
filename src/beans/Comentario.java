package beans;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.swing.JOptionPane;

/**
 *
 * @author daniel migales puertas
 *
 */
public class Comentario implements Serializable { //BEAN FUENTE{

    String comentario;//propiedad compartida que si cambia lanza un evento

    private PropertyChangeSupport propertySupport;

    public Comentario() {

        propertySupport = new PropertyChangeSupport(this);
    }

    public Comentario(String comentario, PropertyChangeSupport propertySupport) {
        this.comentario = comentario;
        propertySupport = new PropertyChangeSupport(this);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertySupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertySupport.removePropertyChangeListener(listener);
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentarioNuevo) {

        String comentarioAnterior = this.comentario;
        this.comentario = comentarioNuevo;

        //aqui se comparan los valores que hacen saltar la alerta
        if (this.comentario.equals("cabron")) {
            //entonces se lanza una alerta escrita a la terminal o un dialogo
            System.out.println("BEAN FUENTE: Este comentario es malsonante.");
            JOptionPane.showMessageDialog(null, "Palabrota detectada, tu comentario pasa a revision.", "MENSAJE DE BEAN FUENTE",
                    JOptionPane.WARNING_MESSAGE);

            propertySupport.firePropertyChange("comentario malsonante",//LANZAMOS EL EVENTO AL RECEPTOR ENVIANDOLE DATOS
                    comentarioAnterior, this.comentario);
        }
    }

}
