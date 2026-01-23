package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import web.repository.UserRepository;
import org.springframework.stereotype.Service;
import web.repository.UserRepository;
import web.model.User;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository repo;
    @Autowired
    public UserServiceImpl(UserRepository repo) {
        this.repo = repo;
    }

    @Override
    public void save(User user) {
        repo.save(user);
    }

    @Override
    public void update(User user) {
        repo.update(user);
    }

    @Override
    public void delete(Long id) {
        repo.delete(id);
    }

    @Override
    public User findById(Long id) {
        return repo.findById(id);
    }

    @Override
    public List<User> findAll() {
        return repo.findAll();
    }

    @Override
    public boolean existsById(Long id) { return repo.findById(id) != null; }
}
