package br.com.stelo.maquina.inativar.repositoryadapters.db;

import br.com.stelo.maquina.inativar.repositoryadapters.db.entity.MaquinaEntity;

public interface IMaquinaDAO {
    //MaquinaEntity getMaquinaById(String nuSerie);

    boolean maquinaExists(String nuSerie);

	boolean inativar(String nuserie);

	boolean inativar(Long nuTerm, String nuSerie);

	MaquinaEntity getMaquinaByNuSerie(String nuSerie);
}