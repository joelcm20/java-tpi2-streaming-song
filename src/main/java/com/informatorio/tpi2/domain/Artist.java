package com.informatorio.tpi2.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Artist {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @GenericGenerator(name = "UUID")
    private UUID id;

    @Column(nullable = false)
    private String name;
}
