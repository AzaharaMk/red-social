import java.time.*;
import java.util.ArrayList;
public class Entrada
{
   private String usuario;
   private LocalDateTime momentoPublicacion;
   private int cantidadMeGusta;
   private ArrayList<String> comentarios;

    /**
     * Constructor for objects of class Entrada
     */
    public Entrada(String autor)
    {
       usuario = autor;
       comentarios = new ArrayList<>();
       momentoPublicacion = LocalDateTime.now();
       cantidadMeGusta = 0;
    }

    public void meGusta()
    {
        cantidadMeGusta++;
    }
    
     public void addCmentarios(String text)
    {
        comentarios.add(text);
    }
    
     public LocalDateTime getMomentoPublicacion()
    {
        return momentoPublicacion;
    }
    
    public String getUsuario()
    {
        return usuario;
    }
    
     public int getCantidadMeGusta()
    {
        return cantidadMeGusta;
    }
    
    public ArrayList <String> getComentarios()
    {
        return comentarios;
    }
    
    public String toString()
    {
        return "";
    }
}
