package com.am.jsa.metadata.repository;

import com.am.jsa.metadata.entity.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LanguageRepository extends JpaRepository<Language, Long> {

    @Query("FROM Language WHERE id = ?1")
    Language read(long id);
}
