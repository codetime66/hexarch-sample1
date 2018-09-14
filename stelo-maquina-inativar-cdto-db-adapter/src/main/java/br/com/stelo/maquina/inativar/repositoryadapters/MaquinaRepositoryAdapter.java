package br.com.stelo.maquina.inativar.repositoryadapters;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.stelo.maquina.inativar.adapter.db.IMaquinaDAO;
import br.com.stelo.maquina.inativar.adapter.db.entity.MaquinaEntity;
import br.com.stelo.maquina.inativar.models.Maquina;
import br.com.stelo.maquina.inativar.ports.MaquinaRepository;

@Service
public class MaquinaRepositoryAdapter implements MaquinaRepository {

	@Autowired
	private IMaquinaDAO maquinaDAO;
	
	@Override
	public Maquina getMaquinaById(String nuSerie) {
		MaquinaEntity maquinaEntity = maquinaDAO.getMaquinaById(nuSerie);
		
		Maquina maquina = null;
		if(maquinaEntity!=null) {
		   maquina = new Maquina();	
           BeanUtils.copyProperties(maquinaEntity, maquina);
		}
		
		return maquina;
	}

	public boolean inativar(String nuserie) {
		return maquinaDAO.inativar(nuserie);
	}

}
