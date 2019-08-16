package asset.manajemen.asset.manajemen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

        String pass = "departemen";

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String chip = passwordEncoder.encode(pass);

        System.out.println("pass = " + chip);
        System.out.println("-----RUNNING-------");
    }

}
