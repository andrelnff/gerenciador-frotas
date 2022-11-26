package com.tcc.gerenciadorfrotas.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcc.gerenciadorfrotas.exception.ViagemNaoEncontradaException;
import com.tcc.gerenciadorfrotas.model.dto.ViagemDto;
import com.tcc.gerenciadorfrotas.model.entity.Viagem;
import com.tcc.gerenciadorfrotas.model.form.ViagemForm;
import com.tcc.gerenciadorfrotas.repository.VeiculoRepository;
import com.tcc.gerenciadorfrotas.repository.ViagemRepository;

@Service
public class ViagemService {

    @Autowired
    ViagemRepository viagemRepository;

    @Autowired
    VeiculoRepository veiculoRepository;

    @Autowired
    VeiculoService veiculoService;

    public ViagemDto criarViagem(ViagemForm form) {

        Viagem viagem = new Viagem();
        viagem.setHorarioSaida(form.getHorarioSaida());
        viagem.setHorarioChegada(form.getHorarioChegada());
        viagem.setOdometroSaida(form.getOdometroSaida());
        viagem.setOdometroChegada(form.getOdometroChegada());
        viagem.setDestino(form.getDestino());
        viagem.setAcidente(form.getAcidente());
        viagem.setMulta(form.getMulta());
        viagem.setUsuario(form.getUsuario());
        viagem.setVeiculo(form.getVeiculo());

        veiculoService.atualizaQuilometragemVeiculo(form.getOdometroChegada(), form.getVeiculo().getId());

        viagem = viagemRepository.save(viagem);

        return toDto(viagem);

    }

    public List<ViagemDto> buscarTodasViagens() {
        List<Viagem> todos = viagemRepository.findAll();
        return listToDto(todos);
    }

    public ViagemDto buscarViagemPorId(Long id) {
        try {
            Optional<Viagem> opt = viagemRepository.findById(id);
            return toDto(opt.get());
        } catch (NoSuchElementException e) {
            throw new ViagemNaoEncontradaException(id);
        }
    }

    public ViagemDto atualizarPorId(ViagemForm form, Long id) {
        try {
            Optional<Viagem> opt = viagemRepository.findById(id);

            Viagem viagem = opt.get();

            viagem.setHorarioSaida(form.getHorarioSaida());
            viagem.setHorarioChegada(form.getHorarioChegada());
            viagem.setOdometroSaida(form.getOdometroSaida());
            viagem.setOdometroChegada(form.getOdometroChegada());
            viagem.setDestino(form.getDestino());
            viagem.setAcidente(form.getAcidente());
            viagem.setMulta(form.getMulta());
            viagem.setUsuario(form.getUsuario());
            viagem.setVeiculo(form.getVeiculo());

            viagemRepository.save(viagem);
            return toDto(viagem);
        } catch (NoSuchElementException e) {
            throw new ViagemNaoEncontradaException(id);
        }
    }

    public void deletarPorId(Long id) {
        if (viagemRepository.existsById(id)) {
            viagemRepository.deleteById(id);
        }
    }

    private ViagemDto toDto(Viagem viagem) {

        ViagemDto dto = new ViagemDto();

        dto.setHorarioSaida(viagem.getHorarioSaida());
        dto.setHorarioChegada(viagem.getHorarioChegada());
        dto.setOdometroSaida(viagem.getOdometroSaida());
        dto.setOdometroChegada(viagem.getOdometroChegada());
        dto.setDestino(viagem.getDestino());
        dto.setAcidente(viagem.getAcidente());
        dto.setMulta(viagem.getMulta());
        dto.setUsuario(viagem.getUsuario());
        dto.setVeiculo(viagem.getVeiculo());
        return dto;
    }

    private static List<ViagemDto> listToDto(List<Viagem> viagems) {
        return viagems.stream().map(ViagemDto::new).collect(Collectors.toList());

    }

}
