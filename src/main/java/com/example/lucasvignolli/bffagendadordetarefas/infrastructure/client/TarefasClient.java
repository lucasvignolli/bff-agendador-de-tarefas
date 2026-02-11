package com.example.lucasvignolli.bffagendadordetarefas.infrastructure.client;

import com.example.lucasvignolli.bffagendadordetarefas.business.dto.out.TarefasDTOResponse;
import com.example.lucasvignolli.bffagendadordetarefas.business.dto.in.TarefasDTORequest;
import com.example.lucasvignolli.bffagendadordetarefas.infrastructure.enums.StatusNotificacaoEnum;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@FeignClient(name = "Tarefas", url = "${tarefas.url}")

public interface TarefasClient {

    @PostMapping
    TarefasDTOResponse gravarTarefas(@RequestBody TarefasDTORequest dto,
                                     @RequestHeader(value = "Authorization", required = false) String token);

    @GetMapping("/eventos")
    List<TarefasDTOResponse> buscaListaDeTarefasPorPeriodo(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataInicial,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataFinal,
            @RequestHeader(value = "Authorization", required = false) String token);

    @GetMapping
    List<TarefasDTOResponse> buscaTarefasPorEmail(@RequestHeader(value = "Authorization", required = false) String token);


    @DeleteMapping
    void deletaTarefaPorId(@RequestParam String id,
                           @RequestHeader(value = "Authorization", required = false) String token);

    @PatchMapping
    TarefasDTOResponse alteraStatus (@RequestParam String id,
                                     @RequestParam StatusNotificacaoEnum status,
                                     @RequestHeader(value = "Authorization", required = false) String token);

    @PutMapping
    TarefasDTOResponse atualizadaTarefa(@RequestBody TarefasDTORequest dto,
                                        @RequestParam String id,
                                        @RequestHeader(value = "Authorization", required = false) String token);
}
