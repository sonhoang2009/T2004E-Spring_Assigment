package com.example.assigment.service;

import com.example.assigment.entity.Street;
import com.example.assigment.repository.StreetRepository;
import com.example.assigment.specification.ObjectFilter;
import com.example.assigment.specification.SearchCriteria;
import com.example.assigment.specification.StreetSpecification;
import com.example.assigment.util.SQLConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class StreetServiceImpl implements StreetService{

    @Autowired
    StreetRepository streetRepository;
    @Override
    public List<Street> getAll(ObjectFilter objectFilter) {
        Specification<Street> spec =Specification.where(null);

        if (objectFilter.getName() != null && objectFilter.getName().length() > 0){
            spec = spec.and(new StreetSpecification(new SearchCriteria(ObjectFilter.NAME, SQLConstant.LIKE,objectFilter.getName())));
        }
        if (objectFilter.getDistrict_id() > 0){
            spec = spec.and(new StreetSpecification(new SearchCriteria(ObjectFilter.DISTRICT_ID, SQLConstant.EQUAL,objectFilter.getDistrict_id())));
        }

        return streetRepository.findAll(spec);
    }

    @Override
    public Street findById(int id) {
        return streetRepository.getById(id);
    }

    @Override
    public Street update(int id, Street street) {
        Street exist = streetRepository.getById(id);
        if (exist == null){
            return null;
        }
        exist.setDescription(street.getDescription());
        exist.setDistrict(street.getDistrict());
        exist.setName(street.getName());
        exist.setStatus(street.getStatus());
        return streetRepository.save(exist);
    }

    @Override
    public List<Street> findByName(String name) {
        return streetRepository.findByName(name);
    }

    @Override
    public Street create(Street street) {
        street.setCreated_at(LocalDate.now());
        return streetRepository.save(street);
    }

    @Override
    public List<Street> findByDistrict_id(int id) {
        return streetRepository.findStreetsByDistrict_id(id);
    }
}
