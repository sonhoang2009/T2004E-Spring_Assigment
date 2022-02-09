package com.example.assigment.service;

import com.example.assigment.entity.Street;
import com.example.assigment.specification.ObjectFilter;

import java.util.List;

public interface StreetService {
    List<Street> getAll(ObjectFilter objectFilter);
    Street findById(int id);
    Street update(int id, Street street);
    List<Street> findByName(String name);
    Street create(Street street);
    List<Street> findByDistrict_id(int id);
}
