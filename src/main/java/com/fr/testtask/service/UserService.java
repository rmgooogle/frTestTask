package com.fr.testtask.service;


import com.fr.testtask.model.User;
import com.fr.testtask.repository.RoleRepo;
import com.fr.testtask.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {


    private final UserRepository userRepository;
    private final RoleRepo roleRepo;

    public UserService(UserRepository userRepository, RoleRepo roleRepo) {
        this.userRepository = userRepository;
        this.roleRepo = roleRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        return userRepository.findByUsername(login);
    }

    public Long saveAnonUser() {
        User user = new User();

        user.setRole(roleRepo.getById(3L));
        user.getRole().getUsers().add(user);
        user.setActive(true);

        userRepository.save(user);
        return user.getId();
    }

}
