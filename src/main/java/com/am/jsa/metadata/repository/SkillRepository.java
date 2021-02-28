package com.am.jsa.metadata.repository;

import com.am.jsa.metadata.entity.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillRepository extends JpaRepository<Skill, Long> {

    @Query("FROM Skill WHERE id = ?1")
    Skill read(long id);
}
