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

/**
 * Seeder class for seeding the development database.
 * Suggested use: change "spring.jpa.hibernate.ddl-auto" in applicaiton.properties file from update to create.
 * Then run the BarkerApplication like normal and if you are connected to the database correctly it will refresh
 * the database with new dummy data provided via faker. If your terminal supports it, the seeding processes should
 * be displayed in purple text.
 */

@Component
public class Seeder implements ApplicationListener<ContextRefreshedEvent> {
    @Autowired
    private UserService us;

    @Autowired
    private ShelterService ss;

    Faker faker = new Faker();

    @EventListener
    public void seed(ContextRefreshedEvent event) {
        System.out.println("\u001B[35m" + "Seeding users_table..." + "\u001B[0m");
        seedUsersTable();
        System.out.println("\u001B[35m" + "Seeding shelter table..." + "\u001B[0m");
        seedShelterUsers();
    }

    /**
     * Method for placing 10 users with preferences into the user_table of the DB
     * All users passwords are "secret" and their emails end in "yahoo" (shelters end in gmail)
     */
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

    /**
     * This method sets the user preferences for the user passed in.
     * Most of the preferences are provided by Faker library except
     * the energy level and the goodWithPreference which is hard coded
     * every so many users.
     * @param user the user whose preferences we wish to set
     */
    private void seedUserPreferences(User user) {
        System.out.println("\u001B[35m" + "Seeding the user's preferences..." + "\u001B[0m");
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

    /**
     * Method that seeds the shelter users. All passwords are secret and all emails end with gmail.
     */
    private void seedShelterUsers() {
        for (int i = 0; i < 4; i++) {
            String userName = faker.company().name();
            String email = (userName + "@gamil.com").replaceAll("\\s+", "");
            String address = faker.address().fullAddress();
            String password = "secret";
            Shelter user = new Shelter(userName, address, email, password);
            System.out.println(user);
            ss.createShelter(user);
        }

    }

    /**
     * Not exactly sure what this method does but don't touch it, we need it for listening for the event.
     * This will run before any of the other methods.
     * @param contextRefreshedEvent
     */
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        System.out.println("\u001B[35m" + "Seeding Database..." + "\u001B[0m");
    }
}
