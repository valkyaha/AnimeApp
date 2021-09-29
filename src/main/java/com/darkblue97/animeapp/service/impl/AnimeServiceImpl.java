package com.darkblue97.animeapp.service.impl;

import com.darkblue97.animeapp.dto.AnimeDTO;
import com.darkblue97.animeapp.exceptions.NotFoundException;
import com.darkblue97.animeapp.service.AnimeService;
import com.darkblue97.animeapp.service.DAOInterface;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Component
@Service
public class AnimeServiceImpl implements AnimeService {

    private final DAOInterface<AnimeDTO> daoInterface;

    public AnimeServiceImpl(DAOInterface<AnimeDTO> daoInterface) {
        this.daoInterface = daoInterface;
    }

    @Override
    public AnimeDTO getAnime(UUID uuid) throws NotFoundException {
        return daoInterface.get(uuid);
    }

    @Override
    public Page<AnimeDTO> getAllAnime(Integer pageNo, Integer pageSize, String sortBy) {
        return daoInterface.getAll(pageNo, pageSize, sortBy);
    }

    @Override
    public void saveAnime(AnimeDTO dto) {
        daoInterface.save(dto);
    }

    @Override
    public AnimeDTO updateAnime(AnimeDTO dto) throws NotFoundException {
        return daoInterface.update(dto);
    }
}
