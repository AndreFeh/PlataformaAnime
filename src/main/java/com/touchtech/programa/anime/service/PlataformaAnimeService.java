package com.touchtech.programa.anime.service;

import com.touchtech.programa.anime.models.PlataformaAnimeModel;
import com.touchtech.programa.anime.repositories.PlataformaAnimeRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

//Criar Interface DENTRO de Servicos para Gerenciamento de Controlers
@Service
public class PlataformaAnimeService {
    final PlataformaAnimeRepository plataformaAnimeRepository;

    public PlataformaAnimeService(PlataformaAnimeRepository plataformaAnimeRepository) {
        this.plataformaAnimeRepository = plataformaAnimeRepository;
    }

    @Transactional
    public PlataformaAnimeModel save(PlataformaAnimeModel plataformaAnimeModel) {
        return plataformaAnimeRepository.save(plataformaAnimeModel);
    }

    public List<PlataformaAnimeModel> findAll() {
        return plataformaAnimeRepository.findAll();
    }

    public Page<PlataformaAnimeModel> findAll(Pageable pageable) {
        return plataformaAnimeRepository.findAll(pageable);
    }

    public Optional<PlataformaAnimeModel> findById(UUID id) {
        return plataformaAnimeRepository.findById(id);
    }

    public boolean existsByNome(String nome) {
        return plataformaAnimeRepository.existsByNome(nome);
    }

    public boolean existsByNumTemporadas(Integer numTemporadas) {
        return plataformaAnimeRepository.existsByNumTemporadas(numTemporadas);
    }

    public boolean existsByNumEpsodios(Integer numEpsodios) {
        return plataformaAnimeRepository.existsByNumEpsodios(numEpsodios);
    }

    public boolean existsByCategoria(String categoria) {
        return plataformaAnimeRepository.existsByCategoria(categoria);
    }
//
//    public boolean existsByDiaLancamento(LocalDateTime diaLancamento){
//        return plataformaRepository.existsByDiaLancamento(String.valueOf(diaLancamento));
//    }

    @Transactional
    public void delete(PlataformaAnimeModel plataformaAnimeModel) {
        plataformaAnimeRepository.delete(plataformaAnimeModel);
    }
}
