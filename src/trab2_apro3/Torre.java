/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trab2_apro3;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author rodrigo
 */
public class Torre {
    
    private ArrayList<Elevador> elevadores;
    private ArrayList<Andar> andares;
    private PrintWriter writer;
    private Integer testes;

    public Torre(int andares, ArrayList<Elevador> elevadores) throws FileNotFoundException {
        
        writer = new PrintWriter("casos178/resultados/"+andares+""+elevadores.size());
        System.out.println(andares+""+elevadores.size());
        
        this.testes = new Integer(0);
        
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
            printAndar(a);
        }
    }
    
    private void printAndar(Andar a) {
        String out = "Andar "+a.getNumero()+" = [ ";
        for(Conexao c: a.getConexoes()) {
            Andar a2 = c.getAndar();
            out += a2.getNumero();
            out += " ";
        }
        out += "]";
        System.out.println(out);
    }
    
    public boolean existeCaminho(int saida, int chegada) {
        boolean existe = existeCaminho(andares.get(saida), andares.get(chegada), new ArrayList<Andar>(), "");
        System.out.println(testes+" testes");
        if(existe)
            writer.println("é possível - "+testes+" testes");
        else 
            writer.println("não é possivel - "+testes+" testes");
        writer.close();
        return existe;
    }
    
    private boolean existeCaminho(Andar saida, Andar chegada, ArrayList<Andar> excluidos, String caminho) {
        boolean existe = existeCaminho(saida, chegada, new ArrayList<Andar>(), null, "");
        if(!existe){
            printAndar(saida);
            printAndar(chegada);
        }
        return existe;
    }
    
    private boolean existeCaminho(Andar saida, Andar chegada, ArrayList<Andar> excluidos, Elevador eAtual,String caminho) {
        if(eAtual != null)
            caminho += " "+eAtual.getNumero()+":";
        caminho += " "+saida.getNumero()+" ";
        if(saida.equals(chegada)) {
            return true;
        }
        
        ArrayList<Conexao> conexoes = saida.getConexoes();
        if(saida.getConexoes().isEmpty() || chegada.getConexoes().isEmpty()) {
            printAndar(saida);
            printAndar(chegada);
            return false;
        }
        
        for(Conexao c: conexoes) {
            Andar a2 = c.getAndar();
            if(!excluidos.contains(a2) && !caminho.contains(" "+a2.getNumero()+" ")) {
                testes++;
                if(existeCaminho(a2, chegada, excluidos, c.getElevador(),caminho)) {
                    if(!c.getElevador().equals(eAtual))
                        writer.println("elevador "+c.getElevador().getNumero()+" no andar "+saida.getNumero());
                    return true;
                }
                excluidos.add(a2);
            }
        }
        return false;
    }
    
}
