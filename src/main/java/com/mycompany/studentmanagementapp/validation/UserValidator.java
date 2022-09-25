package com.mycompany.studentmanagementapp.validation;
import com.mycompany.studentmanagementapp.constant.ErrorType;
import com.mycompany.studentmanagementapp.exception.ErrorModal;
import com.mycompany.studentmanagementapp.model.UserModal;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserValidator {

    public List<ErrorModal> validateRequest(UserModal userModal){

        List<ErrorModal> errorModelList=new ArrayList<>();
        if(null != userModal && userModal.getEmail() == null){
            ErrorModal errorModal=new ErrorModal();
            errorModal.setCode(ErrorType.NOT_EMPTY.toString());
            errorModal.setMessage("Email cannot be empty");
            errorModelList.add(errorModal);
        }
        if(null != userModal && userModal.getPassword()== null){
            ErrorModal errorModal=new ErrorModal();
            errorModal.setCode(ErrorType.NOT_EMPTY.toString());
            errorModal.setMessage("Password cannot be empty");
            errorModelList.add(errorModal);
        }
        return errorModelList;
    }
}
