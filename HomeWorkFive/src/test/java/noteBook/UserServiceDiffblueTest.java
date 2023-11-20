package noteBook;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class UserServiceDiffblueTest {
    /**
     * Method under test: {@link UserService#UserService(UserRepository)}
     */
    @Test
    void testConstructor() {
        UserService actualUserService = new UserService(new NoteBook());
        NoteBook noteBook = actualUserService.noteBook;
        Map<String, User> usersList = noteBook.getUsersList();
        User getResult = usersList.get("1");
        assertEquals("222-333", getResult.getTelNumber());
        User getResult2 = usersList.get("2");
        assertEquals("333-444", getResult2.getTelNumber());
        User getResult3 = usersList.get("3");
        assertEquals("444-555", getResult3.getTelNumber());
        User getResult4 = usersList.get("4");
        assertEquals("555-666", getResult4.getTelNumber());
        assertEquals("Vladislav", getResult.getUsername());
        assertEquals("daniil", getResult4.getUsername());
        assertEquals("svetlana", getResult3.getUsername());
        assertEquals("zlata", getResult2.getUsername());
        assertNull(noteBook.noteBook);
        assertEquals(1, getResult.getId());
        assertEquals(2, getResult2.getId());
        assertEquals(3, getResult3.getId());
        assertEquals(4, getResult4.getId());
        assertEquals(8, actualUserService.findAllUsers().size());
        assertEquals(8, usersList.size());
    }

    /**
     * Method under test: {@link UserService#findUserById(String)}
     */
    @Test
    void testFindUserById() {
        assertNull((new UserService(new NoteBook())).findUserById("42"));
    }

    /**
     * Method under test: {@link UserService#findAllUsers()}
     */
    @Test
    void testFindAllUsers() {
        assertEquals(8, (new UserService(new NoteBook())).findAllUsers().size());
    }

    /**
     * Method under test: {@link UserService#getUserInfoId(int)}
     */
    @Test
    void testGetUserInfoId() {
        assertEquals("Vladislav 222-333", (new UserService(new NoteBook())).getUserInfoId(1));
        assertEquals("user with id 1 not found", (new UserService(new NoteBook(new HashMap<>()))).getUserInfoId(1));
        assertEquals("zlata 333-444", (new UserService(new NoteBook())).getUserInfoId(2));
    }

    /**
     * Method under test: {@link UserService#getUserNameById(int)}
     */
    @Test
    void testGetUserNameById() {
        assertEquals("Vladislav", (new UserService(new NoteBook())).getUserNameById(1));
        assertEquals("user with id 1 not found", (new UserService(new NoteBook(new HashMap<>()))).getUserNameById(1));
        assertEquals("zlata", (new UserService(new NoteBook())).getUserNameById(2));
    }

    /**
     * Method under test: {@link UserService#getUserTelNumberById(int)}
     */
    @Test
    void testGetUserTelNumberById() {
        assertEquals("222-333", (new UserService(new NoteBook())).getUserTelNumberById(1));
        assertEquals("user with id 1 not found", (new UserService(new NoteBook(new HashMap<>()))).getUserTelNumberById(1));
        assertEquals("333-444", (new UserService(new NoteBook())).getUserTelNumberById(2));
    }

    /**
     * Method under test: {@link UserService#addUsersContact(User)}
     */
    @Test
    void testAddUsersContact() {
        NoteBook userRepository = mock(NoteBook.class);
        HashMap<String, User> stringUserMap = new HashMap<>();
        when(userRepository.addUsersContact(Mockito.<User>any())).thenReturn(stringUserMap);
        UserService userService = new UserService(userRepository);
        Map<String, User> actualAddUsersContactResult = userService.addUsersContact(new User(1, "janedoe", "42"));
        verify(userRepository).addUsersContact(Mockito.<User>any());
        assertTrue(actualAddUsersContactResult.isEmpty());
        assertSame(stringUserMap, actualAddUsersContactResult);
    }

    /**
     * Method under test: {@link UserService#deleteUsersContactById(int)}
     */
    @Test
    void testDeleteUsersContactById() {
        NoteBook userRepository = mock(NoteBook.class);
        HashMap<String, User> stringUserMap = new HashMap<>();
        when(userRepository.deleteUsersContactById(anyInt())).thenReturn(stringUserMap);
        Map<String, User> actualDeleteUsersContactByIdResult = (new UserService(userRepository)).deleteUsersContactById(1);
        verify(userRepository).deleteUsersContactById(anyInt());
        assertTrue(actualDeleteUsersContactByIdResult.isEmpty());
        assertSame(stringUserMap, actualDeleteUsersContactByIdResult);
    }

    /**
     * Method under test: {@link UserService#deleteUsersContactByUserName(String)}
     */
    @Test
    void testDeleteUsersContactByUserName() {
        NoteBook userRepository = mock(NoteBook.class);
        HashMap<String, User> stringUserMap = new HashMap<>();
        when(userRepository.deleteUsersContactByUserName(Mockito.<String>any())).thenReturn(stringUserMap);
        Map<String, User> actualDeleteUsersContactByUserNameResult = (new UserService(userRepository))
                .deleteUsersContactByUserName("janedoe");
        verify(userRepository).deleteUsersContactByUserName(Mockito.<String>any());
        assertTrue(actualDeleteUsersContactByUserNameResult.isEmpty());
        assertSame(stringUserMap, actualDeleteUsersContactByUserNameResult);
    }

    /**
     * Method under test: {@link UserService#deleteUsersContactByUserInfo(String, String)}
     */
    @Test
    void testDeleteUsersContactByUserInfo() {
        NoteBook userRepository = mock(NoteBook.class);
        HashMap<String, User> stringUserMap = new HashMap<>();
        when(userRepository.deleteUsersContactByUserInfo(Mockito.<String>any(), Mockito.<String>any()))
                .thenReturn(stringUserMap);
        Map<String, User> actualDeleteUsersContactByUserInfoResult = (new UserService(userRepository))
                .deleteUsersContactByUserInfo("janedoe", "42");
        verify(userRepository).deleteUsersContactByUserInfo(Mockito.<String>any(), Mockito.<String>any());
        assertTrue(actualDeleteUsersContactByUserInfoResult.isEmpty());
        assertSame(stringUserMap, actualDeleteUsersContactByUserInfoResult);
    }

    /**
     * Method under test: {@link UserService#ChangeUsersContactByUserName(String, String)}
     */
    @Test
    void testChangeUsersContactByUserName() {
        NoteBook userRepository = mock(NoteBook.class);
        HashMap<String, User> stringUserMap = new HashMap<>();
        when(userRepository.ChangeUsersContactByUserName(Mockito.<String>any(), Mockito.<String>any()))
                .thenReturn(stringUserMap);
        Map<String, User> actualChangeUsersContactByUserNameResult = (new UserService(userRepository))
                .ChangeUsersContactByUserName("janedoe", "janedoe");
        verify(userRepository).ChangeUsersContactByUserName(Mockito.<String>any(), Mockito.<String>any());
        assertTrue(actualChangeUsersContactByUserNameResult.isEmpty());
        assertSame(stringUserMap, actualChangeUsersContactByUserNameResult);
    }

    /**
     * Method under test: {@link UserService#ChangeUsersContactByTelNumber(String, String)}
     */
    @Test
    void testChangeUsersContactByTelNumber() {
        NoteBook userRepository = mock(NoteBook.class);
        HashMap<String, User> stringUserMap = new HashMap<>();
        when(userRepository.ChangeUsersContactByTelNumber(Mockito.<String>any(), Mockito.<String>any()))
                .thenReturn(stringUserMap);
        Map<String, User> actualChangeUsersContactByTelNumberResult = (new UserService(userRepository))
                .ChangeUsersContactByTelNumber("janedoe", "42");
        verify(userRepository).ChangeUsersContactByTelNumber(Mockito.<String>any(), Mockito.<String>any());
        assertTrue(actualChangeUsersContactByTelNumberResult.isEmpty());
        assertSame(stringUserMap, actualChangeUsersContactByTelNumberResult);
    }
}
