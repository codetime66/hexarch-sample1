package br.com.stelo.maquina.inativar.repositoryadapters;

import br.com.stelo.maquina.inativar.models.Maquina;
import br.com.stelo.maquina.inativar.repositoryadapters.db.IMaquinaDAO;
import br.com.stelo.maquina.inativar.repositoryadapters.db.entity.MaquinaEntity;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.hamcrest.CoreMatchers.equalTo;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class MaquinaRepositoryAdapterTest {

	@Mock
	private IMaquinaDAO maquinaDAO;
	
	@InjectMocks
	MaquinaRepositoryAdapter maquinaRepositoryAdapter;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void getMaquinaByNuSerie_returnsMachine() {
		String nuserie="123";
		MaquinaEntity entity = new MaquinaEntity();
		entity.setNuSerie(nuserie);
		entity.setCdSeqMaqnaMduloTerm("456");
		
		when(maquinaDAO.getMaquinaByNuSerie(nuserie)).thenReturn(entity);
		
		Maquina maquina = maquinaRepositoryAdapter.getMaquinaByNuSerie(nuserie);
		
		assertThat(entity.getNuSerie(), equalTo(maquina.getNuSerie()));
        assertThat(entity.getCdSeqMaqnaMduloTerm(), equalTo(maquina.getCdSeqMaqnaMduloTerm()));
		
		verify(maquinaDAO).getMaquinaByNuSerie(nuserie);
		
	}
	
	@Test
	public void getMaquinaByNuSerie_returnsNoMachine() {
		String nuserie="123";
		MaquinaEntity entity = null;
		
		when(maquinaDAO.getMaquinaByNuSerie(nuserie)).thenReturn(entity);
		
		Maquina maquina = maquinaRepositoryAdapter.getMaquinaByNuSerie(nuserie);
		
		assertNull(maquina);
		
		verify(maquinaDAO).getMaquinaByNuSerie(nuserie);
		
	}	
	
	@Test
	public void inativar_UpdateDone() {
		String nuserie = "123";
		String username = "name";
		
		when(maquinaDAO.inativar(nuserie, username)).thenReturn(true);
		
		boolean updated = maquinaRepositoryAdapter.inativar(nuserie, username);
		
		assertTrue(updated);
		
		verify(maquinaDAO).inativar(nuserie, username);
		
	}
	
	@Test
	public void inativar_UpdateIsNotDone() {
		String nuserie = "123";
		String username = "name";
		
		when(maquinaDAO.inativar(nuserie, username)).thenReturn(false);
		
		boolean updated = maquinaRepositoryAdapter.inativar(nuserie, username);
		
		assertFalse(updated);
		
		verify(maquinaDAO).inativar(nuserie, username);
		
	}	
}
