package com.microservices.bidding.service.services;

import com.microservices.bidding.service.entities.Bidding;

import java.util.List;

public interface BiddingService {
    //create/place Bid
    Bidding createBid(Bidding bidding);

    //get all biddings
    List<Bidding> getAllBiddingReport();

    //get bidding repo by userId
    List<Bidding> getBiddingRepoByUserId(String userId);

    //get bidding repo by nft id
    List<Bidding> getBiddingRepoByNftId(String nftId);


    //TODO: delete,update

}
