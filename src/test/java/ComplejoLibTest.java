/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import edu.eci.cnyt.libreria.Complejo;
import edu.eci.cnyt.libreria.ComplejoLib;
import edu.eci.cnyt.libreria.Vector;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
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
        //System.out.println(resp.getReal());
        //System.out.println(resp.getImaginrio());
        assertTrue(resp.getReal() == 4.0 && resp.getImaginrio() == 3.0);

        Complejo Cua1 = ComplejoLib.multiplicacion(new Complejo(6.0, 6.2), new Complejo(6.0, 6.2));
        Complejo Cua2 = ComplejoLib.multiplicacion(new Complejo(6.0, -7.4), new Complejo(6.0, -7.4));

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
        assertTrue(rta.getImaginrio() == 0.7853981633974483 && rta.getReal() == 1.4142135623730951);
    }

    @Test
    public void TestFase() {
        Complejo a = new Complejo(1.0, 1.0);
        Double rta = ComplejoLib.fase(a);
        assertTrue(rta == 0.7853981633974483);
    }

    @Test
    public void TestSumaVectores() {
        ArrayList<Complejo> a = new ArrayList<Complejo>();
        ArrayList<Complejo> b = new ArrayList<Complejo>();
        Complejo a1 = new Complejo(6.0, -4.0);
        Complejo a2 = new Complejo(7.0, 3.0);
        Complejo a3 = new Complejo(4.2, -8.1);
        Complejo a4 = new Complejo(0.0, -3.0);
        Complejo b1 = new Complejo(16.0, 2.3);
        Complejo b2 = new Complejo(0.0, -7.0);
        Complejo b3 = new Complejo(6.0, 0.0);
        Complejo b4 = new Complejo(0.0, -4.0);
        a.add(a1);
        a.add(a2);
        a.add(a3);
        a.add(a4);
        b.add(b1);
        b.add(b2);
        b.add(b3);
        b.add(b4);
        Vector v = new Vector(a);
        Vector w = new Vector(b);
        Vector r = libreria.sumaVectores(v, w);
        String respuesta = " 22.0 -1.7 7.0 -4.0 10.2 -8.1 0.0 -7.0";
        assertTrue(r.toString().equals(respuesta));

    }

    @Test
    public void TestInversaVectores() {
        ArrayList<Complejo> b = new ArrayList<Complejo>();
        Complejo b1 = new Complejo(6.0, -4.0);
        Complejo b2 = new Complejo(7.0, 3.0);
        Complejo b3 = new Complejo(4.2, -8.1);
        Complejo b4 = new Complejo(0.0, -3.0);
        b.add(b1);
        b.add(b2);
        b.add(b3);
        b.add(b4);
        Vector w = new Vector(b);
        Vector r = ComplejoLib.inversaVector(w);
        String respuesta = " -6.0 4.0 -7.0 -3.0 -4.2 8.1 -0.0 3.0";
        assertTrue(r.toString().equals(respuesta));
    }

    @Test
    public void TestComplejoXVector() {
        Complejo a = new Complejo(1.0, 1.0);
        Double rta = ComplejoLib.fase(a);
        assertTrue(rta == 0.7853981633974483);
    }

    @Test
    public void canicas_con_coeficiente_booleanos() {
        System.out.println("---------Canicas_Con_Coeficiente_Booleanos Test---------");
        System.out.println(" ");
        System.out.println("-------Libro Ejemplo-----------");
        int[][] m = {{0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0},
        {0, 1, 0, 0, 0, 1},
        {0, 0, 0, 1, 0, 0},
        {0, 0, 1, 0, 0, 0},
        {1, 0, 0, 0, 1, 0}};
        Double[] v = {6.0, 2.0, 1.0, 5.0, 3.0, 10.0};
        int Clicks = 1;
        Double[] r = ComplejoLib.CanicasEsperimentoNormal(m, v, Clicks);
        for (Double e : r) {
            System.out.println(e);
        }
        Double[] resp = {0.0, 0.0, 12.0, 5.0, 1.0, 9.0};
        assertArrayEquals(r, resp);
        System.out.println(" ");
        System.out.println("-------Quiz pregunta 2------------");
        int[][] m2 = {{0, 0, 0, 0, 0, 0},
        {0, 0, 0, 1, 0, 0},
        {0, 1, 0, 0, 0, 1},
        {0, 0, 1, 0, 0, 0},
        {0, 0, 0, 0, 1, 0},
        {1, 0, 0, 0, 0, 0}};

        Double[] v2 = {6.0, 0.0, 3.0, 5.0, 3.0, 8.0};
        Clicks = 5000;
        r = ComplejoLib.CanicasEsperimentoNormal(m2, v2, Clicks);
        Double[] resp2 = {0.0, 3.0, 11.0, 8.0, 3.0, 0.0};
        for (Double e : r) {
            System.out.println(e);
        }
        assertArrayEquals(r, resp2);
        System.out.println(" ");
        ComplejoLib.graficarEstado(r, "canicas_con_coeficiente_booleanos_quiz");
    }

    @Test
    public void MultiplesRendijasExperiemnto() {
        System.out.println("---------Multiples Rendijas Experiemnto Clasico ---------");
        System.out.println(" ");
        HashMap<String, Double> probabilidades = new HashMap<>();
        probabilidades.put("0-1", 0.50);
        probabilidades.put("0-2", 0.50);
        probabilidades.put("1-3", 0.33);
        probabilidades.put("1-4", 0.33);
        probabilidades.put("1-5", 0.33);
        probabilidades.put("2-5", 0.33);
        probabilidades.put("2-6", 0.33);
        probabilidades.put("2-7", 0.33);
        Double[][] m = ComplejoLib.getMatrizXmatriz(2, 5, probabilidades);
        Double[] v2 = {1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
        Double[] r = ComplejoLib.Experimentosdelasmúltiplesrendijasclásico(m, v2, 1);
        for (Double e : r) {
            System.out.println(e);
        }
        ComplejoLib.graficarEstado(r, "Multiples_Rendijas_Experiemnto");
    }

    @Test
    public void MultiplesRendijasExperiemntoCuantico() {
        System.out.println("---------Multiples Rendijas Experiemnto Cuantico ---------");
        System.out.println(" ");
        DecimalFormat df = new DecimalFormat("#.00");
        HashMap<String, Complejo> probabilidades = new HashMap<>();
        probabilidades.put("0-1", new Complejo(1 / Math.sqrt(2), 0.0));
        probabilidades.put("0-2", new Complejo(1 / Math.sqrt(2), 0.0));
        probabilidades.put("1-3", new Complejo(-1 / Math.sqrt(6), 1 / Math.sqrt(6)));
        probabilidades.put("1-4", new Complejo(-1 / Math.sqrt(6), -1 / Math.sqrt(6)));
        probabilidades.put("1-5", new Complejo(1 / Math.sqrt(6), -1 / Math.sqrt(6)));
        probabilidades.put("2-5", new Complejo(-1 / Math.sqrt(6), 1 / Math.sqrt(6)));
        probabilidades.put("2-6", new Complejo(-1 / Math.sqrt(6), -1 / Math.sqrt(6)));
        probabilidades.put("2-7", new Complejo(1 / Math.sqrt(6), -1 / Math.sqrt(6)));
        Double[][] m = ComplejoLib.getMatrizXmatrizCuantico(2, 5, probabilidades);
        Double[] v2 = {1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
        Double[] r = ComplejoLib.Experimentosdelasmúltiplesrendijasclásico(m, v2, 1);
        for (Double[] e : m) {
            System.out.println(Arrays.toString(e));
        }
        for (Double e : r) {
            System.out.println(e);
        }
        ComplejoLib.graficarEstado(r, "Multiples_Rendijas_Experiemnto_Cuantico");
    }

    @Test
    public void Sistema_cuántico_de_partícula_en_una_línea() {
        System.out.println("-----------------Sistema_cuántico_de_partícula_en_una_línea-----------------------");
        Complejo[] linea = {
            new Complejo(2.0, 1.0),
            new Complejo(-1.0, 2.0),
            new Complejo(0.0, 1.0),
            new Complejo(1.0, 0.0),
            new Complejo(3.0, -1.0),
            new Complejo(2.0, 0.0),
            new Complejo(0.0, -2.0),
            new Complejo(-2.0, 1.0),
            new Complejo(1.0, -3.0),
            new Complejo(0.0, -1.0)
        };

        for (int i = 0; i < linea.length; i++) {
            System.out.println(ComplejoLib.SistemaCuanticoPartUnalínea(linea, i));
        }
        System.out.println("----------------------------------------");

    }

    @Test
    public void probTransitarVectorAtro() {
        System.out.println("-----------------Sistema_cuántico_de_transicionnnn_en_una_línea-----------------------");
        ArrayList<Complejo> linea = new ArrayList<>();
        linea.add(new Complejo(2.0, 1.0));
        linea.add(new Complejo(-1.0, 2.0));
        linea.add(new Complejo(0.0, 1.0));
        linea.add(new Complejo(1.0, 0.0));
        linea.add(new Complejo(3.0, -1.0));
        linea.add(new Complejo(2.0, 0.0));
        linea.add(new Complejo(0.0, -2.0));
        linea.add(new Complejo(-2.0, 1.0));
        linea.add(new Complejo(1.0, -3.0));
        linea.add(new Complejo(0.0, -1.0));

        ArrayList<Complejo> linea2 = new ArrayList<>();
        linea2.add(new Complejo(-1.0, -4.0));
        linea2.add(new Complejo(2.0, -3.0));
        linea2.add(new Complejo(-7.0, 6.0));
        linea2.add(new Complejo(-1.0, 1.0));
        linea2.add(new Complejo(-5.0, -3.0));
        linea2.add(new Complejo(5.0, 0.0));
        linea2.add(new Complejo(5.0, 8.0));
        linea2.add(new Complejo(4.0, -4.0));
        linea2.add(new Complejo(8.0, -7.0));
        linea2.add(new Complejo(2.0, -7.0));
        System.out.println(ComplejoLib.AmpliTransitarVectorAtro(new Vector(linea),new Vector(linea2)));
    }
    

       
       

    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}

