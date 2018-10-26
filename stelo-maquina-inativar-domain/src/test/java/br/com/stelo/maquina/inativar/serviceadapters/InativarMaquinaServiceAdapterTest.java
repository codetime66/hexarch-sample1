package br.com.stelo.maquina.inativar.serviceadapters;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import br.com.stelo.maquina.inativar.models.Maquina;
import br.com.stelo.maquina.inativar.models.NumeroTerminalGSurfResponse;
import br.com.stelo.maquina.inativar.ports.GsurfRepository;
import br.com.stelo.maquina.inativar.ports.MaquinaRepository;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class InativarMaquinaServiceAdapterTest {

	@Mock
	private MaquinaRepository steloRepositoryMock;

	@Mock
	private GsurfRepository gsurfRepositoryMock;

	@InjectMocks
	private InativarMaquinaServiceAdapter inativarMaquinaServiceAdapter;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void inativar_callsTheRepositories() {
		
		log.info("### inativar_callsTheRepositories()");
		
		String userName = "name";
		
		Maquina maquina = new Maquina();
		maquina.setNuSerie("123");
		maquina.setCdSeqMaqnaMduloTerm("456");
		
		when(steloRepositoryMock.getMaquinaByNuSerie(maquina.getNuSerie())).thenReturn(maquina);
		when(steloRepositoryMock.inativar(maquina.getNuSerie(), userName)).thenReturn(true);
		when(gsurfRepositoryMock.cancel(maquina.getCdSeqMaqnaMduloTerm()) ).thenReturn(new NumeroTerminalGSurfResponse());
		
		inativarMaquinaServiceAdapter.inativar(maquina.getNuSerie(), userName);
		
		verify(steloRepositoryMock).getMaquinaByNuSerie(maquina.getNuSerie());
		verify(steloRepositoryMock).inativar(maquina.getNuSerie(), userName);
		verify(gsurfRepositoryMock).cancel(maquina.getCdSeqMaqnaMduloTerm());
	}
	
	@Test
	public void inativar_whenNuSerieDoesNotMatch_returnsFalse() {

		log.info("### inativar_whenNuSerieDoesNotMatch_returnsFalse()");
		
		String userName = "name";
		
		Maquina maquina = new Maquina();
		maquina.setNuSerie("123");
		maquina.setCdSeqMaqnaMduloTerm("456");
		
		when(steloRepositoryMock.getMaquinaByNuSerie(maquina.getNuSerie())).thenReturn(null);
		
		boolean steloOK = inativarMaquinaServiceAdapter.inativar(maquina.getNuSerie(), userName);
		
		assertFalse(steloOK);
		verify(steloRepositoryMock).getMaquinaByNuSerie(maquina.getNuSerie());
	}
	
	@Test
	public void inativar_whenTerminalCdSeqDoesNotExist_returnsFalse() {
		
		log.info("### inativar_whenTerminalCdSeqDoesNotExist_returnsFalse()");
		
		String userName = "name";
		
		Maquina maquina = new Maquina();
		maquina.setNuSerie("123");
		maquina.setCdSeqMaqnaMduloTerm(null);
		
		when(steloRepositoryMock.getMaquinaByNuSerie(maquina.getNuSerie())).thenReturn(maquina);
		
		boolean steloOK = inativarMaquinaServiceAdapter.inativar(maquina.getNuSerie(), userName);
		
		assertFalse(steloOK);
		verify(steloRepositoryMock).getMaquinaByNuSerie(maquina.getNuSerie());
	}
	
	@Test
	public void inativar_whenNoUpdateIsDone_returnsFalse() {
		
		log.info("### inativar_whenNoUpdateIsDone_returnsFalse()");
		
		String userName = "name";
		
		Maquina maquina = new Maquina();
		maquina.setNuSerie("123");
		maquina.setCdSeqMaqnaMduloTerm("456");
		
		when(steloRepositoryMock.getMaquinaByNuSerie(maquina.getNuSerie())).thenReturn(maquina);
		when(steloRepositoryMock.inativar(maquina.getNuSerie(), userName)).thenReturn(false);
		
		boolean steloOK = inativarMaquinaServiceAdapter.inativar(maquina.getNuSerie(), userName);
		
		assertFalse(steloOK);
		verify(steloRepositoryMock).getMaquinaByNuSerie(maquina.getNuSerie());
		verify(steloRepositoryMock).inativar(maquina.getNuSerie(), userName);
	}

	@Test
	public void inativar_whenTerminalDoesNotExist_returnsFalse() {
		
		log.info("### inativar_whenTerminalDoesNotExist_returnsFalse()");
		
		String userName = "name";
		
		Maquina maquina = new Maquina();
		maquina.setNuSerie("123");
		maquina.setCdSeqMaqnaMduloTerm("456");
		
		when(steloRepositoryMock.getMaquinaByNuSerie(maquina.getNuSerie())).thenReturn(maquina);
		when(steloRepositoryMock.inativar(maquina.getNuSerie(), userName)).thenReturn(true);
		when(gsurfRepositoryMock.cancel(maquina.getCdSeqMaqnaMduloTerm()) ).thenReturn(null);
		
		boolean steloOK = inativarMaquinaServiceAdapter.inativar(maquina.getNuSerie(), userName);
		
		assertTrue(steloOK);
		verify(steloRepositoryMock).getMaquinaByNuSerie(maquina.getNuSerie());
		verify(steloRepositoryMock).inativar(maquina.getNuSerie(), userName);
		verify(gsurfRepositoryMock).cancel(maquina.getCdSeqMaqnaMduloTerm());

	}

}
