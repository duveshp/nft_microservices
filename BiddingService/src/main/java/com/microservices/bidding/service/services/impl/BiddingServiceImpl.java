package com.microservices.bidding.service.services.impl;

import com.microservices.bidding.service.repositories.BiddingRep;
import com.microservices.bidding.service.services.BiddingService;
import com.microservices.bidding.service.entities.Bidding;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class BiddingServiceImpl implements BiddingService {

    @Autowired
    private BiddingRep repository;

    @Override
    public Bidding createBid(Bidding bidding) {
        String randomBiddingId= UUID.randomUUID().toString();
        bidding.setBiddingId(randomBiddingId);
        return repository.save(bidding);
    }

    @Override
    public List<Bidding> getAllBiddingReport() {
        return repository.findAll();
    }

    @Override
    public List<Bidding> getBiddingRepoByUserId(String userId) {

        return repository.getBiddingRepoByUserId(userId);
    }

    @Override
    public List<Bidding> getBiddingRepoByNftId(String nftId) {
        return repository.getBiddingRepoByNftId(nftId);
    }
}
