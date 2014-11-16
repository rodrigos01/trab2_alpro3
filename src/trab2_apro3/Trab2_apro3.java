/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trab2_apro3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rodrigo
 */
public class Trab2_apro3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        try {
            
            File casosDir = new File("casos178");
            File[] casos = casosDir.listFiles();
            
            for(File caso: casos) {
                
                if(caso.isDirectory())
                    continue;
                
                BufferedReader reader = new BufferedReader(new FileReader(caso));
                String[] line1 = reader.readLine().split(" ");
                int andares = Integer.parseInt(line1[0]);
                int numElevadores = Integer.parseInt(line1[1]);

                String[] line2 = reader.readLine().split(" ");
                int saida = Integer.parseInt(line2[0]);
                int chegada = Integer.parseInt(line2[1]);

                ArrayList<Elevador> elevadores = new ArrayList<>();

                String linha;

                for (int i = 1; (linha = reader.readLine()) != null && i<= numElevadores; i++) {
                    //System.out.println(linha);
                    String elevador[] = linha.split(" ");
                    elevadores.add(new Elevador(Integer.parseInt(elevador[0]), Integer.parseInt(elevador[1])));
                }
                System.out.println("Elevadores lidos");

                Torre babel = new Torre(andares, elevadores);

                if(babel.existeCaminho(saida, chegada)) {
                    System.out.println("É possivel");
                }else {
                    System.out.println("não é possivel");
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(Trab2_apro3.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
