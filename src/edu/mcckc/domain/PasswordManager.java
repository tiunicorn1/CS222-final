package edu.mcckc.domain;

import javax.print.DocFlavor;
import java.util.Random;

/**
 * Created by rharris on 5/1/2017.
 */
public class PasswordManager
{
    private Random generator;
    private String upperAlphabet;
    private String lowerAlphabet;
    private String digits;
    private String specialCharacters;
    private String newPassword;
    private boolean bIncludeDigits;
    private boolean bIncludeSpecialChars;
    private boolean bIncludeEZToRead;
    private boolean bIncludeAllUpperCase;
    private boolean bIncludeAllLowerCase;
    private boolean bIncludeMixedCase;
    private int minLength;
    private int maxLength;


    public PasswordManager()
    {
        generator = new Random(System.currentTimeMillis());
        upperAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        lowerAlphabet = "abcdefghijklmnopqrstuvwxyz";
        digits = "0123456789";
    }

    public String getNewPassword()
    {
        return newPassword;
    }

    public void generateNewPassword()
    {
        StringBuilder sb = new StringBuilder();

    }

    public void setSpecialCharacters(String specialCharacters)
    {
    }

    public void setNewPassword(String newPassword)
    {
    }

    public void setbIncludeDigits(boolean bIncludeDigits)
    {
    }

    public void setbIncludeSpecialChars(boolean bIncludeSpecialChars)
    {
    }

    public void setbIncludeEZToRead(boolean bIncludeEZToRead)
    {
    }

    public void setbIncludeAllUpperCase(boolean bIncludeAllUpperCase)
    {
    }

    public void setbIncludeAllLowerCase(boolean bIncludeAllLowerCase)
    {
    }

    public void setbIncludeMixedCase(boolean bIncludeMixedCase)
    {
    }

    public void setMinLength(int minLength)
    {
    }

    public void setMaxLength(int maxLength)
    {
    }
}
