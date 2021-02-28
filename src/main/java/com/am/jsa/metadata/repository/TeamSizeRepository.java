package com.am.jsa.metadata.repository;
import com.am.jsa.metadata.entity.TeamSize;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamSizeRepository extends JpaRepository<TeamSize, Long> {

    @Query("FROM TeamSize WHERE id = ?1")
    TeamSize read(long id);
}
