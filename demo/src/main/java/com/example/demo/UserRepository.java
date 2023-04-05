package com.example.demo;

import org.springframework.data.repository.CrudRepository;
import com.example.demo.entity.User;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;
// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete
@Repository
public interface UserRepository extends CrudRepository<User, Long> {
}
