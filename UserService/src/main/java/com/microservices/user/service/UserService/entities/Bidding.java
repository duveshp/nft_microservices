package com.microservices.user.service.UserService.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Bidding {

    private  String biddingId;
    private  String userId;
    private  String nftId;
    private int bid;
    private String bidStatus;
    private Nft nft;

}
