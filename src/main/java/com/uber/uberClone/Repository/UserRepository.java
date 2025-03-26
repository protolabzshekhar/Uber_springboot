package com.uber.uberClone.Repository;

import com.uber.uberClone.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User,String> {
    User findByEmail(String email);
    boolean existsByEmail(String email);
}
