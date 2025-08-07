package com.project.cine.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.project.cine.models.UserModel;

@Repository

public interface UserRepository extends CrudRepository<UserModel, Long> {

}