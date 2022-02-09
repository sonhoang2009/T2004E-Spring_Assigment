package com.example.assigment.service;

import com.example.assigment.entity.District;
import com.example.assigment.repository.DistrictRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DistrictServiceImpl implements DistrictService{

    @Autowired
    DistrictRepository districtRepository;

    @Override
    public List<District> getAll() {
        return districtRepository.findAll();
    }
}
