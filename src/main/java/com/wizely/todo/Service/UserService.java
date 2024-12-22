package com.wizely.todo.Service;
import com.wizely.todo.Dto.User.CreateUserDTO;
import com.wizely.todo.Dto.User.ReadUserDTO;
import com.wizely.todo.Dto.User.UpdateUserDTO;
import com.wizely.todo.Entity.User;
import com.wizely.todo.Entity.UserPrincipal;
import com.wizely.todo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user= userRepository.findByUsername(username);

        if (user==null) {
            System.out.println("User 404");
            throw new UsernameNotFoundException("User 404");
        }
        return new UserPrincipal(user);
    }

    public User createUser(CreateUserDTO createUserDTO) {
        User user = createUserDTO.toEntity();
        return userRepository.save(user);
    }

    public List<ReadUserDTO> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map(ReadUserDTO::fromEntity).toList();
    }

    public Optional<ReadUserDTO> getUserById(Integer userId) {
        return userRepository.findById(userId).map(ReadUserDTO::fromEntity);
    }

    public User updateUser(Integer userId, UpdateUserDTO updateUserDTO) {
        User existingUser = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return updateUserDTO.updateEntity(existingUser);
    }

    public void deleteUser(Integer userId) {
        userRepository.deleteById(userId);
    }
}
