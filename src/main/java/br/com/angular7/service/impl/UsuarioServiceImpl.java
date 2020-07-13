package br.com.angular7.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.angular7.dto.UsuarioDto;
import br.com.angular7.repository.UsuarioRepository;
import br.com.angular7.service.UsuarioService;


@Service
public class UsuarioServiceImpl implements UsuarioService {
	
	@Autowired
	private UsuarioRepository UsuarioService;

	@Override
	public void addUsuarioDto(UsuarioDto usuarioDto) throws Exception, Throwable {		
		UsuarioService.addUsuarioDto(usuarioDto);
	}

	@Override
	public void updateUsuarioDto(UsuarioDto usuarioDto) throws Exception, Throwable {
		UsuarioService.updateUsuarioDto(usuarioDto);
		
	}

	@Override
	public List<UsuarioDto> getAllUsuarios() throws Exception, Throwable {
	
		return UsuarioService.getAllUsuarios();
	}

	@Override
	public UsuarioDto getUsuarioById(int id) throws Exception, Throwable {
		UsuarioDto obj = UsuarioService.getUsuarioById(id);
		return obj;
	}

	@Override
	public void deleteUsuario(int id) throws Exception, Throwable {
		UsuarioService.deleteUsuario(id);
		
	}

	

}
