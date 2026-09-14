package com.example.cypher_laptop.repository;

import com.example.cypher_laptop.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(value = "SELECT p FROM Product p WHERE p.status = 'ACTIVE' AND p.brand = :brand",
    countQuery = "SELECT count(p) FROM Product p WHERE p.status = 'ACTIVE' AND p.brand = :brand")
    Page<Product> findActiveBybrand(@Param("brand") String brand, Pageable pageable);

    Page<Product> findAll(Specification<Product> productSpecification, Pageable pageable);
}
