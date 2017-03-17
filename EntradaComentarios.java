import java.util.ArrayList;
public class EntradaComentarios extends Entrada
{
    private ArrayList<String> comentarios;
    
    public EntradaComentarios(String autor)
    {
        super(autor);
        comentarios = new ArrayList<>();
    }

    //añade al arraylist el comentario.
    public void addCmentarios(String text)
    {
        comentarios.add(text);
    }

    //Devuelve los comentarios que hay en el array list.
    public ArrayList <String> getComentarios()
    {
        return comentarios;
    }
}
