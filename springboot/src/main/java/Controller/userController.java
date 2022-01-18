package Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Repository.UserRepository;

@RestController
@RequestMapping("/users")
public class userController {

  // GET
  // POST
  // PUT
  // DELETE
  // PATCH

  @Autowired
  private UserRepository userRepository;

  @GetMapping("/{id}")
  public Model.user User(@PathVariable("id") Long id) {

    Optional<Model.user> userFind = this.userRepository.findById(id);

    if (userFind.isPresent()) {
      return userFind.get();
    }

    return null;
  }

  @PostMapping("/")
  public Model.user user(@RequestBody Model.user User) {
    return this.userRepository.save(User);

  }

  @GetMapping("/list")
  public List<Model.user> list() {
    return this.userRepository.findAll();
  }

  @GetMapping("/list/{id}")
  public List<Model.user> listMoreThan(@PathVariable("id") Long id) {
    return this.userRepository.findByIdGreaterThan(id);
  }

  @GetMapping("/findByName/{name}")
  public List<Model.user> findByName(@PathVariable("name") String name) {
    return this.userRepository.findByNameIgnoreCase(name);
  }

}