package br.com.apiecocoleta.projeto.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "descarte")
public class Descarte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "material", length = 100, nullable = false)
    private String material;

    @Column(name = "quantidade", length = 3, nullable = false)
    private Integer quantidade;

    @Column(name = "localizacao", length = 50, nullable = true)
    private Double localizacao;

    @Column(name = "dono", length = 200, nullable = true)
    private String dono;

    @Column(name = "status", length = 50, nullable = true)
    private String status;

    @Column(name = "registro", length = 50, nullable = true)
    private String registro;

    @Column(name = "foto", columnDefinition = "TEXT", nullable = true)
    private String foto;

    @Column(name = "valor", length = 100, nullable = true)  
    private Float valor;

}
