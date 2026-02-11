package com.example.lucasvignolli.bffagendadordetarefas.infrastructure.client;


import com.example.lucasvignolli.bffagendadordetarefas.business.dto.out.EnderecosDTOResponse;
import com.example.lucasvignolli.bffagendadordetarefas.business.dto.out.TelefonesDTOResponse;
import com.example.lucasvignolli.bffagendadordetarefas.business.dto.out.UsuarioDTOResponse;
import com.example.lucasvignolli.bffagendadordetarefas.business.dto.in.EnderecosDTORequest;
import com.example.lucasvignolli.bffagendadordetarefas.business.dto.in.LoginDTORequest;
import com.example.lucasvignolli.bffagendadordetarefas.business.dto.in.TelefonesDTORequest;
import com.example.lucasvignolli.bffagendadordetarefas.business.dto.in.UsuarioDTORequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "usuario", url = "${usuario.url}")
public interface UsuarioClient {


    @PostMapping
    UsuarioDTOResponse salvaUsuario(@RequestBody UsuarioDTORequest usuarioDTO);


    @PostMapping("/login")
    String login(@RequestBody LoginDTORequest usuarioDTO);


    @GetMapping
    UsuarioDTOResponse buscaUsuario(@RequestParam("email") String email,
                                    @RequestHeader(value = "Authorization", required = false) String token);


    @DeleteMapping("/{email}")
    void deletaUsuarioPorEmail(@PathVariable String email,
                               @RequestHeader(value = "Authorization", required = false) String token);


    @PutMapping
    UsuarioDTOResponse atualizaDadosDeUsuario(@RequestBody UsuarioDTORequest dto,
                                              @RequestHeader(value = "Authorization", required = false) String token);


    @PutMapping("/enderecos")
    EnderecosDTOResponse atualizaDadosDeEndereco(@RequestBody EnderecosDTORequest dto,
                                                 @RequestParam("id") Long id,
                                                 @RequestHeader(value = "Authorization", required = false) String token);


    @PutMapping("/telefones")
    TelefonesDTOResponse atualizaDadosDeTelefone(@RequestBody TelefonesDTORequest dto,
                                                 @RequestParam("id") Long id,
                                                 @RequestHeader(value = "Authorization", required = false) String token);


    @PostMapping("/enderecos")
    EnderecosDTOResponse cadastroNovoEndereço(@RequestBody EnderecosDTORequest dto,
                                              @RequestHeader(value = "Authorization", required = false) String token);


    @PostMapping("/telefones")
    TelefonesDTOResponse cadastraNovoTelefone(@RequestBody TelefonesDTORequest dto,
                                              @RequestHeader(value = "Authorization", required = false) String token);
}

