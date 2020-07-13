package br.com.angular7.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 * The persistent class for the tb_endereco database table.
 * 
 */
@Entity
@Table(name="tb_endereco")

public class TbEndereco {


	@Id
	private int id;

	@Column(name="tb_endereco_bairro")
	private String tbEnderecoBairro;

	@Column(name="tb_endereco_cep")
	private String tbEnderecoCep;

	@Column(name="tb_endereco_cidade")
	private String tbEnderecoCidade;

	@Column(name="tb_endereco_complemento")
	private String tbEnderecoComplemento;

	@Column(name="tb_endereco_logradouro")
	private String tbEnderecoLogradouro;

	@Column(name="tb_endereco_numero")
	private String tbEnderecoNumero;

	@Column(name="tb_endereco_uf")
	private String tbEnderecoUf;

	//bi-directional many-to-one association to TbCliente
	@ManyToOne
	@JoinColumn(name="tb_cliente_id")
	private TbCliente tbCliente;

	//bi-directional many-to-one association to TbFornecedor
	@ManyToOne
	@JoinColumn(name="tb_fornecedor_id")
	private TbFornecedor tbFornecedor;

	public TbEndereco() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTbEnderecoBairro() {
		return this.tbEnderecoBairro;
	}

	public void setTbEnderecoBairro(String tbEnderecoBairro) {
		this.tbEnderecoBairro = tbEnderecoBairro;
	}

	public String getTbEnderecoCep() {
		return this.tbEnderecoCep;
	}

	public void setTbEnderecoCep(String tbEnderecoCep) {
		this.tbEnderecoCep = tbEnderecoCep;
	}

	public String getTbEnderecoCidade() {
		return this.tbEnderecoCidade;
	}

	public void setTbEnderecoCidade(String tbEnderecoCidade) {
		this.tbEnderecoCidade = tbEnderecoCidade;
	}

	public String getTbEnderecoComplemento() {
		return this.tbEnderecoComplemento;
	}

	public void setTbEnderecoComplemento(String tbEnderecoComplemento) {
		this.tbEnderecoComplemento = tbEnderecoComplemento;
	}

	public String getTbEnderecoLogradouro() {
		return this.tbEnderecoLogradouro;
	}

	public void setTbEnderecoLogradouro(String tbEnderecoLogradouro) {
		this.tbEnderecoLogradouro = tbEnderecoLogradouro;
	}

	public String getTbEnderecoNumero() {
		return this.tbEnderecoNumero;
	}

	public void setTbEnderecoNumero(String tbEnderecoNumero) {
		this.tbEnderecoNumero = tbEnderecoNumero;
	}

	public String getTbEnderecoUf() {
		return this.tbEnderecoUf;
	}

	public void setTbEnderecoUf(String tbEnderecoUf) {
		this.tbEnderecoUf = tbEnderecoUf;
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