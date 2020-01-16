/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cnyt.libreria;

/**
 *
 * @author 2137497
 */
public class ComplejoLib {
    public ComplejoLib(){
    
    }
    public static Complejo suma(Complejo a,Complejo b){
        Double x=a.getReal()+b.getReal();
        Double y=a.getImaginrio()+b.getImaginrio();
        return  new Complejo(x,y);  
    }
    public static Complejo resta(Complejo a,Complejo b){
        Double x=a.getReal()-b.getReal();
        Double y=a.getImaginrio()-b.getImaginrio();
        return new Complejo(x,y);   
    }
    public static Complejo multiplicacion(Complejo a,Complejo b){
        Double x=a.getReal()*b.getReal()-a.getImaginrio()*b.getImaginrio();
        Double y=a.getReal()*b.getImaginrio()+a.getImaginrio()*b.getReal();
        return new Complejo(x,y); 
    }
    public static Complejo division(Complejo a,Complejo b){
        Double auxiliar=a.getReal()*a.getReal()+a.getImaginrio()*a.getImaginrio();
        Double x=(a.getReal()*b.getImaginrio()+a.getImaginrio()*b.getImaginrio())/auxiliar;
        Double y=(a.getImaginrio()*b.getReal()-a.getReal()*b.getImaginrio())/auxiliar; 
        return new Complejo(x,y);  
    }
    public static Complejo Conjugado(Complejo a){
         return new Complejo(a.getReal(),a.getImaginrio()*-1);
    }
    public static Double Modulo(Complejo a){
        return  Math.sqrt(a.getReal()*a.getReal()+a.getImaginrio()*a.getImaginrio());
    }
    public static Complejo CartecianasApolares(Complejo a){
        //Double angulo= a.getImaginrio()
        return  null ;
    }
    //public static void main(String agr){
        
    //}
}
