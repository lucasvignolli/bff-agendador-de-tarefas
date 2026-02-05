package com.example.lucasvignolli.bffagendadordetarefas.business.dto.out;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class TelefonesDTOResponse {

    private Long id;
    private String ddd;
    private String numero;

}
