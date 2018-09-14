package br.com.stelo.maquina.inativar.serviceadapters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.stelo.maquina.inativar.models.Maquina;
import br.com.stelo.maquina.inativar.ports.InativarMaquinaService;
import br.com.stelo.maquina.inativar.ports.MaquinaRepository;

@Service
public class InativarMaquinaServiceAdapter implements InativarMaquinaService {

	@Autowired
	private MaquinaRepository repository;

	@Override
	public boolean inativar(String nuserie) {
       return repository.inativar(nuserie);		
	}
		
}
