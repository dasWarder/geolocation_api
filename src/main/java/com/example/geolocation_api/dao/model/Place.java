package com.example.geolocation_api.dao.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "location")
public class Place {

    @Id
    @Column(name = "id")
    private String id;

    @Column
    private String name;

    @Column
    private String address;

    @Column
    private Double lat;

    @Column
    private Double lng;
}
