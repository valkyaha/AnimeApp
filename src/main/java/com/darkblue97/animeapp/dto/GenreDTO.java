package com.darkblue97.animeapp.dto;

import com.darkblue97.animeapp.domain.Anime;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Set;
import java.util.UUID;

@AllArgsConstructor
@Getter
public class GenreDTO {

    private UUID id;
    private String name;
    private Set<Anime> animeSet;
}
