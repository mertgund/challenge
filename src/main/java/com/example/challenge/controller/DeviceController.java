package com.example.challenge.controller;

import com.example.challenge.dto.DeviceDto;
import com.example.challenge.entity.Device;
import com.example.challenge.service.DeviceService;
import com.example.challenge.util.result.DataResult;
import com.example.challenge.util.result.Result;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/device")
@RequiredArgsConstructor
public class DeviceController {

    private final DeviceService deviceService;

    @PostMapping("/add")
    public Result add(@RequestBody Device device) {
        return this.deviceService.add(device);
    }


    @GetMapping("/getByBrandAndOsVersion")
    public DataResult<List<Device>> getByBrandAndOsVersion(@RequestParam String brand, String osVersion){
        return this.deviceService.getByBrandAndOsVersion(brand,osVersion);
    }
}
