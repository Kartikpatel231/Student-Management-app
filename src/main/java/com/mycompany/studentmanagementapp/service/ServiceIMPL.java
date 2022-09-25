package com.mycompany.studentmanagementapp.service;

import com.mycompany.studentmanagementapp.constant.ErrorType;
import com.mycompany.studentmanagementapp.conveter.UserConverter;
import com.mycompany.studentmanagementapp.entity.UserEntity;
import com.mycompany.studentmanagementapp.exception.BusinessException;
import com.mycompany.studentmanagementapp.exception.ErrorModal;
import com.mycompany.studentmanagementapp.model.UserModal;
import com.mycompany.studentmanagementapp.repository.UserRepository;
import com.mycompany.studentmanagementapp.validation.UserValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServiceIMPL implements UserService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private UserRepository entityRepository;
    @Autowired
    private UserConverter userConverter;
    @Autowired
    private UserValidator userValidator;

    @Override
    public boolean login(UserModal userModal) throws BusinessException {
        logger.debug("Entering method login");

        //list check of email and password
        List<ErrorModal> errorModelList = userValidator.validateRequest(userModal);
        if (!CollectionUtils.isEmpty(errorModelList)) {
            throw new BusinessException(errorModelList);
        }
        boolean result = false;
        UserEntity userEntity = entityRepository.findByEmailAndPassword(userModal.getEmail(), userModal.getPassword());

        if (userEntity == null) {

            List<ErrorModal> errorList = new ArrayList<>();

            ErrorModal errorModal = new ErrorModal();
            errorModal.setCode(ErrorType.AUTH_INVALID_CREDENTIALS.toString());
            errorModal.setMessage("Incorrect email or password");

            errorList.add(errorModal);
            logger.debug("Invalid login attempt");
            throw new BusinessException(errorList);
        } else {
            logger.debug("Login was success");
            result = true;
        }
        logger.debug("Exiting method login");
        return result;
    }

    public Long register(UserModal userModal) throws BusinessException {

        //list check of email and password
        List<ErrorModal> errorModelList = userValidator.validateRequest(userModal);

        if (!CollectionUtils.isEmpty(errorModelList)) {
            throw new BusinessException(errorModelList);
        }
        UserEntity userEntity = userConverter.convertModelToEntity(userModal);
        //check if user already exist
        UserEntity ue = entityRepository.findByEmail(userModal.getEmail());
        if (null != ue) {
            List<ErrorModal> errorList = new ArrayList<>();

            ErrorModal errorModal = new ErrorModal();
            errorModal.setCode(ErrorType.ALREADY_EXIT.toString());
            errorModal.setMessage("User with this email already exist try another email");

            errorList.add(errorModal);
            throw new BusinessException(errorList);

        }
     //   UserAddress userAddress = new UserAddress();
        //userEntity.setUserAddress(userAddress);
       // userAddress.setHouseno(1);
       // addressRepo.save(userAddress);
       // userEntity.setUserAddress(userAddress);
        UserEntity userEntity1 = entityRepository.save(userEntity);
        return userEntity1.getId();
    }

    @Override
    public Long updates(UserModal userModal) throws BusinessException {

        //list check of email and password
        List<ErrorModal> errorModelList = userValidator.validateRequest(userModal);

        if (!CollectionUtils.isEmpty(errorModelList)) {
            throw new BusinessException(errorModelList);
        }
        UserEntity userEntity = userConverter.convertModelToEntity(userModal);
        //check if user already exist
        UserEntity ue = entityRepository.findByEmail(userModal.getEmail());
        if (null != ue) {
            List<ErrorModal> errorList = new ArrayList<>();

            ErrorModal errorModal = new ErrorModal();
            errorModal.setCode(ErrorType.ALREADY_EXIT.toString());
            errorModal.setMessage("User with this email already exist try another email");

            errorList.add(errorModal);
            throw new BusinessException(errorList);

        }

        UserEntity userEntity1 = entityRepository.save(userEntity);
        return userEntity1.getId();

    }

    public String getDeleted(Long id) throws BusinessException {
        UserEntity userEntity=entityRepository.getOne(id);
        entityRepository.delete(userEntity);
        return "deleted Successfull" ;
/*
        //list check of email and password
        List<ErrorModal> errorModelList = userValidator.validateRequest(userModal);

        if (!CollectionUtils.isEmpty(errorModelList)) {
            throw new BusinessException(errorModelList);
        }
        UserEntity userEntity = userConverter.convertModelToEntity(userModal);
        //check if user already exist
        UserEntity ue = entityRepository.findByEmail(userModal.getEmail());
        if (null != ue) {
            List<ErrorModal> errorList = new ArrayList<>();

            ErrorModal errorModal = new ErrorModal();
            errorModal.setCode(ErrorType.ALREADY_EXIT.toString());
            errorModal.setMessage("User with this email already exist try another email");

            errorList.add(errorModal);
            throw new BusinessException(errorList);

        }

        UserEntity userEntity1 = entityRepository.save(userEntity);
        return userEntity1.getId();
        }
*/
    }
}