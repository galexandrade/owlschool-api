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
    private final MatterRerpository matterRepository;
    private final ClassRoomRepository classRoomRepository;

    DateFormat df = new SimpleDateFormat("dd/MM/yyyy");

    @Autowired
    public DatabaseLoader(CourseRepository courseRepository, UserRepository userRepository, SchoolRepository schoolRepository, StudentRepository studentRepository, StaffRepository staffRepository, MatterRerpository matterRepository, ClassRoomRepository classRoomRepository) {
        this.courseRepository = courseRepository;
        this.userRepository = userRepository;
        this.schoolRepository = schoolRepository;
        this.studentRepository = studentRepository;
        this.staffRepository = staffRepository;
        this.matterRepository = matterRepository;
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
                new User("g.alex.andrade@gmail.com", "456789", new String[]{"ROLE_ADMIN"}, schools.get(0))
        );
        userRepository.save(users);



        //*************** LOAD STUDENTS ***************************************
        List<Parent> parents = Arrays.asList(
                new Parent(
                        new Person("Juliane", "R. Andrade", df.parse("06/07/1984"), Long.parseLong("0759999999"), "Juliane", "Educadora",
                                    new Contact("g.juliane.andrade@gmail.com", "47997755976", null),
                                    new Address("Brazil", "SC", "89814999", "Joinville", "Rua Pavão", 564)),
                        "MOTHER"
                ),
                new Parent(
                        new Person("Alex Andrade", "P. Andrade", df.parse("22/03/1992"), Long.parseLong("07517911996"), "Alex", "System Analyst",
                                    new Contact("g.alex.andrade@gmail.com", "4799745925", null),
                                    new Address("Brazil", "SC", "89814999", "Joinville", "Rua Pavão", 564)),
                        "FATHER"
                )
        );

        List<Student> students = Arrays.asList(
                new Student(
                        new Person("Sarah Lyss", "R. Andrade", df.parse("14/12/2013"), null, "Sarah", null, null,
                                    new Address("Brazil", "SC", "89814999", "Joinville", "Rua Pavão", 564)),
                        null,
                        parents
                ),
                new Student(
                        new Person("Letícia", "R. Andrade", df.parse("14/12/2007"), null, "Leticia", null, null,
                                    new Address("Brazil", "SC", "89814999", "Joinville", "Rua Pavão", 564)),
                        null,
                        parents
                )
        );

        studentRepository.save(students);

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

        matterRepository.save(matters);

        //*************** LOAD STAFFS ***************************************
        Staff staffJuliane = new Staff();
        staffJuliane.setPerson(new Person("Juliane", "R. Andrade", df.parse("06/07/1984"), Long.parseLong("0759999999"), "Juliane", null,
                        new Contact("g.juliane.andrade@gmail.com", "47997755976", null),
                        new Address("Brazil", "SC", "89814999", "Joinville", "Rua Pavão", 564))
                );
        staffJuliane.setUser(new User("g.juliane.andrade@gmail.com", "123456", new String[]{"ROLE_USER"}, schools.get(0)));
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
        staffJuliane.setFunction("teacher");

        staffJuliane.setMatters(Arrays.asList(matterRepository.findOne(Long.parseLong("1"))));

        List<Staff> staffs = Arrays.asList(
                staffJuliane
        );

        staffRepository.save(staffs);


        //*************** LOAD CLASS ***************************************
        ClassRoom classRoom = new ClassRoom("Pré 1 B", "morning", "classroom", staffJuliane);
        classRoom.setStudents((List<Student>) studentRepository.findAll());

        List<ClassRoomTeacherMatter> classRoomTeacherMatters = Arrays.asList(
                new ClassRoomTeacherMatter(staffJuliane, matters.get(0), classRoom),
                new ClassRoomTeacherMatter(staffJuliane, matters.get(4), classRoom)
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

        /*
        Student student = studentRepository.findOne(Long.parseLong("1"));
        student.setClassRoom(classRoom);
        studentRepository.save(student);
        */
    }
}
