package com.cts.jobmodulemicroservices.repository;

import com.cts.jobmodulemicroservices.model.job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface jobRepository extends JpaRepository<job,Long> {



    @Query("from job where status=?1")
    public List<job> findByStatus(String status);


}
