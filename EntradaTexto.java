import java.util.*;
import java.time.*;
/**
 * Write a description of class EntradaTexto here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EntradaTexto
{
    // instance variables - replace the example below with your own
    private String usuario;
    private String mensaje;
    private LocalDateTime momentoPublicacion;
    private int cantidadMeGusta;
    private ArrayList<String> comentarios;

    /**
     * Constructor for objects of class EntradaTexto
     */
    public EntradaTexto(String autor,String texto)
    {
        usuario = autor;
        mensaje = texto;
    }

    public void meGusta()
    {

    }

    public void addCmentarios(String text)
    {
        comentarios.add(text);
    }

    public String getMensaje()
    {
        return mensaje;
    }

    public LocalDateTime getMomentoPublicacion()
    {
        return momentoPublicacion;
    }

    public String toString()
    {
        String textoADevolver = "";
       	LocalTime horaActual = LocalTime.now();
		int minutosActuales = horaActual.getMinute();
		int segundosActuales = horaActual.getSecond();
		int minutosPublicacion = momentoPublicacion.getMinute();
		int segundosPublicacion = momentoPublicacion.getSecond();
		int tiempoFinalMinutos = minutosActuales -minutosPublicacion;
		int tiempoFinalSegundos = segundosActuales - segundosPublicacion;
		String momentoFinal= Integer.toString(tiempoFinalSegundos);

        if (comentarios == null){
            textoADevolver ="La entrada no tiene comentarios";
        }
        else{
            textoADevolver ="Usuario: "+usuario+ " Mensaje: "+mensaje+ " Momento Publicacion: "+momentoFinal+ 
            " Cantidad Me Gusta: "+cantidadMeGusta+ "Comentarios: " +comentarios;
        }
        System.out.println(horaActual);
        return textoADevolver;
    }	

}