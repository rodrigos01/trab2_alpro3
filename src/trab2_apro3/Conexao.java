/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trab2_apro3;

import java.util.Objects;

/**
 *
 * @author rodrigo
 */
public class Conexao {
    
    private Elevador elevador;
    private Andar andar;

    public Conexao(Elevador elevador, Andar andar) {
        this.elevador = elevador;
        this.andar = andar;
    }

    public Elevador getElevador() {
        return elevador;
    }

    public void setElevador(Elevador elevador) {
        this.elevador = elevador;
    }

    public Andar getAndar() {
        return andar;
    }

    public void setAndar(Andar andar) {
        this.andar = andar;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Conexao other = (Conexao) obj;
        if (!Objects.equals(this.elevador, other.elevador)) {
            return false;
        }
        if (!Objects.equals(this.andar, other.andar)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.elevador);
        hash = 79 * hash + Objects.hashCode(this.andar);
        return hash;
    }
    
    
    
    
    
}
