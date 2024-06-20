package tn.capgemini.Emploxi.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import tn.capgemini.Emploxi.entities.User;
import tn.capgemini.Emploxi.repositories.UserRepository;

import java.util.List;
@Service
public class GestionUserImpl{
    @Autowired
    UserRepository repo;

    @Autowired
    private PasswordEncoder passwordEncoder;
    public void createUser(User user) {
        //crypt password
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        //add user
        repo.save(user);
    }


    public boolean login(String username, String password) {
        User user = repo.findByEmail(username);
        if (user != null && passwordEncoder.matches(password, user.getPassword())) {
            // Successful login
            return true;
        }
        return false;
    }


    public User getUserById(long id) {
        return repo.findById(id).orElse(null);
    }

    public User getUserByEmail(String email) {
        return repo.findByEmail(email);
    }


    public boolean resetPassword(long userId, String newPassword) {
        User user = repo.findById(userId).orElse(null);
        if (user != null) {
            String encodedPassword = passwordEncoder.encode(newPassword);
            user.setPassword(encodedPassword);
            repo.save(user);
            return true;
        }
        return false;
    }


    public void deleteUser(long usedId){
        if(repo.findById(usedId).isPresent()){
            repo.delete(getUserById(usedId));
        }
    }


    public boolean modifyUser(long userId, User user) {
        return false;
    }

    public List<User> getAllUsers() {
        return repo.findAll();
    }
}
