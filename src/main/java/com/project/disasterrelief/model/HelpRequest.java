package com.project.disasterrelief.model;



import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HelpRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(length = 1000)
    private String description;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt = new Date();

    private String status; // Default status
    private String type;
    private String category;

    private String location;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
