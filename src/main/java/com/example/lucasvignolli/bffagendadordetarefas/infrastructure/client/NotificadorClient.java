package com.example.lucasvignolli.bffagendadordetarefas.infrastructure.client;


import com.example.lucasvignolli.bffagendadordetarefas.business.dto.out.TarefasDTOResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "notificador", url = "${notificador.url}")
public interface NotificadorClient {


    @PostMapping
    void enviaEmail (@RequestBody TarefasDTOResponse dto);
    }

