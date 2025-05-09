package com.example.pharmacy.controller;

import com.example.pharmacy.model.Produit;
import com.example.pharmacy.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produits")
public class ProduitController {

    @Autowired
    private ProduitService produitService;

    @PostMapping("/add")
    public Produit ajouterProduit( @RequestBody Produit produit) {
        return produitService.ajouterProduit(produit);
    }

    @GetMapping
    public List<Produit> getProduits() {
        return produitService.getProduits();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produit> getProduitById(@PathVariable Long id) {
        return produitService.getProduitById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

