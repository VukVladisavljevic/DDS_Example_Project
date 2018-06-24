package main.java.com.user_bounded_context.domain_services;

import com.infrastructure.DTOs.UserDTO;
import com.user_bounded_context.entitites.User;
import org.springframework.stereotype.Service;

@Service
public interface UserDomainService {

    User register(UserDTO userDTO);

    User login(UserDTO userDTO);

    public User changeName(String email, String name);

    public User changeSurname(String email, String surname);

    public User changeAddress(String email, String address);


}
