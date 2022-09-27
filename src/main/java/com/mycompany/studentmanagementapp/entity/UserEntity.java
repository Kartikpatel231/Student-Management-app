package com.mycompany.studentmanagementapp.entity;

import com.mycompany.studentmanagementapp.enums.Gender;
import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;
import lombok.Data;

import javax.persistence.*;

@Entity(name = "USER_TABLE")
@Data
public class UserEntity {
    @Column(name = "User_Id")
    @Id                             //denotes to primary key
    @GeneratedValue(strategy = GenerationType.AUTO)        //value automatic increment by jpa
    private long id;
    @Column(name="FULL_NAME")
    private String fullName;
    private String  mobileNumber;
    private String email;
    private String password;
    private Gender gender;

}
