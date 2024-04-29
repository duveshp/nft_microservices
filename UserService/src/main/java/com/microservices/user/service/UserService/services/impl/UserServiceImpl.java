package com.microservices.user.service.UserService.services.impl;

import com.microservices.user.service.UserService.UserRepository;
import com.microservices.user.service.UserService.entities.Bidding;
import com.microservices.user.service.UserService.entities.Nft;
import com.microservices.user.service.UserService.entities.User;
import com.microservices.user.service.UserService.exceptions.ResourceNotFoundException;
import com.microservices.user.service.UserService.external_services.NftService;
import com.microservices.user.service.UserService.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    private String biddingByUsersUrl="";

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private NftService nftService;

    private Logger logger=LoggerFactory.getLogger(UserService.class);



    @Override
    public User saveUser(User user) {

        //creates random unique userId
        String randomUserId=UUID.randomUUID().toString();
        user.setUserId(randomUserId);
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUser() {

        List<User> users=userRepository.findAll();

        for (User user: users){
            ArrayList<Bidding> bidding=getBiddingByUserId(user,user.getUserId());
//            bidding.forEach(bid->{
//                Nft nft= restTemplate.getForObject("http://localhost:8082/nft/"+bid.getNftId(), Nft.class);
//                System.out.println(nft);
//                logger.info("{}",nft);
//                bid.setNft(nft);
//
//            });
            for (Bidding bid: bidding){
//                Nft nft= restTemplate.getForObject("http://NFTSERVICE/nft/"+bid.getNftId(), Nft.class);
                Nft nft= nftService.getNft(bid.getNftId());
                bid.setNft(nft);
            }
            user.setBidding(bidding);
        }

        return users;
    }

    @Override
    public User getUser(String userId) {
        //get user from db w the help of userRepo
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found with given id :" + userId + "!!!"));
        //get biddings of above user from BIDDING SERVICE
        //http://localhost:8083/bidding/users/772c82a2-dbbe-4b89-9132-e2952725a71a
        ArrayList<Bidding> bidding = getBiddingByUserId(user,user.getUserId());
//        System.out.println("here it is... "+forObject);
        logger.info("{}",bidding);
        bidding.forEach(bid->{
//            Nft nft= restTemplate.getForObject("http://NFTSERVICE/nft/"+bid.getNftId(), Nft.class);
            Nft nft= nftService.getNft(bid.getNftId());
            System.out.println(nft);
            logger.info("{}",nft);
            bid.setNft(nft);

        });
//        for(Bidding bid:bidding){
//            Nft nftByBid= restTemplate.getForObject("http://localhost:8082/nft/19e57c58-d595-4c64-9273-871827468dd1",Nft.class);
//
//            logger.info("{}",nftByBid);
//            bid.setNft(nftByBid);
//        }
        user.setBidding(bidding);


        return user;
    }

    public ArrayList<Bidding> getBiddingByUserId(User user, String userId) {
        ResponseEntity<List<Bidding>> response = restTemplate.exchange(
                "http://BIDDINGSERVICE/bidding/users/" + userId,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Bidding>>() {});
        return (ArrayList<Bidding>) response.getBody();
    }

//    public Nft getNftDetailsForBid(ArrayList<Bidding> bidding,String nftId){
//        ArrayList<Bidding> bidding= bidding;
//        bidding.forEach(bid->{
//            Nft nft= restTemplate.getForObject("http://localhost:8082/nft/"+bid.getNftId(), Nft.class);
//            System.out.println(nft);
//            logger.info("{}",nft);
//            bid.setNft(nft);
//
//        });
//
//    }
}
