package com.darkblue97.animeapp.service.impl;

import com.darkblue97.animeapp.domain.Anime;
import com.darkblue97.animeapp.dto.AnimeDTO;
import com.darkblue97.animeapp.exceptions.NotFoundException;
import com.darkblue97.animeapp.mappers.AnimeMapperImpl;
import com.darkblue97.animeapp.repository.AnimeRepository;
import com.darkblue97.animeapp.service.DAOInterface;
import com.darkblue97.animeapp.utils.GenerationUUID;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class DataBaseOperations implements DAOInterface<AnimeDTO> {

    private final AnimeMapperImpl animeMapper = new AnimeMapperImpl();
    private final AnimeRepository animeRepository;

    public DataBaseOperations(AnimeRepository animeRepository) {
        this.animeRepository = animeRepository;
    }

    @Override
    public AnimeDTO get(UUID uuid) throws NotFoundException {
        Optional<Anime> optionalAnime = animeRepository.findById(uuid);

        if (optionalAnime.isEmpty()) {
            throw new NotFoundException("Anime not found");
        }

        return animeMapper.sourceToDestination(optionalAnime.get());
    }

    @Override
    public void save(AnimeDTO objetToSave) {
        Anime anime = animeMapper.destinationToSource(objetToSave);
        anime.setId(GenerationUUID.generate());
        animeRepository.save(anime);
    }

    @Override
    public void delete(AnimeDTO objectToDelete) throws NotFoundException {
        AnimeDTO animeDTO = get(objectToDelete.getId());
        animeRepository.delete(animeMapper.destinationToSource(animeDTO));
    }

    @Override
    public AnimeDTO update(AnimeDTO objectToUpdate) throws NotFoundException {
        Anime anime = animeMapper.destinationToSource(get(objectToUpdate.getId()));

        anime.setDateAdded(objectToUpdate.getDateAdded());
        anime.setDateFinished(objectToUpdate.getDateFinished());
        anime.setDateUpdated(objectToUpdate.getDateUpdated());
        anime.setDateStarted(objectToUpdate.getDateStarted());
        anime.setJapaneseName(objectToUpdate.getJapaneseName());
        anime.setQualification(objectToUpdate.getQualification());
        anime.setStudio(objectToUpdate.getStudio());
        anime.setSeen(objectToUpdate.isSeen());
        anime.setGenres(objectToUpdate.getGenres());
        animeRepository.save(anime);

        return animeMapper.sourceToDestination(anime);
    }
}
