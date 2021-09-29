package com.darkblue97.animeapp.service;

import com.darkblue97.animeapp.exceptions.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public interface DAOInterface<T> {

    T get(UUID objectGet) throws NotFoundException;

    void save(T objetToSave);

    void delete(T objectToDelete) throws NotFoundException;

    T update(T objectToUpdate) throws NotFoundException;
}
