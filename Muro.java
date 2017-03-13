import java.util.ArrayList;

public class Muro
{
    private ArrayList <EntradaTexto> mensajes;
    private ArrayList <EntradaFoto> fotos;

    public Muro()
    {
        
    }

    public void addEntradaTexto(EntradaTexto entradaTexto)
    {
        mensajes.add(entradaTexto);
    }
    
    public void addEntradaFoto(EntradaFoto entradaFoto)
    {
        fotos.add(entradaFoto);
    }
    
    public String toString()
    {
        return "";
    }
}
