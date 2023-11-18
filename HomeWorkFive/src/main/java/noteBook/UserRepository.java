package noteBook;

import java.util.List;
import java.util.Map;

public interface UserRepository {
    User findById(String id);
    List<User> findAll();
    String getUserInfoId(int id);
    String getUserNameById(int id);
    String getUserTelNumberById(int id);
    Map<String, User> addUsersContact(User user);
    Map<String, User> deleteUsersContactById(int id);
    Map<String, User> deleteUsersContactByUserName(String userName);
    Map<String, User> deleteUsersContactByUserInfo(String userName, String telNumber);
    Map<String, User> ChangeUsersContactByUserName(String userName, String newUserName);
    Map<String, User> ChangeUsersContactByTelNumber(String userName, String newTelNumber);

}
