package com.microservices.nft.service.services;

import com.microservices.nft.service.entities.Nft;

import java.util.List;

public interface NftService {
    Nft create(Nft nft);
    List<Nft> getAll();
    Nft get(String id);
}