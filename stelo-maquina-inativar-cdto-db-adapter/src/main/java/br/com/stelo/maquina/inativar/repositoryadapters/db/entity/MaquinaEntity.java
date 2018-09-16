package br.com.stelo.maquina.inativar.repositoryadapters.db.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TB_MAQNA_CATAO", schema = "USR_CADU")
public class MaquinaEntity implements Serializable { 
	
	private static final long serialVersionUID = 1L;
	
	@Column(name = "NU_TERM")
	private String nuTerm;  
	
	@Id
	@Column(name = "NU_SERIE")
	private String nuSerie;  
	
	@Column(name = "CD_ATIVCAO")
	private String cdAtivacao;
	
	@Column(name = "STTUS_MAQNA")
	private String sttusMaqna;
	
	@Column(name = "STTUS")
	private String sttus;
	
	@Column(name = "CD_SEQ_MAQNA_MDULO_TERM")
	private String cdSeqMaqnaMduloTerm;
	
	@Column(name = "CD_MAQNA_MDULO_TERM")
	private String cdMaqnaMduloTerm;
	
	@Column(name = "ID_STTUS_MDULO_TERM")
	private String idSttusMduloTerm;
	
	@Column(name = "USUAR_INCL")
	private String usuarIncl;
	
	@Column(name = "USUAR_ALT")
	private String usuarAlt;
	
	@Column(name = "DT_INCL")
	private Date dtIncl;
	
	@Column(name = "DT_ALT")
	private Date dtAlt;
	
	@Column(name = "DS_MOD_MAQNA")
	private String dsModMaqna;
	
	@Column(name = "VR_MAQNA")
	private BigDecimal vrMaqna;
	
	@Column(name = "CD_PDIDO")
	private Long cdPdido;
	
	@Column(name = "CD_MOD")
	private String cdMod;
	
	@Column(name = "CD_CHIP")
	private String cdChip;         
	
	@Column(name = "FLG_TRANS_REALZ")
	private Long flgTransRealz;
	
	@Column(name = "DS_MOTVO_ALT_STTUS")
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