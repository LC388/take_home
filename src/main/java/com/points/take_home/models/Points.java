package com.points.take_home.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name="points")
public class Points {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "points_id", nullable = false)
    private Long id;

    private int pointsBalance;

    /* JsonIgnore annotation prevents recursion by not also showing user information when we pull an account */
    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="payer_id", insertable = false, updatable = false)
    private Payer payer;


    @Column(name = "payer_id")
    private long payerId;
}
