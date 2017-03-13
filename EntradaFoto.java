import java.time.*;
import java.util.ArrayList;

public class EntradaFoto
{
    private String usuario;
    private String urlImagen;
    private String titulo;
    private LocalDateTime momentoPublicacion;
    private int cantidadMeGusta;
    private ArrayList<String> comentarios;

    /**
     * Constructor for objects of class EntradaFoto
     */
    public EntradaFoto(String autor, String url,String titulo)
    {
       usuario = autor;
       urlImagen = url;
       this.titulo = titulo;
    }

    public void meGusta()
    {
        
    }
    
    public void unLike()
    {
    }
    
    public void addComentario(String text)
    {
       comentarios.add(text); 
    }
    
    public String getUrlImagen()
    {
        return urlImagen;
    }
    
    public String getTituloImagen()
    {
        return titulo;
    }
    
    public LocalDateTime getMomentoPublicacion()
    {
        return momentoPublicacion;
    }
    
    public String toString()
    {
        String textoADevolver="";
        if (comentarios == null){
            textoADevolver ="La entrada no tiene comentarios";
        }
        else{
            textoADevolver ="Usuario: "+usuario+ " Imágen: "+urlImagen+ " Título: "+titulo+ 
            " Momento publicación: "+momentoPublicacion+  " Cantidad me gusta: "+cantidadMeGusta+"Comentarios: " +comentarios;
        }
        return textoADevolver;
    }
}
