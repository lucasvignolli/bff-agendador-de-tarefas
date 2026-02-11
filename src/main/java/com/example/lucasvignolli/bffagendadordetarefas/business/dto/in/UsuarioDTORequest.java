package com.example.lucasvignolli.bffagendadordetarefas.business.dto.in;


import com.example.lucasvignolli.bffagendadordetarefas.business.dto.out.EnderecosDTOResponse;
import com.example.lucasvignolli.bffagendadordetarefas.business.dto.out.TelefonesDTOResponse;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class UsuarioDTORequest {

    private String nome;
    private String email;
    private String senha;
    private List<EnderecosDTOResponse> enderecos;
    private List<TelefonesDTOResponse> telefones;

}
