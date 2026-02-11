package com.example.lucasvignolli.bffagendadordetarefas.controller;

import com.example.lucasvignolli.bffagendadordetarefas.business.TarefasService;
import com.example.lucasvignolli.bffagendadordetarefas.business.dto.out.TarefasDTOResponse;
import com.example.lucasvignolli.bffagendadordetarefas.business.dto.in.TarefasDTORequest;
import com.example.lucasvignolli.bffagendadordetarefas.infrastructure.enums.StatusNotificacaoEnum;
import com.example.lucasvignolli.bffagendadordetarefas.infrastructure.security.SecurityConfig;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/tarefas")
@RequiredArgsConstructor
@Tag(name = "Agendador de Tarefas", description = "Grava, Busca, Atualiza e Deleta Tarefas")
@SecurityRequirement(name = SecurityConfig.SECURITY_SCHEME)
public class TarefasController {

    private final TarefasService tarefasService;

    @PostMapping
    @Operation(summary = "Salva tarefas de usuário", description = "Cria uma nova tarefa")
    @ApiResponse(responseCode = "200", description = "Tarefa salva com sucesso")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    public ResponseEntity<TarefasDTOResponse> gravarTarefas(@RequestBody TarefasDTORequest dto,
                                                            @RequestHeader(value = "Authorization", required = false) String token){
        return ResponseEntity.ok(tarefasService.gravarTarefa(token, dto));
    }

    @GetMapping("/eventos")
    @Operation(summary = "Busca lista tarefas de usuário", description = "Busca lista de tarefas por período")
    @ApiResponse(responseCode = "200", description = "Tarefas encontradas com sucesso")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    @ApiResponse(responseCode = "401", description = "Usuário não autorizado")
    public ResponseEntity<List<TarefasDTOResponse>> buscaListaDeTarefasPorPeriodo(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataInicial,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataFinal,
            @RequestHeader(value = "Authorization", required = false) String token){
        return ResponseEntity.ok(tarefasService.buscaTarefaAgendadasPorPeriodo(dataInicial, dataFinal, token));
    }

    @GetMapping
    @Operation(summary = "Busca lista tarefas de usuário por email", description = "Busca lista de tarefas por email")
    @ApiResponse(responseCode = "200", description = "Tarefas encontradas com sucesso")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    @ApiResponse(responseCode = "403", description = "Email não encontrado")
    @ApiResponse(responseCode = "401", description = "Usuário não autorizado")
    public ResponseEntity<List<TarefasDTOResponse>> buscaTarefasPorEmail(@RequestHeader(name = "Authorization", required = false) String token){
        return ResponseEntity.ok(tarefasService.buscaTarefasPorEmail(token));
    }

    @DeleteMapping
    @Operation(summary = "Deleta tarefas de usuário por ID", description = "Deleta tarefa por ID")
    @ApiResponse(responseCode = "200", description = "Tarefa deletada com sucesso.")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    @ApiResponse(responseCode = "403", description = "Tarefa ID não encontrada")
    @ApiResponse(responseCode = "401", description = "Usuário não autorizado")
    public ResponseEntity<Void> deletaTarefaPorId(@RequestParam String id,
                                                  @RequestHeader(name = "Authorization", required = false) String token){
        tarefasService.deletaTarefaPorId(id, token);
        return ResponseEntity.ok().build();
    }

    @PatchMapping
    @Operation(summary = "Altera status da tarefa", description = "Altera status da tarefa")
    @ApiResponse(responseCode = "200", description = "Status alterado com sucesso.")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    @ApiResponse(responseCode = "403", description = "Tarefa ID não encontrada")
    @ApiResponse(responseCode = "401", description = "Usuário não autorizado")
    public ResponseEntity<TarefasDTOResponse> alteraStatus (@RequestParam String id,
                                                            @RequestParam StatusNotificacaoEnum status,
                                                            @RequestHeader(name = "Authorization", required = false) String token){
        return ResponseEntity.ok(tarefasService.alteraStatus(id, status, token));
    }

    @PutMapping
    @Operation(summary = "Altera dados das tarefsa", description = "Altera dados das tarefas")
    @ApiResponse(responseCode = "200", description = "Dados da tarefa alterado com sucesso.")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    @ApiResponse(responseCode = "403", description = "Tarefa ID não encontrada")
    @ApiResponse(responseCode = "401", description = "Usuário não autorizado")
    public ResponseEntity<TarefasDTOResponse> atualizadaTarefa(@RequestBody TarefasDTORequest dto,
                                                               @RequestParam String id,
                                                               @RequestHeader(name = "Authorization", required = false) String token){
        return ResponseEntity.ok(tarefasService.alteraTarefa(dto, id, token));
    }
}
