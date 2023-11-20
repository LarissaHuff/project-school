package com.projectschool.dto;


public record ApiErrorDTO(String message) {
    public ApiErrorDTO(RuntimeException runtimeException){
        this(runtimeException.getMessage());
    }
}
