package edu.mum.fbsapp.edu.mum.fbsapp.repository;

import edu.mum.fbsapp.edu.mum.fbsapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}