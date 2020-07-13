package br.com.angular7.dto;

public class ResponseDto {

	private int codigo;
	private String mensagem;
 
	public ResponseDto() {}
 
	public ResponseDto(int codigo, String mensagem) {
		this.codigo   = codigo;
		this.mensagem =  mensagem;
	}
 
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getMensagem() {
		return mensagem;
	}
 
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
}
