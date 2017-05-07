package com.producttracker.persistence;

import com.producttracker.entity.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Tests the User Dao
 * @author amatheia
 */
public class UserDaoTest {

    UserDao dao;
    User user;
    int newUser = 0;

    @Before
    public void setUp() throws Exception {

        dao = new UserDao();
        user = new User();
        user.setRole("registered-user");
        user.setFirstName("John");
        user.setLastName("Chapman");
        user.setUsername("johnny");
        user.setPassword("apples");
    }

    @After
    public void tearDown() throws Exception {
        // cleans up test user
        if (newUser != 0) {
            dao.deleteUser(newUser);
        }
    }

    @Test
    public void getAllUsers() throws Exception {
        newUser = dao.addUser(user);
        List<User> users = dao.getAllUsers();
        assertTrue(users.size() > 0);
    }

    @Test
    public void getUser() throws Exception {
        newUser = dao.addUser(user);
        assertNotNull("user not returned", dao.getUser(newUser));
        assertEquals("user ID not returned", user.getUserid(), dao.getUser(newUser).getUserid());
        assertEquals("role not returned", user.getRole(), dao.getUser(newUser).getRole());
        assertEquals("first name not returned", user.getFirstName(), dao.getUser(newUser).getFirstName());
        assertEquals("last name not returned", user.getLastName(), dao.getUser(newUser).getLastName());
        assertEquals("username not returned", user.getUsername(), dao.getUser(newUser).getUsername());
        assertEquals("password not returned", user.getPassword(), dao.getUser(newUser).getPassword());
    }

    @Test
    public void addUser() throws Exception {
        newUser = dao.addUser(user);
        assertNotEquals("no user added", 0, newUser);
        assertEquals("user ID not returned", user.getUserid(), dao.getUser(newUser).getUserid());
        assertEquals("role not added", user.getRole(), dao.getUser(newUser).getRole());
        assertEquals("first name not added", user.getFirstName(), dao.getUser(newUser).getFirstName());
        assertEquals("last name not added", user.getLastName(), dao.getUser(newUser).getLastName());
        assertEquals("username not added", user.getUsername(), dao.getUser(newUser).getUsername());
        assertEquals("password not added", user.getPassword(), dao.getUser(newUser).getPassword());
    }

    @Test
    public void deleteUser() throws Exception {
        dao.addUser(user);
        dao.deleteUser(user.getUserid());
        assertNull("Failed to delete user", dao.getUser(user.getUserid()));
    }

    @Test
    public void updateUser() throws Exception {
        newUser = dao.addUser(user);
        user.setRole("admin");
        user.setFirstName("Johnny");
        user.setLastName("Appleseed");
        user.setUsername("pioneer");
        user.setPassword("appletrees");
        dao.updateUser(user);
        assertEquals("Role change not made", user.getRole(), dao.getUser(newUser).getRole());
        assertEquals("First Name change not made", user.getFirstName(), dao.getUser(newUser).getFirstName());
        assertEquals("Last Name change not made", user.getLastName(), dao.getUser(newUser).getLastName());
        assertEquals("Username change not made", user.getUsername(), dao.getUser(newUser).getUsername());
        assertEquals("Password change not made", user.getPassword(), dao.getUser(newUser).getPassword());
    }
}