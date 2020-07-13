package br.com.angular7.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * The persistent class for the tb_pessoa database table.
 * 
 */
@Entity
@Table(name="tb_pessoa")
public class TbPessoa {


	@Id
	private int id;

	@Column(name="tb_pessoa_tipo")
	private String tbPessoaTipo;

	//bi-directional many-to-one association to TbCliente
	@OneToMany(mappedBy="tbPessoa")
	private List<TbCliente> tbClientes;

	//bi-directional many-to-one association to TbFornecedor
	@OneToMany(mappedBy="tbPessoa")
	private List<TbFornecedor> tbFornecedors;

	public TbPessoa() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTbPessoaTipo() {
		return this.tbPessoaTipo;
	}

	public void setTbPessoaTipo(String tbPessoaTipo) {
		this.tbPessoaTipo = tbPessoaTipo;
	}

	public List<TbCliente> getTbClientes() {
		return this.tbClientes;
	}

	public void setTbClientes(List<TbCliente> tbClientes) {
		this.tbClientes = tbClientes;
	}

	public TbCliente addTbCliente(TbCliente tbCliente) {
		getTbClientes().add(tbCliente);
		tbCliente.setTbPessoa(this);

		return tbCliente;
	}

	public TbCliente removeTbCliente(TbCliente tbCliente) {
		getTbClientes().remove(tbCliente);
		tbCliente.setTbPessoa(null);

		return tbCliente;
	}

	public List<TbFornecedor> getTbFornecedors() {
		return this.tbFornecedors;
	}

	public void setTbFornecedors(List<TbFornecedor> tbFornecedors) {
		this.tbFornecedors = tbFornecedors;
	}

	public TbFornecedor addTbFornecedor(TbFornecedor tbFornecedor) {
		getTbFornecedors().add(tbFornecedor);
		tbFornecedor.setTbPessoa(this);

		return tbFornecedor;
	}

	public TbFornecedor removeTbFornecedor(TbFornecedor tbFornecedor) {
		getTbFornecedors().remove(tbFornecedor);
		tbFornecedor.setTbPessoa(null);

		return tbFornecedor;
	}

}