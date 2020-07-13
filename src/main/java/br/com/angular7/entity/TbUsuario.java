package br.com.angular7.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="tb_usuario")
public class TbUsuario {

	@Id
	@Column(name="id", unique=true, nullable=false)
	private int id;

	@Column(name="tb_usuario_ativo")
	private boolean tbUsuarioAtivo;

	@Temporal(TemporalType.DATE)
	@Column(name="tb_usuario_data_inicio")
	private Date tbUsuarioDataInicio;

	@Column(name="tb_usuario_email")
	private String tbUsuarioEmail;

	@Column(name="tb_usuario_login")
	private String tbUsuarioLogin;

	@Column(name="tb_usuario_nome")
	private String tbUsuarioNome;

	@Column(name="tb_usuario_senha")
	private String tbUsuarioSenha;

	public TbUsuario() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean getTbUsuarioAtivo() {
		return this.tbUsuarioAtivo;
	}

	public void setTbUsuarioAtivo(boolean tbUsuarioAtivo) {
		this.tbUsuarioAtivo = tbUsuarioAtivo;
	}

	public Date getTbUsuarioDataInicio() {
		return this.tbUsuarioDataInicio;
	}

	public void setTbUsuarioDataInicio(Date tbUsuarioDataInicio) {
		this.tbUsuarioDataInicio = tbUsuarioDataInicio;
	}

	public String getTbUsuarioEmail() {
		return this.tbUsuarioEmail;
	}

	public void setTbUsuarioEmail(String tbUsuarioEmail) {
		this.tbUsuarioEmail = tbUsuarioEmail;
	}

	public String getTbUsuarioLogin() {
		return this.tbUsuarioLogin;
	}

	public void setTbUsuarioLogin(String tbUsuarioLogin) {
		this.tbUsuarioLogin = tbUsuarioLogin;
	}

	public String getTbUsuarioNome() {
		return this.tbUsuarioNome;
	}

	public void setTbUsuarioNome(String tbUsuarioNome) {
		this.tbUsuarioNome = tbUsuarioNome;
	}

	public String getTbUsuarioSenha() {
		return this.tbUsuarioSenha;
	}

	public void setTbUsuarioSenha(String tbUsuarioSenha) {
		this.tbUsuarioSenha = tbUsuarioSenha;
	}

}

