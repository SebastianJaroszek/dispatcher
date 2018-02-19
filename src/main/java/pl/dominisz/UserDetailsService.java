package pl.dominisz;

import java.util.Optional;

public class UserDetailsService {

    UserDetailsRepository userDetailsRepository;

    public UserDetailsService(){
        userDetailsRepository = new UserDetailsRepository();
    }

    public boolean isAuthenticated(String username, String password){
        Optional<UserDetails> user = userDetailsRepository.findByUsername(username);
        return user
                .map(userDetails -> userDetails.getPassword().equals(password))
                .orElse(false);
    }

}
