package com.darkblue97.animeapp.dto;

import com.darkblue97.animeapp.domain.Genre;
import com.darkblue97.animeapp.domain.Studio;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Getter
@AllArgsConstructor
public class AnimeDTO {
    private UUID id;
    private String japaneseName;
    private Byte qualification;
    private boolean seen;
    private boolean pending;
    private LocalDateTime dateAdded;
    private LocalDateTime dateUpdated;
    private LocalDateTime dateStarted;
    private LocalDateTime dateFinished;
    private Studio studio;
    private Set<Genre> genres;
}
