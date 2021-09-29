package com.darkblue97.animeapp.repository;

import com.darkblue97.animeapp.domain.Anime;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface AnimeRepository extends PagingAndSortingRepository<Anime, UUID> {
}