package com.tcc.gerenciadorfrotas.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcc.gerenciadorfrotas.exception.UsuarioNaoEncontradoException;
import com.tcc.gerenciadorfrotas.model.dto.UsuarioDto;
import com.tcc.gerenciadorfrotas.model.entity.Usuario;
import com.tcc.gerenciadorfrotas.model.form.UsuarioForm;
import com.tcc.gerenciadorfrotas.repository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    public UsuarioDto criarUsuario(UsuarioForm form) {

        Usuario usuario = new Usuario();
        usuario.setNome(form.getNome());
        usuario.setEmail(form.getNome());
        usuario.setCpf(form.getCpf());
        usuario.setCnh(form.getCnh());
        usuario.setTipoCnh(form.getTipoCnh());

        usuario = usuarioRepository.save(usuario);
        return toDto(usuario);

    }

    public List<UsuarioDto> buscarTodosUsuario() {
        List<Usuario> todos = usuarioRepository.findAll();
        return listToDto(todos);
    }

    public UsuarioDto buscarUsuarioPorId(Long id) {
        try {
            Optional<Usuario> opt = usuarioRepository.findById(id);
            return toDto(opt.get());
        } catch (NoSuchElementException e) {
            throw new UsuarioNaoEncontradoException(id);
        }
    }

    public UsuarioDto atualizarPorId(UsuarioForm form, Long id) {
        try {
            Optional<Usuario> opt = usuarioRepository.findById(id);

            Usuario usuario = opt.get();

            usuario.setNome(form.getNome());
            usuario.setEmail(form.getNome());
            usuario.setCpf(form.getCpf());
            usuario.setCnh(form.getCnh());
            usuario.setTipoCnh(form.getTipoCnh());

            usuarioRepository.save(usuario);
            return toDto(usuario);
        } catch (NoSuchElementException e) {
            throw new UsuarioNaoEncontradoException(id);
        }
    }

    public void deletarPorId(Long id) {
        if (usuarioRepository.existsById(id)) {
            usuarioRepository.deleteById(id);
        }
    }

    private UsuarioDto toDto(Usuario usuario) {

        UsuarioDto dto = new UsuarioDto();

        dto.setId(usuario.getId());
        dto.setNome(usuario.getNome());
        dto.setCpf(usuario.getCpf());
        dto.setCnh(usuario.getCnh());
        dto.setTipoCnh(usuario.getTipoCnh());
        return dto;
    }

    private static List<UsuarioDto> listToDto(List<Usuario> usuarios) {
        return usuarios.stream().map(UsuarioDto::new).collect(Collectors.toList());

    }

}
