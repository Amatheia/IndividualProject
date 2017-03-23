package com.producttracker.persistence;

import com.producttracker.entity.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.After;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by amalbaugh on 2/25/17.
 */
public class UserDaoTest {

    UserDao dao;

    @Before
    public void setup() {

        dao = new UserDao();

    }

    @Test
    public void getAllUsers() throws Exception {
        List<User> users = dao.getAllUsers();
        assertTrue(users.size() > 0);
    }
/*
    @Test
    public void addUser(){
        User addUser = new User();

        addUser.setUserid(12);
        addUser.setRole("registered-user");
        addUser.setFirstName("Jennifer");
        addUser.setLastName("Lawrence");
        addUser.setUsername("mockingjay");
        addUser.setPassword("hungergames");
        addUser.getDateAdded();
        dao.addUser(addUser);

        assertEquals("Last name incorrect", "Lawrence", dao.getUser(12).getLastName());
    }

    @Test
    public void deleteUser(){
        dao.deleteUser(7);
        assertEquals("Failed to delete user", null, dao.getUser(7));
    }

    @Test
    public void updateUser() throws Exception {
        User user = dao.getUser(3);
        user.setUsername("strangerthanparadise");
        dao.updateUser(user);
        assertEquals("Username change not made", "strangerthanparadise", user.getUsername());
    }
*/
}