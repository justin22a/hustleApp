package com.hustle.hustle.repositories;

import org.springframework.stereotype.Repository;

import com.hustle.hustle.model.Posting;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface PostingRepository extends JpaRepository<Posting, Long>{

    Optional<Posting> findByid(Long postingID);

    Optional<Posting> findByTitle(String title);

    Optional<Posting> findByDescription(String description);

    Optional<Posting> findByCategory(String category);

    Optional<Posting> findByLocation(String location);

    Optional<Posting> findByPrice(String price);

    Optional<Posting> findByDatePosted(String datePosted);

    Optional<Posting> findByDateSold(String dateSold);

    Optional<Posting> findByStatus(String status);

    Optional<Posting> findByImage(String image);

    Optional<Posting> findByUserID(Long userID);

    Optional<List<Posting>> findByUsername(String username);

    Optional<Posting> findByName(String name);

    Optional<Posting> findByEmail(String email);

    Optional<Posting> findByPhoneNumber(String phoneNumber);

}
