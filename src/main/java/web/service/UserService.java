package web.service;

import web.repository.UserDAO;
import web.model.User;

import java.util.List;

public interface UserService {

    public void save(User user);

    public void update(User user);

    public void delete(Long id);

    public User findById(Long id);

    public List<User> findAll();

    public boolean existsById(Long id);
}
