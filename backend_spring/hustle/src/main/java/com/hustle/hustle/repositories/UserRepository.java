package com.hustle.hustle.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.hustle.hustle.model.UserProfile;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserProfile, Long> {
    
    Optional<UserProfile> findByUsername(String username);

    public void save(Optional<UserProfile> user);

    Optional<UserProfile> findByid(Long userID);

    Optional<UserProfile> findByEmail(String email);

    Optional<UserProfile> findByPhoneNumber(String phoneNumber);

    Optional<UserProfile> findByUsernameAndPassword(String username, String password);

    Optional<UserProfile> findByEmailAndPassword(String email, String password);

    Optional<UserProfile> findByPhoneNumberAndPassword(String phoneNumber, String password);
    

}