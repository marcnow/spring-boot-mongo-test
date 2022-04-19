package de.adesso.hellospring.repository;

import de.adesso.hellospring.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User,String> {
}
