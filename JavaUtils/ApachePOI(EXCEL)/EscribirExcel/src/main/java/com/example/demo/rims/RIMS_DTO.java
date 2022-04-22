package com.example.demo.rims;

public class RIMS_DTO {	
	
	private String motivo;
	private String discrepancia;
	private String trade;
	private String sentido;
	private String isin;
	private Integer eri;
	private Integer fecha;
	private Integer hora;
	private String cci;
	private Integer titulos;
	private Integer bolsa;
	private String miembro;
	private String cuenta;
	private String  ccc; //TODO si comienza con 0 string, sino Long
	private String plataforma;
	private String segmento;
	private String ordenante;
	private Integer refext;
	private Integer trade_tag;
	private String coi;
	private String mercado;
	private String estado;
	private String titular;
	
	public RIMS_DTO() {
		super();
	}
	
	public RIMS_DTO(Long ccc) {
		super();
	}
	
	

	public RIMS_DTO(String motivo, String discrepancia, String trade, String sentido, String isin, Integer eri,
			Integer fecha, Integer hora, String cci, Integer titulos, Integer bolsa, String miembro, String cuenta,
			String ccc, String plataforma, String segmento, String ordenante, Integer refext, Integer trade_tag,
			String coi, String mercado, String estado, String titular) {
		super();
		this.motivo = motivo;
		this.discrepancia = discrepancia;
		this.trade = trade;
		this.sentido = sentido;
		this.isin = isin;
		this.eri = eri;
		this.fecha = fecha;
		this.hora = hora;
		this.cci = cci;
		this.titulos = titulos;
		this.bolsa = bolsa;
		this.miembro = miembro;
		this.cuenta = cuenta;
		this.ccc = ccc;
		this.plataforma = plataforma;
		this.segmento = segmento;
		this.ordenante = ordenante;
		this.refext = refext;
		this.trade_tag = trade_tag;
		this.coi = coi;
		this.mercado = mercado;
		this.estado = estado;
		this.titular = titular;
	}



	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public String getDiscrepancia() {
		return discrepancia;
	}

	public void setDiscrepancia(String discrepancia) {
		this.discrepancia = discrepancia;
	}

	public String getTrade() {
		return trade;
	}

	public void setTrade(String trade) {
		this.trade = trade;
	}

	public String getSentido() {
		return sentido;
	}

	public void setSentido(String sentido) {
		this.sentido = sentido;
	}

	public String getIsin() {
		return isin;
	}

	public void setIsin(String isin) {
		this.isin = isin;
	}

	public Integer getEri() {
		return eri;
	}

	public void setEri(Integer eri) {
		this.eri = eri;
	}

	public Integer getFecha() {
		return fecha;
	}

	public void setFecha(Integer fecha) {
		this.fecha = fecha;
	}

	public Integer getHora() {
		return hora;
	}

	public void setHora(Integer hora) {
		this.hora = hora;
	}

	public String getCci() {
		return cci;
	}

	public void setCci(String cci) {
		this.cci = cci;
	}

	public Integer getTitulos() {
		return titulos;
	}

	public void setTitulos(Integer titulos) {
		this.titulos = titulos;
	}

	public Integer getBolsa() {
		return bolsa;
	}

	public void setBolsa(Integer bolsa) {
		this.bolsa = bolsa;
	}

	public String getMiembro() {
		return miembro;
	}

	public void setMiembro(String miembro) {
		this.miembro = miembro;
	}

	public String getCuenta() {
		return cuenta;
	}

	public void setCuenta(String cuenta) {
		this.cuenta = cuenta;
	}

	public String getCcc() {
		return ccc;
	}

	public void setCcc(String ccc) {
		this.ccc = ccc;
	}

	public String getPlataforma() {
		return plataforma;
	}

	public void setPlataforma(String plataforma) {
		this.plataforma = plataforma;
	}

	public String getSegmento() {
		return segmento;
	}

	public void setSegmento(String segmento) {
		this.segmento = segmento;
	}

	public String getOrdenante() {
		return ordenante;
	}

	public void setOrdenante(String ordenante) {
		this.ordenante = ordenante;
	}

	public Integer getRefext() {
		return refext;
	}

	public void setRefext(Integer refext) {
		this.refext = refext;
	}

	public Integer getTrade_tag() {
		return trade_tag;
	}

	public void setTrade_tag(Integer trade_tag) {
		this.trade_tag = trade_tag;
	}

	public String getCoi() {
		return coi;
	}

	public void setCoi(String coi) {
		this.coi = coi;
	}

	public String getMercado() {
		return mercado;
	}

	public void setMercado(String mercado) {
		this.mercado = mercado;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	

}
