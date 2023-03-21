

package com.laptrinhjavaweb.service;

import com.laptrinhjavaweb.dto.PasswordDTO;
import com.laptrinhjavaweb.dto.UserDTO;
import com.laptrinhjavaweb.exception.MyException;
import com.laptrinhjavaweb.input.BuildingSearchInput;
import com.laptrinhjavaweb.response.StaffReponse;
import org.springframework.data.domain.Pageable;
import java.util.Map;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    UserDTO findOneByUserNameAndStatus(String name, int status);
    List<UserDTO> getUsers(String searchValue, Pageable pageable);
    int getTotalItems(String searchValue);
    UserDTO findOneByUserName(String userName);
    UserDTO findUserById(long id);
    UserDTO insert(UserDTO userDTO);
    UserDTO update(Long id, UserDTO userDTO);
    void updatePassword(long id, PasswordDTO userDTO) throws MyException;
    UserDTO resetPassword(long id);
    UserDTO updateProfileOfUser(String id, UserDTO userDTO);
    void delete(long[] ids);
    List<StaffReponse> findAllManagementStaff(BuildingSearchInput buildingSearchInput
    );

    List<StaffReponse> findAllCustomerManagementStaff(Long customerId
    );
    List<StaffReponse> findAllStaff();
    Map<Long,String> getStaffMaps();

}


