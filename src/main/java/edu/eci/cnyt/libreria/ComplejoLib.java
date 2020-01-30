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
    public ComplejoLib(){
    
    }
     /**
	 * Este metodo permite calcular la suma de dos numeros complejos 
         * @param a //tipo Complejo
         * @param b //tipo Complejo
	 * @return Complejo
	 */
    public static Complejo suma(Complejo a,Complejo b){
        Double x=a.getReal()+b.getReal();
        Double y=a.getImaginrio()+b.getImaginrio();
        return  new Complejo(redondearDecimales(x,2),redondearDecimales(y,2));  
    }
    /**
	 * Este metodo permite calcular la resta de dos numeros complejos 
         * @param a //tipo Complejo
         * @param b //tipo Complejo
	 * @return Complejo
	 */
    public static Complejo resta(Complejo a,Complejo b){
        Double x=a.getReal()-b.getReal();
        Double y=a.getImaginrio()-b.getImaginrio();
        return new Complejo(x,y);   
    }
     /**
	 * Este metodo permite calcular la multiplicacion  de dos numeros complejos 
         * @param a //tipo Complejo
         * @param b //tipo Complejo
	 * @return Complejo
	 */
    public static Complejo multiplicacion(Complejo a,Complejo b){
        Double x=a.getReal()*b.getReal()-a.getImaginrio()*b.getImaginrio();
        Double y=a.getReal()*b.getImaginrio()+a.getImaginrio()*b.getReal();
        return new Complejo(redondearDecimales(x,2),redondearDecimales(y,2)); 
    }
     /**
	 * Este metodo permite calcular la division de dos numeros complejos 
         * @param a //tipo Complejo
         * @param b //tipo Complejo
	 * @return Complejo
	 */
    public static Complejo division(Complejo a,Complejo b){
        Double auxiliar=a.getReal()*a.getReal()+a.getImaginrio()*a.getImaginrio();
        Double x=(a.getReal()*b.getImaginrio()+a.getImaginrio()*b.getImaginrio())/auxiliar;
        Double y=(a.getImaginrio()*b.getReal()-a.getReal()*b.getImaginrio())/auxiliar; 
        return new Complejo(redondearDecimales(x,2),redondearDecimales(y,2));  
    }
     /**
	 * Este metodo permite calcular el conjugado de un numero complejo
         * @param a //tipo Complejo
	 * @return Complejo
	 */
    public static Complejo Conjugado(Complejo a){
         return new Complejo(a.getReal(),a.getImaginrio()*-1);
    }
     /**
	 * Este metodo permite calcular el modulo de un numero complejo
         * @param a //tipo Complejo
	 * @return Complejo
	 */
    public static Double Modulo(Complejo a){
        return  Math.sqrt(a.getReal()*a.getReal()+a.getImaginrio()*a.getImaginrio());
    }
     /**
	 * Este metodo permite calcular el las cordenadas  polares  de un numero complejo
         * @param a //tipo Complejo
	 * @return Complejo
	 */
    public static Complejo CartecianasApolares(Complejo a){
        Double angulo=Math.atan(a.getReal()/a.getImaginrio());
        Double p=Math.sqrt(a.getReal()*a.getReal()+a.getImaginrio()*a.getImaginrio());
        return  new Complejo(p, angulo) ;
    }
      /**
	 * Este metodo permite calcular la fase  de un numero complejo
         * @param a //tipo Complejo
	 * @return Double
	 */
    public static Double fase(Complejo a){
        Double angulo=Math.atan(a.getReal()/a.getImaginrio());
        return  angulo;
    }
    /**
	 * Este metodo permite calcular el inverso  de un numero complejo
         * @param a //tipo Complejo
	 * @return Complejo
	 */
    public static Complejo InversaComplejo(Complejo a ){
        return new Complejo(a.getReal()*-1, a.getImaginrio()*-1);
    }
     /**
	 * Este metodo permite calcular el suma de vectores
         * @param a //tipo vector
         * @param b //tipo vector
	 * @return Vector
	 */
    public static Vector sumaVectores(Vector a, Vector b){
        int r= a.getVec().size();
        ArrayList<Complejo> vectorResultado=new ArrayList<Complejo>();
        for(int i=0;i<r;i++){
            vectorResultado.add(suma(a.getVec().get(i),b.getVec().get(i)));
        }
        Vector v =new Vector(vectorResultado);
        return  v;
    }
     /**
	 * Este metodo permite calcular el inverso un de Vector 
         * @param a //tipo vector
	 * @return Vector
         */
    public static Vector  inversaVector(Vector a){
        int r= a.getVec().size();
        ArrayList<Complejo> vectorResultado=new ArrayList<Complejo>();
        for(int i=0;i<r;i++){
            vectorResultado.add(InversaComplejo(a.getVec().get(i)));
        }
        Vector v=new Vector(vectorResultado);
        return v;
    }
     /**
	 * Este metodo permite calcular la multiplicacion entre un vector y un complejo
         * @param a //tipo vector
         * @param b //tipo complejo
	 * @return Vector
         */
    public static Vector VectorXComplejo(Vector a, Complejo b){
        int r= a.getVec().size();
        ArrayList<Complejo> vectorResultado=new ArrayList<Complejo>();
        for(int i=0;i<r;i++){
            vectorResultado.add(multiplicacion(a.getVec().get(i),b));
        }
        Vector v =new Vector(vectorResultado);
        return  v;
    }
     
    public static double redondearDecimales(double valorInicial, int numeroDecimales) {
        double parteEntera, resultado;
        resultado = valorInicial;
        parteEntera = Math.floor(resultado);
        resultado=(resultado-parteEntera)*Math.pow(10, numeroDecimales);
        resultado=Math.round(resultado);
        resultado=(resultado/Math.pow(10, numeroDecimales))+parteEntera;
        return resultado;
    }
   
    //public static void main(String agr){
        
    //}
}
