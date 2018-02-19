package pl.dominisz;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserDetailsRepository {

    private List<UserDetails> users = new ArrayList<>();

    public UserDetailsRepository() {
        users.add(new UserDetails("username1", "password1"));
        users.add(new UserDetails("username2", "password2"));
        users.add(new UserDetails("username3", "password3"));
        users.add(new UserDetails("username4", "password4"));
        users.add(new UserDetails("username5", "password5"));
    }

    public Optional<UserDetails> findByUsername(String username) {
        return users.stream()
                .filter(user -> user.getName().equals(username))
                .findFirst();
    }

}
