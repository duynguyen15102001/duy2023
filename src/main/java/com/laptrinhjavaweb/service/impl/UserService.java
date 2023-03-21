
package com.laptrinhjavaweb.service.impl;

import com.laptrinhjavaweb.constant.SystemConstant;
import com.laptrinhjavaweb.converter.UserConverter;
import com.laptrinhjavaweb.dto.PasswordDTO;
import com.laptrinhjavaweb.dto.UserDTO;
import com.laptrinhjavaweb.entity.RoleEntity;
import com.laptrinhjavaweb.entity.UserEntity;
import com.laptrinhjavaweb.exception.MyException;
import com.laptrinhjavaweb.input.BuildingSearchInput;
import com.laptrinhjavaweb.repository.RoleRepository;
import com.laptrinhjavaweb.repository.UserRepository;

import com.laptrinhjavaweb.response.StaffReponse;
import com.laptrinhjavaweb.service.IUserService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;


    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserConverter userConverter;

    @Override
    public UserDTO findOneByUserNameAndStatus(String name, int status) {
        return userConverter.convertToDto(userRepository.findOneByUserNameAndStatus(name, status));
    }

    @Override
    public List<UserDTO> getUsers(String searchValue, Pageable pageable) {
        Page<UserEntity> users = null;
        if (StringUtils.isNotBlank(searchValue)) {
            users = userRepository.findByUserNameContainingIgnoreCaseOrFullNameContainingIgnoreCaseAndStatusNot(searchValue, searchValue, 0, pageable);
        } else {
            users = userRepository.findByStatusNot(0, pageable);
        }
        List<UserEntity> newsEntities = users.getContent();
        List<UserDTO> result = new ArrayList<>();
        for (UserEntity userEntity : newsEntities) {
            UserDTO userDTO = userConverter.convertToDto(userEntity);
            userDTO.setRoleCode(userEntity.getRoles().get(0).getCode());
            result.add(userDTO);
        }
        return result;
    }

    @Override
    public int getTotalItems(String searchValue) {
        int totalItem = 0;
        if (StringUtils.isNotBlank(searchValue)) {
            totalItem = (int) userRepository.countByUserNameContainingIgnoreCaseOrFullNameContainingIgnoreCaseAndStatusNot(searchValue, searchValue, 0);
        } else {
            totalItem = (int) userRepository.countByStatusNot(0);
        }
        return totalItem;
    }

    @Override
    public UserDTO findOneByUserName(String userName) {
        UserEntity userEntity = userRepository.findOneByUserName(userName);
        UserDTO userDTO = userConverter.convertToDto(userEntity);
        return userDTO;
    }

    @Override
    public UserDTO findUserById(long id) {
        UserEntity entity = userRepository.findById(id).get();
        List<RoleEntity> roles = entity.getRoles();
        UserDTO dto = userConverter.convertToDto(entity);
        roles.forEach(item -> {
            dto.setRoleCode(item.getCode());
        });
        return dto;
    }

    @Override
    @Transactional
    public UserDTO insert(UserDTO newUser) {
        RoleEntity role = roleRepository.findOneByCode(newUser.getRoleCode());
        UserEntity userEntity = userConverter.convertToEntity(newUser);
        userEntity.setRoles(Stream.of(role).collect(Collectors.toList()));
        userEntity.setStatus(1);
        userEntity.setPassword(passwordEncoder.encode(SystemConstant.PASSWORD_DEFAULT));
        return userConverter.convertToDto(userRepository.save(userEntity));
    }

    @Override
    @Transactional
    public UserDTO update(Long id, UserDTO updateUser) {
        RoleEntity role = roleRepository.findOneByCode(updateUser.getRoleCode());
        UserEntity oldUser = userRepository.findById(id).get();
        UserEntity userEntity = userConverter.convertToEntity(updateUser);
        userEntity.setUserName(oldUser.getUserName());
        userEntity.setStatus(oldUser.getStatus());
        userEntity.setRoles(Stream.of(role).collect(Collectors.toList()));
        userEntity.setPassword(oldUser.getPassword());
        return userConverter.convertToDto(userRepository.save(userEntity));
    }

    @Override
    @Transactional
    public void updatePassword(long id, PasswordDTO passwordDTO) throws MyException {
        UserEntity user = userRepository.findById(id).get();
        if (passwordEncoder.matches(passwordDTO.getOldPassword(), user.getPassword())
                && passwordDTO.getNewPassword().equals(passwordDTO.getConfirmPassword())) {
            user.setPassword(passwordEncoder.encode(passwordDTO.getNewPassword()));
            userRepository.save(user);
        } else {
            throw new MyException(SystemConstant.CHANGE_PASSWORD_FAIL);
        }
    }

    @Override
    @Transactional
    public UserDTO resetPassword(long id) {
        UserEntity userEntity = userRepository.findById(id).get();
        userEntity.setPassword(passwordEncoder.encode(SystemConstant.PASSWORD_DEFAULT));
        return userConverter.convertToDto(userRepository.save(userEntity));
    }

    @Override
    @Transactional
    public UserDTO updateProfileOfUser(String username, UserDTO updateUser) {
        UserEntity oldUser = userRepository.findOneByUserName(username);
        oldUser.setFullName(updateUser.getFullName());
        return userConverter.convertToDto(userRepository.save(oldUser));
    }

    @Override
    @Transactional
    public void delete(long[] ids) {
        for (Long item : ids) {
            UserEntity userEntity = userRepository.findById(item).get();
            userEntity.setStatus(0);
            userRepository.save(userEntity);
        }
    }

    @Override
    public List<StaffReponse> findAllManagementStaff(BuildingSearchInput buildingSearchInput) {
        List<StaffReponse> results = new ArrayList<>();
        List<UserEntity> userEntities = userRepository.findByRoles_Code("STAFF");
        for (UserEntity item : userEntities) {
            System.out.println(item.getFullName());

        }
        List<UserEntity> staffAssignBuidling = userRepository.findByBuildings_id(buildingSearchInput.getId());
        List<Long> staffId = new ArrayList<>();
        for (UserEntity item1 : staffAssignBuidling) {
            if (item1 != null) {
                staffId.add(item1.getId());
            } else {
                staffId.add(0L);
            }
        }
        for (UserEntity item : userEntities) {
            StaffReponse staffReponse = new StaffReponse();
            staffReponse = userConverter.convertToResponse(item);
            staffReponse.setStaffId(item.getId());
            /*userDTO.setId(item.getId());
            userDTO.setFullName(item.getFullName());*/
            if (staffId.contains(item.getId())) {
                staffReponse.setChecked("checked");

            } else {
                staffReponse.setChecked("");
            }
            results.add(staffReponse);
        }

        return results;
    }

    @Override
    public List<StaffReponse> findAllCustomerManagementStaff(Long customerId) {
        List<StaffReponse> results = new ArrayList<>();
        List<UserEntity> userEntities = userRepository.findByRoles_Code("STAFF");
        List<UserEntity> staffAssignCustomer = userRepository.findByCustomers_Id(customerId);
        List<Long> staffId = new ArrayList<>();
        for (UserEntity item1 : staffAssignCustomer) {
            if (item1 != null) {
                staffId.add(item1.getId());
            } else {
                staffId.add(0L);
            }
        }
        for (UserEntity item : userEntities) {
            StaffReponse staffReponse = new StaffReponse();
            staffReponse = userConverter.convertToResponse(item);
            staffReponse.setStaffId(item.getId());
            if (staffId.contains(item.getId())) {
                staffReponse.setChecked("checked");

            } else {
                staffReponse.setChecked("");
            }
            results.add(staffReponse);
        }

        return results;
    }


    @Override
    public List<StaffReponse> findAllStaff() {
        List<StaffReponse> results = new ArrayList<>();
        StaffReponse staffReponse = new StaffReponse();
        List<UserEntity> userEntities = userRepository.findAll();
        for (UserEntity item : userEntities) {
            staffReponse.setFullName(item.getFullName());
            staffReponse.setStaffId(item.getId());
            staffReponse.setChecked("checked");


            results.add(staffReponse);
        }

        return results;

    }


    @Override
    public Map<Long, String> getStaffMaps() {
        Map<Long, String> result = new HashMap<>();
        List<UserEntity> staffs = userRepository.findByStatusAndRoles_Code(1, "STAFF");
        for (UserEntity item : staffs) {
            UserDTO userDTO = userConverter.convertToDto(item);
            result.put(userDTO.getId(), userDTO.getFullName());
        }
        return result;
    }


}

