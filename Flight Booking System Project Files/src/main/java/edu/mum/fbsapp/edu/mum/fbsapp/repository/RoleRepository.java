package edu.mum.fbsapp.edu.mum.fbsapp.repository;

import edu.mum.fbsapp.edu.mum.fbsapp.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role findByRole(String role);

}
