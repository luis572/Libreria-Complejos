/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cnyt.libreria;

import java.util.ArrayList;

/**
 *
 * @author luis.pizza
 */
public class Vector {
    private ArrayList<Complejo> vec;
    public Vector(ArrayList<Complejo> vec){
        this.vec=vec;
    }

    public void setVec(ArrayList<Complejo> vec) {
        this.vec = vec;
    }

    public ArrayList<Complejo> getVec() {
        return vec;
    }
    public String toString(){
        String retornar="";
        for(Complejo e: vec){
            retornar+=" "+e.toString();
        }
        return retornar;
    }
    

    


    
}
