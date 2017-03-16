import java.time.*;
import java.time.temporal.ChronoUnit;
public class EntradaTexto extends Entrada
{
    private String mensaje;
    
    public EntradaTexto (String autor,String texto)
    {
        super(autor);
        mensaje = texto;
    }

    public String getMensaje()
    {
        return mensaje;
    }

    public String toString()
    {
        String textoADevolver = "";

        textoADevolver += "Usuario: "+getUsuario()+"\n"; 
        textoADevolver += "Mensaje: "+mensaje+ "\n";
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

