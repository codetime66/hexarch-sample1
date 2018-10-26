package br.com.stelo.maquina.inativar.repositoryadapters;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.stelo.maquina.inativar.models.TokenGsurf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class GsurfRepositoryAdapterHelper {

	private static final Logger log = LoggerFactory.getLogger(GsurfRepositoryAdapterHelper.class);

	@Value("${stelo.gsurf.token.url.srv}")
	private String stelo_gsurf_token_url_srv;

	@Value("${gsurf.api.endpoint.srv}")
	private String gsurf_api_endpoint_srv;

	@Value("${gsurf.api.mock}")
	private boolean gsurf_api_mock; // TESTE LOCAL USANDO JSON-SERVER

    @Value("${gsurf_ws_key}")
    private String gsurf_ws_key;
    			
	protected ResponseEntity<String> handleResponse(RestTemplate restTemplate, String nuCdSeqMaqnaMduloTerm)
			throws Exception {

		String uri = getTerminalCancelResource(nuCdSeqMaqnaMduloTerm);

		log.info("### (1) GsurfRepositoryAdapter.cancel: uri=" + uri);

		ResponseEntity<String> response = callTerminalCancelService(restTemplate, uri);

		return response;
	}    
    
	protected String getTerminalCancelResource(String nuCdSeqMaqnaMduloTerm) {
		StringBuilder resource = new StringBuilder();
		resource.append(gsurf_api_endpoint_srv);
		resource.append("/terminals/");
		resource.append(nuCdSeqMaqnaMduloTerm);
		resource.append("/cancel");
		log.info("###getTerminalCancelResource: " + resource.toString());
		return resource.toString();
	}
	
	protected ResponseEntity<String> callTerminalCancelService(RestTemplate restTemplate, String uri) {
		ResponseEntity<String> response = null;
		try {
			log.info("### (2) GsurfRepositoryAdapterHelper.callTerminalCancelService:");

			response = restTemplate.exchange(uri, HttpMethod.PUT, getHttpEntity(), String.class);
		} catch (Exception ex) {
			
			log.info("### (3) GsurfRepositoryAdapterHelper.callTerminalCancelService: message=" + ex.getMessage());
			
			response = ("401 Unauthorized".equals(ex.getMessage()))
					? callTerminalCancelServiceRenewToken(restTemplate, uri)
			        : new ResponseEntity<String>(ex.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return response;
	}
	
	protected ResponseEntity<String> callTerminalCancelServiceRenewToken(RestTemplate restTemplate, String uri)  {
		ResponseEntity<String> response = null;
		try {
			log.error("### (4) GsurfRepositoryAdapter.cancel:");

			getGsurfToken(Boolean.TRUE);
		    response = restTemplate.exchange(uri, HttpMethod.PUT, getHttpEntity(), String.class);
		} catch (Exception ex) {
			
			log.error("### (4) GsurfRepositoryAdapter.cancel: ERROR: " + ex.getMessage());
			
			return new ResponseEntity<String>(ex.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return response;
	}

	protected HttpEntity<String> getHttpEntity() {
		HttpHeaders httpHeaders = getGsurfHttpHeaders();
		HttpEntity<String> entity = (gsurf_api_mock) ? null
				: new HttpEntity<>("parameters", httpHeaders);
		return entity;
	}

	protected HttpHeaders getGsurfHttpHeaders() {
		return getGsurfHttpHeaders(getGsurfToken(Boolean.FALSE));
	}

	protected TokenGsurf getGsurfToken(Boolean renewToken) {

		if(renewToken!=null && renewToken) {
			stelo_gsurf_token_url_srv=stelo_gsurf_token_url_srv+"?renew=true";
		}
		
		log.info("###GsurfRepositoryAdapter.getGsurfToken: stelo_gsurf_token_url_srv="+stelo_gsurf_token_url_srv);
		
		RestTemplate restTemplate = new RestTemplate();
		TokenGsurf tokenGsurf = restTemplate.getForObject(stelo_gsurf_token_url_srv, TokenGsurf.class);
		log.info(tokenGsurf.toString());

		return tokenGsurf;
	}
	
	protected HttpHeaders getGsurfHttpHeaders(TokenGsurf tokenGsurf) {
		String token = tokenGsurf.getToken();
		log.info("###getGsurfHttpHeaders(): ws_key = " + gsurf_ws_key);
		log.info("###getGsurfHttpHeaders(): token = " + token);
		HttpHeaders headers = new HttpHeaders();
		headers.add("ws_key", gsurf_ws_key );
		headers.add("ws_token", token);
		headers.setContentType(MediaType.APPLICATION_JSON);
		return headers;
	}

}
