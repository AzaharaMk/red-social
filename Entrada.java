import java.time.*;
import java.time.temporal.ChronoUnit;
public abstract class Entrada
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
        String textoADevolver = "";
        textoADevolver += "<h2>" +getUsuario()+ "</h2>";
        
        //Calculamos los segundos y minutos que han pasado
        long segundosQueHanPasadoDesdeCreacion = getMomentoPublicacion().until(LocalDateTime.now(),ChronoUnit.SECONDS);
        long minutosQueHanPasadoDesdeCreacion = segundosQueHanPasadoDesdeCreacion / 60;
        long segundosResiduales = segundosQueHanPasadoDesdeCreacion % 60;

        textoADevolver += "Hace ";
        if(minutosQueHanPasadoDesdeCreacion > 0 )
        {
            textoADevolver += minutosQueHanPasadoDesdeCreacion+ " minutos";
        }
       
        textoADevolver+= segundosResiduales + " segundos <br/>";
        textoADevolver += getCantidadMeGusta()+ " me gusta.<br/>";
        
        return textoADevolver;
    }
    
    public abstract void mostrar();
    
    public abstract int getCantidadDeDatosAsociadosALaEntrada();
    
    

    
}
