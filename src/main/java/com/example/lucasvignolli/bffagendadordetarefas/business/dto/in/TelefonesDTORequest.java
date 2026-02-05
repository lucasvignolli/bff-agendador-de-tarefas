package com.example.lucasvignolli.bffagendadordetarefas.business.dto.in;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class TelefonesDTORequest {

    private String ddd;
    private String numero;

}
