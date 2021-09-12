package com.darkblue97.animeapp.mappers;

import com.darkblue97.animeapp.domain.Studio;
import com.darkblue97.animeapp.dto.StudioDTO;
import org.mapstruct.Mapper;

@Mapper
public interface StudioMapper {
    StudioDTO sourceToDestination(Studio source);

    Studio destinationToSource(StudioDTO destination);
}
