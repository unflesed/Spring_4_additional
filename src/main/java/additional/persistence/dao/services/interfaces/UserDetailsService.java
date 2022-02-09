package additional.persistence.dao.services.interfaces;

import additional.persistence.model.User;

public interface UserDetailsService {
    User findByLogin(String login);
}
