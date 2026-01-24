package web.service;

import web.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

     void save(User user);

     void delete(Long id);

     Optional<User> findById(Long id);

     List<User> findAll();

}
