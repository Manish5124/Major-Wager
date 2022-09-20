package com.cts.userdetails.repository;

import com.cts.userdetails.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long>{
}
