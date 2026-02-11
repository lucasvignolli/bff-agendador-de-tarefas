package com.example.lucasvignolli.bffagendadordetarefas.business.dto.out;


import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class UsuarioDTOResponse {

    private String nome;
    private String email;
    private String senha;
    private List<EnderecosDTOResponse> enderecos;
    private List<TelefonesDTOResponse> telefones;

}
