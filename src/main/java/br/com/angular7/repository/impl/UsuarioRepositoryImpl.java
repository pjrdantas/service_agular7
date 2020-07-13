package br.com.angular7.repository.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.angular7.dto.UsuarioDto;
import br.com.angular7.repository.UsuarioRepository;

@Transactional
@Repository
public class UsuarioRepositoryImpl implements UsuarioRepository {

	private static final Logger log = LoggerFactory.getLogger(UsuarioRepositoryImpl.class);

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	 
	SimpleDateFormat formatador  = new SimpleDateFormat("dd/MM/yyyy");
	String dataFormatada;
	Date data;
	
	/**
	 * INCLUIR USUARIO
	 */
	@Override
	public void addUsuarioDto(UsuarioDto usuarioDto) throws Exception, Throwable {
		
				
		usuarioDto.setDtInicioUsuario(usuarioDto.getDtInicioUsuario().substring(0, 10));
		
		System.out.println("*******************************************: "+usuarioDto.getDtInicioUsuario());
		
		StringBuilder sql = new StringBuilder();
		
		sql.append("  INSERT INTO ");
		sql.append("  tb_usuario (");
		sql.append("  id, ");
		sql.append("  tb_usuario_ativo, ");
		sql.append("  tb_usuario_data_inicio, ");
		sql.append("  tb_usuario_email, ");
		sql.append("  tb_usuario_login, ");
		sql.append("  tb_usuario_senha, ");
		sql.append("  tb_usuario_nome) ");
		sql.append("  values (:id, :usuarioAtivo, :usuarioDataInicio, :usuarioEmail, :usuarioLogin, :usuarioSenha, :usuarioNome)");
		SqlParameterSource params = new MapSqlParameterSource()
				.addValue("id", usuarioDto.getId())
				.addValue("usuarioAtivo", usuarioDto.isAtivoUsuario())
				.addValue("usuarioDataInicio", usuarioDto.getDtInicioUsuario())
				.addValue("usuarioEmail", usuarioDto.getEmailUsuario())
				.addValue("usuarioLogin", usuarioDto.getLoginUsuario())
				.addValue("usuarioSenha", usuarioDto.getSenhaUsuario())
				.addValue("usuarioNome", usuarioDto.getNomeUsuario());
		try {
			jdbcTemplate.update(sql.toString(), params);
			log.info("UsuarioRepositoryImpl.addUsuarioDto--------> USUARIO INCLUIDO COM SUCESSO!");
		} catch (Exception e) {
			log.error("UsuarioRepositoryImpl.addUsuarioDto----------------- ERRO NA INCLUSÃO DO USUARIO: " + e.toString());
		}
	}
	
	

	/**
	 * ATUALIZA USUARIO
	 */
	@Override
	public void updateUsuarioDto(UsuarioDto usuarioDto) throws Exception, Throwable {
		
usuarioDto.setDtInicioUsuario(usuarioDto.getDtInicioUsuario().substring(0, 10));
		
		System.out.println("*******************************************: "+usuarioDto.getDtInicioUsuario());
		
		StringBuilder sql = new StringBuilder();
		
		sql.append(" UPDATE tb_usuario ");
		sql.append(" SET  ");
		sql.append(" tb_usuario_ativo = :usuarioAtivo, ");
		sql.append(" tb_usuario_data_inicio = :usuarioDataInicio, ");
		sql.append(" tb_usuario_email = :usuarioEmail, ");
		sql.append(" tb_usuario_login = :usuarioLogin, ");
		sql.append(" tb_usuario_senha = :usuarioSenha, ");
		sql.append(" tb_usuario_nome = :usuarioNome ");
		sql.append(" WHERE id = :id");
		
		SqlParameterSource params = new MapSqlParameterSource()
				.addValue("id", usuarioDto.getId())
				.addValue("usuarioAtivo", usuarioDto.isAtivoUsuario())
				.addValue("usuarioDataInicio", usuarioDto.getDtInicioUsuario())
				.addValue("usuarioEmail", usuarioDto.getEmailUsuario())
				.addValue("usuarioLogin", usuarioDto.getLoginUsuario())
				.addValue("usuarioSenha", usuarioDto.getSenhaUsuario())
				.addValue("usuarioNome", usuarioDto.getNomeUsuario());
		try {
			jdbcTemplate.update(sql.toString(), params);
			log.info("UsuarioRepositoryImpl.updateUsuarioDto--------> USUARIO ATUALIZADO COM SUCESSO!");
		} catch (Exception e) {
			log.error("UsuarioRepositoryImpl.updateUsuarioDto----------------- ERRO NA ATUALIZAÇÃO DO USUARIO: " + e.toString());
		}
	}
	
	

	/**
	 * LISTAR TODOS USUARIOS
	 */
	@Override
	public List<UsuarioDto> getAllUsuarios() throws Exception, Throwable {
		
		try {
			StringBuilder sql = new StringBuilder(sqlSelectPrincipal).append(" order by tb_usuario_nome ");
			log.info("UsuarioRepositoryImpl.getAllUsuarios--------> LISTA DE USUARIOS EMITIDA COM SUCESSO!");
			return devolveListaObjetos(sql, null);
		} catch (Exception e) {
			log.error("UsuarioRepositoryImpl.getAllUsuarios----------------- ERRO NA EMISSÃO DA LISTA DE USUARIOS: " + e.toString());
		}
		return null;
	}

	
	
	/**
	 * CONSULTA USUARIO POR ID
	 */
	@Override
	public UsuarioDto getUsuarioById(int id) throws Exception, Throwable {
		
		try {
			StringBuilder sql = new StringBuilder(sqlSelectPrincipal);
			sql.append(" WHERE id = :id ");
			SqlParameterSource params = new MapSqlParameterSource().addValue("id", id);
			log.info("UsuarioRepositoryImpl.getUsuarioById--------> USUARIO LOCALIZADO COM SUCESSO!!!");
			return devolveObjeto(sql, params);
		} catch (Exception e) {
			log.error("UsuarioRepositoryImpl.getUsuarioById----------------- ERRO AO TENTAR LOCALIZAR O USUARIO: " + e.toString());
		}
		return null;
	}

	
	
	/**
	 * EXCLUIR USUARIO PELO ID
	 */
	@Override
	public void deleteUsuario(int id) throws Exception, Throwable {

		StringBuilder sql = new StringBuilder();
		sql.append(" DELETE FROM ");
		sql.append(" tb_usuario ");
		sql.append(" WHERE id = :id");
		SqlParameterSource params = new MapSqlParameterSource().addValue("id", id);
		try {
			jdbcTemplate.update(sql.toString(), params);
			log.info("UsuarioRepositoryImpl.deleteUsuario--------> USUARIO EXCLUIDO COM SUCESSO!!!");
		} catch (Exception e) {
			log.error("UsuarioRepositoryImpl.deleteUsuario----------------- ERRO NA EXCLUSÃO DO USUARIO! " + e.toString());
		}
	}
	
	

	
	
	
	// --------------------- METODOS PARA IMPLEMENTAÇÃO DE CONSULTAS POR ID OU LISTA
	
	/**
	 * PREPARAR USUARIO PARA CONSULTA
	 */
	final static StringBuilder sqlSelectPrincipal = new StringBuilder()
			.append("  SELECT ")
			.append("  id")
			.append("  ,tb_usuario_ativo")
			.append("  ,tb_usuario_data_inicio")
			.append("  ,tb_usuario_email")
			.append("  ,tb_usuario_login")
			.append("  ,tb_usuario_senha")
			.append("  ,tb_usuario_nome")
			.append("  FROM tb_usuario ");

	
	
	
	
	/**
	 * MONTAR LISTA PARA CONSULTA DE USUARIO	 * 
	 * @param sql
	 * @param params
	 * @return
	 * @throws Exception
	 * @throws Throwable
	 */
	private List<UsuarioDto> devolveListaObjetos(StringBuilder sql, SqlParameterSource params) throws Exception, Throwable {
		return jdbcTemplate.query(sql.toString(), params, (rs, i) -> {
			
			UsuarioDto usuarioDto = new UsuarioDto();
			
			usuarioDto.setId(rs.getLong("id"));
			usuarioDto.setAtivoUsuario(rs.getBoolean("tb_usuario_ativo"));
			dataFormatada = formatador.format(rs.getDate("tb_usuario_data_inicio"));
			usuarioDto.setDtInicioUsuario(dataFormatada);
			usuarioDto.setEmailUsuario(rs.getString("tb_usuario_email"));
			usuarioDto.setLoginUsuario(rs.getString("tb_usuario_login"));
			usuarioDto.setSenhaUsuario(rs.getString("tb_usuario_senha"));
			usuarioDto.setNomeUsuario(rs.getString("tb_usuario_nome"));
			return usuarioDto;
		});
	}

	
	
	
	
	/**
	 * CONSULTA POR ID USUARIO	 * 
	 * @param sql
	 * @param params
	 * @return
	 * @throws Exception
	 * @throws Throwable
	 */
	private UsuarioDto devolveObjeto(StringBuilder sql, SqlParameterSource params) throws Exception, Throwable {
		return jdbcTemplate.queryForObject(sql.toString(), params, (rs, i) -> {
			UsuarioDto usuarioDto = new UsuarioDto();
			usuarioDto.setId(rs.getLong("id"));
			usuarioDto.setAtivoUsuario(rs.getBoolean("tb_usuario_ativo"));
			usuarioDto.setDtInicioUsuario(rs.getString("tb_usuario_data_inicio"));
			usuarioDto.setEmailUsuario(rs.getString("tb_usuario_email"));
			usuarioDto.setLoginUsuario(rs.getString("tb_usuario_login"));
			usuarioDto.setSenhaUsuario(rs.getString("tb_usuario_senha"));
			usuarioDto.setNomeUsuario(rs.getString("tb_usuario_nome"));
			return usuarioDto;
		});
	}

}
