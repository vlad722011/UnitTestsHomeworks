package noteBook;
import java.util.List;
import java.util.Map;

public class View {
    public static void main (String[] args) {
        NoteBook noteBook = new NoteBook();
        List<User> userList = noteBook.findAll();
        User user;

        UserRepository userRepository = new UserRepository() {
            @Override
            public User findById(String id) {
                return userList.get(Integer.parseInt(id));
            }

            @Override
            public List<User> findAll() {
                return userList;
            }

            @Override
            public String getUserInfoId(int id) {
                User user = userList.get(id);
                return  user.toString();
            }

            @Override
            public String getUserNameById(int id) {
                for (User user : userList)
                    if (user.getId() == id) {
                        return user.getUsername();
                    }
                return "user with id " + id + " not found";
            }

            @Override
            public String getUserTelNumberById(int id) {
                for (User user : userList)
                    if (user.getId() == id) {
                        return user.getTelNumber();
                    }
                return "user with id " + id + " not found";
            }

            @Override
            public Map<String, User> addUsersContact(User user) {
                Map<String, User> usersList;
                usersList = noteBook.getUsersList();
                String key = String.valueOf(user.getId());
                usersList.put(key, user);
                noteBook.setUsersList(usersList);
                return noteBook.setUsersList(usersList);
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
        };

        UserService userService = new UserService(userRepository);

        // Печатаем базу данных контактов из записной книжки
        System.out.println();
        System.out.println("В записной книжке есть следующие контакты:");
        for (User value : userList) {
            user = value;
            System.out.println(user.toString());
        }
        System.out.println();

        // Найдем и выведем на печать телефонный номер пользователя с ID 1
        System.out.println();
        System.out.println("Выведем на печать телефонный номер пользователя с ID 1");
        String telNumberUserWithId1 = userService.getUserTelNumberById(1);
        System.out.println(telNumberUserWithId1);
        System.out.println();

        // Выведем на печать информацию о пользователе с ID 4
        System.out.println();
        System.out.println("Выведем на печать информацию о пользователе с ID 4");
        String userInfoForUserWithId4 = userService.getUserInfoId(4);
        System.out.println(userInfoForUserWithId4);
        System.out.println();

        // Добавим в записную книгу новый контакт
        System.out.println("Добавим в записную книгу новый контакт: -> " +
                "id = 18, userName = alex, telNumber = 777-888");
        noteBook.setUsersList(userService
                .addUsersContact(new User(18, "alex", "777-888")));

        // Печатаем базу данных контактов из записной книжки после добавления нового контакта
        List<User> newList = noteBook.findAll();
        System.out.println();
        System.out.println("Записная книжка после добавления нового контакта, выглядит так:");
        for (User value : newList) {
            user = value;
            System.out.println(user.toString());
        }
        System.out.println();

        // Удалим из записной книги контакт по ID
        System.out.println("Удалим из записной книги контакт c id = 1");
        noteBook.setUsersList(userService.deleteUsersContactById(1));

        // Печатаем базу данных контактов из записной книжки после удаления контакта с ID = 1
        List<User> newList2 = noteBook.findAll();
        System.out.println();
        System.out.println("Записная книжка после удаления контакта с ID 1, выглядит так:");
        for (User value : newList2) {
            user = value;
            System.out.println(user.toString());
        }
        System.out.println();

        // Удалим из записной книги контакт по имени пользователя
        System.out.println("Удалим из записной книги контакт c userName = daniil");
        noteBook.setUsersList(userService.deleteUsersContactByUserName("daniil"));

        // Печатаем базу данных контактов из записной книжки после удаления контакта с userName = daniil
        List<User> newList3 = noteBook.findAll();
        System.out.println();
        System.out.println("Записная книжка после удаления контакта с userName = daniil, выглядит так:");
        for (User value : newList3) {
            user = value;
            System.out.println(user.toString());
        }
        System.out.println();

        // Удалим из записной книги контакт по userInfo (знаем и имя пользователя, и его телефон)
        System.out.println("Удалим из записной книги контакт c " +
                "userName = svetlana и telNumber = 444-555");
        noteBook.setUsersList(userService
                .deleteUsersContactByUserInfo("svetlana", "444-555"));

        // Печатаем базу данных контактов из записной книжки после удаления контакта с
        // userName = svetlana и telNumber = 444-555
        List<User> newList4 = noteBook.findAll();
        System.out.println();
        System.out.println("Записная книжка после удаления контакта с " +
                "userName = svetlana и telNumber = 444-555, выглядит так:");
        for (User value : newList4) {
            user = value;
            System.out.println(user.toString());
        }
        System.out.println();

        // Изменим в записной книге контакт с userName = alex. Изменим пользователю  userName на vladislav
        System.out.println("Изменим в записной книге контакт с userName = alex. " +
                "Изменим пользователю  userName на vladislav");
        noteBook.setUsersList(userService
                .ChangeUsersContactByUserName("alex", "vladislav"));

        // Печатаем базу данных контактов из записной книжки после удаления контакта с userName = daniil
        List<User> newList5 = noteBook.findAll();
        System.out.println();
        System.out.println("Записная книжка после изменения контакту " +
                "с userName = alex имени на userName = vladislav, выглядит так:");
        for (User value : newList5) {
            user = value;
            System.out.println(user.toString());
        }
        System.out.println();

        // Изменим в записной книге контакт с userName = petr. Изменим пользователю  telNumber на 111-111
        System.out.println("Изменим в записной книге контакт с userName = petr. " +
                "Изменим пользователю  telNumber на 111-111");
        noteBook.setUsersList(userService
                .ChangeUsersContactByTelNumber("petr", "111-111"));

        // Печатаем базу данных контактов из записной книжки после удаления контакта с userName = daniil
        List<User> newList6 = noteBook.findAll();
        System.out.println();
        System.out.println("Записная книжка после изменения контакту с " +
                "username = petr номера телефона, выглядит так:");
        for (User value : newList6) {
            user = value;
            System.out.println(user.toString());
        }
        System.out.println();

    }
}

