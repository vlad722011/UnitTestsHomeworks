package noteBook;

import java.util.List;
import java.util.Map;

public class UserService {
    NoteBook noteBook = new NoteBook();
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findUserById(String id) {
        return userRepository.findById(id);
    }

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    public String getUserInfoId(int id) {
        return userRepository.getUserInfoId(id);
    }

    public String getUserNameById(int id) {
        return userRepository.getUserNameById(id);
    }

    public String getUserTelNumberById(int id) {
        return userRepository.getUserTelNumberById(id);
    }

    public Map<String, User> addUsersContact(User user) {
        return userRepository.addUsersContact(user);
    }

    public Map<String, User> deleteUsersContactById(int id) {
        return userRepository.deleteUsersContactById(id);
    }

    public Map<String, User> deleteUsersContactByUserName(String userName) {
        return userRepository.deleteUsersContactByUserName(userName);
    }

    public Map<String, User> deleteUsersContactByUserInfo(String userName, String telNumber) {
       return userRepository.deleteUsersContactByUserInfo(userName, telNumber);
    }

    public Map<String, User> ChangeUsersContactByUserName(String userName, String newUserName) {
       return userRepository.ChangeUsersContactByUserName(userName, newUserName);
    }

    public Map<String, User> ChangeUsersContactByTelNumber(String userName, String newTelNumber) {
      return userRepository.ChangeUsersContactByTelNumber(userName, newTelNumber);
    }

}

