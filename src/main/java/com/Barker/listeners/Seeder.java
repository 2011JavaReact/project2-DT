package com.Barker.listeners;

import com.Barker.dto.UserDto;
import com.Barker.model.Dog;
import com.Barker.model.Shelter;
import com.Barker.model.User;
import com.Barker.service.ShelterService;
import com.Barker.service.UserService;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Seeder implements ApplicationListener<ContextRefreshedEvent> {
    @Autowired
    private UserService us;

    @Autowired
    private ShelterService ss;

    Faker faker = new Faker();

    @EventListener
    public void seed(ContextRefreshedEvent event) {
        System.out.println("Seeding users_table...");
        seedUsersTable();
        System.out.println("Seeding shelter table...");
        seedShelterUsers();
    }

    private void seedUsersTable() {
        for (int i = 0; i < 10; i++) {
            String userName = faker.name().fullName();
            String email = (userName + "@yahoo.com").replaceAll("\\s+", "");
            String password = "secret";
            User user = new User(userName, email, password);
            System.out.println(user);
            us.createUser(user);
            seedUserPreferences(user);
        }
    }

    private void seedUserPreferences(User user) {
        System.out.println("Seeding the user's preferences");
        user = us.getUserByEmail(user.getEmail());
        UserDto dto;
        if (user.getId() < 4) {
            dto = new UserDto(user.getId() , true , faker.dog().breed() , faker.dog().age(),
                    faker.dog().size(), faker.dog().gender(), "any", faker.dog().coatLength() , "Low");

        } else if (user.getId() >= 4 && user.getId() < 7 ) {
            dto = new UserDto(user.getId() , true , faker.dog().breed() , faker.dog().age(),
                    faker.dog().size(), faker.dog().gender(), "Kids", faker.dog().coatLength() , "Medium");
        } else {
            dto = new UserDto(user.getId() , true , faker.dog().breed() , faker.dog().age(),
                    faker.dog().size(), faker.dog().gender(), "Adults Only", faker.dog().coatLength() , "High");
        }
        us.updateUserPreferences(dto);
    }

    private void seedShelterUsers() {
        for (int i = 0; i < 4; i++) {
            String userName = faker.company().name();
            String email = (userName + "@gamil.com").replaceAll("\\s+", "");
            String address = faker.address().fullAddress();
            String password = "secret";
            Shelter user = new Shelter(userName, address, email);
            System.out.println(user);
            ss.createShelter(user);
        }

    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        System.out.println("Testing the event listner");
//        seedUsersTable();
    }
}
