package br.com.stelo.maquina.inativar.repositoryadapters;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.stelo.maquina.inativar.repositoryadapters.db.IMaquinaDAO;
import br.com.stelo.maquina.inativar.repositoryadapters.db.entity.MaquinaEntity;
import br.com.stelo.maquina.inativar.models.Maquina;
import br.com.stelo.maquina.inativar.ports.MaquinaRepository;

@Service
public class MaquinaRepositoryAdapter implements MaquinaRepository {

	@Autowired
	private IMaquinaDAO maquinaDAO;
	
	@Override
	public Maquina getMaquinaByNuSerie(String nuSerie) {
		MaquinaEntity maquinaEntity = maquinaDAO.getMaquinaByNuSerie(nuSerie);
		
		Maquina maquina = null;
		if(maquinaEntity!=null) {
		   maquina = new Maquina();	
           BeanUtils.copyProperties(maquinaEntity, maquina);
		}
		
		return maquina;
	}

    @Override
	public boolean inativar(String nuserie, String userName) {
		return maquinaDAO.inativar(nuserie, userName);
	}

}
