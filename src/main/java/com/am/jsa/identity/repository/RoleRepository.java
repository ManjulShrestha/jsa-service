package com.am.jsa.identity.repository;

import com.am.jsa.identity.entity.Role;
import com.am.jsa.identity.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    @Query("FROM Role WHERE name = ?1")
    List<Role> getRolesByName(String name);

}
