package com.mycompany.studentmanagementapp.service;


import com.mycompany.studentmanagementapp.exception.BusinessException;
import com.mycompany.studentmanagementapp.model.UserModal;

public interface UserService {
     boolean login(UserModal userModal) throws BusinessException; //throws BusinessException;
      Long register(UserModal userModal) throws BusinessException; //throws BusinessException;
      Long updates(UserModal userModal) throws  BusinessException;
      String getDeleted(Long id) throws  BusinessException;
}
