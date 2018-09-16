package br.com.stelo.maquina.inativar.ports;

import br.com.stelo.maquina.inativar.models.NumeroTerminalGSurfResponse;

public interface GsurfRepository {
	
   public NumeroTerminalGSurfResponse cancel(String nuCdSeqMaqnaMduloTerm);
}
