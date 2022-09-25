package com.mycompany.studentmanagementapp.repository;

import com.mycompany.studentmanagementapp.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {
 UserEntity findByEmailAndPassword(String email, String password);
 UserEntity findByEmail(String email);
 UserEntity getOne(Long id);
}
