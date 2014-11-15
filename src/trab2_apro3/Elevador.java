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
public class Elevador {
    
    private int base, passo, numero;
    private ArrayList<Andar> andares;

    public Elevador(int base, int passo) {
        this.base = base;
        this.passo = passo;
        this.andares = new ArrayList<>();
    }
    
    public void addAndar(Andar a) {
        if(!andares.contains(a)) {
            this.andares.add(a);
            a.addElevador(this);
        }
    }

    public ArrayList<Andar> getAndares() {
        return andares;
    }

    public int getBase() {
        return base;
    }

    public void setBase(int base) {
        this.base = base;
    }

    public int getPasso() {
        return passo;
    }

    public void setPasso(int passo) {
        this.passo = passo;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
    
    
    
    
}
