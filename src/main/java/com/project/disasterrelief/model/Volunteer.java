package com.project.disasterrelief.model;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Volunteer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String email;
    private String mobileNumber;

    @Enumerated(EnumType.STRING)
    private Role role = Role.VOLUNTEER;

    @OneToMany(mappedBy = "volunteer")
    private List<HelpRequest> helpRequests; // if a volunteer can have multiple help requests
}
