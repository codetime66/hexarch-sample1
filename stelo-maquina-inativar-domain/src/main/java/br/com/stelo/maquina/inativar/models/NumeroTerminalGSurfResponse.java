package br.com.stelo.maquina.inativar.models;

import java.io.Serializable;
import java.util.List;

public class NumeroTerminalGSurfResponse implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private List<Terminal> terminals;
	private String associaMqnaVddorResponse;
	private String respCancelamento;

	
	public List<Terminal> getTerminals() {
		return terminals;
	}

	public void setTerminals(List<Terminal> terminals) {
		this.terminals = terminals;
	}

	public String getAssociaMqnaVddorResponse() {
		return associaMqnaVddorResponse;
	}

	public void setAssociaMqnaVddorResponse(String associaMqnaVddorResponse) {
		this.associaMqnaVddorResponse = associaMqnaVddorResponse;
	}

	public String getRespCancelamento() {
		return respCancelamento;
	}

	public void setRespCancelamento(String respCancelamento) {
		this.respCancelamento = respCancelamento;
	}
}
