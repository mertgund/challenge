package com.example.challenge.entity;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Table(name = "devices")
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class Device {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "device_id")
    private int id;

    @NotNull
    @Column(length = 50, name = "brand")
    private String brand;

    @NotNull
    @Column(length = 50, name = "model")
    private String model;

    @NotNull
    @Column(length = 50, name = "os")
    private String os;

    @NotNull
    @Column(length = 50, name = "os_version")
    private String osVersion;

}

