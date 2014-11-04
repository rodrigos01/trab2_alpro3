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
public class Torre {
    
    private int saida, chegada, atual;
    private ArrayList<Elevador> elevadores;
    private ArrayList<Andar> andares;

    public Torre(int andares, int saida, int chegada, ArrayList<Elevador> elevadores) {
        this.andares = new ArrayList();
        for(int i=0; i<andares; i++) {
            this.andares.add(new Andar(i));
        }
        this.saida = saida;
        this.atual = saida;
        this.chegada = chegada;
        this.elevadores = elevadores;
        for(Elevador e: elevadores) {
            
            for(int i=e.getBase(); i<andares; i+=e.getPasso()) {
                System.out.println(i+", "+andares);
                int proximo = i+e.getPasso();
                if(proximo < andares)
                    this.andares.get(i).addConexao(this.andares.get(i+e.getPasso()));
            }
            
        }
    }
    
    public void printAndares() {
        for (Andar a: andares) {
            System.out.print("Andar "+a.getNumero()+" = [");
            for(Andar a2: a.getConexoes()) {
                System.out.print(a2.getNumero());
                System.out.print(" ");
            }
            System.out.println("]");
        }
    }
    
}
