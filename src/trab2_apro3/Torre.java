/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trab2_apro3;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author rodrigo
 */
public class Torre {
    
    private ArrayList<Elevador> elevadores;
    private ArrayList<Andar> andares;

    public Torre(int andares, ArrayList<Elevador> elevadores) {
        this.andares = new ArrayList();
        for(int i=0; i<andares; i++) {
            this.andares.add(new Andar(i));
        }
        this.elevadores = elevadores;
        int nElevadores = 1;
        for(Elevador e: elevadores) {
            e.setNumero(nElevadores);
            for(int i=e.getBase(); i<andares; i+=e.getPasso()) {
                e.addAndar(this.andares.get(i));
                int proximo = i+e.getPasso();
                if(proximo < andares)
                    this.andares.get(i).addConexao(e,this.andares.get(i+e.getPasso()));
            }
            nElevadores++;
        }
    }
    
    public void printAndares() {
        for (Andar a: andares) {
            System.out.print("Andar "+a.getNumero()+" = [ ");
            for(Conexao c: a.getConexoes()) {
                Andar a2 = c.getAndar();
                System.out.print(a2.getNumero());
                System.out.print(" ");
            }
            System.out.println("]");
        }
    }
    
    public boolean existeCaminho(int saida, int chegada) {
        return existeCaminho(andares.get(saida), andares.get(chegada), new ArrayList<Andar>(), "", 0);
    }
    
    private boolean existeCaminho(Andar saida, Andar chegada, ArrayList<Andar> excluidos, String caminho, int tamanho) {
        return existeCaminho(saida, chegada, new ArrayList<Andar>(), null, "", 0);
    }
    
    private boolean existeCaminho(Andar saida, Andar chegada, ArrayList<Andar> excluidos, Elevador eAtual,String caminho, int tamanho) {
        if(eAtual != null)
            caminho += " "+eAtual.getNumero()+":";
        caminho += " "+saida.getNumero()+" ";
        if(saida.equals(chegada)) {
            System.out.println("achei com "+tamanho);
            System.out.println(caminho);
            return true;
        }
        
        ArrayList<Conexao> conexoes = saida.getConexoes();
        if(conexoes.isEmpty())
            return false;
        
        for(Conexao c: conexoes) {
            Andar a2 = c.getAndar();
            if(!excluidos.contains(a2) && !caminho.contains(" "+a2.getNumero()+" ")) {
                if(existeCaminho(a2, chegada, excluidos, c.getElevador(),caminho, tamanho+1)) {
                    if(!c.getElevador().equals(eAtual))
                        System.out.println("elevador "+c.getElevador().getNumero()+" no andar "+saida.getNumero());
                    return true;
                }
                excluidos.add(a2);
            }
        }
        return false;
    }
    
}
