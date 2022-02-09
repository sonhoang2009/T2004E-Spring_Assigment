package com.example.assigment.controller;

import com.example.assigment.entity.Street;
import com.example.assigment.repository.StreetRepository;
import com.example.assigment.service.StreetService;
import com.example.assigment.specification.ObjectFilter;
import com.example.assigment.specification.ObjectFilterBuilder;
import com.example.assigment.specification.SearchCriteria;
import com.example.assigment.specification.StreetSpecification;
import com.example.assigment.util.SQLConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/streets")
@CrossOrigin("*")
public class StreetController {

    @Autowired
    StreetService streetService;

    @Autowired
    StreetRepository repository;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Object> findAll(@RequestParam(name = "districtId", defaultValue = "-1") int districtId,
                                          @RequestParam(name = "name", required = false) String name){
        ObjectFilter builder = ObjectFilterBuilder.anObjectFilter()
                .withName(name)
                .withDistrict_id(districtId)
                .build();
        return new ResponseEntity<>(streetService.getAll(builder), HttpStatus.OK);

    }

    @RequestMapping(method = RequestMethod.GET,path = "search/{name}")
    public ResponseEntity<Object> findByName(@PathVariable String name){
        return new ResponseEntity<>(streetService.findByName(name),HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Object> create(@RequestBody Street street){
        return new ResponseEntity<>(streetService.create(street),HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET,path = "{id}")
    public ResponseEntity<Object> detail(@PathVariable int id){
        return new ResponseEntity<>(streetService.findById(id),HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT,path = "{id}")
    public ResponseEntity<Object> update(@PathVariable int id,@RequestBody Street street){
        return new ResponseEntity<>(streetService.update(id,street),HttpStatus.ACCEPTED);
    }

}
