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
 * The persistent class for the tb_cliente database table.
 * 
 */
@Entity
@Table(name="tb_cliente")
public class TbCliente   {
	

	@Id
	private int id;

	@Column(name="tb_cliente_ativo")
	private int tbClienteAtivo;

	@Column(name="tb_cliente_cnpj")
	private String tbClienteCnpj;

	@Column(name="tb_cliente_cpf")
	private String tbClienteCpf;

	@Temporal(TemporalType.DATE)
	@Column(name="tb_cliente_data_cadastramento")
	private Date tbClienteDataCadastramento;

	@Column(name="tb_cliente_nome")
	private String tbClienteNome;

	@Column(name="tb_cliente_razao_social")
	private String tbClienteRazaoSocial;

	@Column(name="tb_cliente_tipo_cliente")
	private String tbClienteTipoCliente;

	//bi-directional many-to-one association to TbPessoa
	@ManyToOne
	@JoinColumn(name="tb_pessoa_id")
	private TbPessoa tbPessoa;

	//bi-directional many-to-one association to TbContato
	@OneToMany(mappedBy="tbCliente")
	private List<TbContato> tbContatos;

	//bi-directional many-to-one association to TbEndereco
	@OneToMany(mappedBy="tbCliente")
	private List<TbEndereco> tbEnderecos;

	public TbCliente() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTbClienteAtivo() {
		return this.tbClienteAtivo;
	}

	public void setTbClienteAtivo(int tbClienteAtivo) {
		this.tbClienteAtivo = tbClienteAtivo;
	}

	public String getTbClienteCnpj() {
		return this.tbClienteCnpj;
	}

	public void setTbClienteCnpj(String tbClienteCnpj) {
		this.tbClienteCnpj = tbClienteCnpj;
	}

	public String getTbClienteCpf() {
		return this.tbClienteCpf;
	}

	public void setTbClienteCpf(String tbClienteCpf) {
		this.tbClienteCpf = tbClienteCpf;
	}

	public Date getTbClienteDataCadastramento() {
		return this.tbClienteDataCadastramento;
	}

	public void setTbClienteDataCadastramento(Date tbClienteDataCadastramento) {
		this.tbClienteDataCadastramento = tbClienteDataCadastramento;
	}

	public String getTbClienteNome() {
		return this.tbClienteNome;
	}

	public void setTbClienteNome(String tbClienteNome) {
		this.tbClienteNome = tbClienteNome;
	}

	public String getTbClienteRazaoSocial() {
		return this.tbClienteRazaoSocial;
	}

	public void setTbClienteRazaoSocial(String tbClienteRazaoSocial) {
		this.tbClienteRazaoSocial = tbClienteRazaoSocial;
	}

	public String getTbClienteTipoCliente() {
		return this.tbClienteTipoCliente;
	}

	public void setTbClienteTipoCliente(String tbClienteTipoCliente) {
		this.tbClienteTipoCliente = tbClienteTipoCliente;
	}

	public TbPessoa getTbPessoa() {
		return this.tbPessoa;
	}

	public void setTbPessoa(TbPessoa tbPessoa) {
		this.tbPessoa = tbPessoa;
	}

	public List<TbContato> getTbContatos() {
		return this.tbContatos;
	}

	public void setTbContatos(List<TbContato> tbContatos) {
		this.tbContatos = tbContatos;
	}

	public TbContato addTbContato(TbContato tbContato) {
		getTbContatos().add(tbContato);
		tbContato.setTbCliente(this);

		return tbContato;
	}

	public TbContato removeTbContato(TbContato tbContato) {
		getTbContatos().remove(tbContato);
		tbContato.setTbCliente(null);

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
		tbEndereco.setTbCliente(this);

		return tbEndereco;
	}

	public TbEndereco removeTbEndereco(TbEndereco tbEndereco) {
		getTbEnderecos().remove(tbEndereco);
		tbEndereco.setTbCliente(null);

		return tbEndereco;
	}

}