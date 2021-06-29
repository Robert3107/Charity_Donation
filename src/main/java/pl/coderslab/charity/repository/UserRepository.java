package pl.coderslab.charity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.coderslab.charity.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT e FROM User e where e.email = ?1 and e.password = ?1")
    User findUserByEmailAndPassword(String email, String password);

    boolean existsByEmail(String email);
}
