package web.service;

import org.springframework.transaction.annotation.Transactional;
import web.repository.UserRepository;
import org.springframework.stereotype.Service;
import web.model.User;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository repo;
    public UserServiceImpl(UserRepository repo) {
        this.repo = repo;
    }

    @Override
    public void save(User user) {
        repo.save(user);
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }

    @Override
    public Optional<User> findById(Long id) {
        return repo.findById(id);
    }

    @Override
    public List<User> findAll() {
        return repo.findAll();
    }


}
