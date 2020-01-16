/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import edu.eci.cnyt.libreria.Complejo;
import edu.eci.cnyt.libreria.ComplejoLib;
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
    ComplejoLib libreria =new ComplejoLib();
    public ComplejoLibTest() {
    }
    
    @Test
    public  void TestSuma() {
       Complejo a = new Complejo(3.0,-1.0);
       Complejo b = new Complejo(1.0,4.0);
       Complejo resp= ComplejoLib.suma(a, b);
       System.out.println(resp.getReal());
       System.out.println(resp.getImaginrio());
       assertTrue(resp.getReal()==4.0&&resp.getImaginrio()==3.0 );
    }
    @Test
    public  void TestResta() {
       Complejo a = new Complejo(3.0,-1.0);
       Complejo b = new Complejo(1.0,4.0);
       Complejo resp= ComplejoLib.resta(a, b);
       
       System.out.println("------REST-----------------");
        System.out.println(resp.getReal());
       System.out.println(resp.getImaginrio());
       assertTrue(resp.getReal()==2.0&&resp.getImaginrio()==-5.0 );
    }
    @Test
    public  void TestMultiplicacion() {
       Complejo a = new Complejo(3.0,-1.0);
       Complejo b = new Complejo(1.0,4.0);
       Complejo resp= ComplejoLib.multiplicacion(a, b);
       System.out.println("------MULT-----------------");
       System.out.println(resp.getReal());
       System.out.println(resp.getImaginrio());
       assertTrue(resp.getReal()==7.0&&resp.getImaginrio()==11.0 );
    }
    @Test
    public  void TestDivicion() {
       Complejo a = new Complejo(-2.0,1.0);
       Complejo b = new Complejo(1.0,2.0);
       Complejo resp= ComplejoLib.division(a, b);
       System.out.println("------DIVIDIR-----------------");
       System.out.println(Math.round(resp.getReal()));
       System.out.println(resp.getImaginrio());
       assertTrue(Math.round(resp.getReal())==0 &&resp.getImaginrio()==1.0);
        //assertTrue(true);
       
    }
    @Test
    public  void TestModulo() {
        Complejo a = new Complejo(1.0,-1.0);
        Double rta=ComplejoLib.Modulo(a);
        assertTrue((Objects.equals(rta, (Double)(Math.sqrt(2)))));
    }
    @Test
    public  void TestConjugado() {
        Complejo a = new Complejo(1.0,-1.0);
        Complejo rta=ComplejoLib.Conjugado(a);
        assertTrue(rta.getReal()==1.0 && rta.getImaginrio()==1.0);
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
