package com.example.assigment.specification;

import com.example.assigment.entity.Street;
import com.example.assigment.util.SQLConstant;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class StreetSpecification implements Specification<Street> {
    private SearchCriteria criteria;

    public StreetSpecification(SearchCriteria criteria){
        this.criteria =criteria;
    }

    @Override
    public Predicate toPredicate(Root<Street> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
        if (criteria.getOperation().equalsIgnoreCase(SQLConstant.GREATER_THAN_OR_EQUAL_TO)) {
            return builder.greaterThanOrEqualTo(
                    root.<String> get(criteria.getKey()), criteria.getValue().toString());
        }
        else if (criteria.getOperation().equalsIgnoreCase(SQLConstant.LESS_THAN_OR_EQUAL_TO)) {
            return builder.lessThanOrEqualTo(
                    root.<String> get(criteria.getKey()), criteria.getValue().toString());
        }
        else if (criteria.getOperation().equalsIgnoreCase(SQLConstant.LIKE)) {
            if (root.get(criteria.getKey()).getJavaType() == String.class) {
                return builder.like(
                        root.<String>get(criteria.getKey()), "%" + criteria.getValue() + "%");
            } else {
                return builder.equal(root.get(criteria.getKey()), criteria.getValue());
            }
        }else if (criteria.getOperation().equalsIgnoreCase(SQLConstant.EQUAL)){
            return builder.equal(
                    root.<String>get(criteria.getKey()), criteria.getValue() );
        }
        return null;
    }
}
