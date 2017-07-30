package me.owlschool.controller;

import me.owlschool.model.Staff;
import me.owlschool.model.User;
import me.owlschool.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
@RepositoryEventHandler(Staff.class)
public class StaffEventHandler {

    private final UserRepository users;

    @Autowired
    public StaffEventHandler(UserRepository users) {
        this.users = users;
    }

    @HandleBeforeCreate
    public void beforeCreateStaff(Staff staff){
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User loggedUser = users.findByEmail(username);

        staff.getUser().setPassword("teste");
        staff.getUser().setSchool(loggedUser.getSchool());
    }
}
