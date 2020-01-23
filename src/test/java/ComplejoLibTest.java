/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import edu.eci.cnyt.libreria.Complejo;
import edu.eci.cnyt.libreria.ComplejoLib;
import edu.eci.cnyt.libreria.Vector;
import java.util.ArrayList;
import java.util.Objects;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author 2137497
 */
public class ComplejoLibTest {

    ComplejoLib libreria = new ComplejoLib();

    public ComplejoLibTest() {
    }

    @Test
    public void TestSuma() {
        Complejo a = new Complejo(3.0, -1.0);
        Complejo b = new Complejo(1.0, 4.0);
        Complejo resp = ComplejoLib.suma(a, b);
        System.out.println(resp.getReal());
        System.out.println(resp.getImaginrio());
        assertTrue(resp.getReal() == 4.0 && resp.getImaginrio() == 3.0);
    }

    @Test
    public void TestResta() {
        Complejo a = new Complejo(3.0, -1.0);
        Complejo b = new Complejo(1.0, 4.0);
        Complejo resp = ComplejoLib.resta(a, b);
        assertTrue(resp.getReal() == 2.0 && resp.getImaginrio() == -5.0);
    }

    @Test
    public void TestMultiplicacion() {
        Complejo a = new Complejo(3.0, -1.0);
        Complejo b = new Complejo(1.0, 4.0);
        Complejo resp = ComplejoLib.multiplicacion(a, b);
        assertTrue(resp.getReal() == 7.0 && resp.getImaginrio() == 11.0);
    }

    @Test
    public void TestDivicion() {
        Complejo a = new Complejo(-2.0, 1.0);
        Complejo b = new Complejo(1.0, 2.0);
        Complejo resp = ComplejoLib.division(a, b);

        assertTrue(Math.round(resp.getReal()) == 0 && resp.getImaginrio() == 1.0);
        //assertTrue(true);

    }

    @Test
    public void TestModulo() {
        Complejo a = new Complejo(1.0, -1.0);
        Double rta = ComplejoLib.Modulo(a);
        assertTrue((Objects.equals(rta, (Double) (Math.sqrt(2)))));
    }

    @Test
    public void TestConjugado() {
        Complejo a = new Complejo(1.0, -1.0);
        Complejo rta = ComplejoLib.Conjugado(a);
        assertTrue(rta.getReal() == 1.0 && rta.getImaginrio() == 1.0);
    }
    @Test
    public void TestPolar() {
        Complejo a = new Complejo(1.0, 1.0);
        Complejo rta = ComplejoLib.CartecianasApolares(a);
        assertTrue(rta.getImaginrio()==0.7853981633974483 && rta.getReal()==1.4142135623730951 );
    }
    @Test
    public void TestFase() {
        Complejo a = new Complejo(1.0, 1.0);
        Double rta = ComplejoLib.fase(a);
        assertTrue(rta==0.7853981633974483 );
    }
    @Test
    public void TestSumaVectores() {
        ArrayList<Complejo> a =new ArrayList<Complejo>();
        ArrayList<Complejo> b =new ArrayList<Complejo>();
        Complejo a1=new Complejo(6.0,-4.0);
        Complejo a2=new Complejo(7.0,3.0);
        Complejo a3=new Complejo(4.2,-8.1);
        Complejo a4=new Complejo(0.0,-3.0);
        Complejo b1=new Complejo(16.0,2.3);
        Complejo b2=new Complejo(0.0,-7.0);
        Complejo b3=new Complejo(6.0,0.0);
        Complejo b4=new Complejo(0.0,-4.0);
        a.add(a1);a.add(a2);a.add(a3);a.add(a4);
        b.add(b1);b.add(b2);b.add(b3);b.add(b4);
        Vector v=new Vector(a);
        Vector w=new Vector(b);
        Vector r=libreria.sumaVectores(v, w);
        String respuesta=" 22.0 -1.7 7.0 -4.0 10.2 -8.1 0.0 -7.0";
        assertTrue(r.toString().equals(respuesta));
      
    }
    @Test
    public void TestInversaVectores() {
        ArrayList<Complejo> b =new ArrayList<Complejo>();
        Complejo b1=new Complejo(6.0,-4.0);
        Complejo b2=new Complejo(7.0,3.0);
        Complejo b3=new Complejo(4.2,-8.1);
        Complejo b4=new Complejo(0.0,-3.0);
        b.add(b1);b.add(b2);b.add(b3);b.add(b4);
        Vector w=new Vector(b);
        Vector r=ComplejoLib.inversaVector(w);
        String respuesta=" -6.0 4.0 -7.0 -3.0 -4.2 8.1 -0.0 3.0";
        System.out.println(respuesta);
        System.out.println(r.toString());
        assertTrue(r.toString().equals(respuesta));
    }
    @Test
    public void TestComplejoXVector() {
        Complejo a = new Complejo(1.0, 1.0);
        Double rta = ComplejoLib.fase(a);
        assertTrue(rta==0.7853981633974483 );
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
