package dev.viel.studentregistration.controller.dto;

import jakarta.validation.constraints.NotBlank;

import java.util.UUID;
public record StudentDto(

        UUID id,

        @NotBlank
        String name,

        @NotBlank
        String course
){}
