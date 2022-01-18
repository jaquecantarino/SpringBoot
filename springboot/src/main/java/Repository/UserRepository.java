package Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import Model.user;

public interface UserRepository extends JpaRepository<user, Long> {

  @Query("SELECT u from User u where u.id > :id")
  public List<user> findAllMoreThan(@Param("id") Long id);

  public List<user> findByIdGreaterThan(Long id);

  public List<user> findByNameIgnoreCase(String name);

}