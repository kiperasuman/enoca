package com.example.enoca.entities;

import jakarta.persistence.*;
import lombok.Data;


@Entity

@Table(name="sirket")
@Data
public class Sirket{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long sirket_id;
    String sirket_adi;
    String konum;
    String aciklama;

}