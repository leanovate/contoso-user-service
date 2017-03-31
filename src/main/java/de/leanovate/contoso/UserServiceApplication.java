package de.leanovate.contoso;

import java.io.IOException;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.integration.annotation.ServiceActivator;

@SpringBootApplication
@EnableBinding(Sink.class)
public class UserServiceApplication {

    UserStore userStore = new UserStore();
    ObjectMapper objectMapper = new ObjectMapper();

    public static void main(String[] args) {
        SpringApplication.run(UserServiceApplication.class, args);
    }

    @ServiceActivator(inputChannel=Sink.INPUT)
    public void onMessage(String message) throws IOException {
        System.out.println(message);

        final User user = objectMapper.readValue(message, User.class);
        userStore.addUser(user);

        System.out.println("Known users: " + userStore);
    }

}
