package com.example.lucasvignolli.bffagendadordetarefas.business.dto.in;


import com.example.lucasvignolli.bffagendadordetarefas.business.dto.EnderecosDTO;
import com.example.lucasvignolli.bffagendadordetarefas.business.dto.TelefonesDTO;
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
    private List<EnderecosDTO> enderecos;
    private List<TelefonesDTO> telefones;

}
