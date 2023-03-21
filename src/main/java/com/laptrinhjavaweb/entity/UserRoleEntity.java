//
//package com.laptrinhjavaweb.entity;
//
//import javax.persistence.*;
//
//@Entity
//@Table(name = "user_role")
//public class UserRoleEntity extends BaseEntity {
//
//
//    @Column(name = "userid")
//    private Integer userId;
//
//    @ManyToOne
//    @JoinColumn(name = "userid",nullable = false)
//    private UserEntity user;
//
//    @ManyToOne
//    @JoinColumn(name = "userid",nullable = false)
//    private RoleEntity role;
//
//    public Integer getUserId() {
//        return userId;
//    }
//
//    public void setUserId(Integer userId) {
//        this.userId = userId;
//    }
//
//    public UserEntity getUser() {
//        return user;
//    }
//
//    public void setUser(UserEntity user) {
//        this.user = user;
//    }
//
//    public RoleEntity getRole() {
//        return role;
//    }
//
//    public void setRole(RoleEntity role) {
//        this.role = role;
//    }
//}
