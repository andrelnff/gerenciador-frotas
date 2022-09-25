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

import com.tcc.gerenciadorfrotas.model.dto.ViagemDto;
import com.tcc.gerenciadorfrotas.model.form.ViagemForm;
import com.tcc.gerenciadorfrotas.service.ViagemService;

@RestController
@RequestMapping("/viagens")
public class ViagemController {

	@Autowired
	private ViagemService viagemService;

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public ViagemDto registrarViagem(@RequestBody @Valid ViagemForm viagemForm) {
		return viagemService.criarViagem(viagemForm);
	}

	@GetMapping
	public List<ViagemDto> listarTodos() {
		return viagemService.buscarTodasViagens();
	}

	@GetMapping("/{id}")
	public ViagemDto buscaPorId(@PathVariable("id") Long id) {
		return viagemService.buscarViagemPorId(id);
	}

	@PutMapping("/{id}")
	public ViagemDto atualizarPorId(@RequestBody ViagemForm form, @PathVariable("id") Long id) {
		return viagemService.atualizarPorId(form, id);
	}

	@DeleteMapping("/{id}")
	public void deletarPorId(@PathVariable("id") Long id) {
		viagemService.deletarPorId(id);
	}

}
