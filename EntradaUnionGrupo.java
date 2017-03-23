
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
        //invocamos el toString de la clase padre y lo guardamos en nuestra variable local.
        textoADevolver += super.toString();
        
        textoADevolver +="Se ha unido al grupo " +grupo+ "\n";
        return textoADevolver;
    }
    
    public void mostrar()
    {
        System.out.println(this);
    }
    
    public int getCantidadDeDatosAsociadosALaEntrada()
    {
        return 4;
    }
    
    public void mostrarDatosExclusivos()
    {
        System.out.println(grupo);
    }
}   

