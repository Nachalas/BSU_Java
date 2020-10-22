package com.company.dao;

import com.company.model.User;
import com.company.model.UserRole;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class UserDao {
    public final static String DELIM = "-";
    private final String DB_DESTINATION = "database/users/userDatabase.txt";

    public static Logger log = LogManager.getLogger();
    private CourseDao courseDao = new CourseDao();

    private User parseUser(String input) {
        StringTokenizer st = new StringTokenizer(input, DELIM);
        long id = Long.parseLong(st.nextToken());
        String login = st.nextToken();
        String password = st.nextToken();
        String email = st.nextToken();
        UserRole role = UserRole.valueOf(st.nextToken());
        return new User(id, login, password, email, role);
    }

    private long getLastID() {
        long toReturn = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(DB_DESTINATION))) {
            String tempLine = "";
            while ((tempLine = reader.readLine()) != null) {
                toReturn = parseUser(tempLine).getId();
            }
        } catch (IOException e) {
            log.fatal(e);
        }
        return toReturn;
    }

    public List<User> getAll() {
        List<User> toReturn = new ArrayList<User>();
        try (BufferedReader reader = new BufferedReader(new FileReader(DB_DESTINATION))) {
            String tempLine = "";
            while ((tempLine = reader.readLine()) != null) {
                toReturn.add(parseUser(tempLine));
            }
            return toReturn;
        } catch (IOException e) {
            log.fatal(e);
        }
        return new ArrayList<User>();
    }

    public User getById(long inputId) {
//        try (BufferedReader reader = new BufferedReader(new FileReader(DB_Destination))) {
//            String tempLine = "";
//            while ((tempLine = reader.readLine()) != null) {
//                User temp = parseUser(tempLine);
//                if (temp.getId() == inputId) {
//                    return temp;
//                }
//            }
//        } catch (IOException e) {
//            log.fatal(e);
//        }
        List<User> userList = getAll();
        for(User userIter : userList) {
            if(userIter.getId() == inputId) {
                return userIter;
            }
        }
        return null;
    }

    public User getByLogin(String inputLogin) {
//        try (BufferedReader reader = new BufferedReader(new FileReader(DB_Destination))) {
//            String tempLine = "";
//            while ((tempLine = reader.readLine()) != null) {
//                User temp = parseUser(tempLine);
//                if (temp.getLogin().equals(inputLogin)) {
//                    return temp;
//                }
//            }
//        } catch (IOException e) {
//            log.fatal(e);
//        }
        List<User> userList = getAll();
        for(User userIter : userList) {
            if(userIter.getLogin().equals(inputLogin)) {
                return userIter;
            }
        }
        return null;
    }

    public void createUser(String login, String password, String email, UserRole role) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(DB_DESTINATION, true))) {
            User newUser = new User(getLastID() + 1, login, password, email, role);
            writer.write(newUser.toStringFileFormat());
            writer.newLine();
        } catch (IOException e) {
            log.fatal(e);
        }
    }

    public void recreateUser(User user) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(DB_DESTINATION, true))) {
            writer.write(user.toStringFileFormat());
            writer.newLine();
        } catch (IOException e) {
            log.fatal(e);
        }
    }

    public void deleteAll(boolean deleteAllFromCourses) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(DB_DESTINATION))) {
            writer.write("");
            if(deleteAllFromCourses) {
                courseDao.removeAllUsersFromAllCourses();
            }
        } catch (IOException e) {
            log.fatal(e);
        }
    }

    public void deleteById(long inputId) {
        List<User> users = getAll();
        deleteAll(false);
        for (User userIter : users) {
            if (userIter.getId() != inputId) {
                recreateUser(userIter);
                courseDao.removeUserFromAllCourses(inputId);
            }
        }
    }

    public void updateById (long inputId, User newUser) {
        List<User> users = getAll();
        deleteAll(false);
        for (User userIter : users) {
            if(userIter.getId() == inputId) {
                userIter.setLogin(newUser.getLogin());
                userIter.setPassword(newUser.getPassword());
                userIter.setEmail(newUser.getEmail());
                userIter.setRole(newUser.getRole());
            }
            recreateUser(userIter);
        }
    }
}
