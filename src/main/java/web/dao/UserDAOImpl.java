package web.dao;

import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class UserDAOImpl implements UserDAO {
    @PersistenceContext
    private EntityManager em;

    @Override
    public void save(User user) {
        em.persist(user);
    }

    @Override
    public void update(User user) {
        em.merge(user);
    }

    @Override
    public void delete(long id) {
        User user = findById(id);
        if  (user != null) {
            em.remove(user);
        }
    }

    @Override
    public User findById(long id) {
        return em.find(User.class, id);
    }

    @Override
    public List<User> findAll() {
        return em
                .createQuery("from User", User.class)
                .getResultList();
    }
}
