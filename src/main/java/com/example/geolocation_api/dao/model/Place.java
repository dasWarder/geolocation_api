package com.example.geolocation_api.dao.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "place")
public class Place {

    @Id
    @Column(name = "id")
    private String id;
    @Column
    private String name;
    @Column
    private String address;
    @Column
    private Float lat;
    @Column
    private Float lng;
}
