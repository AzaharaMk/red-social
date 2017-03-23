import java.time.*;
import java.time.temporal.ChronoUnit;

public class EntradaTexto extends EntradaComentarios
{
    private String mensaje;
    
    public EntradaTexto (String autor,String texto)
    {
        super(autor);
        mensaje = texto;
    }
    
    //Devuelve el contenido del mensaje.
    public String getMensaje()
    {
        return mensaje;
    }

    public String toString()
    {
        String textoADevolver= "";
        
        //Invocamos a la clase padre toString y se gaurda en la variable local.
        textoADevolver+= super.toString();
        
        textoADevolver += "Mensaje: "+mensaje+ "\n";
     
        return textoADevolver;
    }
    
    public void mostrarAutorYMensaje()
    {
        String autorMensaje = "";
        autorMensaje += "Autor: "+getUsuario()+"\n";
        autorMensaje += "Mensaje: "+mensaje+" \n";
        System.out.println(autorMensaje);
    }
    
    public void mostrar()
    {
        System.out.println(this);
    }
    
    public int getCantidadDeDatosAsociadosALaEntrada()
    {
        return 5;
    }
    
    public void mostrarDatosExclusivos()
    {
       String mensaje = getMensaje() ;
       System.out.println (mensaje);
    }

}   

