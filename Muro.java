import java.util.ArrayList;

public class Muro
{
    private ArrayList <Entrada> entrada;
    
    public Muro()
    {
        entrada = new ArrayList<>();
    }
   
    public void addEntrada(Entrada nuevaEntrada)
    {
        entrada.add(nuevaEntrada);
    }
    
    public String toString()
    {
        String cadenaAdevolver = "";
        
        //bucle que recorra los elementos de post
        for (Entrada nuevaEntrada : entrada){
            cadenaAdevolver += nuevaEntrada+ "\n";
        }
   
        return cadenaAdevolver;
    }
    
    public void mostrar()
    {
        System.out.println(this);
    }
}
