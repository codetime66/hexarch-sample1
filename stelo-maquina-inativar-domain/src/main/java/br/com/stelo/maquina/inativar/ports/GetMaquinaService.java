package br.com.stelo.maquina.inativar.ports;

import br.com.stelo.maquina.inativar.models.Maquina;

public interface GetMaquinaService {
	Maquina getMaquinaById(String nuSerie);
}
