package br.com.stelo.maquina.inativar.serviceadapters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.stelo.maquina.inativar.models.Maquina;
import br.com.stelo.maquina.inativar.ports.GetMaquinaService;
import br.com.stelo.maquina.inativar.ports.MaquinaRepository;

@Service
public class GetMaquinaServiceAdapter implements GetMaquinaService {

	@Autowired
	private MaquinaRepository repository;

	@Override
	public Maquina getMaquinaById(String nuSerie) {
		return repository.getMaquinaById(nuSerie);
	}
		
}
