package com.microservices.bidding.service.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table (name = "biddingTracker")
public class Bidding {

    @Id
    @Column(name = "BidId")
    private  String biddingId;
    @Column (name = "userId")
    private  String userId;
    @Column (name = "nftId")
    private  String nftId;
    @Column (name = "bidAmount")
    private int bid;
    @Column (name = "bidStatus")
    private String bidStatus;
}
