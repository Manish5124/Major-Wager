package com.cts.userdetails.repository;

import com.cts.userdetails.model.Role;
import com.cts.userdetails.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long>{



}
