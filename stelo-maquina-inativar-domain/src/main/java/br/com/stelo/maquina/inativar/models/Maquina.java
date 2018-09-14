package br.com.stelo.maquina.inativar.models;

import java.math.BigDecimal;
import java.util.Date;

public class Maquina {
	private String nuTerm;  
	private String nuSerie;  
	private String cdAtivacao;
	private String sttusMaqna;
	private String sttus;
	private String cdSeqMaqnaMduloTerm;
	private String cdMaqnaMduloTerm;
	private String idSttusMduloTerm;
	private String usuarIncl;
	private String usuarAlt;
	private Date dtIncl;
	private Date dtAlt;
	private String dsModMaqna;
	private BigDecimal vrMaqna;
	private Long cdPdido;
	private String cdMod;
	private String cdChip;         
	private Long flgTransRealz;
	private String dsMotvoAltSttus;
	
	public String getNuTerm() {
		return nuTerm;
	}

	public void setNuTerm(String nuTerm) {
		this.nuTerm = nuTerm;
	}

	public String getNuSerie() {
		return nuSerie;
	}

	public void setNuSerie(String nuSerie) {
		this.nuSerie = nuSerie;
	}

	public String getCdAtivacao() {
		return cdAtivacao;
	}

	public void setCdAtivacao(String cdAtivacao) {
		this.cdAtivacao = cdAtivacao;
	}

	public String getSttusMaqna() {
		return sttusMaqna;
	}

	public void setSttusMaqna(String sttusMaqna) {
		this.sttusMaqna = sttusMaqna;
	}

	public String getSttus() {
		return sttus;
	}

	public void setSttus(String sttus) {
		this.sttus = sttus;
	}

	public String getCdSeqMaqnaMduloTerm() {
		return cdSeqMaqnaMduloTerm;
	}

	public void setCdSeqMaqnaMduloTerm(String cdSeqMaqnaMduloTerm) {
		this.cdSeqMaqnaMduloTerm = cdSeqMaqnaMduloTerm;
	}

	public String getCdMaqnaMduloTerm() {
		return cdMaqnaMduloTerm;
	}

	public void setCdMaqnaMduloTerm(String cdMaqnaMduloTerm) {
		this.cdMaqnaMduloTerm = cdMaqnaMduloTerm;
	}

	public String getIdSttusMduloTerm() {
		return idSttusMduloTerm;
	}

	public void setIdSttusMduloTerm(String idSttusMduloTerm) {
		this.idSttusMduloTerm = idSttusMduloTerm;
	}
	
	public String getUsuarIncl() {
		return usuarIncl;
	}

	public void setUsuarIncl(String usuarIncl) {
		this.usuarIncl = usuarIncl;
	}

	public String getUsuarAlt() {
		return usuarAlt;
	}

	public void setUsuarAlt(String usuarAlt) {
		this.usuarAlt = usuarAlt;
	}

	public Date getDtIncl() {
		return dtIncl;
	}

	public void setDtIncl(Date dtIncl) {
		this.dtIncl = dtIncl;
	}

	public Date getDtAlt() {
		return dtAlt;
	}

	public void setDtAlt(Date dtAlt) {
		this.dtAlt = dtAlt;
	}

	public String getDsModMaqna() {
		return dsModMaqna;
	}

	public void setDsModMaqna(String dsModMaqna) {
		this.dsModMaqna = dsModMaqna;
	}

	public BigDecimal getVrMaqna() {
		return vrMaqna;
	}

	public void setVrMaqna(BigDecimal vrMaqna) {
		this.vrMaqna = vrMaqna;
	}

	public Long getCdPdido() {
		return cdPdido;
	}

	public void setCdPdido(Long cdPdido) {
		this.cdPdido = cdPdido;
	}

	public String getCdMod() {
		return cdMod;
	}

	public void setCdMod(String cdMod) {
		this.cdMod = cdMod;
	}

	public String getCdChip() {
		return cdChip;
	}

	public void setCdChip(String cdChip) {
		this.cdChip = cdChip;
	}

	public Long getFlgTransRealz() {
		return flgTransRealz;
	}

	public void setFlgTransRealz(Long flgTransRealz) {
		this.flgTransRealz = flgTransRealz;
	}

	public String getDsMotvoAltSttus() {
		return dsMotvoAltSttus;
	}

	public void setDsMotvoAltSttus(String dsMotvoAltSttus) {
		this.dsMotvoAltSttus = dsMotvoAltSttus;
	}

	@Override
	public String toString() {
		return "MaqnaCataoDomain [nuTerm=" + nuTerm + ", nuSerie=" + nuSerie + ", cdAtivacao=" + cdAtivacao
				+ ", sttusMaqna=" + sttusMaqna + ", sttus=" + sttus + ", cdSeqMaqnaMduloTerm=" + cdSeqMaqnaMduloTerm
				+ ", cdMaqnaMduloTerm=" + cdMaqnaMduloTerm + ", idSttusMduloTerm=" + idSttusMduloTerm + ", usuarIncl="
				+ usuarIncl + ", usuarAlt=" + usuarAlt + ", dtIncl=" + dtIncl + ", dtAlt=" + dtAlt + ", dsModMaqna="
				+ dsModMaqna + ", vrMaqna=" + vrMaqna + ", cdPdido=" + cdPdido + ", cdMod=" + cdMod + ", cdChip="
				+ cdChip + ", flgTransRealz=" + flgTransRealz + ", dsMotvoAltSttus=" + dsMotvoAltSttus + "]";
	}
}
