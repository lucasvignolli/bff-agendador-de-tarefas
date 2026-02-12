package com.example.lucasvignolli.bffagendadordetarefas.infrastructure.exceptions;

public class UnauthorizedExceptions extends RuntimeException {

    public UnauthorizedExceptions(String mensagem){
        super(mensagem);
    }

    public UnauthorizedExceptions(String mensagem, Throwable throwable){
        super(mensagem, throwable);
    }
}
