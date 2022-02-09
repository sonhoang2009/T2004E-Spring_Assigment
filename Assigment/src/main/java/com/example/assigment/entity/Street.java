package com.example.assigment.entity;

import com.example.assigment.StreetStatus;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "streets")
public class Street {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private LocalDate created_at;
    private String description;
    private StreetStatus status;

    @Column(name = "district_id")
    private Integer district_id;

    @ManyToOne
    @JoinColumn(name = "district_id",insertable = false,updatable = false)
    private District district;

    public Street(String name, LocalDate created_at, String description, StreetStatus status, Integer district_id) {
        this.name = name;
        this.created_at = created_at;
        this.description = description;
        this.status = status;
        this.district_id = district_id;
    }
}
