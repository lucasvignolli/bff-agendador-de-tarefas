package com.example.lucasvignolli.bffagendadordetarefas.business;


import com.example.lucasvignolli.bffagendadordetarefas.business.dto.out.TarefasDTOResponse;
import com.example.lucasvignolli.bffagendadordetarefas.infrastructure.client.NotificadorClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class EmailService {

    private final NotificadorClient notificadorClient;

    public void enviaEmail (TarefasDTOResponse dto){
        notificadorClient.enviaEmail(dto);

    }

}
