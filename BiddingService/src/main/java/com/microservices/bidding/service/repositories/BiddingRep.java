package com.microservices.bidding.service.repositories;

import com.microservices.bidding.service.entities.Bidding;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BiddingRep extends JpaRepository<Bidding,String> {

    //custom finder methods
    List<Bidding> getBiddingRepoByUserId(String userId);

    List<Bidding> getBiddingRepoByNftId(String nftId);
}
