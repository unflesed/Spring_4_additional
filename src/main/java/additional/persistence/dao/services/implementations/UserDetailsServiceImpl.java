package additional.persistence.dao.services.implementations;

import additional.persistence.dao.repositories.UserRepository;
import additional.persistence.dao.services.interfaces.UserDetailsService;
import additional.persistence.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private UserRepository userRepository;
    @Override
    public User findByLogin(String login) {
        return userRepository.findByLogin(login);
    }
}
