package com.tcc.gerenciadorfrotas.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcc.gerenciadorfrotas.exception.VeiculoNaoEncontradoException;
import com.tcc.gerenciadorfrotas.model.dto.VeiculoDto;
import com.tcc.gerenciadorfrotas.model.entity.Veiculo;
import com.tcc.gerenciadorfrotas.model.form.VeiculoForm;
import com.tcc.gerenciadorfrotas.repository.VeiculoRepository;

@Service
public class VeiculoService {

    @Autowired
    VeiculoRepository veiculoRepository;

    public VeiculoDto criarVeiculo(VeiculoForm form) {

        Veiculo veiculo = new Veiculo();
        veiculo.setMarca(form.getMarca());
        veiculo.setModelo(form.getModelo());
        veiculo.setPlaca(form.getPlaca());
        veiculo.setChassi(form.getChassi());
        veiculo.setAno(form.getAno());
        veiculo.setEstadoAtual(form.getEstadoAtual());

        veiculo = veiculoRepository.save(veiculo);
        return toDto(veiculo);

    }

    public List<VeiculoDto> buscarTodosVeiculos() {
        List<Veiculo> todos = veiculoRepository.findAll();
        return listToDto(todos);
    }

    public VeiculoDto buscarVeiculoPorId(Long id) {
        try {
            Optional<Veiculo> opt = veiculoRepository.findById(id);
            return toDto(opt.get());
        } catch (NoSuchElementException e) {
            throw new VeiculoNaoEncontradoException(id);
        }
    }

    public VeiculoDto atualizarPorId(VeiculoForm form, Long id) {
        Optional<Veiculo> opt = veiculoRepository.findById(id);
        try {
            Veiculo veiculo = opt.get();

            veiculo.setMarca(form.getMarca());
            veiculo.setModelo(form.getModelo());
            veiculo.setPlaca(form.getPlaca());
            veiculo.setChassi(form.getChassi());
            veiculo.setAno(form.getAno());
            veiculo.setEstadoAtual(form.getEstadoAtual());

            veiculoRepository.save(veiculo);
            return toDto(veiculo);
        } catch (NoSuchElementException e) {
            throw new VeiculoNaoEncontradoException(id);
        }
    }

    public void deletarPorId(Long id) {
        if (veiculoRepository.existsById(id)) {
            veiculoRepository.deleteById(id);
        }
    }

    private VeiculoDto toDto(Veiculo veiculo) {

        VeiculoDto dto = new VeiculoDto();
        dto.setMarca(veiculo.getMarca());
        dto.setModelo(veiculo.getModelo());
        dto.setPlaca(veiculo.getPlaca());
        dto.setChassi(veiculo.getChassi());
        dto.setAno(veiculo.getAno());
        dto.setEstadoAtual(veiculo.getEstadoAtual());
        return dto;
    }

    private static List<VeiculoDto> listToDto(List<Veiculo> veiculos) {
        return veiculos.stream().map(VeiculoDto::new).collect(Collectors.toList());

    }

}
