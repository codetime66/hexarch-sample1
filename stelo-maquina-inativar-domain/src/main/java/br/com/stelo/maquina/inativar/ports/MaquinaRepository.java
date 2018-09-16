package br.com.stelo.maquina.inativar.ports;

import br.com.stelo.maquina.inativar.models.Maquina;

public interface MaquinaRepository {
    Maquina getMaquinaByNuSerie(String nuSerie);
    boolean inativar(String nuSerie);
}
