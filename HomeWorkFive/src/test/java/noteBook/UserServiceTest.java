package noteBook;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.*;

class UserServiceTest {
    public static Map<String, User> users = new HashMap<>();

    @BeforeAll
    static void setUp() {
        users.put("1", new User(1, "Vladislav", "222-333"));
        users.put("2", new User(2, "zlata", "333-444"));
        users.put("3", new User(3, "svetlana", "444-555"));
        users.put("4", new User(4, "daniil", "555-666"));
        users.put("5", new User(5, "petr", "999-000"));
        users.put("6", new User(6, "oleg", "888-117"));
        users.put("7", new User(7, "sonya", "543-321"));
        users.put("8", new User(8, "evgeny", "987-654"));
    }

    @Test
    void findUserById() {
        NoteBook noteBook = new NoteBook();
        List<User> userList = noteBook.findAll();

        // заглушка для интерфейса userRepository
        UserRepository userRepository = mock(NoteBook.class);

        // задаем поведение заглушки
        when(userRepository.findById("4")).thenReturn(userList.get(4 - 1));

        // создаем объект userService, который зависит от интерфейса userRepository
        UserService userService = new UserService(userRepository);

        // сравниваем фактический результат с ожидаемым
        assertThat(userService.findUserById("4")).isEqualTo(userList.get(4 - 1));
    }

    @Test
    void findAllUsers() {
        NoteBook noteBook = new NoteBook();
        List<User> userList = noteBook.findAll();

        // заглушка для интерфейса userRepository
        UserRepository userRepository = mock(NoteBook.class);

        // задаем поведение заглушки
        when(userRepository.findAll()).thenReturn(userList);

        // создаем объект userService, который зависит от интерфейса userRepository
        UserService userService = new UserService(userRepository);

        // сравниваем фактический результат с ожидаемым
        assertThat(userService.findAllUsers()).isEqualTo(userList);
    }

    @Test
    void getUserInfoId() {
        NoteBook noteBook = new NoteBook();
        List<User> userList = noteBook.findAll();

        // заглушка для интерфейса userRepository
        UserRepository userRepository = mock(NoteBook.class);

        // задаем поведение заглушки
        when(userRepository.getUserInfoId(3)).thenReturn(userList.get(3 - 1).toString());

        // создаем объект userService, который зависит от интерфейса userRepository
        UserService userService = new UserService(userRepository);

        // сравниваем фактический результат с ожидаемым
        assertThat(userService.getUserInfoId(3)).isEqualTo(userList.get(3 - 1).toString());
    }

    @Test
    void getUserNameById() {
        NoteBook noteBook = new NoteBook();
        List<User> userList = noteBook.findAll();

        // заглушка для интерфейса userRepository
        UserRepository userRepository = mock(NoteBook.class);

        // задаем поведение заглушки
        when(userRepository.getUserNameById(4)).thenReturn(userList.get(4 - 1).getUsername());

        // создаем объект userService, который зависит от интерфейса userRepository
        UserService userService = new UserService(userRepository);

        // сравниваем фактический результат с ожидаемым
        assertThat(userService.getUserNameById(4)).isEqualTo(userList.get(4 - 1).getUsername());
    }

    @Test
    void getUserTelNumberById() {
        NoteBook noteBook = new NoteBook();
        List<User> userList = noteBook.findAll();

        // заглушка для интерфейса userRepository
        UserRepository userRepository = mock(NoteBook.class);

        // задаем поведение заглушки
        when(userRepository.getUserTelNumberById(5)).thenReturn(userList.get(5 - 1).getTelNumber());

        // создаем объект userService, который зависит от интерфейса userRepository
        UserService userService = new UserService(userRepository);

        // сравниваем фактический результат с ожидаемым
        assertThat(userService.getUserTelNumberById(5)).isEqualTo(userList.get(5 - 1).getTelNumber());
    }

    @Test
    void addUsersContact() {
        NoteBook noteBook = new NoteBook();
        User newUser = new User(12, "anatoly", "712-834");
        users.put(String.valueOf(12), new User(12, "anatoly", "712-834"));
        noteBook.setUsersList(users);

        // заглушка для интерфейса userRepository
        UserRepository userRepository = mock(NoteBook.class);

        // задаем поведение заглушки
        when(userRepository.addUsersContact(newUser)).thenReturn(users);

        // создаем объект userService, который зависит от интерфейса userRepository
        UserService userService = new UserService(userRepository);

        // сравниваем фактический результат с ожидаемым
        assertThat(userRepository.addUsersContact(newUser)).isEqualTo(users);
    }

    @Test
    void deleteUsersContactById() {
        NoteBook noteBook = new NoteBook();
        noteBook.setUsersList(users);
        List<User> userList = noteBook.findAll();
        User user = userList.get(2 - 1);
        String key = String.valueOf(user.getId());
        users.remove(key);
        noteBook.setUsersList(users);

        // заглушка для интерфейса userRepository
        UserRepository userRepository = mock(NoteBook.class);

        // задаем поведение заглушки
        when(userRepository.deleteUsersContactById(2)).thenReturn(users);

        // создаем объект userService, который зависит от интерфейса userRepository
        UserService userService = new UserService(userRepository);

        // сравниваем фактический результат с ожидаемым
        assertThat(userService.deleteUsersContactById(2)).isEqualTo(users);
    }

    @Test
    void deleteUsersContactByUserName() {
        NoteBook noteBook = new NoteBook();
        noteBook.setUsersList(users);
        List<User> userList = noteBook.findAll();
        String userName = "svetlana";
        for (User user : userList) {
            if (user.getUsername().equals(userName)) {
                users.remove(user);
                noteBook.setUsersList(users);
            }
        }
        // заглушка для интерфейса userRepository
        UserRepository userRepository = mock(NoteBook.class);

        // задаем поведение заглушки
        when(userRepository.deleteUsersContactByUserName("svetlana")).thenReturn(users);

        // создаем объект userService, который зависит от интерфейса userRepository
        UserService userService = new UserService(userRepository);

        // сравниваем фактический результат с ожидаемым
        assertThat(userService.deleteUsersContactByUserName(userName)).isEqualTo(users);
    }


    @Test
    void deleteUsersContactByUserInfo() {
        NoteBook noteBook = new NoteBook();
        noteBook.setUsersList(users);
        List<User> userList = noteBook.findAll();
        String userName= "sonya";
        String telNumber = "543-321";
        for (User user : userList) {
            if (user.getUsername().equals(userName) && user.getTelNumber().equals(telNumber)) {
                users.remove(user);
                noteBook.setUsersList(users);
            }
        }
        // заглушка для интерфейса userRepository
        UserRepository userRepository = mock(NoteBook.class);

        // задаем поведение заглушки
        when(userRepository.deleteUsersContactByUserInfo(userName, telNumber)).thenReturn(users);

        // создаем объект userService, который зависит от интерфейса userRepository
        UserService userService = new UserService(userRepository);

        // сравниваем фактический результат с ожидаемым
        assertThat(userService.deleteUsersContactByUserInfo(userName, telNumber)).isEqualTo(users);
    }

    @Test
    void changeUsersContactByUserName() {
        NoteBook noteBook = new NoteBook();
        noteBook.setUsersList(users);
        List<User> userList = noteBook.findAll();
        String userName= "anatoly";
        String newUserName = "boris";
        for (User user : userList) {
            if (user.getUsername().equals(userName)) {
                user.setUsername(newUserName);
                noteBook.setUsersList(users);
            }
        }
        // заглушка для интерфейса userRepository
        UserRepository userRepository = mock(NoteBook.class);

        // задаем поведение заглушки
        when(userRepository.ChangeUsersContactByUserName(userName, newUserName)).thenReturn(users);

        // создаем объект userService, который зависит от интерфейса userRepository
        UserService userService = new UserService(userRepository);

        // сравниваем фактический результат с ожидаемым
        assertThat(userService.ChangeUsersContactByUserName(userName, newUserName)).isEqualTo(users);
    }

    @Test
    void changeUsersContactByTelNumber() {
        NoteBook noteBook = new NoteBook();
        noteBook.setUsersList(users);
        List<User> userList = noteBook.findAll();
        String userName= "oleg";
        String newTelNumber = "100-100";
        for (User user : userList) {
            if (user.getUsername().equals(userName)) {
                user.setTelNumber(newTelNumber);
                noteBook.setUsersList(users);
            }
        }
        // заглушка для интерфейса userRepository
        UserRepository userRepository = mock(NoteBook.class);

        // задаем поведение заглушки
        when(userRepository.ChangeUsersContactByTelNumber(userName, newTelNumber)).thenReturn(users);

        // создаем объект userService, который зависит от интерфейса userRepository
        UserService userService = new UserService(userRepository);

        // сравниваем фактический результат с ожидаемым
        assertThat(userService.ChangeUsersContactByTelNumber(userName, newTelNumber)).isEqualTo(users);
    }
}
