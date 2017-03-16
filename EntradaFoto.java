import java.time.*;
import java.time.temporal.ChronoUnit;

public class EntradaFoto extends Entrada
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

        textoADevolver += "Usuario: "+getUsuario()+"\n"; 
        textoADevolver += "Título imágen: "+titulo+ "\n";
        textoADevolver += "URL imágen: "+urlimagen+ "\n";
        textoADevolver += "Cantidad Me Gusta: "+getCantidadMeGusta()+ "\n";
        textoADevolver += "Comentarios: " +getComentarios();
        //Calculamos los segundos y minutos que han pasado
        long segundosQueHanPasadoDesdeCreacion = getMomentoPublicacion().until(LocalDateTime.now(),ChronoUnit.SECONDS);
        long minutosQueHanPasadoDesdeCreacion = segundosQueHanPasadoDesdeCreacion / 60;
        long segundosResiduales = segundosQueHanPasadoDesdeCreacion % 60;

        textoADevolver += "Hace ";
        if(minutosQueHanPasadoDesdeCreacion > 0 ){
            textoADevolver += minutosQueHanPasadoDesdeCreacion+ " minutos";
        }
        textoADevolver+= segundosResiduales + " segundos \n";

        //comprobamos si el arraylist está vacío
        if (getComentarios().isEmpty()){
            textoADevolver += "La entrada no tiene comentarios.";
        }
        else{
            textoADevolver += "Comentarios:";
            //guardamos los comentarios
            for(String comentario : getComentarios()){
                textoADevolver += comentario + "\n";
            }
        }
        return textoADevolver;
    }
}
