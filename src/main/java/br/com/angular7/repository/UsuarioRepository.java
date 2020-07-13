package br.com.angular7.repository;

import java.util.List;

import br.com.angular7.dto.UsuarioDto;

public interface UsuarioRepository {
	
	/**
	 * INCLUIR USUARIO
	 * @param usuarioDto
	 * @throws Exception
	 * @throws Throwable
	 */
	void addUsuarioDto(UsuarioDto usuarioDto)  throws Exception, Throwable;
	
	/**
	 * EDITAR USUARIO
	 * @param usuarioDto
	 * @throws Exception
	 * @throws Throwable
	 */
	void updateUsuarioDto(UsuarioDto usuarioDto)  throws Exception, Throwable;
	
	/**
	 * LISTAR TODOS USUARIOS
	 * @return
	 * @throws Exception
	 * @throws Throwable
	 */
	List<UsuarioDto> getAllUsuarios()  throws Exception, Throwable;
	
	/**
	 * CONSULTAR USUARIO POR ID
	 * @param id
	 * @return
	 * @throws Exception
	 * @throws Throwable
	 */
	UsuarioDto getUsuarioById(int id)  throws Exception, Throwable;
	
	/**
	 * APAGAR CLIENTE POR ID
	 * @param id
	 * @throws Exception
	 * @throws Throwable
	 */
	void deleteUsuario(int id)  throws Exception, Throwable;
}
