package com.example.pharmacy.service;

import com.example.pharmacy.model.Produit;
import com.example.pharmacy.repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProduitService {

    @Autowired
    private ProduitRepository produitRepository;

    public Produit ajouterProduit(Produit produit) {
        return produitRepository.save(produit);
    }

    public List<Produit> getProduits() {
        return produitRepository.findAll();
    }


    public Optional<Produit> getProduitById(Long id) {
        return produitRepository.findById(id);
    }

    public Produit updateProduit(Long id, Produit produit) {
        produit.setId(id);
        return produitRepository.save(produit);
    }

    public void deleteProduit(Long id) {
        produitRepository.deleteById(id);
    }
}
