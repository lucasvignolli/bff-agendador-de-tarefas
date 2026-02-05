package com.example.lucasvignolli.bffagendadordetarefas.infrastructure.client;

import com.example.lucasvignolli.bffagendadordetarefas.business.dto.TarefasDTO;
import com.example.lucasvignolli.bffagendadordetarefas.business.dto.in.TarefasDTORequest;
import com.example.lucasvignolli.bffagendadordetarefas.infrastructure.enums.StatusNotificacaoEnum;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@FeignClient(name = "Tarefas", url = "${tarefas.url}")

public interface TarefasClient {

    @PostMapping
    TarefasDTO gravarTarefas(@RequestBody TarefasDTORequest dto,
                             @RequestHeader("Authorization") String token);

    @GetMapping("/eventos")
    List<TarefasDTO> buscaListaDeTarefasPorPeriodo(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataInicial,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataFinal,
            @RequestHeader("Authorization") String token);

    @GetMapping
    List<TarefasDTO> buscaTarefasPorEmail(@RequestHeader("Authorization") String token);


    @DeleteMapping
    void deletaTarefaPorId(@RequestParam String id,
                           @RequestHeader("Authorization") String token);

    @PatchMapping
    TarefasDTO alteraStatus (@RequestParam String id,
                             @RequestParam StatusNotificacaoEnum status,
                             @RequestHeader("Authorization") String token);

    @PutMapping
    TarefasDTO atualizadaTarefa(@RequestBody TarefasDTORequest dto,
                                @RequestParam String id,
                                @RequestHeader("Authorization") String token);
}
