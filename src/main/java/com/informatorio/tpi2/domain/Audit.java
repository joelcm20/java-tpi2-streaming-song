package com.informatorio.tpi2.domain;

import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@MappedSuperclass // clase base para todas las entidades(no crear una tabla para esta clase)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Audit {
    private LocalDate createdAt;
    private String createdBy;
    private LocalDate updatedAt;
    private String updatedBy;
}
