package com.touchtech.programa.anime.controller;

import com.touchtech.programa.anime.dto.PlataformaAnimeDto;
import com.touchtech.programa.anime.models.PlataformaAnimeModel;
import com.touchtech.programa.anime.service.PlataformaAnimeService;

import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.time.ZoneId;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)//Compartilha Informações de outros dominios na HTTP
@RequestMapping("/home")
public class PlataformaAnimeController {

    final PlataformaAnimeService plataformaAnimeService;

    public PlataformaAnimeController(PlataformaAnimeService plataformaAnimeService) {
        this.plataformaAnimeService = plataformaAnimeService;
    }

//  Post
    @PostMapping
    public ResponseEntity<Object> savePlataforma(@RequestBody @Valid PlataformaAnimeDto plataformaAnimeDto){
        if(plataformaAnimeService.existsByNome(plataformaAnimeDto.getNome())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: Esse nome já está em uso!");
        }
        if(plataformaAnimeService.existsByNumTemporadas(plataformaAnimeDto.getNumTemporadas())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: Temporada já cadastrada!");
        }
        if(plataformaAnimeService.existsByNumEpsodios(plataformaAnimeDto.getNumEpsodios())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: Esse epsódio já foi adicionado!");
        }
        if(plataformaAnimeService.existsByCategoria(plataformaAnimeDto.getCategoria())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: Categoria já inclusa!");
        }

        PlataformaAnimeModel plataformaAnimeModel = new PlataformaAnimeModel();
        BeanUtils.copyProperties(plataformaAnimeDto, plataformaAnimeModel);
        plataformaAnimeModel.setDiaLancamento(LocalDateTime.now(ZoneId.of("UTC")));
        return ResponseEntity.status(HttpStatus.CREATED).body(plataformaAnimeService.save(plataformaAnimeModel));
    }
//-------------------------------------------------------------
//  Método Get
//        Para Configuração de Paginação, insert depois de getAll... >>> @Pageable
@GetMapping
public ResponseEntity<Page<PlataformaAnimeModel>> getAllPlataformaAnime(@PageableDefault
                (page = 0,size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
    return ResponseEntity.status(HttpStatus.OK).body(plataformaAnimeService.findAll(pageable));
}

    @GetMapping("/{id}")
//  Se tiver cadastrado Ok! senão NOT FOUND
    public ResponseEntity<Object> getOnePlataformaAnime(@PathVariable(value = "id") UUID id) {
        Optional<PlataformaAnimeModel> plataformaAnimeModelOptional = plataformaAnimeService.findById(id);
        if (!plataformaAnimeModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Anime not found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(plataformaAnimeModelOptional.get());
    }

    //  Método Del
    @DeleteMapping("/{id}")
//  Vai procurar o Id a ser verificado
//  Procurar se esse ID existe!
    public ResponseEntity<Object> deletePlataformaAnime(@PathVariable(value = "id") UUID id) {
        Optional<PlataformaAnimeModel> plataformaAnimeModelOptional = plataformaAnimeService.findById(id);
        if (!plataformaAnimeModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Anime Not Found!");
        }
        plataformaAnimeService.delete(plataformaAnimeModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Anime Delete Suscessfully!");
    }

    @PutMapping("/{id}")
//    Converter plataformaDTO para plataformaMODEL
    public ResponseEntity<Object> updatePlataformaAnime(@PathVariable(value = "id") UUID id, @RequestBody @Valid PlataformaAnimeDto plataformaAnimeDto) {
        Optional<PlataformaAnimeModel> plataformaAnimeModelOptional = plataformaAnimeService.findById(id);
        if (!plataformaAnimeModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Anime Not Found!");
        }
//  Método Put >>> 2 Maneiras de FZR
//  1° Set em todos os campos, exceto ID e DATA
//        ParkingSpotModel parkingSpotModel = parkingSpotModelOptional.get();
//        parkingSpotModel.setParkingSpotNumber(parkingSpotDto.getParkingSpotNumber());
//        parkingSpotModel.setLicensePlateCar(parkingSpotDto.getLicensePlateCar());
//        parkingSpotModel.setBrandCar(parkingSpotDto.getBrandCar());
//        parkingSpotModel.setModelCar(parkingSpotDto.getModelCar());
//        parkingSpotModel.setColorCar(parkingSpotDto.getColorCar());
//        parkingSpotModel.setResponsibleName(parkingSpotDto.getResponsibleName());
//        parkingSpotModel.setApartment(parkingSpotDto.getApartment());
//        parkingSpotModel.setBlock(parkingSpotDto.getBlock());
//        return ResponseEntity.status(HttpStatus.OK).body(parkingSpotService.save(parkingSpotModel));
//    }
//  2° Set em ID e DATA, para permanecer os mesmos Campos
        PlataformaAnimeModel plataformaAnimeModel = new PlataformaAnimeModel();
        BeanUtils.copyProperties(plataformaAnimeDto, plataformaAnimeModel);
        plataformaAnimeModel.setId(plataformaAnimeModelOptional.get().getId());
        plataformaAnimeModel.setDiaLancamento(plataformaAnimeModelOptional.get().getDiaLancamento());
        return ResponseEntity.status(HttpStatus.OK).body(plataformaAnimeService.save(plataformaAnimeModel));
    }

}