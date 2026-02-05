package com.example.lucasvignolli.bffagendadordetarefas.business.dto;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class TelefonesDTO {

    private Long id;
    private String ddd;
    private String numero;

}
