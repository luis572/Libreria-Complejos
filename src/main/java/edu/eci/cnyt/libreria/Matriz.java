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
public class Matriz {

    private Complejo[][] matriz;
    private int length;

    public Matriz(int m, int n) {
        matriz = new Complejo[m][n];
        length = m;
    }

    public Matriz(Complejo[][] M) {
        matriz = M;
    }

    public void AgregarElemento(Complejo x, int i, int j) {
        matriz[i][j] = x;
    }

    @Override
    public String toString() {
        return null;
    }

    public int getLength() {
        return length;
    }
    public Matriz inversaM() {
		Complejo r [][] = new Complejo [matriz.length][matriz[0].length];
		for (int i=0; i< matriz.length; i++){
			for (int j=0; j<matriz[0].length; j++) {
				r[i][j] = ComplejoLib.InversaComplejo(matriz[i][j]);	
			}
		}
		return new Matriz(r);
	}
    
    public Matriz traspuesta() {
        Complejo nueva[][] = new Complejo[matriz[0].length][matriz.length];
        for (int i = 0; i < matriz[0].length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                nueva[j][i] = matriz[i][j];
            }
        }

        return new Matriz(nueva);
    }

}
