package com.example.enoca.entities;
import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name="calisan")
@Data
public class Calisan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long calisan_id;
    String calisan_ad;
    String calisan_soyad;
    String cinsiyet;
    String dogum_tarihi;

    @ManyToOne
    @JoinColumn(name = "sirket_id")
    private Sirket sirket;

}
