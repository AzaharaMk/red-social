import java.util.ArrayList;
public abstract class EntradaComentarios extends Entrada
{
    private ArrayList<String> comentarios;
    
    public EntradaComentarios(String autor)
    {
        super(autor);
        comentarios = new ArrayList<>();
    }

    //añade al arraylist el comentario.
    public void addComentarios(String text)
    {
        comentarios.add(text);
    }

    //Devuelve los comentarios que hay en el array list.
    public ArrayList <String> getComentarios()
    {
        return comentarios;
    }
    
    public String toString()
    {
        String textoADevolver = "";
        //Invocamos el toString de la clase padre y lo gaurdamos en nuestra variable.
        textoADevolver += super.toString();
        
        //comprobamos si el arraylist está vacío
        if (getComentarios().isEmpty())
        {
            textoADevolver += "La entrada no tiene comentarios. <br/>";
        }
        else
        {
            textoADevolver += "<b>Comentarios:</b> <br/>";
            //guardamos los comentarios
            for(String comentario : getComentarios())
            {
                textoADevolver += comentario + "<br/>";
            }
        }
        return textoADevolver;
    }
}
