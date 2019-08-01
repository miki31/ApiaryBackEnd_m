package domain.controller;

import domain.exception.UserNotFoundException;
import domain.repository.UserRepository;
import domain.repository.model.Responce;
import domain.repository.model.User;
import domain.repository.repositoryImpl.UserCustomRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserCustomRepositoryImpl customRepository;

    @GetMapping("/all")
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    @PostMapping("/create")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user){
        User alreadyUser = userRepository.findByLoginAndPassAndRemoveDateIsNull(user.getLogin(),user.getPass());
        if (alreadyUser!=null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }else {
            return new ResponseEntity<>(userRepository.save(user),HttpStatus.OK);
        }
    }

    @PostMapping("/delete")
    public ResponseEntity<Responce> deleteUser(@Valid @RequestParam("id") Long id){
        try {
            User alreadyUser = userRepository.findByIdAndRemoveDateIsNull(id);
            if (alreadyUser == null){
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }else {
                alreadyUser.setRemoveDate(LocalDate.now());
                userRepository.save(alreadyUser);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/current")
    public User getUserById(@RequestParam("id") Long userId){
        return userRepository.findById(userId).orElseThrow( ()-> {
            return (new UserNotFoundException(userId, "User not found"));
        });
    }

    @GetMapping("/login")
    public ResponseEntity<Responce> login(@RequestParam("login") String login,
                                          @RequestParam("pass") String pass){
        User user = userRepository.findByLoginAndPassAndRemoveDateIsNull(login,pass);
        if (user!=null){
            return new ResponseEntity<>(HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }



}
