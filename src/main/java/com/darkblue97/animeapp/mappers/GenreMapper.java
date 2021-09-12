package com.darkblue97.animeapp.mappers;

import com.darkblue97.animeapp.domain.Genre;
import com.darkblue97.animeapp.dto.GenreDTO;
import org.mapstruct.Mapper;

@Mapper
public interface GenreMapper {
    GenreDTO sourceToDestination(Genre source);
    Genre destinationToSource(GenreDTO destination);
}
