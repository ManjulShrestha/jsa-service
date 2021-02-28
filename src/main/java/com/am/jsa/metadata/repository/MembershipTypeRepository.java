package com.am.jsa.metadata.repository;


import com.am.jsa.metadata.entity.MembershipType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MembershipTypeRepository extends JpaRepository<MembershipType, Long> {
    @Query("FROM MembershipType WHERE id = ?1")
    MembershipType read(long id);

}
