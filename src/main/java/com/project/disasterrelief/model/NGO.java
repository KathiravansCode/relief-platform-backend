package com.project.disasterrelief.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NGO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String contact;

    private String address;

    // If you want to associate this with a User account
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}
