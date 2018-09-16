package br.com.stelo.maquina.inativar.repositoryadapters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.stelo.maquina.inativar.models.NumeroTerminalGSurfResponse;
import br.com.stelo.maquina.inativar.models.TokenGsurf;
import br.com.stelo.maquina.inativar.ports.GsurfRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class GsurfRepositoryAdapter implements GsurfRepository {

	private static final Logger log = LoggerFactory.getLogger(GsurfRepositoryAdapter.class);

	@Value("${stelo.gsurf.token.url.srv}")
	private String stelo_gsurf_token_url_srv;

	@Value("${gsurf.api.endpoint.srv}")
	private String gsurf_api_endpoint_srv;

	@Value("${gsurf.api.mock}")
	private boolean gsurf_api_mock; // TESTE LOCAL USANDO JSON-SERVER

	@Autowired
	RestTemplate restTemplate;

	@Override
	public NumeroTerminalGSurfResponse cancel(String nuCdSeqMaqnaMduloTerm) {
		try {

			ResponseEntity<String> response = restTemplate.exchange(getTerminalCancelResource(nuCdSeqMaqnaMduloTerm),
					HttpMethod.PUT, getHttpEntity(), String.class);

			log.info("###GsurfRepositoryAdapter.cancel: HttpStatus=" + response.getStatusCode());

			if (response.getStatusCode() == HttpStatus.ACCEPTED) {
				log.info("###GsurfRepositoryAdapter.cancel: HttpStatus.ACCEPTED...");
				ObjectMapper mapper = new ObjectMapper();
				mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

				return mapper.readValue(response.getBody(), NumeroTerminalGSurfResponse.class);

			} else {
				return null;
			}

		} catch (Exception ex) {
			log.error("###GsurfRepositoryAdapter.cancel: ERROR: " + ex.getMessage());
			return null;
		}
	}

	private TokenGsurf getGsurfToken() {
		TokenGsurf tokenGsurf = restTemplate.getForObject(stelo_gsurf_token_url_srv, TokenGsurf.class);
		log.info(tokenGsurf.toString());

		return tokenGsurf;
	}

	private HttpHeaders getGsurfHttpHeaders() {
		return getGsurfHttpHeaders(getGsurfToken());
	}

	private HttpHeaders getGsurfHttpHeaders(TokenGsurf tokenGsurf) {
		String token = tokenGsurf.getToken();
		log.info("###getGsurfHttpHeaders(): token = " + token);
		HttpHeaders headers = new HttpHeaders();
		headers.add("ws_key", "0d581bb8-ae8d-4313-a8f2-4777e8999c7e");
		headers.add("ws_token", token);
		headers.setContentType(MediaType.APPLICATION_JSON);
		return headers;
	}

	private String getTerminalCancelResource(String nuCdSeqMaqnaMduloTerm) {
		StringBuilder resource = new StringBuilder();
		resource.append(gsurf_api_endpoint_srv);
		resource.append("/terminals/");
		resource.append(nuCdSeqMaqnaMduloTerm);
		resource.append("/cancel");
		log.info("###getTerminalCancelResource: " + resource.toString());
		return resource.toString();
	}

	private HttpEntity<String> getHttpEntity() {
		HttpHeaders httpHeaders = getGsurfHttpHeaders();
		HttpEntity<String> entity = (gsurf_api_mock) ? null
				: new HttpEntity<String>("parameters", httpHeaders);
		return entity;
	}
}
