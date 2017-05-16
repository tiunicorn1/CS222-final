package edu.mcckc.tests;

import edu.mcckc.domain.PasswordManager;
import edu.mcckc.exceptions.PasswordException;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by rharris on 5/1/2017.
 */
public class TestPasswordManager
{
    @Test
    public void TestPasswordManagerConstructor()
    {
        PasswordManager test = new PasswordManager();
        Assert.assertNotNull(test);
    }


  @Test
  public void TestPasswordManagerSetNewPassword()
  {
      PasswordManager test = new PasswordManager();
      test.setNewPassword("Bx3!J9i#");
      Assert.assertTrue("Bx3!J9i#".equals(test.getNewPassword()));

  }

    @Test
    public void TestPasswordManagerSetMinLength()
    {
        PasswordManager test = new PasswordManager();
        test.setMinLength(9);
        Assert.assertEquals(9, test.getMinLength(), 9);

    }

    @Test
    public void TestPasswordManagerSetMaxLength()
    {
        PasswordManager test = new PasswordManager();
        test.setMaxLength(20);
        Assert.assertEquals(20, test.getMaxLength(), 20);

    }

    @Test
    public void TestPasswordManagerUpperAlaphabet()
    {
        PasswordManager test = new PasswordManager();
        Assert.assertTrue("ABCDEFGHIJKLMNOPQRSTUVWXYZ".equals(test.getUpperAlphabet()));
    }

    @Test
    public void TestPasswordManagerLowerAlaphabet()
    {
        PasswordManager test = new PasswordManager();
        Assert.assertTrue("abcdefghijklmnopqrstuvwxyz".equals(test.getLowerAlphabet()));
    }

    @Test
    public void TestPasswordManagerDigits()
    {
        PasswordManager test = new PasswordManager();
        Assert.assertTrue("0123456789".equals(test.getDigits()));
    }

    @Test
    public void TestPasswordManagerGenerateNewPassword() {
        PasswordManager test = new PasswordManager();
        String specialCharacters = "";

        try {
            test.generateNewPassword(8, 15, false, false, false, false, false, true, specialCharacters);
            System.out.println(test.getNewPassword());
            Assert.assertNotNull(test.getNewPassword());
        } catch (PasswordException pex) {
            System.out.println(pex.getMessage());
        }
    }

    @Test
    public void TestPasswordManagerGenerateNewPassword2()
    {
        PasswordManager test = new PasswordManager();
        String specialCharacters = "";

        try {
            test.generateNewPassword(8, 15, false, false, false, false, true, true, specialCharacters);
            System.out.println(test.getNewPassword());
            Assert.assertNotNull(test.getNewPassword());
        }
        catch(PasswordException pex)
        {
            System.out.println(pex.getMessage());
        }
    }

    @Test
    public void TestPasswordManagerGenerateNewPassword3()
    {
        PasswordManager test = new PasswordManager();
        String specialCharacters = "";

        try {
            test.generateNewPassword(8, 15, false, false, false, true, true, true, specialCharacters);
            System.out.println(test.getNewPassword());
            Assert.assertNotNull(test.getNewPassword());
        }
        catch(PasswordException pex)
        {
            System.out.println(pex.getMessage());
        }
    }

    @Test
    public void TestPasswordManagerGenerateNewPassword4()
    {
        PasswordManager test = new PasswordManager();
        String specialCharacters = "";

        try {
            test.generateNewPassword(8, 15, false, false, true, true, true, true, specialCharacters);
            System.out.println(test.getNewPassword());
            Assert.assertNotNull(test.getNewPassword());
        }
        catch(PasswordException pex)
        {
            System.out.println(pex.getMessage());
        }
    }

    @Test
    public void TestPasswordManagerGenerateNewPassword5()
    {
        PasswordManager test = new PasswordManager();
        String specialCharacters = "";

        try {
            test.generateNewPassword(8, 15, true, false, true, true, true, true, specialCharacters);
            System.out.println(test.getNewPassword());
            Assert.assertNotNull(test.getNewPassword());
        }
        catch(PasswordException pex)
        {
            System.out.println(pex.getMessage());
        }
    }

    @Test
    public void TestPasswordManagerGenerateNewPassword6()
    {
        PasswordManager test = new PasswordManager();
        String specialCharacters = "+-=_@#$^&;:,.<>~[](){}?!|";

        try {
            test.generateNewPassword(8, 15, true, true, true, true, true, true, specialCharacters);
            System.out.println(test.getNewPassword());
            Assert.assertNotNull(test.getNewPassword());
        }
        catch(PasswordException pex)
        {
            System.out.println(pex.getMessage());
        }
    }

    @Test
    public void TestPasswordManagerGenerateNewPasswordCheckMinLength1()
    {
        PasswordManager test = new PasswordManager();
        String specialCharacters = "+-=_@#$^&;:,.<>~[](){}?!|";

        try {
            test.generateNewPassword(5, 15, true, true, true, true, true, true, specialCharacters);
            System.out.println(test.getNewPassword());
            Assert.assertNotNull(test.getNewPassword());
        }
        catch(PasswordException pex)
        {
            System.out.println(pex.getMessage());
        }
    }

    @Test
    public void TestPasswordManagerGenerateNewPasswordCheckMinLength2()
    {
        PasswordManager test = new PasswordManager();
        String specialCharacters = "+-=_@#$^&;:,.<>~[](){}?!|";

        try {
            test.generateNewPassword(20, 15, true, true, true, true, true, true, specialCharacters);
            System.out.println(test.getNewPassword());
            Assert.assertNotNull(test.getNewPassword());
        }
        catch(PasswordException pex)
        {
            System.out.println(pex.getMessage());
        }
    }
}
