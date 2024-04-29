package com.microservices.nft.service.controllers;


import com.microservices.nft.service.entities.Nft;
import com.microservices.nft.service.services.NftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/nft")
public class NftController {

    @Autowired
    private NftService nftService;

    @PostMapping
    public ResponseEntity<Nft> createNft(@RequestBody Nft nft){

        return ResponseEntity.status(HttpStatus.CREATED).body(nftService.create(nft));
    }

    @GetMapping("/{nftId}")
    public ResponseEntity<Nft> getNft(@PathVariable String nftId){
        return ResponseEntity.status(HttpStatus.OK).body(nftService.get(nftId));
    }

    @GetMapping
    public ResponseEntity<List<Nft>> getAll(){
        return ResponseEntity.ok(nftService.getAll());
    }

}
