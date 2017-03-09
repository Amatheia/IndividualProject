package com.producttracker.persistence;

import com.producttracker.entity.User;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;
import java.util.List;
import java.util.GregorianCalendar;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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

    @Test
    public void addUser(){
        User addUser = new User();

        addUser.setUserid(4);
        addUser.setRole("admin");
        addUser.setFirstName("Mary J.");
        addUser.setLastName("Blige");
        addUser.setUsername("hiphopsoulqueen");
        addUser.setPassword("icandobad");
        addUser.getDateAdded();
        dao.addUser(addUser);

        assertEquals("Last name incorrect", "Blige", dao.getUser(4).getLastName());
    }

}