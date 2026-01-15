package web.service;

import web.dao.UserDAO;
import web.dao.UserDAOImpl;
import org.springframework.stereotype.Service;
import web.model.User;

import java.util.List;

@Service
public class UserService {

    private UserDAO userDAO = new UserDAOImpl();

    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public void save(User user) {
        userDAO.save(user);
    }

    public void update(User user) {
        userDAO.update(user);
    }

    public void delete(Long id) {
        userDAO.delete(id);
    }

    public User findById(Long id) {
        return userDAO.findById(id);
    }

    public List<User> findAll() {
        return userDAO.findAll();
    }

    public boolean existsById(Long id) { return userDAO.findById(id) != null; }
}
