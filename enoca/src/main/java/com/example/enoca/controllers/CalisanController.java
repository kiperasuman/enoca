package com.example.enoca.controllers;

import com.example.enoca.entities.Calisan;
import com.example.enoca.repository.ICalisanRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/calisan")
public class CalisanController {

    private ICalisanRepository calisanRepository;

    private CalisanController(ICalisanRepository calisanRepository){
        this.calisanRepository=calisanRepository;
    }
    @GetMapping
    public List<Calisan> getAllCalisan(){return calisanRepository.findAll();}

    @GetMapping("/{calisan_id}")
    public Calisan getCalisanById( Long calisan_id){return calisanRepository.findById(calisan_id).orElse(null); }
    @PostMapping
    public Calisan saveOneCalisan(@RequestBody Calisan yeni_calisan){return calisanRepository.save(yeni_calisan);}

    @PutMapping("/{calisan_id}")
    public Calisan updateCalisanById(@RequestBody Calisan yeni_calisan,@PathVariable Long calisan_id) {
        Optional<Calisan> calisan = calisanRepository.findById(calisan_id);
        if (calisan.isPresent()) {
            Calisan calisan1 = calisan.get();
            calisan1.setCalisan_ad(yeni_calisan.getCalisan_ad());
            calisan1.setCalisan_soyad(yeni_calisan.getCalisan_soyad());
            calisan1.setCinsiyet(yeni_calisan.getCinsiyet());
            calisan1.setDogum_tarihi(yeni_calisan.getDogum_tarihi());
            calisan1.setSirket(yeni_calisan.getSirket());
            calisanRepository.save(calisan1);
            return calisan1;
        }
        else{
            return null;
        }

    }
    @DeleteMapping("/{calisan_id}")
    public void deleteCalisan(@PathVariable Long calisan_id){
        calisanRepository.deleteById(calisan_id);
    }

}
