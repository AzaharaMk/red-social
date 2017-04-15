import java.util.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.net.URL;
import java.io.*;
import java.time.LocalDateTime;
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
        for (Entrada nuevaEntrada : entrada)
        {
            cadenaAdevolver += nuevaEntrada+ "<br/>";
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
        //Recorremos el bucle for each recorriendo todas las entradas
        for (Entrada entradaActual : entrada)
        {
            //comprobamos que las entradas son del mismo tipo de Entrada
            if(entradaActual.getClass().getSimpleName().equals(tipoEntrada) || tipoEntrada == null)
            {
                //Comprobamos el autor
                if (entradaActual.getUsuario().equals(autor) ||autor == null)
                {
                    //comprobamos de que tipo es la entradaActual
                    if(entradaActual instanceof EntradaTexto)
                    {
                        //imprimimos por pantalla los datos exclusivos utilizando el casting 
                        ((EntradaTexto)entradaActual).mostrarDatosExclusivos();
                    }
                    else if( entradaActual instanceof EntradaFoto)
                    {
                        //imprimimos por pantalla los datos exclusivos utilizando el casting 
                        ((EntradaFoto)entradaActual).mostrarDatosExclusivos();
                    }
                    else if (entradaActual instanceof EntradaUnionGrupo)
                    {
                        //imprimimos por pantalla los datos exclusivos utilizando el casting
                        ((EntradaUnionGrupo)entradaActual).mostrarDatosExclusivos();
                    }
                }
            }
        }
    }

    /**
     * Método que al invocarlo construya una página HTML en la carpeta donde está el proyecto con el contenido de todas las entradas del muro 
     * y abra una ventana del navegador que muestre dicho archivo HTML. 
     */
    public void mostrarMuroEnNavegado()
    {
        // Obtenemos una referencia a una ruta donde estará el archivo
        Path rutaArchivo = Paths.get("muroNavegador.html");

        // Abrimos el archivo, escribimos en él y lo cerramos. Si se produce una
        try  
        {
            BufferedWriter archivo = Files.newBufferedWriter(rutaArchivo);
            archivo.write("<html>");
            archivo.write("<head>");
            archivo.write("<link rel=\"STYLESHEET\" type=\"text/css\" href=\"estilos.css\">" );
            archivo.write("</head>");
            archivo.write("<body>");
            archivo.write("<h1>Red social de Azahara</h1>");

            for (int i =0; i<entrada.size();i++)
            {
                archivo.write(entrada.get(i) +"<br />");
            }
            archivo.write("</body>");
            archivo.write("</html>");
            archivo.close();
        }
        catch (IOException excepcion) 
        {
            // Mostramos por pantalla la excepción que se ha producido
            System.out.println(excepcion.toString());
        }

        //Hacemos que la página HTML se abra automáticamente en el navegador en cuanto invoquemos el método
        try 
        {
            String cmd = "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome "+"muroNavegador.html";
            Runtime.getRuntime().exec(cmd); 
        } 
        catch (IOException ioe) 
        {
            System.out.println (ioe);
        }
    }
    
     public void mostrarMuroEnNavegador2(String usuario)
    {
       //guardamos la url y leemos el documento con el nombre de usuario.
      try {
            URL url = new URL("https://script.google.com/macros/s/AKfycbzHc3p1twTfyF7o0_cxSwnxSsyOemuHnSu406ly9DZIf5Ck2BA/exec?user="+usuario);
            Scanner sc = new Scanner(url.openStream());
            while (sc.hasNextLine()) {
               //guardas linea actual en una variable de String
                String lineaLeida= sc.nextLine();
               //cortas las lineas que van separadas por ;
                String[] muroNavegador=lineaLeida.split(";");
               
                //Creamos el objeto correspondiente a la entrada
                if (muroNavegador[0].equals("EntradaFoto")){
                     EntradaFoto entradaFoto = new EntradaFoto(muroNavegador[1],muroNavegador[4], muroNavegador[5]);
                     this.entrada.add(entradaFoto);
                     
                     int cont = 0;
                     while(cont<Integer.parseInt(muroNavegador[2])){
                       entradaFoto.meGusta();
                       cont++;
                     }
                     
                     cont = 0;
                     muroNavegador[3] = muroNavegador[3].replace("-","/");
                     muroNavegador[3] = muroNavegador[3].replace(":","/");
                     
                     String fechaYHora[] = muroNavegador[3].split("/");
                     int[] elementosFechaHora = new int[5];
                     while(cont < 5){
                         elementosFechaHora[cont] = Integer.parseInt(fechaYHora[cont]);
                         cont++;
                     }
                     LocalDateTime momentoLeido = LocalDateTime.of(elementosFechaHora[2], elementosFechaHora[1], elementosFechaHora[0], elementosFechaHora[3], elementosFechaHora[4]);
                     entradaFoto.añadirMomentoPublicacion(momentoLeido);
                     
                     if(!muroNavegador[6].equals("Sin comentarios")){
                         String comentarios[] = muroNavegador[6].split("%");
                         
                         cont = 0;
                         while(cont<comentarios.length){
                             entradaFoto.addComentarios(comentarios[cont]);
                             cont++;
                         }
                     }
                 }
                 else if (muroNavegador[0].equals("EntradaTexto")) {
                     EntradaTexto entradaTexto = new EntradaTexto(muroNavegador[1],muroNavegador[4]);
                     this.entrada.add(entradaTexto);
                     
                     int cont = 0;
                     while(cont<Integer.parseInt(muroNavegador[2])){
                       entradaTexto.meGusta();
                       cont++;
                     }
                     
                     cont = 0;
                     muroNavegador[3] = muroNavegador[3].replace("-","/");
                     muroNavegador[3] = muroNavegador[3].replace(":","/");
                     
                     String fechaYHora[] = muroNavegador[3].split("/");
                     int[] elementosFechaHora = new int[5];
                     while(cont < 5){
                         elementosFechaHora[cont] = Integer.parseInt(fechaYHora[cont]);
                         cont++;
                     }
                     LocalDateTime momentoLeido = LocalDateTime.of(elementosFechaHora[2], elementosFechaHora[1], elementosFechaHora[0], elementosFechaHora[3], elementosFechaHora[4]);
                     entradaTexto.añadirMomentoPublicacion(momentoLeido);
                     
                     if(!muroNavegador[5].equals("Sin comentarios")){
                         String comentarios[] = muroNavegador[5].split("%");
                         
                         cont = 0;
                         while(cont<comentarios.length){
                             entradaTexto.addComentarios(comentarios[cont]);
                             cont++;
                         }
                     }
                 }
                 else if (muroNavegador[0].equals("EntradaUnionGrupo")) {
                     EntradaUnionGrupo entradaUnionGrupo = new EntradaUnionGrupo(muroNavegador[1], muroNavegador[4]);
                     this.entrada.add(entradaUnionGrupo);
                     
                     int cont = 0;
                     while(cont<Integer.parseInt(muroNavegador[2])){
                       entradaUnionGrupo.meGusta();
                       cont++;
                     }
                     
                     cont = 0;
                     muroNavegador[3] = muroNavegador[3].replace("-","/");
                     muroNavegador[3] = muroNavegador[3].replace(":","/");
                     
                     String fechaYHora[] = muroNavegador[3].split("/");
                     int[] elementosFechaHora = new int[5];
                     while(cont < 5){
                         elementosFechaHora[cont] = Integer.parseInt(fechaYHora[cont]);
                         cont++;
                     } 
                 }
            }
            sc.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
       this.mostrarMuroEnNavegado();
    }
}

