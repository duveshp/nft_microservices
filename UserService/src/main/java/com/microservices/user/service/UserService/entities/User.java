package com.microservices.user.service.UserService.entities;


import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table (name = "micro_users")
public class User {

    @Id
    @Column (name = "ID")
    private String userId;

    @Column(name = "NAME" )
    private  String name;

    @Column (name = "UserEmail")
    private String email;

    @Column(name = "UserKYC")
    private String kyc;

    @Transient
    private ArrayList<Bidding> bidding = new ArrayList<>();
}
