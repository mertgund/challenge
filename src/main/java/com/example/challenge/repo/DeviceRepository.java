package com.example.challenge.repo;


import com.example.challenge.entity.Device;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DeviceRepository extends JpaRepository<Device,Integer> {
    List <Device> getByBrandAndOsVersion(String brand, String osVersion);

    Boolean existsByBrandAndOsVersion(String brand, String osVersion);

    Boolean existsByBrandAndModelAndOsVersion(String brand,String model, String osVersion);
}
