package pl.dominisz;

public class UserDetailsServiceTest {
    public static void main(String[] args) {
        UserDetailsService service = new UserDetailsService();

        System.out.println(service.isAuthenticated("username1", "password1"));
    }
}
