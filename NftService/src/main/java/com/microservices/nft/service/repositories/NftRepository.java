package com.microservices.nft.service.repositories;

import com.microservices.nft.service.entities.Nft;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NftRepository extends JpaRepository<Nft,String> {

}
