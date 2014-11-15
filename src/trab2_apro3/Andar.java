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
    
    private ArrayList<Conexao> conexoes;
    private ArrayList<Elevador> elevadores;
    private int numero;

    public Andar(int n) {
        
        numero = n;
        conexoes = new ArrayList<>();
        elevadores = new ArrayList<>();
        
    }

    public ArrayList<Conexao> getConexoes() {
        return conexoes;
    }

    public ArrayList<Elevador> getElevadores() {
        return elevadores;
    }

    public int getNumero() {
        return numero;
    }
    
    public void addConexao(Elevador e, Andar a) {
        Conexao c = new Conexao(e, a);
        if(!a.equals(this) && !conexoes.contains(c)) {
            conexoes.add(c);
            a.addConexao(e, this);
        }
    }
    
    public void addElevador(Elevador e) {
        if(!elevadores.contains(e)) {
            elevadores.add(e);
            e.addAndar(this);
        }
    }
    
    
    
}
