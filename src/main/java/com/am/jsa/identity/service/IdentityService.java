package com.am.jsa.identity.service;

import com.am.jsa.common.SHAHash;
import com.am.jsa.common.constants.ConstantMetadata;
import com.am.jsa.common.exceptions.AuthorizationException;
import com.am.jsa.identity.entity.Role;
import com.am.jsa.identity.entity.User;
import com.am.jsa.identity.repository.RoleRepository;
import com.am.jsa.identity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Component
public class IdentityService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    public  User addUser(User user){
        String roleName= "";
        if(user.getUserType().getId()== ConstantMetadata.USER_TYPE_COMPANY) {
            roleName="access-level-company";
        }else if(user.getUserType().getId()==ConstantMetadata.USER_TYPE_CANDIDATE){
            roleName="access-level-candidate";
        }
        Set<Role> roleSet = new HashSet<>(roleRepository.getRolesByName(roleName));
        user.setPassword(SHAHash.hashPassword(user.getPassword()));
        user.setUuId(UUID.randomUUID().toString());
        user.setRoleList(roleSet);
        user.setActive(false);
        user.setDeleted(false);
        user.setLoginAttempt(0);
        user.setFirstTimeLogin(true);
        userRepository.save(user);
        return user;
    }


    public User activateUser(int uuId){
        User user=userRepository.getUserByUUid(uuId);
        user.setActive(true);
        userRepository.save(user);
        return user;
    }

    public User getUser(Long id) {
        return userRepository.read(id);
    }

    public void updateUser(User user) {
        user.setPassword(SHAHash.hashPassword(user.getPassword()));
        user.setLoginAttempt(0);
        userRepository.save(user);
    }

    public void deleteUser(User user){
        userRepository.delete(user);
    }


    public void changedPassword(User user) throws AuthorizationException {
        User retrievedUser = userRepository.read(user.getId());
        if (retrievedUser != null) {
            if(retrievedUser.getPassword().equals(SHAHash.hashPassword(user.getPassword()))){
                retrievedUser.setPassword(SHAHash.hashPassword(user.getNewPassword()));
                userRepository.save(retrievedUser);
            }else{
                throw new AuthorizationException("Old Password Incorrect");
            }
        } else {
            throw new AuthorizationException("Email does not exists");
        }
    }



    public boolean checkIfUserExists(String username) {
        return userRepository.checkIfUserExists(username)>0;
    }

    public boolean checkIfEmailExists(String email) {
        return userRepository.checkIfEmailExists(email)>0;
    }

   /* public List<Role> getUserRolesAll(Integer userId) {
        return userRepository.getUserRolesAll(userId);
    }*/

    public List<Role> getUserRoles(Long userId) {
        return userRepository.getUserRoles(userId);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

}
