package com.touchtech.programa.anime.repositories;

import com.touchtech.programa.anime.models.PlataformaAnimeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PlataformaAnimeRepository extends JpaRepository<PlataformaAnimeModel, UUID> {
    //  validar existencia dos respectivos campos
    boolean existsByNome(String nome);

    boolean existsByNumTemporadas(Integer numTemporadas);

    boolean existsByNumEpsodios(Integer numEpsodios);

    boolean existsByCategoria(String categoria);

    boolean existsByDiaLancamento(String diaLancamento);
}
