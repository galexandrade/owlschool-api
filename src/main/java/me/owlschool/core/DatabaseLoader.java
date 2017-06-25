package me.owlschool.core;

import me.owlschool.model.*;
import me.owlschool.repository.CourseRepository;
import me.owlschool.repository.SchoolRepository;
import me.owlschool.repository.StudentRepository;
import me.owlschool.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

@Component
public class DatabaseLoader implements ApplicationRunner {
    private final CourseRepository courseRepository;
    private final UserRepository userRepository;
    private final SchoolRepository schoolRepository;
    private final StudentRepository studentRepository;

    DateFormat df = new SimpleDateFormat("dd/MM/yyyy");

    @Autowired
    public DatabaseLoader(CourseRepository courseRepository, UserRepository userRepository, SchoolRepository schoolRepository, StudentRepository studentRepository) {
        this.courseRepository = courseRepository;
        this.userRepository = userRepository;
        this.schoolRepository = schoolRepository;
        this.studentRepository = studentRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        List<User> users = Arrays.asList(
                new User("g.alex.andrade@gmail.com", "456", new String[]{"ROLE_ADMIN"}),
                new User("g.juliane.andrade@gmail.com", "123", new String[]{"ROLE_USER"})
        );
        userRepository.save(users);

        List<School> schools = Arrays.asList(
            new School("Escola Adventista Costa e Silva",
                        "12332132132",
                        new Contact("cajcs@adventista.edu.br", "4797745925", "www.escolaadventista.com.br"),
                        new Address("Brazil", "SC", "89824999", "Joinville", "Rua Joaçaba", 1))
        );

        schoolRepository.save(schools);

        List<Parent> parents = Arrays.asList(
                new Parent(
                        new Person("Juliane Rocha Andrade", df.parse("06/07/1984"), Long.parseLong("0759999999"),
                                    new Contact("g.juliane.andrade@gmail.com", "47997755976", null),
                                    new Address("Brazil", "SC", "89814999", "Joinville", "Rua Pavão", 564)),
                        "MOTHER"
                ),
                new Parent(
                        new Person("Alex Pedrero Andrade", df.parse("22/03/1992"), Long.parseLong("07517911996"),
                                    new Contact("g.alex.andrade@gmail.com", "4799745925", null),
                                    new Address("Brazil", "SC", "89814999", "Joinville", "Rua Pavão", 564)),
                        "FATHER"
                )
        );

        List<Student> students = Arrays.asList(
                new Student(
                        new Person("Sarah Lyss Rocha Andrade", df.parse("14/12/2013"), null, null,
                                    new Address("Brazil", "SC", "89814999", "Joinville", "Rua Pavão", 564)),
                        1,
                        parents
                ),
                new Student(
                        new Person("Letícia Emanuelly Rocha Andrade", df.parse("14/12/2007"), null, null,
                                    new Address("Brazil", "SC", "89814999", "Joinville", "Rua Pavão", 564)),
                        1,
                        parents
                )
        );

        studentRepository.save(students);

        String[] templates = {
                "Up and Running with %s",
                "%s for beginners",
                "%s Basics",
                "Under the hood: %s",
                "On the road with %s"
        };

        String[] buzzWords = {
                "Java",
                "Angular",
                "JavaScript",
                "Spring"
        };

        List<Course> bunchOfCourses = new ArrayList<>();
        IntStream.range(0, 100).forEach(i -> {
            String template = templates[i % templates.length];
            String buzzWord = buzzWords[i % buzzWords.length];

            String title = String.format(template, buzzWord);
            Course c = new Course(title, "http://teamtreehouse.com/");
            Review review = new Review((i % 5) + 1, String.format("More %s please", buzzWord));
            review.setReviewer(users.get(i % users.size()));
            c.addReview(review);

            bunchOfCourses.add(c);
        });

        courseRepository.save(bunchOfCourses);
    }
}
