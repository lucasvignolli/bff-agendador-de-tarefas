package com.example.lucasvignolli.bffagendadordetarefas.infrastructure.client;


import com.example.lucasvignolli.bffagendadordetarefas.business.dto.EnderecosDTO;
import com.example.lucasvignolli.bffagendadordetarefas.business.dto.TelefonesDTO;
import com.example.lucasvignolli.bffagendadordetarefas.business.dto.UsuarioDTO;
import com.example.lucasvignolli.bffagendadordetarefas.business.dto.in.EnderecosDTORequest;
import com.example.lucasvignolli.bffagendadordetarefas.business.dto.in.LoginDTORequest;
import com.example.lucasvignolli.bffagendadordetarefas.business.dto.in.TelefonesDTORequest;
import com.example.lucasvignolli.bffagendadordetarefas.business.dto.in.UsuarioDTORequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "usuario", url = "${usuario.url}")
public interface UsuarioClient {


    @PostMapping
    UsuarioDTO salvaUsuario(@RequestBody UsuarioDTORequest usuarioDTO);


    @PostMapping("/login")
    String login(@RequestBody LoginDTORequest usuarioDTO);


    @GetMapping
    UsuarioDTO buscaUsuario(@RequestParam("email") String email,
                            @RequestHeader("Authorization") String token);


    @DeleteMapping("/{email}")
    void deletaUsuarioPorEmail(@PathVariable String email,
                               @RequestHeader("Authorization") String token);


    @PutMapping
    UsuarioDTO atualizaDadosDeUsuario(@RequestBody UsuarioDTORequest dto,
                                      @RequestHeader("Authorization") String token);


    @PutMapping("/enderecos")
    EnderecosDTO atualizaDadosDeEndereco(@RequestBody EnderecosDTORequest dto,
                                         @RequestParam("id") Long id,
                                         @RequestHeader("Authorization") String token);


    @PutMapping("/telefones")
    TelefonesDTO atualizaDadosDeTelefone(@RequestBody TelefonesDTORequest dto,
                                         @RequestParam("id") Long id,
                                         @RequestHeader("Authorization") String token);


    @PostMapping("/enderecos")
    EnderecosDTO cadastroNovoEndereço(@RequestBody EnderecosDTORequest dto,
                                      @RequestHeader("Authorization") String token);


    @PostMapping("/telefones")
    TelefonesDTO cadastraNovoTelefone(@RequestBody TelefonesDTORequest dto,
                                   @RequestHeader("Authorization") String token);
}

