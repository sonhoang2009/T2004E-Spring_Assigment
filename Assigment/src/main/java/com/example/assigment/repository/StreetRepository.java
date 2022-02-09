package com.example.assigment.repository;

import com.example.assigment.entity.Street;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StreetRepository extends JpaRepository<Street, Integer> , JpaSpecificationExecutor<Street> {
    @Query("select s from Street s where s.name like %:name%")
    List<Street> findByName(String name);

    List<Street> findStreetsByDistrict_id(int id);
}
