package com.mycompany.studentmanagementapp.exception;

import lombok.Data;

@Data
public class ErrorModal {
    private String code;
    private String  message;
}
