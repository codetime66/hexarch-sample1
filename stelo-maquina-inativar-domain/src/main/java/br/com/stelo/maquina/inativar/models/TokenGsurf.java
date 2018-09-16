package br.com.stelo.maquina.inativar.models;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "token", "expiration" })
public class TokenGsurf {

	@JsonProperty("token")
	private String token;

	@JsonProperty("expiration")
	private Date expiration;

	@JsonProperty("token")
	public String getToken() {
		return token;
	}

	@JsonProperty("token")
	public void setToken(String token) {
		this.token = token;
	}

	@JsonProperty("expiration")
	public Date getExpiration() {
		return expiration;
	}

	@JsonProperty("expiration")
	public void setExpiration(Date expiration) {
		this.expiration = expiration;
	}

	@Override
	public String toString() {
		return "TokenGsurf{" + "token='" + token + '\'' + ", expiration=" + getExpiration() + '}';
	}

}