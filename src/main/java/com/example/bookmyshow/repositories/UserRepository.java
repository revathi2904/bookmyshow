package com.example.bookmyshow.repositories;

import com.example.bookmyshow.models.User;
import jakarta.persistence.OneToMany;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Override
    Optional<User> findById(Long userID);
    Optional<User> findByEmail(String email);

    @Override
    User save(User user);
}


