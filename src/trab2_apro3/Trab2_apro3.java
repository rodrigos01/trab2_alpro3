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
public class Trab2_apro3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        ArrayList<Elevador> elevadores = new ArrayList<>();
        elevadores.add(new Elevador(2, 3));
        elevadores.add(new Elevador(7, 4));
        elevadores.add(new Elevador(6, 13));
        elevadores.add(new Elevador(0, 10));
        
        Torre babel = new Torre(22, 0, 6, elevadores);
        
        babel.printAndares();
        
    }
    
}
