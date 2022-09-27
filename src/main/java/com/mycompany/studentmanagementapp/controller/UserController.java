package com.mycompany.studentmanagementapp.controller;

import com.mycompany.studentmanagementapp.exception.BusinessException;
import com.mycompany.studentmanagementapp.model.UserModal;
import com.mycompany.studentmanagementapp.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@RequestMapping("/api/v1")
/*@CrossOrigin(origins = "http://localhost:63342",methods={RequestMethod.POST, RequestMethod.GET}
)*/
public class UserController {

    private final Logger logger=LoggerFactory.getLogger(this.getClass());


    @Autowired
    private UserService userService;

    @PostMapping("/users")


    public ResponseEntity<Boolean> login(@RequestBody UserModal userModal) throws BusinessException {

        logger.debug("Entering method login");
        boolean result = userService.login(userModal);
        ResponseEntity<Boolean> responseEntity = new ResponseEntity<>(result, HttpStatus.OK);
        logger.debug("Exiting method login");
        return responseEntity;
    }
   // @CrossOrigin(origins = "http://localhost:63342")
    @PostMapping("/users/register")
    public ResponseEntity<Long> register(@RequestBody UserModal userModal)throws BusinessException {

        Long result = userService.register(userModal);
        ResponseEntity<Long> responseEntity = new ResponseEntity<>(result, HttpStatus.CREATED);
        return responseEntity;
   //     RedirectView redirectView=new RedirectView();
        // redirectView.setUrl("http://localhost:63342/student-management-app/static/home.html?_ijt=pqtjk2v4kj71b204f73g82sds8");
     //   redirectView.setUrl("http://localhost:9000/Student-Management-App");
       // return redirectView;




    }

    @RequestMapping(method = RequestMethod.PUT,value = "/users/register/updates")
    public ResponseEntity<Long> updates(@RequestBody UserModal userModal) throws BusinessException {

        Long result = userService.updates(userModal);
        ResponseEntity<Long> responseEntity = new ResponseEntity<>(result, HttpStatus.CREATED);
        return responseEntity;
    }


    @RequestMapping(method = RequestMethod.DELETE,value = "/users/register/delete/{id}")
    public String getDeleted(@PathVariable Long id)throws BusinessException{
        return userService.getDeleted(id);

    }

}
 /* try {
            boolean result=userService.login(userModal);

                responseEntity=new ResponseEntity<>(result,HttpStatus.OK);

            userService.login(userModal);
        } catch (BusinessException be) {

        }*/