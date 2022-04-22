package com.example.challenge.service;

import com.example.challenge.dto.DeviceDto;
import com.example.challenge.entity.Device;
import com.example.challenge.util.result.DataResult;
import com.example.challenge.util.result.Result;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface DeviceService {

    DataResult<List<Device>> getAll();
    Result add(Device device);

    void saveAll(List<Device> devices);

    DataResult<List<Device>> getByBrandAndOsVersion(String brand, String osVersion);
}
