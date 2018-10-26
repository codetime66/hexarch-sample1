package br.com.stelo.maquina.inativar.controllers;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import br.com.stelo.maquina.inativar.config.UsuarioLogado;
import br.com.stelo.maquina.inativar.ports.InativarMaquinaService;

public class MaquinaRestControllerTest {

	@Mock
	private InativarMaquinaService inativarMaquinaServiceMock;

	@Mock
	private UsuarioLogado usuarioLogadoMock;

	@InjectMocks
	private MaquinaRestController maquinaRestController;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void inativarMaquina_callsTheInativarMaquinaService() {
		String nuserie = "123";
		String userName = "name";
		
		when(usuarioLogadoMock.getUserName()).thenReturn(userName);
		when(inativarMaquinaServiceMock.inativar(nuserie, userName)).thenReturn(true);
		
		maquinaRestController.inativarMaquina(nuserie);
		
		verify(inativarMaquinaServiceMock).inativar(nuserie, userName);
	}
	
	@Test
	public void inativarMaquina_givenAMachineThatExists_returnsOK() {
		String nuserie = "123";
		String userName = "name";
		
		when(usuarioLogadoMock.getUserName()).thenReturn(userName);
		when(inativarMaquinaServiceMock.inativar(nuserie, userName)).thenReturn(true);
		
		@SuppressWarnings("rawtypes")
		ResponseEntity responseEntity = maquinaRestController.inativarMaquina(nuserie);
		String response = ( (String)responseEntity.getBody() );
		
		assertTrue(responseEntity.getStatusCode() == HttpStatus.OK);
		assertTrue(response.equals("{\"id\": " + nuserie + "}"));

		verify(inativarMaquinaServiceMock).inativar(nuserie, userName);		
		
	}
	
	@Test
	public void inativarMaquina_givenAMachineThatDoesNotExist_returnsABadRequest() {
		String nuserie = "123";
		String userName = "name";
		
		when(usuarioLogadoMock.getUserName()).thenReturn(userName);
		when(inativarMaquinaServiceMock.inativar(nuserie, userName)).thenReturn(false);
		
		@SuppressWarnings("rawtypes")
		ResponseEntity responseEntity = maquinaRestController.inativarMaquina(nuserie);

		assertTrue(responseEntity.getStatusCode() == HttpStatus.BAD_REQUEST);

		verify(inativarMaquinaServiceMock).inativar(nuserie, userName);		
	}
	
}
