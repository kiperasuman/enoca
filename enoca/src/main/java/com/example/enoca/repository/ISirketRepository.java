package com.example.enoca.repository;

import com.example.enoca.entities.Sirket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISirketRepository extends JpaRepository<Sirket, Long> {
    void deleteById(Long sirketId);
}
