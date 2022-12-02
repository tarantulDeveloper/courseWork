package kg.sklad.services;

import kg.sklad.entities.User;
import kg.sklad.models.Roles;
import kg.sklad.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    UserRepo userRepo;

    @Autowired
    MailSender mailSender;

    @Override
    public boolean registerUser(User user) {
        Optional<User> employee1 = userRepo.findById(user.getUserEmail());
        if(employee1.isPresent()){
            return false;
        }
        user.setActivationCode(UUID.randomUUID().toString());
        user.setRole(Roles.USER);
        user.setUserPassword(getEncodedPassword(user.getUserPassword()));
        user.setEnable(0);



        String message = String.format(
                "Hello, %s! \n" +
                        "Welcome to our system. Visit the link to activate your account: http://localhost:5000/api/user/activation/%s",
                user.getFirstName(),
                user.getActivationCode()
        );
        mailSender.send(user.getUserEmail(),"Activation code",message);

        userRepo.save(user);
        return true;
    }

    @Override
    public String activateUser(String code) {
        User user = userRepo.findByActivationCode(code);
        user.setEnable(1);
        userRepo.save(user);
        return "<h1 style='text-align: center; font-size: 40px; margin-top: 100px; color: green;'>" + "Hello, " + user.getFirstName() +", your account has been activated</h1>";
    }

    public String getEncodedPassword(String password) {
        return passwordEncoder.encode(password);
    }
}
