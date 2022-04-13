package com.touchtech.programa.anime.dto;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.Date;
//@NotBlank para ver se nao está nulo
//@Size verifica se tem "N" caracteres

public class PlataformaAnimeDto {

//    Fazer as devidas verificações, para ver se os campos nao estao nulos
    @NotBlank
    private String nome;

    @NotBlank
    @Size(min = 2)
    private String anime;
    @NotBlank
    private String categoria;
    @NotBlank
    @Size(max = 5)
    private Integer numEpisodios;
    @NotBlank
    @Size(max = 5)
    private Integer numTemporadas;
    @NotBlank
    private Date dataEstreia;
    @NotNull // valida que o campo nao estara nulo
    private Boolean finalFechado;
    @NotBlank
    private LocalDateTime diaLancamento;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAnime() {
        return anime;
    }

    public void setAnime(String anime) {
        this.anime = anime;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Integer getNumEpsodios() {
        return numEpisodios;
    }

    public void setNumEpisodios(Integer numEpisodios) {
        this.numEpisodios = numEpisodios;
    }

//    public Integer getNumEpisodios() {
//        return numEpisodios;
//    }

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

//    public boolean isFinalFechado() {
//        return finalFechado;
//    }
//
//    public void setFinalFechado(boolean finalFechado) {
//        this.finalFechado = finalFechado;
//    }

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
