package br.com.angular7.dto;

public class UsuarioDto {

	private Long id;
	private String nomeUsuario;
	private String loginUsuario;
	private String senhaUsuario;
	private String emailUsuario;
	private String dtInicioUsuario;
	private boolean ativoUsuario;

	public UsuarioDto() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getLoginUsuario() {
		return loginUsuario;
	}

	public void setLoginUsuario(String loginUsuario) {
		this.loginUsuario = loginUsuario;
	}

	public String getSenhaUsuario() {
		return senhaUsuario;
	}

	public void setSenhaUsuario(String senhaUsuario) {
		this.senhaUsuario = senhaUsuario;
	}

	public String getEmailUsuario() {
		return emailUsuario;
	}

	public void setEmailUsuario(String emailUsuario) {
		this.emailUsuario = emailUsuario;
	}

	public String getDtInicioUsuario() {
		return dtInicioUsuario;
	}

	public void setDtInicioUsuario(String dtInicioUsuario) {
		this.dtInicioUsuario = dtInicioUsuario;
	}

	public boolean isAtivoUsuario() {
		return ativoUsuario;
	}

	public void setAtivoUsuario(boolean ativoUsuario) {
		this.ativoUsuario = ativoUsuario;
	}

}
