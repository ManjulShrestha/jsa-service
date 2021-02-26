package com.am.jsa.endpoints;

import com.am.jsa.common.SHAHash;
import com.am.jsa.common.constants.UrlConstant;
import com.am.jsa.common.exceptions.AuthorizationException;
import com.am.jsa.identity.controller.AuthenticationService;
import com.am.jsa.identity.controller.IdentityService;
import com.am.jsa.identity.entity.User;
import com.am.jsa.logger.AmLogger;
import com.am.jsa.servicehandler.AmResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(UrlConstant.BASE_SERVICE_URL + UrlConstant.IDENTITY_SERVICE_URL)
public class IdentityController {

    @Autowired
    AuthenticationService authenticationService;

    @Autowired
    IdentityService identityService;

    @PostMapping("authenticate")
    public ResponseEntity authenticate(@RequestBody User user){
        return AmResponse.successResponse(authenticationService.challenge(user));
    }

    @PostMapping("user")
    public ResponseEntity addUser(@RequestBody User user){
        user.setPassword(SHAHash.hashPassword(user.getPassword()));
        return AmResponse.successResponse(identityService.addUser(user));
    }

    @GetMapping("user/{userId}")
    public ResponseEntity getUser(@PathVariable Long userId) {
        AmLogger.info(this.getClass(), "getUser");
        return AmResponse.successResponse(identityService.getUser(userId));
    }

    @GetMapping("user")
    public ResponseEntity getAllUser() {
        AmLogger.info(this.getClass(), "getAllUser");
        return AmResponse.successResponse(identityService.getAllUsers());
    }

    @PutMapping("user")
    public ResponseEntity updateUser(User user) {
        AmLogger.info(this.getClass(), "updateUser");
        identityService.updateUser(user);
        return AmResponse.successResponse("Users details update Successfully.");
    }

    @DeleteMapping("user")
    public ResponseEntity deleteUser(User user) {
        AmLogger.info(this.getClass(), "deleteUser");
        identityService.deleteUser(user);
        return AmResponse.successResponse("User deleted Successfully.");
    }


    @GetMapping("/username-duplication-check")
    public Boolean checkUsernameDuplication(@RequestParam String userName) {
        if (userName.equals(null) | userName.equals("")) {
            return false;
        }
        return identityService.checkIfUserExists(userName);
    }

    @GetMapping("/email-duplication-check")
    public Boolean checkEmailDuplication(@RequestParam  String email) {
        if (email==null || email.equals("")) {
            return false;
        }
        return identityService.checkIfEmailExists(email);
    }

    @GetMapping("{id}/roles")
    public ResponseEntity getRolesByUserId(@PathVariable Integer id) {
        AmLogger.info(this.getClass(), "getRolesByUserId");
        return AmResponse.successResponse(identityService.getUserRoles(id));
    }

    @PutMapping("activate-user")
    public ResponseEntity activateUser(@RequestParam int uuId) {
        AmLogger.info(this.getClass(), "activateUser");
        return AmResponse.successResponse(identityService.activateUser(uuId));
    }

    @PutMapping("change-password")
    public ResponseEntity updateChangedPassword(User user) throws AuthorizationException {
        AmLogger.info(this.getClass(), "updateChangedPassword by User");
        identityService.changedPassword(user);
        return AmResponse.successResponse("User password successfully updated");

    }
}
