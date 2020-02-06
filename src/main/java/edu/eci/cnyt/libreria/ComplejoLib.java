/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cnyt.libreria;

import java.util.ArrayList;

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
        return Math.sqrt(a.getReal() * a.getReal() + a.getImaginrio() * a.getImaginrio());
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

    public static Matriz sumaM(Complejo[][] m1, Complejo[][] m2) {
        Complejo r[][] = new Complejo[m1.length][m1[0].length];
        for (int i = 0; i < m1.length; i++) {
            for (int j = 0; j < m1[0].length; j++) {
                r[i][j] = suma(m1[i][j], m2[i][j]);
            }
        }
        return new Matriz(r);
    }

    public static Matriz restaM(Complejo[][] m1, Complejo[][] m2) {
        Complejo r[][] = new Complejo[m1.length][m1[0].length];
        for (int i = 0; i < m1.length; i++) {
            for (int j = 0; j < m1[0].length; j++) {
                r[i][j] = resta(m1[i][j], m2[i][j]);

            }
        }
        return new Matriz(r);
    }

    public static Matriz productoScalar(Complejo c1, Complejo[][] m1) {
        Complejo r[][] = new Complejo[m1.length][m1[0].length];
        for (int i = 0; i < m1.length; i++) {
            for (int j = 0; j < m1[0].length; j++) {
                r[i][j] = multiplicacion(c1, m1[i][j]);
            }
        }
        return new Matriz(r);
    }

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

    public static Complejo[] productoMatrisVector(Complejo[][] m1, Complejo[] v) {
        Complejo sum;
        Complejo r[] = new Complejo[v.length];
        for (int i = 0; i < m1.length; i++) {
            sum = new Complejo(0.0, 0.0);
            for (int j = 0; j < v.length; j++) {
                sum = suma(sum, multiplicacion(m1[i][j], v[j]));
            }

            r[i] = sum;
        }
        int cont = 1;
        return r;

    }

    public static Complejo productoInterno(Complejo[][] m1, Complejo[][] m2) {
        Complejo sum = new Complejo(0.0, 0.0);
        for (int i = 0; i < m1.length; i++) {
            for (int j = 0; j < m1[0].length; j++) {
                sum = suma(sum, multiplicacion(m1[i][j], m2[i][j]));
            }
        }
        return sum;
    }

    public static Matriz productoTensor(Complejo[][] m1, Complejo[][] m2) {
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

    public static double redondearDecimales(double valorInicial, int numeroDecimales) {
        double parteEntera, resultado;
        resultado = valorInicial;
        parteEntera = Math.floor(resultado);
        resultado = (resultado - parteEntera) * Math.pow(10, numeroDecimales);
        resultado = Math.round(resultado);
        resultado = (resultado / Math.pow(10, numeroDecimales)) + parteEntera;
        return resultado;
    }

    //public static void main(String agr){
    //}
}
