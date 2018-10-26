package br.com.stelo.maquina.inativar.repositoryadapters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.stelo.maquina.inativar.ports.GsurfRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class GsurfRepositoryAdapter implements GsurfRepository {

	private static final Logger log = LoggerFactory.getLogger(GsurfRepositoryAdapter.class);

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	GsurfRepositoryAdapterHelper helper;

	@Override
	public boolean cancel(String nuCdSeqMaqnaMduloTerm) {
		try {

			log.info("### GsurfRepositoryAdapter.cancel: nuCdSeqMaqnaMduloTerm=" + nuCdSeqMaqnaMduloTerm);

			ResponseEntity<String> response = helper.handleResponse(restTemplate, nuCdSeqMaqnaMduloTerm);

			return (response != null && response.getStatusCode() == HttpStatus.ACCEPTED);

		} catch (Exception ex) {
			log.error("###GsurfRepositoryAdapter.cancel: ERROR: " + ex.getMessage());
			return false;
		}
	}

}
