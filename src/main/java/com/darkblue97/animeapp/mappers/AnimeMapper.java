package com.darkblue97.animeapp.mappers;

import com.darkblue97.animeapp.domain.Anime;
import com.darkblue97.animeapp.dto.AnimeDTO;
import org.mapstruct.Mapper;

@Mapper
public interface AnimeMapper {
    AnimeDTO sourceToDestination(Anime source);
    Anime destinationToSource(AnimeDTO destination);
}
