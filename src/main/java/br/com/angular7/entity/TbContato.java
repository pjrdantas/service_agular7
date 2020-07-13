package br.com.angular7.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 * The persistent class for the tb_contatos database table.
 * 
 */
@Entity
@Table(name="tb_contatos")

public class TbContato {


	@Id
	private int id;

	@Column(name="tb_contatos_contato")
	private String tbContatosContato;

	@Column(name="tb_contatos_email")
	private String tbContatosEmail;

	@Column(name="tb_contatos_telefone")
	private String tbContatosTelefone;

	//bi-directional many-to-one association to TbCliente
	@ManyToOne
	@JoinColumn(name="tb_cliente_id")
	private TbCliente tbCliente;

	//bi-directional many-to-one association to TbFornecedor
	@ManyToOne
	@JoinColumn(name="tb_fornecedor_id")
	private TbFornecedor tbFornecedor;

	public TbContato() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTbContatosContato() {
		return this.tbContatosContato;
	}

	public void setTbContatosContato(String tbContatosContato) {
		this.tbContatosContato = tbContatosContato;
	}

	public String getTbContatosEmail() {
		return this.tbContatosEmail;
	}

	public void setTbContatosEmail(String tbContatosEmail) {
		this.tbContatosEmail = tbContatosEmail;
	}

	public String getTbContatosTelefone() {
		return this.tbContatosTelefone;
	}

	public void setTbContatosTelefone(String tbContatosTelefone) {
		this.tbContatosTelefone = tbContatosTelefone;
	}

	public TbCliente getTbCliente() {
		return this.tbCliente;
	}

	public void setTbCliente(TbCliente tbCliente) {
		this.tbCliente = tbCliente;
	}

	public TbFornecedor getTbFornecedor() {
		return this.tbFornecedor;
	}

	public void setTbFornecedor(TbFornecedor tbFornecedor) {
		this.tbFornecedor = tbFornecedor;
	}

}