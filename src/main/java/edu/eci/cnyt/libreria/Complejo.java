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
public class Complejo {
    private Double  real;
    private Double  imaginrio;
    public Complejo(Double real, Double imaginrio){
        this.real=real;
        this.imaginrio=imaginrio;
    }

    public Double getReal() {
        return real;
    }

    public Double getImaginrio() {
        return imaginrio;
    }
}
