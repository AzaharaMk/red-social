import java.util.ArrayList;

public class Muro
{
    private ArrayList <EntradaTexto> mensajes;
    private ArrayList <EntradaFoto> fotos;

    public Muro()
    {
        mensajes = new ArrayList<>();
        fotos = new ArrayList<>();
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
        String cadenaAdevolver = "";
        
        //bucle que recorra los elementos de post
        for (EntradaTexto entrada : mensajes){
            cadenaAdevolver += entrada+ "\n";
        }
        
        //bucle que recorra los elementos de imagen
        for (EntradaFoto entrada : fotos){
            cadenaAdevolver += entrada + "\n";
        }
        
        return cadenaAdevolver;
    }
    
    public void mostrar()
    {
        System.out.println(this);
    }
}
