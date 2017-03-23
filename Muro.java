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

        //bucle que recorra los elementos del arrayList entrada.
        for (Entrada nuevaEntrada : entrada){
            cadenaAdevolver += nuevaEntrada+ "\n";
        }

        return cadenaAdevolver;
    }

    public void mostrar()
    {
        System.out.println(this);
    }

    public void verCantidadDatosPorEntrada()
    {
        for (int i=0; i<entrada.size();i++)
        {
            System.out.println(entrada.get(i).getCantidadDeDatosAsociadosALaEntrada());
        }

        /*
         * for (Entrada entradaActual : entrada)
         * {
         *     System.out.println(entrada.getCantidadDeDatosAsociadosALaEntrada());
         *  }
         */
    }

    public void mostrarDatosExclusivosEntradasFiltradas(String tipoEntrada, String autor)
    {
        //Recorremos el bucle for each
        for (Entrada entradaActual : entrada)
        {
            //comprobamos que las entradas son del mismo tipo
            if(entradaActual.getClass().getSimpleName().equals(tipoEntrada) ||tipoEntrada == null )
            {
                //Comprobamos el autor
                if (autor.equals(entradaActual.getUsuario()) ||tipoEntrada == null )
                {
                    //comprobamos de que tipo es la entradaActual
                    if(entradaActual instanceof EntradaTexto)
                    {
                        //imprimimos por pantalla
                        ((EntradaTexto)entradaActual).mostrarDatosExclusivos();
                    }
                    else if( entradaActual instanceof EntradaFoto)
                    {
                        ((EntradaFoto)entradaActual).mostrarDatosExclusivos();
                    }
                    else
                    {
                        ((EntradaUnionGrupo)entradaActual).mostrarDatosExclusivos();
                    }
                }
            }
        }
    }
}

