import com.day20.UserRegistration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class UserRegistrationTest {

    private String email;

    public UserRegistrationTest(String email) {
        this.email = email;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"abc@yahoo.com"},
                {"abc-100@yahoo.com"},
                {"abc.100@yahoo.com"},
                {"abc111@abc.com"},
                {"abc-100@abc.net"},
                {"abc.100@abc.com.au"},
                {"abc@1.com"},
                {"abc@gmail.com.com"},
                {"abc+100@gmail.com"},
                {"abc"},
                {"abc@.com.my"},
                {"abc123@gmail.a"},
                {"abc123@.com"},
                {"abc123@.com.com"},
                {".abc@abc.com"},
                {"abc()*@gmail.com"},
                {"abc@%*.com"},
                {"abc..2002@gmail.com"},
                {"abc.@gmail.com"},
                {"abc@abc@gmail.com"},
                {"abc@gmail.com.1a"},
                {"abc@gmail.com.aa.au"}
        });
    }

    @Test
    public void testValidateEmail() {
        UserRegistration userRegistration = new UserRegistration();
        boolean result = userRegistration.validateEmail(email);
        assertTrue(result);
    }

    @Test
    public void testValidateFirstName() {
        UserRegistration userRegistration = new UserRegistration();
        assertTrue(userRegistration.validateFirstName("John"));
        assertFalse(userRegistration.validateFirstName("Jo"));
        assertFalse(userRegistration.validateFirstName("john"));
    }

    @Test
    public void testValidateLastName() {
        UserRegistration userRegistration = new UserRegistration();
        assertTrue(userRegistration.validateLastName("Doe"));
        assertFalse(userRegistration.validateLastName("Do"));
        assertFalse(userRegistration.validateLastName("doe"));
    }

    @Test
    public void testValidateMobile() {
        UserRegistration userRegistration = new UserRegistration();
        assertTrue(userRegistration.validateMobile("91 9919819801"));
        assertFalse(userRegistration.validateMobile("9919819801"));
        assertFalse(userRegistration.validateMobile("91 99198198010"));
    }

    @Test
    public void testValidatePassword() {
        UserRegistration userRegistration = new UserRegistration();
        assertTrue(userRegistration.validatePassword("Password1@"));
        assertFalse(userRegistration.validatePassword("pass"));
        assertFalse(userRegistration.validatePassword("password@"));
        assertFalse(userRegistration.validatePassword("Password1"));
        assertFalse(userRegistration.validatePassword("password1@"));
        assertFalse(userRegistration.validatePassword("Password@"));
    }
}
