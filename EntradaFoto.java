import java.time.*;
import java.time.temporal.ChronoUnit;

public class EntradaFoto extends EntradaComentarios
{
    private String urlimagen;
    private String titulo;
    
    public EntradaFoto(String autor,String url,String titulo)
    {
        super(autor);
        urlimagen = url;
        this.titulo = titulo;
    }

    public String getUrlImagen()
    {
        return urlimagen;
    }

    public String getTituloImagen()
    {
        return titulo;
    }

    public String toString()
    {
        String textoADevolver = "";
        
        //Invocamos a toString de la clase padre y se guarda en la variable local.
        textoADevolver += super.toString();
        textoADevolver += "Título imágen: "+titulo+ "\n";
        textoADevolver += "URL imágen: "+urlimagen+ "\n";

        return textoADevolver;
    }
    
    public void mostrar()
    {
        System.out.println(this);
    }
    
    public int getCantidadDeDatosAsociadosALaEntrada()
    {
        return 6;
    }
    
    public void mostrarDatosExclusivos()
    {
        String url = getUrlImagen();
        String tituloImagen = getTituloImagen();
        
        System.out.println(url+"\n" +tituloImagen);
    }
}
