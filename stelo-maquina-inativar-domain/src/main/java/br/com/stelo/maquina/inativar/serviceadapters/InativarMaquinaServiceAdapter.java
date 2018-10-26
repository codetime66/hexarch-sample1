package br.com.stelo.maquina.inativar.serviceadapters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.stelo.maquina.inativar.models.Maquina;
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
	public boolean inativar(String nuserie, String userName) {

		log.info("###InativarMaquinaServiceAdapter.inativar: nuserie=" + nuserie + ", userName=" + userName);

		boolean inativarOK = false;
		Maquina maquina = steloRepository.getMaquinaByNuSerie(nuserie);
		if (maquina != null && maquina.getCdSeqMaqnaMduloTerm() != null
				&& inativarGsurf(maquina.getCdSeqMaqnaMduloTerm())) {

			log.info("###InativarMaquinaServiceAdapter.inativar: maquina.getCdSeqMaqnaMduloTerm()="
					+ maquina.getCdSeqMaqnaMduloTerm());
			inativarOK = inativarStelo(nuserie, userName);

		} else {
			log.info("###InativarMaquinaServiceAdapter.inativar: maquina is null");
		}
		return inativarOK;
	}

	private boolean inativarStelo(String nuserie, String userName) {
		log.info("###InativarMaquinaServiceAdapter.inativarStelo");
		return steloRepository.inativar(nuserie, userName);
	}

	private boolean inativarGsurf(String nuCdSeqMaqnaMduloTerm) {
		log.info("###InativarMaquinaServiceAdapter.inativarGsurf");
		return gsurfRepository.cancel(nuCdSeqMaqnaMduloTerm);
	}
}
