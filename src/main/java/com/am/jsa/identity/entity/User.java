package com.am.jsa.identity.entity;

import com.am.jsa.common.entity.BaseEntity;
import com.am.jsa.common.entity.EmbeddedName;
import com.am.jsa.metadata.entity.UserType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "USER")
public class User extends BaseEntity {


    @Embedded
    @AttributeOverrides({ @AttributeOverride(name = "firstName", column = @Column(name = "FIRST_NAME")),
            @AttributeOverride(name = "middleName", column = @Column(name = "MIDDLE_NAME")),
            @AttributeOverride(name = "lastName", column = @Column(name = "LAST_NAME")) })
    private EmbeddedName nameEnglish;

    @Column(name = "PASSWORD")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    @Column(name = "ACTIVE")
    private Boolean active;

    @Column(name = "CONTACT_NO")
    private String contactNo;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "USERNAME")
    private String userName;

    @Column(name = "U_ID")
    private String uuId;

    @Column(name = "LOGIN_ATTEMPT")
    private Integer loginAttempt;

    @Column(name = "FIRST_TIME_LOGIN")
    private Boolean firstTimeLogin;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="USER_TYPE")
    private UserType userType;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY, targetEntity = Role.class)
    @JoinTable(name = "USER_ROLE", joinColumns=@JoinColumn(name="USER_ID"),inverseJoinColumns = @JoinColumn(name="ROLE_ID"))
    private Set<Role> roleList;

    @Transient
    @JsonProperty
    private String token;

    @Transient
    private String newPassword;

    public EmbeddedName getNameEnglish() {
        return nameEnglish;
    }

    public void setNameEnglish(EmbeddedName nameEnglish) {
        this.nameEnglish = nameEnglish;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUuId() {
        return uuId;
    }

    public void setUuId(String uuId) {
        this.uuId = uuId;
    }

    public Integer getLoginAttempt() {
        return loginAttempt;
    }

    public void setLoginAttempt(Integer loginAttempt) {
        this.loginAttempt = loginAttempt;
    }

    public Boolean getFirstTimeLogin() {
        return firstTimeLogin;
    }

    public void setFirstTimeLogin(Boolean firstTimeLogin) {
        this.firstTimeLogin = firstTimeLogin;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
    @JsonIgnore
    public Set<Role> getRoleList() {
        return roleList;
    }

    @JsonProperty("roleList")
    public void setRoleList(Set<Role> roleList) {
        this.roleList = roleList;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
}
