package com.example.cypher_laptop.repository.specifications;

import com.example.cypher_laptop.entity.Product;
import jakarta.persistence.criteria.Expression;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ProductSpecification {

    public static Specification<Product> filterProducts(String name, String brand, BigDecimal minPrice, BigDecimal maxPrice) {
        return ((root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (StringUtils.hasText(name)) {
                Expression<String> productName =
                        criteriaBuilder.function(
                                "unaccent",
                                String.class,
                                root.get("name")
                        );
                predicates.add(criteriaBuilder.like(criteriaBuilder.lower(productName), "%" + name.toLowerCase()+ "%"));
            }

            if (StringUtils.hasText(brand)) {
                predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("brand")), "%" + brand.toLowerCase()+ "%"));
            }

            if (maxPrice != null) {
                predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("price"), maxPrice));
            }

            if (minPrice != null) {
                predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("price"), minPrice));
            }

            return criteriaBuilder.and(predicates.toArray(predicates.toArray(new Predicate[0])));
        });
    }
}
