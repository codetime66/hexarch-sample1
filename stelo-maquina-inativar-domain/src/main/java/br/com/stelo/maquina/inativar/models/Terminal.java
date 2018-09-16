package br.com.stelo.maquina.inativar.models;

import java.io.Serializable;

public class Terminal implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String id;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
}
