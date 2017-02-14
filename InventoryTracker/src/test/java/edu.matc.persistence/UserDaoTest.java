package edu.matc.persistence;

import edu.matc.entity.User;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by amalbaugh on 2/14/17.
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
    public void getUser() throws Exception {
        User user = dao.getUser(1);
        assertNotNull(user);
        assertEquals("Moore", user.getLastName());
    }
}


