package com.example.enoca.repository;

import com.example.enoca.entities.Calisan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICalisanRepository extends JpaRepository<Calisan,Long> {
 // db'ye sorgu atmamızı sağlar
 // find all metodu ile hepsini getirir ,finfById ile id ye göre veri getirir

}
