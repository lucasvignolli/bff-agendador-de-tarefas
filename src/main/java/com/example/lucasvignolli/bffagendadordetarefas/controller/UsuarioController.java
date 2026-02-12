package com.example.lucasvignolli.bffagendadordetarefas.controller;


import com.example.lucasvignolli.bffagendadordetarefas.business.UsuarioService;
import com.example.lucasvignolli.bffagendadordetarefas.business.dto.out.EnderecosDTOResponse;
import com.example.lucasvignolli.bffagendadordetarefas.business.dto.out.TelefonesDTOResponse;
import com.example.lucasvignolli.bffagendadordetarefas.business.dto.out.UsuarioDTOResponse;
import com.example.lucasvignolli.bffagendadordetarefas.business.dto.in.EnderecosDTORequest;
import com.example.lucasvignolli.bffagendadordetarefas.business.dto.in.LoginDTORequest;
import com.example.lucasvignolli.bffagendadordetarefas.business.dto.in.TelefonesDTORequest;
import com.example.lucasvignolli.bffagendadordetarefas.business.dto.in.UsuarioDTORequest;
import com.example.lucasvignolli.bffagendadordetarefas.business.dto.out.ViaCepResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/usuario")
@Tag(name = "Usuário", description = "Cadastro e Login de Usuário")

public class UsuarioController {

    private final UsuarioService usuarioService;

    @PostMapping
    @Operation(summary = "Salva Usuário", description = "Cria um novo Usuário")
    @ApiResponse(responseCode = "200", description = "Usuário salvo com sucesso")
    @ApiResponse(responseCode = "400", description = "Usuário já cadastrado")
    @ApiResponse(responseCode = "409", description = "Usuário já cadastrado")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    public ResponseEntity<UsuarioDTOResponse> salvaUsuario(@RequestBody UsuarioDTORequest usuarioDTO){
        return ResponseEntity.ok(usuarioService.salvaUsuario(usuarioDTO));
    }

    @PostMapping("/login")
    @Operation(summary = "Login de Usuário", description = "Realiza o login de usuário")
    @ApiResponse(responseCode = "200", description = "Usuário logado com sucesso")
    @ApiResponse(responseCode = "401", description = "Credencias invalidas")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    public String login(@RequestBody LoginDTORequest usuarioDTO){
        return usuarioService.loginUsuario(usuarioDTO);
    }

    @GetMapping
    @Operation(summary = "Buscar dados de Usuário por Email", description = "Busca dados de usuário")
    @ApiResponse(responseCode = "200", description = "Usuário encontrado com sucesso")
    @ApiResponse(responseCode = "403", description = "Usuário não encontrado")
    @ApiResponse(responseCode = "401", description = "Credencias invalidas")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    public ResponseEntity<UsuarioDTOResponse> buscaUsuario(@RequestParam("email") String email,
                                                           @RequestHeader(name = "Authorization", required = false) String token){
        return ResponseEntity.ok(usuarioService.buscarUsuarioPorEmail(email, token));
    }

    @DeleteMapping("/{email}")
    @Operation(summary = "Dela usuário", description = "Deleta usário por ID")
    @ApiResponse(responseCode = "200", description = "Usuário deletado com sucesso")
    @ApiResponse(responseCode = "403", description = "Usuário não encontrado")
    @ApiResponse(responseCode = "401", description = "Credencias invalidas")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    public ResponseEntity<Void> deletaUsuarioPorEmail(@PathVariable String email,
                                                      @RequestHeader(name = "Authorization", required = false) String token){
        usuarioService.deletaUsuario(email, token);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    @Operation(summary = "Atualiza dados", description = "Atualizar dados de usuário")
    @ApiResponse(responseCode = "200", description = "Usuário atualizado com sucesso")
    @ApiResponse(responseCode = "403", description = "Usuário não encontrado")
    @ApiResponse(responseCode = "401", description = "Credencias invalidas")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    public ResponseEntity<UsuarioDTOResponse> atualizaDadosDeUsuario(@RequestBody UsuarioDTORequest dto,
                                                                     @RequestHeader(name = "Authorization", required = false) String token){
        return ResponseEntity.ok(usuarioService.atualizaDadosUsuario(token, dto));
    }

    @PutMapping("/enderecos")
    @Operation(summary = "Atualiza Endereço", description = "Atualiza endereço de usuário")
    @ApiResponse(responseCode = "200", description = "Endereço atualizado com sucesso")
    @ApiResponse(responseCode = "403", description = "Usuário não encontrado")
    @ApiResponse(responseCode = "401", description = "Credencias invalidas")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    public ResponseEntity<EnderecosDTOResponse> atualizaDadosDeEndereco(@RequestBody EnderecosDTORequest dto,
                                                                        @RequestParam("id") Long id,
                                                                        @RequestHeader(name = "Authorization", required = false) String token) {
        return ResponseEntity.ok(usuarioService.atualizaEndereco(id, dto, token));
    }

    @PutMapping("/telefones")
    @Operation(summary = "Atualiza Telefone", description = "Atualiza telefone de usuário")
    @ApiResponse(responseCode = "200", description = "Telefone atualizado com sucesso")
    @ApiResponse(responseCode = "403", description = "Usuário não encontrado")
    @ApiResponse(responseCode = "401", description = "Credencias invalidas")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    public ResponseEntity<TelefonesDTOResponse> atualizaDadosDeTelefone(@RequestBody TelefonesDTORequest dto,
                                                                        @RequestParam("id") Long id,
                                                                        @RequestHeader(name = "Authorization", required = false) String token){
    return ResponseEntity.ok(usuarioService.atualizaTelefone(id, dto, token));
    }

    @PostMapping("/enderecos")
    @Operation(summary = "Salva Endereço", description = "Salva endereço de usuário")
    @ApiResponse(responseCode = "200", description = "Endereço salvo com sucesso")
    @ApiResponse(responseCode = "403", description = "Usuário não encontrado")
    @ApiResponse(responseCode = "401", description = "Credencias invalidas")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    public ResponseEntity<EnderecosDTOResponse> cadastroNovoEndereco(@RequestBody EnderecosDTORequest dto,
                                                                     @RequestHeader(name = "Authorization", required = false) String token){
        return ResponseEntity.ok(usuarioService.cadastraEndereco(dto, token));
    }

    @PostMapping("/telefones")
    @Operation(summary = "Salva Telefone", description = "Salva telefone de usuário")
    @ApiResponse(responseCode = "200", description = "Telefone salvo com sucesso")
    @ApiResponse(responseCode = "403", description = "Usuário não encontrado")
    @ApiResponse(responseCode = "401", description = "Credencias invalidas")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    public ResponseEntity<TelefonesDTOResponse> cadastraNovoTelefone(@RequestBody TelefonesDTORequest dto,
                                                                     @RequestHeader(name = "Authorization", required = false) String token){
        return ResponseEntity.ok(usuarioService.cadastraTelefone(dto, token));
    }

    @GetMapping("/endereco/{cep}")
    @Operation(summary = "Buscar Endereco por CEP", description = "Buscar Endereco")
    @ApiResponse(responseCode = "200", description = "Endereço encontrado com sucesso")
    @ApiResponse(responseCode = "400", description = "CEP Invalido")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    public ResponseEntity<ViaCepResponse> buscaEnderecoPorCep(@PathVariable("cep") String cep){
        return ResponseEntity.ok(usuarioService.buscarEnderecoPorCep(cep));
    }

}
