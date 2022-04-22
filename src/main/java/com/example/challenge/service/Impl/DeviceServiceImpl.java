package com.example.challenge.service.Impl;

import com.example.challenge.dto.DeviceDto;
import com.example.challenge.entity.Device;
import com.example.challenge.repo.DeviceRepository;
import com.example.challenge.service.DeviceService;
import com.example.challenge.util.result.*;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Service
@RequiredArgsConstructor
public class DeviceServiceImpl implements DeviceService {

    private final DeviceRepository deviceRepository;

    @PostConstruct
    public void init(){
        System.out.println("JsonParseException");
    }


    @Override
    public DataResult<List<Device>> getAll() {
        return new SuccessDataResult<List<Device>>(this.deviceRepository.findAll(),"Cihazlar Listelendi");






    }
    @Override
    public Result add(Device device) {
        if(!(device.getOs().toLowerCase().equals("Android") || device.getOs().toLowerCase().equals("IOS")))
            return new ErrorResult("os yalnızca Android veya IOS olabilir");
        if(StringUtils.isBlank(device.getOs()) || StringUtils.isBlank(device.getModel()) || StringUtils.isBlank(device.getBrand()) || StringUtils.isBlank(device.getOsVersion()))
            return new ErrorResult("Brand,model,os,osVersion kısımları boş bırakılamaz.");
        Boolean checkDevices = deviceRepository.existsByBrandAndModelAndOsVersion(device.getBrand(), device.getModel(), device.getOsVersion());
        if (checkDevices)
            return new ErrorResult("Var olan cihaz eklenemez");
        else
            this.deviceRepository.save(device);
        return new SuccessResult("Cihaz Eklendi");
    }



    @Override
    public DataResult<List<Device>> getByBrandAndOsVersion(String brand, String osVersion) {
        Boolean checkRecords = deviceRepository.existsByBrandAndOsVersion(brand, osVersion);
        if(checkRecords)
            return new SuccessDataResult<List<Device>>(this.deviceRepository.getByBrandAndOsVersion(brand,osVersion),"Cihazlar Getirildi");
        else
            return getAll();
    }




    @Override
    public void saveAll(List<Device> devices) {
        deviceRepository.saveAll(devices);
    }

}
