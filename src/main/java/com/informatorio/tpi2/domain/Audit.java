package com.informatorio.tpi2.domain;

import java.time.LocalDate;

public abstract class Audit {
    private LocalDate createAt;
    private User createdBy;
    private LocalDate updatedAt;
    private User updatedBy;
}
