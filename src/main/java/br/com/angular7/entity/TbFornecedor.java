package br.com.angular7.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the tb_fornecedor database table.
 * 
 */
@Entity
@Table(name="tb_fornecedor")
public class TbFornecedor {


	@Id
	private int id;

	@Column(name="tb_fornecedor_ativo")
	private int tbFornecedorAtivo;

	@Column(name="tb_fornecedor_cnpj")
	private String tbFornecedorCnpj;

	@Column(name="tb_fornecedor_cpf")
	private String tbFornecedorCpf;

	@Temporal(TemporalType.DATE)
	@Column(name="tb_fornecedor_data_cadastramento")
	private Date tbFornecedorDataCadastramento;

	@Column(name="tb_fornecedor_nome")
	private String tbFornecedorNome;

	@Column(name="tb_fornecedor_razao_social")
	private String tbFornecedorRazaoSocial;

	@Column(name="tb_fornecedor_tipo_cliente")
	private String tbFornecedorTipoCliente;

	//bi-directional many-to-one association to TbContato
	@OneToMany(mappedBy="tbFornecedor")
	private List<TbContato> tbContatos;

	//bi-directional many-to-one association to TbEndereco
	@OneToMany(mappedBy="tbFornecedor")
	private List<TbEndereco> tbEnderecos;

	//bi-directional many-to-one association to TbPessoa
	@ManyToOne
	@JoinColumn(name="tb_pessoa_id")
	private TbPessoa tbPessoa;

	public TbFornecedor() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTbFornecedorAtivo() {
		return this.tbFornecedorAtivo;
	}

	public void setTbFornecedorAtivo(int tbFornecedorAtivo) {
		this.tbFornecedorAtivo = tbFornecedorAtivo;
	}

	public String getTbFornecedorCnpj() {
		return this.tbFornecedorCnpj;
	}

	public void setTbFornecedorCnpj(String tbFornecedorCnpj) {
		this.tbFornecedorCnpj = tbFornecedorCnpj;
	}

	public String getTbFornecedorCpf() {
		return this.tbFornecedorCpf;
	}

	public void setTbFornecedorCpf(String tbFornecedorCpf) {
		this.tbFornecedorCpf = tbFornecedorCpf;
	}

	public Date getTbFornecedorDataCadastramento() {
		return this.tbFornecedorDataCadastramento;
	}

	public void setTbFornecedorDataCadastramento(Date tbFornecedorDataCadastramento) {
		this.tbFornecedorDataCadastramento = tbFornecedorDataCadastramento;
	}

	public String getTbFornecedorNome() {
		return this.tbFornecedorNome;
	}

	public void setTbFornecedorNome(String tbFornecedorNome) {
		this.tbFornecedorNome = tbFornecedorNome;
	}

	public String getTbFornecedorRazaoSocial() {
		return this.tbFornecedorRazaoSocial;
	}

	public void setTbFornecedorRazaoSocial(String tbFornecedorRazaoSocial) {
		this.tbFornecedorRazaoSocial = tbFornecedorRazaoSocial;
	}

	public String getTbFornecedorTipoCliente() {
		return this.tbFornecedorTipoCliente;
	}

	public void setTbFornecedorTipoCliente(String tbFornecedorTipoCliente) {
		this.tbFornecedorTipoCliente = tbFornecedorTipoCliente;
	}

	public List<TbContato> getTbContatos() {
		return this.tbContatos;
	}

	public void setTbContatos(List<TbContato> tbContatos) {
		this.tbContatos = tbContatos;
	}

	public TbContato addTbContato(TbContato tbContato) {
		getTbContatos().add(tbContato);
		tbContato.setTbFornecedor(this);

		return tbContato;
	}

	public TbContato removeTbContato(TbContato tbContato) {
		getTbContatos().remove(tbContato);
		tbContato.setTbFornecedor(null);

		return tbContato;
	}

	public List<TbEndereco> getTbEnderecos() {
		return this.tbEnderecos;
	}

	public void setTbEnderecos(List<TbEndereco> tbEnderecos) {
		this.tbEnderecos = tbEnderecos;
	}

	public TbEndereco addTbEndereco(TbEndereco tbEndereco) {
		getTbEnderecos().add(tbEndereco);
		tbEndereco.setTbFornecedor(this);

		return tbEndereco;
	}

	public TbEndereco removeTbEndereco(TbEndereco tbEndereco) {
		getTbEnderecos().remove(tbEndereco);
		tbEndereco.setTbFornecedor(null);

		return tbEndereco;
	}

	public TbPessoa getTbPessoa() {
		return this.tbPessoa;
	}

	public void setTbPessoa(TbPessoa tbPessoa) {
		this.tbPessoa = tbPessoa;
	}

}