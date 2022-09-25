package com.mycompany.studentmanagementapp.conveter;


import com.mycompany.studentmanagementapp.entity.UserEntity;
import com.mycompany.studentmanagementapp.model.UserModal;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {
    public UserEntity convertModelToEntity(UserModal userModal) {
        UserEntity userEntity = new UserEntity();
        userEntity.setEmail(userModal.getEmail());
        userEntity.setFullName(userModal.getFullName());
        userEntity.setMobileNumber(userModal.getMobileNumber());
        userEntity.setPassword(userModal.getPassword());

        return userEntity;
    }
}