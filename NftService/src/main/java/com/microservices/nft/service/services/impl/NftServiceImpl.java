package com.microservices.nft.service.services.impl;

import com.microservices.nft.service.entities.Nft;
import com.microservices.nft.service.exception.ResourceNotFoundException;
import com.microservices.nft.service.repositories.NftRepository;
import com.microservices.nft.service.services.NftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class NftServiceImpl implements NftService {

    @Autowired
    private NftRepository nftRepository;
    @Override
    public Nft create(Nft nft) {
        //creates random unique userId
        String randomNftId= UUID.randomUUID().toString();
        nft.setId(randomNftId);
        return nftRepository.save(nft);
    }

    @Override
    public List<Nft> getAll() {
        return nftRepository.findAll();
    }

    @Override
    public Nft get(String id) {
        return nftRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Nft not found by the given id!!"));
    }
}
