package com.am.jsa.identity.repository;

import com.am.jsa.identity.entity.Role;
import com.am.jsa.identity.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("FROM User WHERE userName = ?1 AND password = ?2")
    User validateUser(String userName, String password);

    @Query("FROM User WHERE uuId = ?1")
    User getUserByUUid(Integer uuId);

    @Query("FROM User as user LEFT JOIN FETCH user.roleList WHERE user.id = ?1")
    List<Role> getUserRoles(Integer userId);

    @Query("Select count(entity) FROM User entity where entity.email like ?1")
    int checkIfEmailExists(String email);

    @Query("Select count(entity) FROM User entity where entity.userName like ?1")
    int checkIfUserExists(String username);

    @Query("FROM User WHERE id = ?1")
    User read(long id);

}
