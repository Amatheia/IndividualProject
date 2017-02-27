package com.producttracker.persistence;

import com.producttracker.entity.User;
import org.junit.Before;
import org.junit.Test;

import java.sql.Date;
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

        addUser.setUserid(2);
        addUser.setRole("admin");
        addUser.setFirstName("Jennifer");
        addUser.setLastName("Lawrence");
        addUser.setUsername("mockingjay");
        addUser.setPassword("hungergames");
        addUser.setDateAdded(new java.sql.Date(new GregorianCalendar(2017, 02, 25).getTime().getTime()));
        dao.addUser(addUser);

        assertEquals("Last name incorrect", "Lawrence", dao.getUser(2).getLastName());
    }

}