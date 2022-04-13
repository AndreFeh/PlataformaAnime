package com.touchtech.programa.anime.models;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;


@Entity
@Table(name = "TB_ESPECIFICACOES")
//conversao de objetos Java para Bytes, para conversao no BD
public class PlataformaAnimeModel implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    @Column(nullable = false, unique = true, length = 255)
    private String nome;

    @Column(nullable = false, unique = true, length =11)
    private String categoria;

    @Column(nullable = false, unique = true, length = 10001)
    private String descricao;

    @Column(nullable = false, unique = true, length = 5)
    private Integer numEpsodios;

    @Column(nullable = false, unique = true, length = 3)
    private Integer numTemporadas;

    @Column(nullable = false)
    private Date dataEstreia;

    @Column(nullable = false, unique = true, length = 3)
    private Boolean finalFechado;

    @Column(nullable = false)
    private LocalDateTime diaLancamento;

//    public PlataformaModel() {
//    }

    public PlataformaAnimeModel() {
    }

    public PlataformaAnimeModel(UUID id, String nome, String categoria, String descricao, Integer numEpsodios, Integer numTemporadas, Date dataEstreia, Boolean finalFechado, LocalDateTime diaLancamento) {
        this.id = id;
        this.nome = nome;
        this.categoria = categoria;
        this.descricao = descricao;
        this.numEpsodios = numEpsodios;
        this.numTemporadas = numTemporadas;
        this.dataEstreia = dataEstreia;
        this.finalFechado = finalFechado;
        this.diaLancamento = diaLancamento;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getNumEpsodios() {
        return numEpsodios;
    }

    public void setNumEpsodios(Integer numEpsodios) {
        this.numEpsodios = numEpsodios;
    }

    public Integer getNumTemporadas() {
        return numTemporadas;
    }

    public void setNumTemporadas(Integer numTemporadas) {
        this.numTemporadas = numTemporadas;
    }

    public Date getDataEstreia() {
        return dataEstreia;
    }

    public void setDataEstreia(Date dataEstreia) {
        this.dataEstreia = dataEstreia;
    }

    public Boolean getFinalFechado() {
        return finalFechado;
    }

    public void setFinalFechado(Boolean finalFechado) {
        this.finalFechado = finalFechado;
    }

    public LocalDateTime getDiaLancamento() {
        return diaLancamento;
    }

    public void setDiaLancamento(LocalDateTime diaLancamento) {
        this.diaLancamento = diaLancamento;
    }
}
