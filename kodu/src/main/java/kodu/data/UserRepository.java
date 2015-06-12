package kodu.data;

import kodu.model.mongo.User;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, String> {
    public User findByUsername(String username);
    public User findByEmail(String email); 
    public User findById(String id);
}
