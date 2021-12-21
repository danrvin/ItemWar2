package by.itstep.itemwar.itemwar.dao.repo;

import by.itstep.itemwar.itemwar.dao.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Long> {
    Optional<User>findByEmail(String email);
    //User findByEmail(String email);
    User findByUsername(String username);
    User findUserById(Long id);
}
