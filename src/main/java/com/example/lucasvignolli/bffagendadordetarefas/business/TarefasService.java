package com.example.lucasvignolli.bffagendadordetarefas.business;

import com.example.lucasvignolli.bffagendadordetarefas.business.dto.TarefasDTO;
import com.example.lucasvignolli.bffagendadordetarefas.business.dto.in.TarefasDTORequest;
import com.example.lucasvignolli.bffagendadordetarefas.infrastructure.client.TarefasClient;
import com.example.lucasvignolli.bffagendadordetarefas.infrastructure.enums.StatusNotificacaoEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor

public class TarefasService {

    private final TarefasClient tarefasClient;

    public TarefasDTO gravarTarefa(String token, TarefasDTORequest dto) {
        return tarefasClient.gravarTarefas(dto, token);
    }

    public List<TarefasDTO> buscaDataEvento(LocalDateTime dataInicial, LocalDateTime dataFinal, String token) {
        return tarefasClient.buscaListaDeTarefasPorPeriodo(dataInicial, dataFinal, token);
    }

    public List<TarefasDTO> buscaTarefasPorEmail(String token) {
        return tarefasClient.buscaTarefasPorEmail(token);
    }

    public void deletaTarefaPorId(String id, String token) {
        tarefasClient.deletaTarefaPorId(id, token);
    }

    public TarefasDTO alteraStatus(String id, StatusNotificacaoEnum status, String token) {
        return tarefasClient.alteraStatus(id, status, token);
    }

    public TarefasDTO alteraTarefa(TarefasDTORequest dto, String id, String token){
        return tarefasClient.atualizadaTarefa(dto, id, token);

    }
}