package br.com.angular7.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.angular7.dto.ResponseDto;
import br.com.angular7.dto.UsuarioDto;
import br.com.angular7.service.UsuarioService;

@Controller
@CrossOrigin(origins  = "http://localhost:4200")
@RestController
@RequestMapping("/service")
public class UsuarioController {
	
	private static final Logger log = LoggerFactory.getLogger(UsuarioController.class);
	
	@Autowired
	private UsuarioService usuarioService;
	
	/**
	 * INCLUIR USUARIO
	 * @param usuarioDto
	 * @return
	 * @throws Exception
	 * @throws Throwable
	 */
	@RequestMapping(value="/usuario",method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody ResponseDto salvar(@RequestBody UsuarioDto usuarioDto)  throws Exception, Throwable {      


		log.info("UsuarioController.salvar--------> INCLUINDO USUARIO!");
		
		
		try {			 
			this.usuarioService.addUsuarioDto(usuarioDto);
			return new ResponseDto(1,"Usuario salvo com sucesso!"); 
		}catch(Exception e) {
			log.error("UsuarioController.salvar----------------- ERRO AO INCLUIR USUARIO: " + e.toString());
			return new ResponseDto(0,e.getMessage());			
		}
	}
	
	
	/**
	 * ATUALIZAR USUARIO
	 * @param usuarioDto
	 * @return
	 * @throws Exception
	 * @throws Throwable
	 */	
	@RequestMapping(value="/usuario", method = RequestMethod.PUT, produces = "application/json")
	public @ResponseBody ResponseDto atualizar(@RequestBody UsuarioDto usuarioDto)  throws Exception, Throwable {

		log.info("UsuarioController.atualizar--------> ATUALIZAR USUARIO!");
		
		
		try {			 
			this.usuarioService.updateUsuarioDto(usuarioDto);	
			return new ResponseDto(1,"Usuario atualizado com sucesso!"); 
		}catch(Exception e) { 
			log.error("UsuarioController.atualizar----------------- ERRO AO ATUALIZAR USUARIO: " + e.toString());
			return new ResponseDto(0,e.getMessage());
		}
	}
	
	
	/**
	 * LISTAR TOS OS USUARIOS
	 * @return
	 * @throws Exception
	 * @throws Throwable
	 */
	@RequestMapping(value="/usuario", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<UsuarioDto> consultar()  throws Exception, Throwable {
		
		log.info("UsuarioController.consultar--------> LISTAR DE USUARIOS!");
		try {			
			return this.usuarioService.getAllUsuarios();
		} catch (Exception e) {
			log.error("UsuarioController.consultar----------------- ERRO AO LISTAR USUARIO: " + e.toString());
		}
		return null;
	}


	/**
	 * CONSULTAR USUARIO POR ID
	 * @param idUsuario
	 * @return
	 * @throws Exception
	 * @throws Throwable
	 */
	@RequestMapping(value="/usuario/{idUsuario}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody UsuarioDto buscar(@PathVariable("idUsuario") String idUsuario)  throws Exception, Throwable {
		
		log.info("UsuarioController.buscar--------> CONSULTAR USUARIO!");
		try {
			int id = Integer.parseInt(idUsuario);			
			return this.usuarioService.getUsuarioById(id);
		} catch (Exception e) {
			log.error("UsuarioController.buscar----------------- ERRO AO BUSCAR USUARIO POR ID: " + e.toString());
		}
		return null;
	}
	

	/**
	 * EXCLUIR USUARIO POR ID
	 * @param idUsuario
	 * @return
	 * @throws Exception
	 * @throws Throwable
	 */
	@RequestMapping(value="/usuario/{idUsuario}", method = RequestMethod.DELETE, produces = "application/json")
	public @ResponseBody ResponseDto excluir(@PathVariable("idUsuario") String idUsuario)  throws Exception, Throwable {
		
		log.info("UsuarioController.excluir--------> EXCLUIR USUARIO!");
		
		int id = Integer.parseInt(idUsuario);
		 
		try { 
			usuarioService.deleteUsuario(id);
			return new ResponseDto(1, "Usuario excluido com sucesso!"); 
		}catch(Exception e) {
			log.error("UsuarioController.excluir----------------- ERRO AO EXCLUIR USUARIO POR ID: " + e.toString());
			return new ResponseDto(0, e.getMessage());
		}
	}	
	
}
