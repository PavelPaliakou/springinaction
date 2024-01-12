package sia.tacocloud.tacos.security;

import org.springframework.security.crypto.password.PasswordEncoder;
import sia.tacocloud.tacos.User;

public class RegistrationForm {
    private String username;
    private String password;
    private String fullName;
    private String street;
    private String city;
    private String state;
    private String zip;
    private String phoneNumber;

    public User toUser(PasswordEncoder passwordEncoder) {
        return new User(username, password, fullName, state, city, state, zip, phoneNumber);
    }
}
