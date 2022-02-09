package com.example.assigment.specification;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ObjectFilter {
    public static final String NAME = "name";
    public static final String DISTRICT_ID = "district_id";

    private String name;
    private int district_id;

}
