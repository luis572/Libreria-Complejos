/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cnyt.libreria;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import javax.imageio.ImageIO;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author 2137497
 */
public class ComplejoLib {

    public ComplejoLib() {

    }

    /**
     * Este metodo permite calcular la suma de dos numeros complejos
     *
     * @param a //tipo Complejo
     * @param b //tipo Complejo
     * @return Complejo
     */
    public static Complejo suma(Complejo a, Complejo b) {
        Double x = a.getReal() + b.getReal();
        Double y = a.getImaginrio() + b.getImaginrio();
        return new Complejo(redondearDecimales(x, 2), redondearDecimales(y, 2));
    }

    /**
     * Este metodo permite calcular la resta de dos numeros complejos
     *
     * @param a //tipo Complejo
     * @param b //tipo Complejo
     * @return Complejo
     */
    public static Complejo resta(Complejo a, Complejo b) {
        Double x = a.getReal() - b.getReal();
        Double y = a.getImaginrio() - b.getImaginrio();
        return new Complejo(x, y);
    }

    /**
     * Este metodo permite calcular la multiplicacion de dos numeros complejos
     *
     * @param a //tipo Complejo
     * @param b //tipo Complejo
     * @return Complejo
     */
    public static Complejo multiplicacion(Complejo a, Complejo b) {
        Double x = a.getReal() * b.getReal() - a.getImaginrio() * b.getImaginrio();
        Double y = a.getReal() * b.getImaginrio() + a.getImaginrio() * b.getReal();
        return new Complejo(redondearDecimales(x, 2), redondearDecimales(y, 2));
    }

    /**
     * Este metodo permite calcular la division de dos numeros complejos
     *
     * @param a //tipo Complejo
     * @param b //tipo Complejo
     * @return Complejo
     */
    public static Complejo division(Complejo a, Complejo b) {
        Double auxiliar = a.getReal() * a.getReal() + a.getImaginrio() * a.getImaginrio();
        Double x = (a.getReal() * b.getImaginrio() + a.getImaginrio() * b.getImaginrio()) / auxiliar;
        Double y = (a.getImaginrio() * b.getReal() - a.getReal() * b.getImaginrio()) / auxiliar;
        return new Complejo(redondearDecimales(x, 2), redondearDecimales(y, 2));
    }

    /**
     * Este metodo permite calcular el conjugado de un numero complejo
     *
     * @param a //tipo Complejo
     * @return Complejo
     */
    public static Complejo Conjugado(Complejo a) {
        return new Complejo(a.getReal(), a.getImaginrio() * -1);
    }

    /**
     * Este metodo permite calcular el modulo de un numero complejo
     *
     * @param a //tipo Complejo
     * @return Complejo
     */
    public static Double Modulo(Complejo a) {
        return Math.sqrt((a.getReal() * a.getReal()) + (a.getImaginrio() * a.getImaginrio()));
    }

    public static Double Mod(Complejo a) {
        return (a.getReal() * a.getReal()) + (a.getImaginrio() * a.getImaginrio());
    }

    /**
     * Este metodo permite calcular el las cordenadas polares de un numero
     * complejo
     *
     * @param a //tipo Complejo
     * @return Complejo
     */
    public static Complejo CartecianasApolares(Complejo a) {
        Double angulo = Math.atan2(a.getReal(), a.getImaginrio());
        Double p = Math.sqrt(a.getReal() * a.getReal() + a.getImaginrio() * a.getImaginrio());
        return new Complejo(p, angulo);
    }

    /**
     * Este metodo permite calcular la fase de un numero complejo
     *
     * @param a //tipo Complejo
     * @return Double
     */
    public static Double fase(Complejo a) {

        Double angulo = Math.atan2(a.getReal(), a.getImaginrio());
        return angulo;
    }

    /**
     * Este metodo permite calcular el inverso de un numero complejo
     *
     * @param a //tipo Complejo
     * @return Complejo
     */
    public static Complejo InversaComplejo(Complejo a) {
        return new Complejo(a.getReal() * -1, a.getImaginrio() * -1);
    }

    /**
     * Este metodo permite calcular el suma de vectores
     *
     * @param a //tipo vector
     * @param b //tipo vector
     * @return Vector
     */
    public static Vector sumaVectores(Vector a, Vector b) {
        int r = a.getVec().size();
        ArrayList<Complejo> vectorResultado = new ArrayList<Complejo>();
        for (int i = 0; i < r; i++) {
            vectorResultado.add(suma(a.getVec().get(i), b.getVec().get(i)));
        }
        Vector v = new Vector(vectorResultado);
        return v;
    }

    /**
     * Este metodo permite calcular el inverso un de Vector
     *
     * @param a //tipo vector
     * @return Vector
     */
    public static Vector inversaVector(Vector a) {
        int r = a.getVec().size();
        ArrayList<Complejo> vectorResultado = new ArrayList<Complejo>();
        for (int i = 0; i < r; i++) {
            vectorResultado.add(InversaComplejo(a.getVec().get(i)));
        }
        Vector v = new Vector(vectorResultado);
        return v;
    }

    /**
     * Este metodo permite calcular la multiplicacion entre un vector y un
     * complejo
     *
     * @param a //tipo vector
     * @param b //tipo complejo
     * @return Vector
     */
    public static Vector VectorXComplejo(Vector a, Complejo b) {
        int r = a.getVec().size();
        ArrayList<Complejo> vectorResultado = new ArrayList<Complejo>();
        for (int i = 0; i < r; i++) {
            vectorResultado.add(multiplicacion(a.getVec().get(i), b));
        }
        Vector v = new Vector(vectorResultado);
        return v;
    }

    /**
     * Este metodo permite calcular la suma entre matrices.
     *
     * @param m1 //tipo Complejo[][]
     * @param m2 //tipo Complejo[][]
     * @return Matriz
     */
    public static Matriz sumaDeMatrizes(Complejo[][] m1, Complejo[][] m2) {
        Complejo r[][] = new Complejo[m1.length][m1[0].length];
        for (int i = 0; i < m1.length; i++) {
            for (int j = 0; j < m1[0].length; j++) {
                r[i][j] = suma(m1[i][j], m2[i][j]);
            }
        }
        return new Matriz(r);
    }

    /**
     * Este metodo permite calcular la resta entre matrices.
     *
     * @param m1 //tipo Complejo[][]
     * @param m2 //tipo Complejo[][]
     * @return Matriz
     */
    public static Matriz restaDeMatrizes(Complejo[][] m1, Complejo[][] m2) {
        Complejo r[][] = new Complejo[m1.length][m1[0].length];
        for (int i = 0; i < m1.length; i++) {
            for (int j = 0; j < m1[0].length; j++) {
                r[i][j] = resta(m1[i][j], m2[i][j]);

            }
        }
        return new Matriz(r);
    }

    /**
     * Este metodo permite calcular la resta entre matrices.
     *
     * @param m1 //tipo Complejo[][]
     * @return Matriz
     */
    public static Matriz inversaMatriz(Complejo[][] m1) {
        Complejo r[][] = new Complejo[m1.length][m1[0].length];
        for (int i = 0; i < m1.length; i++) {
            for (int j = 0; j < m1[0].length; j++) {
                r[i][j] = InversaComplejo(m1[i][j]);
            }
        }
        return new Matriz(r);
    }

    /**
     * Este metodo permite calcular la multiplicacion entre una matriz y un
     * escalar.
     *
     * @param c1 //tipo Complejo
     * @param m1 //tipo Complejo[][]
     * @return Matriz
     */
    public static Matriz productoScalar(Complejo c1, Complejo[][] m1) {
        Complejo r[][] = new Complejo[m1.length][m1[0].length];
        for (int i = 0; i < m1.length; i++) {
            for (int j = 0; j < m1[0].length; j++) {
                r[i][j] = multiplicacion(c1, m1[i][j]);
            }
        }
        return new Matriz(r);
    }

    /**
     * Este metodo permite calcular transpuesta de una matriz.
     *
     * @param m1 //tipo Complejo[][]
     * @return Matriz
     */
    public static Matriz transpuestaMatriz(Complejo[][] m1) {
        Complejo r[][] = new Complejo[m1.length][m1[0].length];
        for (int i = 0; i < m1.length; i++) {
            for (int j = 0; j < m1[0].length; j++) {
                r[i][j] = m1[j][i];
            }
        }
        return new Matriz(r);
    }

    /**
     * Este metodo permite calcular transpuesta de una matriz.
     *
     * @param v //tipo Vector
     * @return Vector
     */
    public static Vector transpuestaVector(Vector v) {
        return v;
    }

    /**
     * Este metodo permite calcular el conjugado de vector.
     *
     * @param v // Vector
     * @return vector
     */
    public static Vector conjugadoVector(Vector v) {
        ArrayList<Complejo> vectorResultado = new ArrayList<Complejo>();
        for (int i = 0; i < v.getVec().size(); i++) {
            vectorResultado.add(Conjugado(v.getVec().get(i)));
        }
        return new Vector(vectorResultado);

    }

    /**
     * Este metodo permite calcular el conjugado de una matriz.
     *
     * @param m1 //Complejo[][]
     * @return Matriz
     */
    public static Matriz conjugadoMatriz(Complejo[][] m1) {
        Complejo r[][] = new Complejo[m1.length][m1[0].length];
        for (int i = 0; i < m1.length; i++) {
            for (int j = 0; j < m1[0].length; j++) {
                r[i][j] = Conjugado(m1[j][i]);
            }
        }
        return new Matriz(r);
    }

    /**
     * Este metodo permite calcular la adjunta de una matriz.
     *
     * @param m1 //Complejo[][]
     * @return Matriz
     */
    public static Matriz adjuntaMatriz(Complejo[][] m1) {
        Complejo r[][] = conjugadoMatriz(transpuestaMatriz(m1).getMatriz()).getMatriz();
        return new Matriz(r);
    }

    /**
     * Este metodo permite calcular la adjunta de un vector.
     *
     * @param v //Vector
     * @return Vector
     */
    public static Vector adjuntaVector(Vector v) {
        return conjugadoVector(transpuestaVector(v));
    }

    /**
     * Este metodo permite calcular la multiplicacion entre dos matrizes.
     *
     * @param m1 //Complejo[][]
     * @param m2 //Complejo[][]
     * @return Matriz
     */
    public static Matriz productoMatrices(Complejo[][] m1, Complejo[][] m2) {
        Complejo sum;
        Complejo r[][] = new Complejo[m1.length][m1[0].length];
        for (int i = 0; i < m1.length; i++) {
            for (int j = 0; j < m2[0].length; j++) {
                sum = new Complejo(0.0, 0.0);
                for (int k = 0; k < m1[0].length; k++) {
                    sum = suma(sum, multiplicacion(m1[i][k], m2[k][j]));
                }
                r[i][j] = sum;
            }
        }
        return new Matriz(r);
    }

    /**
     * Este metodo permite calcular la accion entre una matriz y un vector.
     *
     * @param m1 //Complejo[][]
     * @param v //Complejo[]
     * @return Vector
     */
    public static Vector accionMatrisVector(Complejo[][] m1, Complejo[] v) {
        Complejo sum;
        Complejo r[] = new Complejo[v.length];
        for (int i = 0; i < m1.length; i++) {
            sum = new Complejo(0.0, 0.0);
            for (int j = 0; j < v.length; j++) {
                sum = suma(sum, multiplicacion(m1[i][j], v[j]));
            }

            r[i] = sum;
        }
        ArrayList<Complejo> vectorResultado = new ArrayList<Complejo>();
        for (int i = 0; i < r.length; i++) {
            vectorResultado.add(r[i]);
        }
        return new Vector(vectorResultado);

    }

    /**
     * Este metodo permite calcular el producto interno entre dos matrizes.
     *
     * @param m1 //Complejo[][]
     * @param m2 //Complejo[][]
     * @return Complejo
     */
    public static Complejo productoInternoMatrizes(Complejo[][] m1, Complejo[][] m2) {
        Complejo sum = new Complejo(0.0, 0.0);
        for (int i = 0; i < m1.length; i++) {
            for (int j = 0; j < m1[0].length; j++) {
                sum = suma(sum, multiplicacion(m1[i][j], m2[i][j]));
            }
        }
        return sum;
    }

    /**
     * Este metodo permite calcular el producto interno entre dos matrizes.
     *
     * @param v1 //Vector
     * @param v2 //Vector
     * @return Complejo
     */
    public static Complejo productoInternoVectores(Vector v1, Vector v2) {
        Complejo sum = new Complejo(0.0, 0.0);
        for (int i = 0; i < v1.getVec().size(); i++) {
            sum = suma(sum, multiplicacion(v1.getVec().get(i), v2.getVec().get(i)));
        }
        return sum;
    }

    /**
     * Este metodo permite calcular la distancia entre dos vectores.
     *
     * @param v1 //Vector
     * @param v2 //Vector
     * @return Double
     */
    public static Double distanciaVectores(Vector v1, Vector v2) {
        Double sum = 0.0;
        for (int i = 0; i < v1.getVec().size(); i++) {
            sum = sum + Math.pow(Modulo(resta(v1.getVec().get(i), v2.getVec().get(i))), 2);
        }
        return sum;
    }

    /**
     * Este metodo permite calcular si una matriz es Hermitiana.
     *
     * @param m1 //Complejo[][]
     * @return Boolean
     */
    public static Boolean hermitiana(Complejo[][] m1) {
        Complejo[][] m2 = adjuntaMatriz(m1).getMatriz();
        return m1.equals(m2);
    }

    /**
     * Este metodo permite calcular si una matriz es Unitaria.
     *
     * @param m1 //Complejo[][]
     * @return Boolean
     */
    public static Boolean unitaria(Complejo[][] m1) {
        return productoMatrices(m1, adjuntaMatriz(m1).getMatriz()).equals(productoMatrices(adjuntaMatriz(m1).getMatriz(), m1));
    }

    /**
     * Este metodo permite calcular el producto tensor entre dos matrices.
     *
     * @param m1 //Complejo[][]
     * @param m2 //Complejo[][]
     * @return Matriz
     */
    public static Matriz productoTensorMatrizes(Complejo[][] m1, Complejo[][] m2) {
        Complejo[][] r = new Complejo[m1.length * m2.length][m1[0].length * m2[0].length];
        for (int i = 0; i < m1.length; i++) {
            for (int j = 0; j < m1[0].length; j++) {
                for (int k = 0; k < m2.length; k++) {
                    for (int l = 0; l < m2[0].length; l++) {
                        r[i * m2.length + k][j * m2[0].length + l] = multiplicacion(m1[i][j], m2[k][l]);
                    }

                }
            }

        }
        return new Matriz(r);
    }

    /**
     * Este metodo permite calcular el producto tensor entre dos matrices.
     *
     * @param b //Vector
     * @param a //Vector
     * @return Matriz
     */
    public static Vector productoTenseroVectores(Vector a, Vector b) {
        int r = a.getVec().size();
        ArrayList<Complejo> vectorResultado = new ArrayList<Complejo>();
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < b.getVec().size(); j++) {
                vectorResultado.add(multiplicacion(a.getVec().get(i), b.getVec().get(j)));
            }

        }
        Vector v = new Vector(vectorResultado);
        return v;
    }

    public static Vector canicasExperimentoCuantico(Complejo[][] m1, Complejo[] v) {
        Complejo[] r = v;
        Vector prob = accionMatrisVector(m1, r);

        return prob;
    }

    public static Double[] CanicasEsperimentoNormal(int[][] m1, Double[] v, int clics) {
        Double[] r = v;
        for (int i = 0; i < clics; i++) {
            r = multiplicacionMatrisVector(m1, r);
        }
        return r;
    }
    /**
     * Crea la matriz correspondiente con las probabilidades dadas entre el punto de partida, las rendijas y objetivos 
     *
     * @param rendijas //int 
     * @param objetivos //int
     * @param probabilidades //HashMap<String, Complejo>
     * @return Double[][]
     */
    public static Double[][] getMatrizXmatrizCuantico(int rendijas, int objetivos, HashMap<String, Complejo> probabilidades) {
        Complejo[][] m = new Complejo[rendijas + objetivos + 1][rendijas + objetivos + 1];

        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                if (i == j && j > rendijas) {
                    m[i][j] = new Complejo(1.0, 0.0);
                } else {
                    m[i][j] = new Complejo(0.0, 0.0);
                }

            }
        }

        for (String key : probabilidades.keySet()) {
            String[] p = key.split("-");
            m[Integer.parseInt(p[1])][Integer.parseInt(p[0])] = probabilidades.get(key);

        }
        Double[][] resp = new Double[m.length][m[0].length];
        Complejo[][] m2 = productoMatrices(m, m).getMatriz();
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                resp[i][j] = Mod(m2[i][j]);
            }
        }
        return resp;
    }
    /**
     * Crea la matriz correspondiente con las probabilidades dadas entre el punto de partida, las rendijas y objetivos 
     *
     * @param rendijas //int 
     * @param objetivos //int
     * @param probabilidades //HashMap<String, Double>
     * @return Double[][]
     */
    public static Double[][] getMatrizXmatriz(int rendijas, int objetivos, HashMap<String, Double> probabilidades) {
        Double[][] m = new Double[rendijas + objetivos + 1][rendijas + objetivos + 1];
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                if (i == j && j > rendijas) {
                    m[i][j] = 1.00;
                } else {
                    m[i][j] = 0.00;
                }

            }
        }
        for (String key : probabilidades.keySet()) {
            String[] p = key.split("-");
            m[Integer.parseInt(p[1])][Integer.parseInt(p[0])] = probabilidades.get(key);
        }
        Double[][] m2 = productoMatricesReales(m, m);
        for (Double[] e : m2) {
            System.out.println(Arrays.toString(e));
        }
        return m2;
    }

    public static Double[][] productoMatricesReales(Double[][] m1, Double[][] m2) {
        Double sum;
        Double r[][] = new Double[m1.length][m1[0].length];
        for (int i = 0; i < m1.length; i++) {
            for (int j = 0; j < m2[0].length; j++) {
                sum = 0.0;
                for (int k = 0; k < m1[0].length; k++) {
                    sum = sum + (m1[i][k] * m2[k][j]);
                }
                r[i][j] = sum;
            }
        }
        return r;
    }

    private static Double[] multiplicacionMatrisVector(int[][] m1, Double[] v) {
        Double sum;
        Double r[] = new Double[v.length];
        for (int i = 0; i < m1.length; i++) {
            sum = 0.0;
            for (int j = 0; j < v.length; j++) {
                sum += m1[i][j] * v[j];
            }
            r[i] = sum;
        }
        return r;
    }

    private static Double[] multiplicacionMatrisVectorDouble(Double[][] m1, Double[] v) {
        Double sum;
        Double r[] = new Double[v.length];
        for (int i = 0; i < m1.length; i++) {
            sum = 0.0;
            for (int j = 0; j < v.length; j++) {
                sum += m1[i][j] * v[j];
            }
            r[i] = sum;
        }
        return r;
    }
    /**
     * Calcula la probabilidad de que una particula se encuentr en un objetivo despuesde ciertos click en el tiempo. 
     *
     * @param m1 //Double[][]
     * @param v //Double[] 
     * @param clics //HashMap<String, Double>
     * @return int
     */
    public static Double[] Experimentosdelasmúltiplesrendijasclásico(Double[][] m1, Double[] v, int clics) {
        Double[] r = v;
        for (int i = 0; i < clics; i++) {
            r = multiplicacionMatrisVectorDouble(m1, r);
        }
        return r;
    }
	public static Double SistemaCuanticoPartUnalínea(Complejo[] linea,int posicion) {
            Double suma=0.0;
            for(Complejo e: linea){
                suma=suma+Mod(e);
            }
            Double estand=Math.sqrt(suma);
            Double prob=Mod(linea[posicion])/(estand*estand);
            return prob;
        }
    public static Vector normalizar(Vector a){
        
        ArrayList<Complejo>b=a.getVec();    
        Double magnitud=0.0;
        for(int i=0;i<b.size();i++){
            magnitud+=Math.pow(Modulo(b.get(i)),2);
        }
        magnitud=Math.sqrt(magnitud);
        
        for(int i=0;i<b.size();i++){
            Complejo d=new Complejo(b.get(i).getReal()/magnitud,b.get(i).getImaginrio()/magnitud); 
            b.set(i, d);
        }
        return new Vector(b);   
    }
    public static Complejo AmpliTransitarVectorAtro(Vector a,Vector b){
        Vector vn2=normalizar(adjuntaVector(a));
        Vector vn1=normalizar(b);
        ArrayList<Complejo>v1=vn1.getVec();
        ArrayList<Complejo>v2=vn2.getVec();
        
        return productoInternoVectores(new Vector(v1),new Vector(v2));
    }
    
    public static double redondearDecimales(double valorInicial, int numeroDecimales) {
        double parteEntera, resultado;
        resultado = valorInicial;
        parteEntera = Math.floor(resultado);
        resultado = (resultado - parteEntera) * Math.pow(10, numeroDecimales);
        resultado = Math.round(resultado);
        resultado = (resultado / Math.pow(10, numeroDecimales)) + parteEntera;
        return resultado;
    }
    /**
     * Crea una imagen mediante un vector de estado  y la guarda en el directorio raiz de nuestro proyecto.
     * @param EstadoVector //Double[]
     * @param name //String
     */
    public static void graficarEstado(Double[] EstadoVector,String name) {
        try {
            DefaultCategoryDataset ds = new DefaultCategoryDataset();
            for(int i=0;i<EstadoVector.length;i++){
                ds.addValue(EstadoVector[i],"Vertice"+Integer.toString(i),"");
            }
            JFreeChart jf = ChartFactory.createBarChart3D("Estado", "Vertices", "Probabilidad", ds, PlotOrientation.VERTICAL, true, true, true);
            ChartFrame f = new ChartFrame("Estados", jf);
            f.setSize(1000, 600);
            f.setLocationRelativeTo(null);
            f.setVisible(false);
            ChartUtilities.saveChartAsPNG(new File(name+".png"),jf, 1000,600,null);
            
        } catch (Exception e) {
            System.out.println("error" + e);
        }

    }
    //public static void main(String agr){
    //}
}
