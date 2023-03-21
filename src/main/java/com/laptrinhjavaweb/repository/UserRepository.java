package com.laptrinhjavaweb.repository;

import com.laptrinhjavaweb.entity.UserEntity;

import com.laptrinhjavaweb.repository.custom.UserRepositoryCustom;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;
import java.util.Optional;


public interface UserRepository extends UserRepositoryCustom,JpaRepository<UserEntity, Long>{
    UserEntity findOneByUserNameAndStatus(String name, int status);
    Page<UserEntity> findByUserNameContainingIgnoreCaseOrFullNameContainingIgnoreCaseAndStatusNot(String userName, String fullName, int status,
                                                                                          Pageable pageable);
    Page<UserEntity> findByStatusNot(int status, Pageable pageable);
    long countByUserNameContainingIgnoreCaseOrFullNameContainingIgnoreCaseAndStatusNot(String userName, String fullName, int status);
    long countByStatusNot(int status);
    UserEntity findOneByUserName(String userName);

    List<UserEntity> findByStatusAndRoles_Code(Integer status , String roleCode);
    List<UserEntity> findByRoles_Code(String roleCode);
    Optional<UserEntity> findByIdAndRoles_Code(Long id , String roleCode);
    List<UserEntity> findByBuildings_id(Long id);
    List<UserEntity> findByCustomers_Id(Long id);



}
