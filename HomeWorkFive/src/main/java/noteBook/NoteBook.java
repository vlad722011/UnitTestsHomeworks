package noteBook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NoteBook implements UserRepository {

    /*
    Данный класс будет имитировать записную книгу.
     */
    NoteBook noteBook;

    private Map<String, User> usersList;


    public Map<String, User> setUsersList(Map<String, User> usersList) {
        this.usersList = usersList;
        return usersList;
    }

    public Map<String, User> getUsersList() {
        return usersList;
    }

    public NoteBook(Map<String, User> usersList) {
        this.usersList = usersList;
    }


    public NoteBook() {
        this.usersList = new HashMap<>();
        usersList.put("1", new User(1, "Vladislav", "222-333"));
        usersList.put("2", new User(2, "zlata", "333-444"));
        usersList.put("3", new User(3, "svetlana", "444-555"));
        usersList.put("4", new User(4, "daniil", "555-666"));
        usersList.put("5", new User(5, "petr", "999-000"));
        usersList.put("6", new User(6, "oleg", "888-117"));
        usersList.put("7", new User(7, "sonya", "543-321"));
        usersList.put("8", new User(8, "evgeny", "987-654"));
    }

    @Override
    public User findById(String id) {
        return usersList.get(id);
    }

    @Override
    public List<User> findAll() {
        return new ArrayList<>(usersList.values());
    }

    @Override
    public String getUserInfoId(int id) {
        List<User> users  = new ArrayList<>(usersList.values());
        for (User user : users)
            if (user.getId() == id) {
                return  user.toString();
            }
        return "user with id " + id + " not found";
    }

    @Override
    public String getUserNameById(int id) {
        List<User> users  = new ArrayList<>(usersList.values());
        for (User user : users)
            if (user.getId() == id) {
                return user.getUsername();
            }
        return "user with id " + id + " not found";
    }

    @Override
    public String getUserTelNumberById(int id) {
        List<User> users  = new ArrayList<>(usersList.values());
        for (User user : users)
            if (user.getId() == id) {
                return user.getTelNumber();
            }
        return "user with id " + id + " not found";
    }

    @Override
    public Map<String, User> addUsersContact(User user) {
        Map<String, User> userContacts;
        userContacts = noteBook.getUsersList();
        String key = String.valueOf(user.getId());
        userContacts.put(key, user);
        return noteBook.setUsersList(userContacts);
    }

    @Override
    public Map<String, User> deleteUsersContactById(int id) {
        Map<String, User> userContacts;
        userContacts = noteBook.getUsersList();
        List<User> userList = noteBook.findAll();
        User user = userList.get(id - 1);
        String key = String.valueOf(user.getId());
        userContacts.remove(key);
        noteBook.setUsersList(userContacts);
        return noteBook.setUsersList(userContacts);
    }

    @Override
    public Map<String, User> deleteUsersContactByUserName(String userName) {
        Map<String, User> userContacts;
        User user;
        userContacts = noteBook.getUsersList();
        List<User> userList = noteBook.findAll();
        for (User value : userList) {
            if (value.getUsername().equals(userName)) {
                user = value;
                String key = String.valueOf(user.getId());
                userContacts.remove(key);
                noteBook.setUsersList(userContacts);
                return noteBook.setUsersList(userContacts);
            }
        }
        return userContacts;
    }

    @Override
    public Map<String, User> deleteUsersContactByUserInfo(String userName, String telNumber) {
        Map<String, User> userContacts;
        User user;
        userContacts = noteBook.getUsersList();
        List<User> userList = noteBook.findAll();
        for (User value : userList) {
            if (value.getUsername().equals(userName) && value.getTelNumber().equals(telNumber)) {
                user = value;
                String key = String.valueOf(user.getId());
                userContacts.remove(key);
                noteBook.setUsersList(userContacts);
                return noteBook.setUsersList(userContacts);
            }
        }
        return userContacts;
    }

    @Override
    public Map<String, User> ChangeUsersContactByUserName(String userName, String newUserName) {
        Map<String, User> userContacts;
        User user;
        userContacts = noteBook.getUsersList();
        List<User> userList = noteBook.findAll();
        for (User value : userList) {
            if (value.getUsername().equals(userName)) {
                user = value;
                user.setUsername(newUserName);
                noteBook.setUsersList(userContacts);
                return noteBook.setUsersList(userContacts);
            }
        }
        return userContacts;
    }

    @Override
    public Map<String, User> ChangeUsersContactByTelNumber(String userName, String newTelNumber) {
        Map<String, User> userContacts;
        User user;
        userContacts = noteBook.getUsersList();
        List<User> userList = noteBook.findAll();
        for (User value : userList) {
            if (value.getUsername().equals(userName)) {
                user = value;
                user.setTelNumber(newTelNumber);
                noteBook.setUsersList(userContacts);
                return noteBook.setUsersList(userContacts);
            }
        }
        return userContacts;
    }
}
