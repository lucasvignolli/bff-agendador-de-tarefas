package com.example.lucasvignolli.bffagendadordetarefas.business;

import com.example.lucasvignolli.bffagendadordetarefas.business.dto.out.EnderecosDTOResponse;
import com.example.lucasvignolli.bffagendadordetarefas.business.dto.out.TelefonesDTOResponse;
import com.example.lucasvignolli.bffagendadordetarefas.business.dto.out.UsuarioDTOResponse;
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

    public UsuarioDTOResponse salvaUsuario(UsuarioDTORequest usuarioDTO) {
        return usuarioClient.salvaUsuario(usuarioDTO);
    }

    public String loginUsuario(LoginDTORequest loginDTORequest){
        return usuarioClient.login(loginDTORequest);
    }

    public UsuarioDTOResponse buscarUsuarioPorEmail(String email, String token){
        return usuarioClient.buscaUsuario(email, token);
    }

    public void deletaUsuario(String email, String token){
        usuarioClient.deletaUsuarioPorEmail(email, token);
    }

    public UsuarioDTOResponse atualizaDadosUsuario (String token, UsuarioDTORequest dto){
        return usuarioClient.atualizaDadosDeUsuario(dto, token);
    }

    public EnderecosDTOResponse atualizaEndereco(Long idEndereco, EnderecosDTORequest enderecosDTO, String token){
        return usuarioClient.atualizaDadosDeEndereco(enderecosDTO, idEndereco, token);
    }

    public TelefonesDTOResponse atualizaTelefone(Long idTelefone, TelefonesDTORequest telefonesDTO, String token){
        return usuarioClient.atualizaDadosDeTelefone(telefonesDTO, idTelefone, token);
    }

    public EnderecosDTOResponse cadastraEndereco (EnderecosDTORequest enderecosDto, String token){
        return usuarioClient.cadastroNovoEndereço(enderecosDto, token);
    }

    public TelefonesDTOResponse cadastraTelefone(TelefonesDTORequest telefoneDto, String token){
        return usuarioClient.cadastraNovoTelefone(telefoneDto, token);
    }

}

