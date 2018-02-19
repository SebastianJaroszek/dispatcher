package pl.dominisz;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserDetailsRepository {

    private List<UserDetails> users = new ArrayList<>();

    public UserDetailsRepository() {
        users.add(new UserDetails("asdf", "asdf"));
        users.add(new UserDetails("1234", "qwerty123"));
        users.add(new UserDetails("gdsa", "qazwsx123"));
        users.add(new UserDetails("23ss", "asdfasdf"));
        users.add(new UserDetails("plmkoijn", "rvfgtb"));
    }

    public Optional<UserDetails> findByUsername(String username) {
        return users.stream()
                .filter(user -> user.getName().equals(username))
                .findFirst();
    }

}
