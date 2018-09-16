package br.com.stelo.maquina.inativar.serviceadapters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.stelo.maquina.inativar.models.Maquina;
import br.com.stelo.maquina.inativar.models.NumeroTerminalGSurfResponse;
import br.com.stelo.maquina.inativar.ports.GsurfRepository;
import br.com.stelo.maquina.inativar.ports.InativarMaquinaService;
import br.com.stelo.maquina.inativar.ports.MaquinaRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class InativarMaquinaServiceAdapter implements InativarMaquinaService {

	private static final Logger log = LoggerFactory.getLogger(InativarMaquinaServiceAdapter.class);

	@Autowired
	private MaquinaRepository steloRepository;

	@Autowired
	private GsurfRepository gsurfRepository;

	@Override
	public boolean inativar(String nuserie) {
		boolean steloOK = false;
		Maquina maquina = steloRepository.getMaquinaByNuSerie(nuserie);
		if (maquina != null && maquina.getCdSeqMaqnaMduloTerm() != null) {
			steloOK = inativarStelo(nuserie);
			inativarGsurf(maquina.getCdSeqMaqnaMduloTerm());
		}
		return steloOK;
	}

	private boolean inativarStelo(String nuserie) {
		return steloRepository.inativar(nuserie);
	}

	private NumeroTerminalGSurfResponse inativarGsurf(String nuCdSeqMaqnaMduloTerm) {
		NumeroTerminalGSurfResponse response = gsurfRepository.cancel(nuCdSeqMaqnaMduloTerm);
		return response;
	}
}
