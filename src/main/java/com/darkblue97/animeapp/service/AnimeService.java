package com.darkblue97.animeapp.service;

import com.darkblue97.animeapp.dto.AnimeDTO;
import com.darkblue97.animeapp.exceptions.NotFoundException;
import org.springframework.data.domain.Page;

import java.util.UUID;

public interface AnimeService {
    AnimeDTO getAnime(UUID uuid) throws NotFoundException;

    Page<AnimeDTO> getAllAnime(Integer pageNo, Integer pageSize, String sortBy);

    void saveAnime(AnimeDTO dto);
}
