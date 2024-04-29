package com.microservices.bidding.service.controllers;


import com.microservices.bidding.service.services.BiddingService;
import com.microservices.bidding.service.entities.Bidding;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bidding")
public class BiddingController {

    @Autowired
    private BiddingService biddingService;

    @PostMapping
    public ResponseEntity<Bidding> createBid(@RequestBody Bidding bidding){
        return ResponseEntity.status(HttpStatus.CREATED).body(biddingService.createBid(bidding));
    }

    @GetMapping
    public ResponseEntity<List<Bidding>> getAllBiddingReport(){
        List<Bidding> allBiddings=biddingService.getAllBiddingReport();
        return ResponseEntity.ok(allBiddings);
    }

    @GetMapping ("/users/{userId}")
    public ResponseEntity<List<Bidding>> getAllBiddingReportByUserId(@PathVariable String userId){
        List<Bidding> allBiddingsByUserId=biddingService.getBiddingRepoByUserId(userId);
        return ResponseEntity.ok(allBiddingsByUserId);
    }

    @GetMapping ("/nft/{nftId}")
    public ResponseEntity<List<Bidding>> getAllBiddingReportByNftId(@PathVariable String nftId){
        List<Bidding> allBiddingsByNftId=biddingService.getBiddingRepoByNftId(nftId);
        return ResponseEntity.ok(allBiddingsByNftId);
    }



}
