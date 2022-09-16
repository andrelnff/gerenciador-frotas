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

import com.tcc.gerenciadorfrotas.model.dto.VeiculoDto;
import com.tcc.gerenciadorfrotas.model.form.VeiculoForm;
import com.tcc.gerenciadorfrotas.service.VeiculoService;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {

	@Autowired
	private VeiculoService veiculoService;

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public VeiculoDto registrarVeiculo(@RequestBody @Valid VeiculoForm veiculoForm) {
		return veiculoService.criarVeiculo(veiculoForm);
	}

	@GetMapping
	public List<VeiculoDto> listarTodos() {
		return veiculoService.buscarTodosVeiculos();
	}

	@GetMapping("/{id}")
	public VeiculoDto buscaPorId(@PathVariable("id") Long id) {
		return veiculoService.buscarVeiculoPorId(id);
	}

	@PutMapping("/{id}")
	public VeiculoDto atualizarPorId(@RequestBody VeiculoForm form, @PathVariable("id") Long id) {
		return veiculoService.atualizarPorId(form, id);
	}

	@DeleteMapping("/{id}")
	public void deletarPorId(@PathVariable("id") Long id) {
		veiculoService.deletarPorId(id);
	}

}
