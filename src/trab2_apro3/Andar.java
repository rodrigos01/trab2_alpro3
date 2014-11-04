/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trab2_apro3;

import java.util.ArrayList;

/**
 *
 * @author rodrigo
 */
public class Andar {
    
    private ArrayList<Andar> conexoes;
    private int numero;

    public Andar(int n) {
        
        numero = n;
        conexoes = new ArrayList();
        
    }

    public ArrayList<Andar> getConexoes() {
        return conexoes;
    }

    public int getNumero() {
        return numero;
    }
    
    public void addConexao(Andar a) {
        if(!conexoes.contains(a)) {
            conexoes.add(a);
            a.addConexao(this);
        }
    }
    
    
    
}
