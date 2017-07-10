package me.owlschool.core;

import me.owlschool.model.*;
import me.owlschool.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Component
public class DatabaseLoader implements ApplicationRunner {
    private final CourseRepository courseRepository;
    private final UserRepository userRepository;
    private final SchoolRepository schoolRepository;
    private final StudentRepository studentRepository;
    private final StaffRepository staffRepository;
    private final TeacherRepository teacherRepository;
    private final ClassRoomRepository classRoomRepository;

    DateFormat df = new SimpleDateFormat("dd/MM/yyyy");

    @Autowired
    public DatabaseLoader(CourseRepository courseRepository, UserRepository userRepository, SchoolRepository schoolRepository, StudentRepository studentRepository, StaffRepository staffRepository, TeacherRepository teacherRepository, ClassRoomRepository classRoomRepository) {
        this.courseRepository = courseRepository;
        this.userRepository = userRepository;
        this.schoolRepository = schoolRepository;
        this.studentRepository = studentRepository;
        this.staffRepository = staffRepository;
        this.teacherRepository = teacherRepository;
        this.classRoomRepository = classRoomRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        //*************** LOAD SCHOOL ***************************************
        List<School> schools = Arrays.asList(
                new School("Escola Adventista Costa e Silva",
                        "12332132132",
                        new Contact("cajcs@adventista.edu.br", "4797745925", "www.escolaadventista.com.br"),
                        new Address("Brazil", "SC", "89824999", "Joinville", "Rua Joaçaba", 1))
        );

        schoolRepository.save(schools);

        //*************** LOAD USERS ***************************************
        List<User> users = Arrays.asList(
                new User("g.alex.andrade@gmail.com", "456789", new String[]{"ROLE_ADMIN"}, schools.get(0)),
                new User("g.juliane.andrade@gmail.com", "123456", new String[]{"ROLE_USER"}, schools.get(0))
        );
        userRepository.save(users);



        //*************** LOAD STUDENTS ***************************************
        List<Parent> parents = Arrays.asList(
                new Parent(
                        new Person("Juliane", "R. Andrade", df.parse("06/07/1984"), Long.parseLong("0759999999"), "Nasta",
                                    new Contact("g.juliane.andrade@gmail.com", "47997755976", null),
                                    new Address("Brazil", "SC", "89814999", "Joinville", "Rua Pavão", 564)),
                        "MOTHER"
                ),
                new Parent(
                        new Person("Alex Andrade", "P. Andrade", df.parse("22/03/1992"), Long.parseLong("07517911996"), "Andrey",
                                    new Contact("g.alex.andrade@gmail.com", "4799745925", null),
                                    new Address("Brazil", "SC", "89814999", "Joinville", "Rua Pavão", 564)),
                        "FATHER"
                )
        );

        List<Student> students = Arrays.asList(
                new Student(
                        new Person("Sarah Lyss", "R. Andrade", df.parse("14/12/2013"), null, "img1.jpg", null,
                                    new Address("Brazil", "SC", "89814999", "Joinville", "Rua Pavão", 564)),
                        null,
                        parents
                ),
                new Student(
                        new Person("Letícia", "R. Andrade", df.parse("14/12/2007"), null, "img1.jpg", null,
                                    new Address("Brazil", "SC", "89814999", "Joinville", "Rua Pavão", 564)),
                        null,
                        parents
                )
        );

        studentRepository.save(students);

        //*************** LOAD STAFFS ***************************************
        Staff staffJuliane = new Staff();
        staffJuliane.setPerson(new Person("Juliane", "R. Andrade", df.parse("06/07/1984"), Long.parseLong("0759999999"), "img1.jpg",
                        new Contact("g.juliane.andrade@gmail.com", "47997755976", null),
                        new Address("Brazil", "SC", "89814999", "Joinville", "Rua Pavão", 564))
                );
        staffJuliane.setUser(userRepository.findOne(Long.parseLong("1")));
        staffJuliane.setPermission(new Permission(
                true,
                true,
                true,
                true,
                true,
                true,
                true,
                true
        ));

        List<Staff> staffs = Arrays.asList(
                staffJuliane
        );

        staffRepository.save(staffs);

        //*************** LOAD TEACHER ***************************************
        List<Matter> matters = Arrays.asList(
                new Matter("Math"),
                new Matter("English"),
                new Matter("Portuguese"),
                new Matter("Geography"),
                new Matter("History"),
                new Matter("Physics Education"),
                new Matter("Arts"),
                new Matter("Religion")
        );

        Teacher teacher = new Teacher(staffJuliane, matters);

        teacherRepository.save(teacher);

        //*************** LOAD CLASS ***************************************
        ClassRoom classRoom = new ClassRoom("Pré 1 B", "Tarde", teacher);
        classRoom.setStudents(students);

        List<ClassRoomTeacherMatter> classRoomTeacherMatters = Arrays.asList(
                new ClassRoomTeacherMatter(teacher, matters.get(0), classRoom),
                new ClassRoomTeacherMatter(teacher, matters.get(4), classRoom)
        );

        classRoom.setClassRoomTeacherMatters(classRoomTeacherMatters);

        List<Matter> mondaySchedule = Arrays.asList(
                matters.get(0),
                matters.get(5),
                matters.get(2),
                matters.get(3)
        );
        List<Matter> tuesdaySchedule = Arrays.asList(
                matters.get(1),
                matters.get(7)
        );
        List<Matter> wednesdaySchedule = Arrays.asList(
                matters.get(3),
                matters.get(1),
                matters.get(5),
                matters.get(6)
        );
        List<Matter> thursdaySchedule = Arrays.asList(
                matters.get(7),
                matters.get(3),
                matters.get(4)
        );
        List<Matter> fridaySchedule = Arrays.asList(
                matters.get(4),
                matters.get(2),
                matters.get(3),
                matters.get(6)
        );

        ClassRoomSchedule schedule = new ClassRoomSchedule();
        schedule.setMonday(mondaySchedule);
        schedule.setTuesday(tuesdaySchedule);
        schedule.setWednesday(wednesdaySchedule);
        schedule.setThursday(thursdaySchedule);
        schedule.setFriday(fridaySchedule);

        classRoom.setSchedule(schedule);

        List<Event> events = Arrays.asList(
                new Event("Feira cultural", new Date(), "", classRoom, null)
        );

        classRoom.setEvents(events);

        classRoomRepository.save(classRoom);
    }
}
