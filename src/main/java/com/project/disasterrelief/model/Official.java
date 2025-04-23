package com.project.disasterrelief.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Official {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String designation;

    private String department;

    private String contact;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}

