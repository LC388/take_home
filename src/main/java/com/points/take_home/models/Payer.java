package com.points.take_home.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@JsonIgnoreProperties({"id"})
@Table(name="payer")
public class Payer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payer_id", nullable = false)
    private Long id;

    private String payerName;

    /* Joining points and payer with a relationship annotation we can see a user's account when we call them */
    @OneToOne(mappedBy = "payer", cascade = CascadeType.ALL)
    private Points points;


}
