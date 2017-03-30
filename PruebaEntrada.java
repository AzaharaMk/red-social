

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class PruebaEntrada.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class PruebaEntrada
{
    private EntradaTexto entradaT1;
    private EntradaFoto entradaF1;
    private EntradaUnionGrupo entradaU1;
    private EntradaTexto entradaT2;
    private EntradaFoto entradaF2;
    private EntradaUnionGrupo entradaU2;
    private Muro muro1;

    
    
    
    
    
    
    

    
    
    
    
    
    
    

    /**
     * Default constructor for test class PruebaEntrada
     */
    public PruebaEntrada()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        entradaT1 = new EntradaTexto("Azahara", "hola a todos");
        entradaF1 = new EntradaFoto("Azahara", "http://imagenesdefrasesbonitas.com/wp-content/uploads/2016/09/imagenes-bonitas-para-facebook-perfil-640x350.jpg", "foto Azahara");
        entradaU1 = new EntradaUnionGrupo("Azahara", "DAM1");
        entradaT2 = new EntradaTexto("usuario1", "soy usuario1");
        entradaF2 = new EntradaFoto("usuario1", "http://imagenpng.com/wp-content/uploads/2015/09/imagenes-png-635x508.png", "foto usuario 1");
        entradaU2 = new EntradaUnionGrupo("usuario 1", "ASIR1");
        muro1 = new Muro();
        muro1.addEntrada(entradaT1);
        muro1.addEntrada(entradaF1);
        muro1.addEntrada(entradaU1);
        muro1.addEntrada(entradaT2);
        muro1.addEntrada(entradaF2);
        muro1.addEntrada(entradaU2);
        entradaF1.addCmentarios("me gusta la foto¡");
        entradaF2.getComentarios();
        entradaF2.addCmentarios("esa foto es muy chula");
        entradaF2.addCmentarios("no me gusta mucho...");
        muro1.mostrarMuroEnNavegado();
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }
}
