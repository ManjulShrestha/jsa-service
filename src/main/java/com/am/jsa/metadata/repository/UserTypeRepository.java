package com.am.jsa.metadata.repository;

import com.am.jsa.metadata.entity.UserType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserTypeRepository extends JpaRepository<UserType, Long> {

    @Query("FROM UserType WHERE id = ?1")
    UserType read(long id);
}