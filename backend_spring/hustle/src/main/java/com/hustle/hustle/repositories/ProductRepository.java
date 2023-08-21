package com.hustle.hustle.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import com.hustle.hustle.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

    Optional<Product> findByid(Long productID);

    Optional<Product> findByTitle(String title);

    Optional<Product> findByDescription(String description);

    Optional<Product> findByCategory(String category);

    Optional<Product> findByLocation(String location);

    Optional<Product> findByPrice(String price);

    Optional<Product> findByDatePosted(String datePosted);

    Optional<Product> findByDateSold(String dateSold);

    Optional<Product> findByStatus(String status);

    Optional<Product> findByImage(String image);

    Optional<Product> findByUserID(Long userID);

    Optional<List<Product>> findByUsername(String username);

    Optional<Product> findByName(String name);

    Optional<Product> findByEmail(String email);

    Optional<Product> findByPhoneNumber(String phoneNumber);
    
}