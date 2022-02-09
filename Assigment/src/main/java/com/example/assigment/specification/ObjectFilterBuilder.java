package com.example.assigment.specification;

public final class ObjectFilterBuilder {
    private String name;
    private int district_id;

    private ObjectFilterBuilder() {
    }

    public static ObjectFilterBuilder anObjectFilter() {
        return new ObjectFilterBuilder();
    }

    public ObjectFilterBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public ObjectFilterBuilder withDistrict_id(int district_id) {
        this.district_id = district_id;
        return this;
    }

    public ObjectFilter build() {
        ObjectFilter objectFilter = new ObjectFilter();
        objectFilter.setName(name);
        objectFilter.setDistrict_id(district_id);
        return objectFilter;
    }
}
