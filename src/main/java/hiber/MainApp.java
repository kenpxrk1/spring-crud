package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);

        Car bmw = new Car("BMW", 5);
        Car vag = new Car("Volkswagen", 8);
        Car audi = new Car("Audi", 4);

        userService.add(new User("User1", "Lastname1", "user1@mail.ru", bmw));
        userService.add(new User("User2", "Lastname2", "user2@mail.ru", audi));
        userService.add(new User("User3", "Lastname3", "user3@mail.ru", vag));

        userService.listUsers()
                .forEach(System.out::println);
        System.out.println(userService.getUserByCar("BMW", 5));

        context.close();
    }
}
