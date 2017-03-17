import java.time.*;
import java.time.temporal.ChronoUnit;
public class EntradaUnionGrupo extends Entrada
{
    //Nombre del grupo al que se ha unido el usuario
    private String grupo;

    public EntradaUnionGrupo (String usuario,String grupo)
    {
        super(usuario);
        this.grupo = grupo;
    }

    public String toString()
    {
        String textoADevolver = "";

        textoADevolver += "El usuario: "+getUsuario();
        textoADevolver += " se ha unido al grupo " +grupo+ "\n";
        textoADevolver += "Cantidad Me Gusta: "+getCantidadMeGusta()+ "\n";
        //Calculamos los segundos y minutos que han pasado
        long segundosQueHanPasadoDesdeCreacion = getMomentoPublicacion().until(LocalDateTime.now(),ChronoUnit.SECONDS);
        long minutosQueHanPasadoDesdeCreacion = segundosQueHanPasadoDesdeCreacion / 60;
        long segundosResiduales = segundosQueHanPasadoDesdeCreacion % 60;

        textoADevolver += "Hace ";
        if(minutosQueHanPasadoDesdeCreacion > 0 ){
            textoADevolver += minutosQueHanPasadoDesdeCreacion+ " minutos";
        }
        textoADevolver+= segundosResiduales + " segundos \n";
        return textoADevolver;
    }
    
    public void mostrar()
    {
        System.out.println(this);
    }
}   

