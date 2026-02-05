package com.example.lucasvignolli.bffagendadordetarefas.business;

import com.example.lucasvignolli.bffagendadordetarefas.business.dto.EnderecosDTO;
import com.example.lucasvignolli.bffagendadordetarefas.business.dto.TelefonesDTO;
import com.example.lucasvignolli.bffagendadordetarefas.business.dto.UsuarioDTO;
import com.example.lucasvignolli.bffagendadordetarefas.business.dto.in.EnderecosDTORequest;
import com.example.lucasvignolli.bffagendadordetarefas.business.dto.in.LoginDTORequest;
import com.example.lucasvignolli.bffagendadordetarefas.business.dto.in.TelefonesDTORequest;
import com.example.lucasvignolli.bffagendadordetarefas.business.dto.in.UsuarioDTORequest;
import com.example.lucasvignolli.bffagendadordetarefas.infrastructure.client.UsuarioClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class UsuarioService {


    private final UsuarioClient usuarioClient;

    public UsuarioDTO salvaUsuario(UsuarioDTORequest usuarioDTO) {
        return usuarioClient.salvaUsuario(usuarioDTO);
    }

    public String loginUsuario(LoginDTORequest loginDTORequest){
        return usuarioClient.login(loginDTORequest);
    }

    public UsuarioDTO buscarUsuarioPorEmail(String email, String token){
        return usuarioClient.buscaUsuario(email, token);
    }

    public void deletaUsuario(String email, String token){
        usuarioClient.deletaUsuarioPorEmail(email, token);
    }

    public UsuarioDTO atualizaDadosUsuario (String token, UsuarioDTORequest dto){
        return usuarioClient.atualizaDadosDeUsuario(dto, token);
    }

    public EnderecosDTO atualizaEndereco(Long idEndereco, EnderecosDTORequest enderecosDTO, String token){
        return usuarioClient.atualizaDadosDeEndereco(enderecosDTO, idEndereco, token);
    }

    public TelefonesDTO atualizaTelefone(Long idTelefone, TelefonesDTORequest telefonesDTO, String token){
        return usuarioClient.atualizaDadosDeTelefone(telefonesDTO, idTelefone, token);
    }

    public EnderecosDTO cadastraEndereco (EnderecosDTORequest enderecosDto, String token){
        return usuarioClient.cadastroNovoEndereço(enderecosDto, token);
    }

    public TelefonesDTO cadastraTelefone(TelefonesDTORequest telefoneDto, String token){
        return usuarioClient.cadastraNovoTelefone(telefoneDto, token);
    }

}

