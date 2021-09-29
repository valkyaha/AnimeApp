package com.darkblue97.animeapp.mappers.impl;

import com.darkblue97.animeapp.domain.Anime;
import com.darkblue97.animeapp.dto.AnimeDTO;
import com.darkblue97.animeapp.utils.GenerationUUID;

public class AnimeMapper {

    private AnimeMapper() {

    }

    public static Anime fromDtoToAnime(AnimeDTO destination) {
        return new Anime(
                destination.getId() == null ? GenerationUUID.generate() : destination.getId(),
                destination.getJapaneseName(),
                destination.getQualification(),
                destination.isSeen(),
                destination.isPending(),
                destination.getDateAdded(),
                destination.getDateUpdated(),
                destination.getDateStarted(),
                destination.getDateFinished(),
                destination.getGenres(),
                destination.getStudio()
        );
    }

    public static AnimeDTO fromAnimeToDto(Anime source) {
        return new AnimeDTO(
                source.getId() == null ? GenerationUUID.generate() : source.getId(),
                source.getJapaneseName(),
                source.getQualification(),
                source.isSeen(),
                source.isPending(),
                source.getDateAdded(),
                source.getDateUpdated(),
                source.getDateStarted(),
                source.getDateFinished(),
                source.getStudio(),
                source.getGenres()
        );
    }
}
