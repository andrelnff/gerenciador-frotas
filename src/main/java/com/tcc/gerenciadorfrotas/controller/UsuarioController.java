package com.tcc.gerenciadorfrotas.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tcc.gerenciadorfrotas.model.dto.UsuarioDto;
import com.tcc.gerenciadorfrotas.model.form.UsuarioForm;
import com.tcc.gerenciadorfrotas.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public UsuarioDto registrarUsuario(@RequestBody @Valid UsuarioForm usuarioForm) {
		return usuarioService.criarUsuario(usuarioForm);
	}

	@GetMapping
	public List<UsuarioDto> listarTodos() {
		return usuarioService.buscarTodosUsuario();
	}

	@GetMapping("/{id}")
	public UsuarioDto buscaPorId(@PathVariable("id") Long id) {
		return usuarioService.buscarUsuarioPorId(id);
	}

	@PutMapping("/{id}")
	public UsuarioDto atualizarPorId(@RequestBody UsuarioForm form, @PathVariable("id") Long id) {
		return usuarioService.atualizarPorId(form, id);
	}

	@DeleteMapping("/{id}")
	public void deletarPorId(@PathVariable("id") Long id) {
		usuarioService.deletarPorId(id);
	}

}
