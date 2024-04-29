package com.microservices.user.service.UserService.external_services;


import com.microservices.user.service.UserService.entities.Nft;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "NFTSERVICE")
public interface NftService {

    @GetMapping("/nft/{nftId}")
    Nft getNft(@PathVariable("nftId") String nftId);
}
