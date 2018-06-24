package main.java.com.user_bounded_context.domain_services;

import com.infrastructure.DTOs.UserDTO;
import com.user_bounded_context.repositories.UserRepository;
import com.user_bounded_context.entitites.Customer;
import com.user_bounded_context.entitites.User;
import com.user_bounded_context.value_objects.Email;
import com.user_bounded_context.value_objects.Name;
import com.user_bounded_context.value_objects.Password;
import com.user_bounded_context.value_objects.Surname;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserDomainServiceImpl implements UserDomainService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User register(UserDTO userDTO) {
        Email email = new Email(userDTO.getEmail());
        User user = userRepository.findByEmail(email);

        if(user == null){
            System.out.println(userDTO.getAddress());
            User retval = userRepository.save(new Customer(userDTO.getEmail(),userDTO.getPassword(),
                    userDTO.getName(),userDTO.getSurname(), userDTO.getAddress()));
            return retval;
        }
        return null;
    }


    @Override
    public User login(UserDTO userDTO) {
        Email email = new Email(userDTO.getEmail());
        Password password = new Password(userDTO.getPassword());

        User user2 = userRepository.findByEmail(email);

        User user = userRepository.findByEmailAndPassword(email,password);

        if(user != null){
            if(user.getPassword().getValue().equals(userDTO.getPassword())){
                return user;
            }
        }

        return null;
    }

    @Override
    public User changeName(String email, String name) {
        User user = userRepository.findByEmail(new Email(email));

        if(user == null){
            return null;
        }

        user.setName(new Name(name));
        userRepository.save(user);

        userRepository.flush();
        User retUser = userRepository.findByEmail(new Email(email));


        return retUser;
    }

    @Override
    public User changeSurname(String email, String surname) {
        User user = userRepository.findByEmail(new Email(email));


        if(user == null){
            return null;
        }

        user.setSurname(new Surname(surname));
        userRepository.save(user);

        userRepository.flush();
        User retUser = userRepository.findByEmail(new Email(email));


        return retUser;
    }

    @Override
    public User changeAddress(String email, String address) {
        Customer customer = userRepository.findCustomer(new Email(email));


        if(customer == null){
            return null;
        }

        customer.setAddress(address);
        userRepository.save(customer);

        userRepository.flush();
        User retUser = userRepository.findByEmail(new Email(email));


        return retUser;
    }


}
