package br.com.stelo.maquina.inativar.repositoryadapters;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import br.com.stelo.maquina.inativar.models.NumeroTerminalGSurfResponse;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class GsurfRepositoryAdapterTest {

	@Mock
	private RestTemplate restTemplate;

	@Mock
	private GsurfRepositoryAdapterHelper gsurfRepositoryAdapterHelper;

	@InjectMocks
	GsurfRepositoryAdapter gsurfRepositoryAdapter;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void cancel_callGsurfRestWS_requestAccepted() {

		String nuCdSeqMaqnaMduloTerm = "456";
		String uri = "http://localhost:3999/terminals/"+nuCdSeqMaqnaMduloTerm+"/cancel";
		
		when(gsurfRepositoryAdapterHelper.getTerminalCancelResource(nuCdSeqMaqnaMduloTerm))
				.thenReturn(uri);

		ResponseEntity<String> myEntity = new ResponseEntity<String>("{\"terminals\": [{\"id\": \"456\"}]}", HttpStatus.ACCEPTED);
		
		when(restTemplate.exchange(
				uri,
				HttpMethod.PUT,
				null, String.class))
				.thenReturn(myEntity);

		NumeroTerminalGSurfResponse numeroTerminalGSurfResponse = gsurfRepositoryAdapter.cancel(nuCdSeqMaqnaMduloTerm);

		verify(gsurfRepositoryAdapterHelper).getTerminalCancelResource(nuCdSeqMaqnaMduloTerm);
		verify(restTemplate).exchange(
				uri,
				HttpMethod.PUT,
				null, String.class);
			
		if(numeroTerminalGSurfResponse!=null 
				&& numeroTerminalGSurfResponse.getTerminals()!=null) {
			numeroTerminalGSurfResponse.getTerminals().forEach(terminal -> log.info("terminal: id="+terminal.getId()));
		}

		assertNotNull(numeroTerminalGSurfResponse);
	}

	@Test
	public void cancel_callGsurfRestWS_requestNotAccepted() {

		String nuCdSeqMaqnaMduloTerm = "456";
		String uri = "http://localhost:3999/terminals/"+nuCdSeqMaqnaMduloTerm+"/cancel";
		
		when(gsurfRepositoryAdapterHelper.getTerminalCancelResource(nuCdSeqMaqnaMduloTerm))
				.thenReturn(uri);

		ResponseEntity<String> myEntity = new ResponseEntity<String>("{\"terminals\": [{\"id\": \"456\"}]}", HttpStatus.BAD_REQUEST);
		
		when(restTemplate.exchange(
				uri,
				HttpMethod.PUT,
				null, String.class))
				.thenReturn(myEntity);

		NumeroTerminalGSurfResponse numeroTerminalGSurfResponse = gsurfRepositoryAdapter.cancel(nuCdSeqMaqnaMduloTerm);

		verify(gsurfRepositoryAdapterHelper).getTerminalCancelResource(nuCdSeqMaqnaMduloTerm);
		verify(restTemplate).exchange(
				uri,
				HttpMethod.PUT,
				null, String.class);
			
		assertNull(numeroTerminalGSurfResponse);
	}	
}
