import java.time.*;
public class Entrada
{
    private String usuario;
    private LocalDateTime momentoPublicacion;
    private int cantidadMeGusta;

    public Entrada(String autor)
    {
        usuario = autor;
        momentoPublicacion = LocalDateTime.now();
        cantidadMeGusta = 0;
    }

    //Aumenta la cantidad de me gusta.
    public void meGusta()
    {
        cantidadMeGusta++;
    }

    //devuelve la fecha del momento de la publicacion.
    public LocalDateTime getMomentoPublicacion()
    {
        return momentoPublicacion;
    }

    //Devuelve el nombre de usuario.
    public String getUsuario()
    {
        return usuario;
    }

    //Devuelve la cantidad de me gusta.
    public int getCantidadMeGusta()
    {
        return cantidadMeGusta;
    }

    
    public String toString()
    {
        return "";
    }
    
    public void mostrar()
    {
    }
    
}
