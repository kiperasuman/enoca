package com.example.enoca.controllers;

import com.example.enoca.entities.Sirket;
import com.example.enoca.repository.ISirketRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/sirket")
public class SirketController {
    private ISirketRepository sirketRepository;
    private SirketController(ISirketRepository sirketRepository){
        this.sirketRepository = sirketRepository;
    }
    @GetMapping
    public List<Sirket> getAllSirket(){return sirketRepository.findAll();}

    @GetMapping("/{sirket_id}")
    public Sirket getSirketById(Long sirket_id){return sirketRepository.findById(sirket_id).orElse(null);}

    @PostMapping
    public Sirket saveOneSirket(@RequestBody Sirket yeni_sirket){return sirketRepository.save(yeni_sirket);}

    @PutMapping("/{sirket_id}")
    public Sirket updateCalisanById(@RequestBody Sirket yeni_sirket , @PathVariable Long sirket_id){
        Optional<Sirket> sirket = sirketRepository.findById(sirket_id);
        if(sirket.isPresent()){
            Sirket sirket1 = sirket.get();
            sirket1.setSirket_adi(yeni_sirket.getSirket_adi());
            sirket1.setAciklama(yeni_sirket.getAciklama());
            sirket1.setKonum(yeni_sirket.getKonum());
            sirketRepository.save(yeni_sirket);
            return yeni_sirket;

        }else{
            return null;
        }
    }
    @DeleteMapping("/{sirket_id}")
    public void deleteCalisan(@PathVariable Long sirket_id){
        sirketRepository.deleteById(sirket_id);
    }

}
