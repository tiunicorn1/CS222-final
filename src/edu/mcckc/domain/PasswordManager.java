package edu.mcckc.domain;

import edu.mcckc.exceptions.PasswordException;
import edu.mcckc.gui.PanelApp;
import org.apache.log4j.Logger;

import javax.print.DocFlavor;
import java.util.ArrayList;
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
        specialCharacters = "";
    }

    public String getNewPassword()
    {
        return newPassword;
    }

    public String getUpperAlphabet() {
        return upperAlphabet;
    }

    public String getLowerAlphabet() {
        return lowerAlphabet;
    }

    public String getDigits() {
        return digits;
    }

    public int getMinLength() {
        return minLength;
    }

    public int getMaxLength() {
        return maxLength;
    }

    public void generateNewPassword(int minLength, int maxLength, boolean bIncludeDigits, boolean bIncludeSpecialChars, boolean bIncludeEZToRead, boolean bIncludeAllUpperCase,
                                    boolean bIncludeAllLowerCase, boolean bIncludeMixedCase, String specialCharacters) throws PasswordException
    {
        Logger.getLogger(this.getClass()).debug("Inside generateNewPassword");

        initializeValues();

        setSpecialCharacters(specialCharacters);

        StringBuilder sb = new StringBuilder(maxLength);
        StringBuilder charTypes = new StringBuilder();

        if (minLength < 8)
        {
            Logger.getLogger(this.getClass()).debug("Minimum password length must be 8 characters");
            throw new PasswordException("Minimum password length must be 8 characters");
        }

        if (minLength > maxLength)
        {
            Logger.getLogger(this.getClass()).error("MIN PW length must be less than the MAX PW length");
            throw new PasswordException("MIN PW length must be less than the MAX PW length");

        }

        if (bIncludeDigits && !bIncludeEZToRead)
        {
            charTypes.append(digits);
        }

        if (bIncludeSpecialChars)
        {

            /*try
            {
                specialCharacters = "";
                throw new PasswordException("Special Characters needed");
            }
            catch(PasswordException pex)
            {
                Logger.getLogger(this.getClass()).error(pex.getMessage());
            }
*/
            charTypes.append(specialCharacters);
        }

        if (bIncludeEZToRead)
        {
            if(bIncludeAllUpperCase)
            {
                String EZreadUpperAlphabet = upperAlphabet.replace("O", "");
                charTypes.append(EZreadUpperAlphabet);
                Logger.getLogger(this.getClass()).debug(String.format("EZreadUpperAlphabet: %s", EZreadUpperAlphabet));
            }
            if(bIncludeAllLowerCase)
            {
                String EZreadlowerAlphabet = lowerAlphabet.replace("l", "");
                charTypes.append(EZreadlowerAlphabet);
                Logger.getLogger(this.getClass()).debug(String.format("EZreadLowerAlphabet: %s", EZreadlowerAlphabet));
            }
            if(bIncludeMixedCase)
            {
                String EZreadUpperAlphabet = upperAlphabet.replace("O", "");
                String EZreadlowerAlphabet = lowerAlphabet.replace("l", "");
                charTypes.append(EZreadUpperAlphabet);
                charTypes.append(EZreadlowerAlphabet);
                Logger.getLogger(this.getClass()).debug(String.format("EZreadUpperAlphabet: %s, EZreadLowerAlphabet: %s", EZreadUpperAlphabet, EZreadlowerAlphabet));
            }
            if(bIncludeDigits)
            {
                String EZreadDigits = digits.replace("0", "");
                Logger.getLogger(this.getClass()).debug(String.format("EZreadDigit: %s", EZreadDigits));
                EZreadDigits = EZreadDigits.replace("1", "");
                Logger.getLogger(this.getClass()).debug(String.format("EZreadDigit: %s", EZreadDigits));
                charTypes.append(EZreadDigits);
                Logger.getLogger(this.getClass()).debug(String.format("EZreadDigit: %s", EZreadDigits));
            }

        }

        if (bIncludeAllUpperCase && !bIncludeEZToRead)
        {
            charTypes.append(upperAlphabet);
        }

        if (bIncludeAllLowerCase && !bIncludeEZToRead)
        {
            charTypes.append(lowerAlphabet);
        }

        if (bIncludeMixedCase && !bIncludeEZToRead)
        {
            charTypes.append(upperAlphabet);
            charTypes.append(lowerAlphabet);
        }

        Logger.getLogger(this.getClass()).debug(String.format("charTypes: %s", charTypes));

        int randomLength = minLength + generator.nextInt((maxLength-minLength) + 1);
        Logger.getLogger(this.getClass()).debug(String.format("random Length: %d  charTypeLenghth %d ", randomLength, charTypes.length()));


        /*
            while (randomLength < minLength && randomLength > maxLength) {
                randomLength = generator.nextInt(maxLength);
                Logger.getLogger(this.getClass()).debug(String.format("random Length: %d  charTypeLenghth %d ", randomLength, charTypes.length()));
            }
        */
            for (int i = 0; i < randomLength; i++)
            {
                sb.append(charTypes.charAt(generator.nextInt(charTypes.length())));
            }


           newPassword = sb.substring(0, sb.length());



    }

    public void setSpecialCharacters(String specialCharacters)
    {
        this.specialCharacters = specialCharacters;
    }

    public void setNewPassword(String newPassword)
    {
        this.newPassword = newPassword;
    }

    public void setbIncludeDigits(boolean bIncludeDigits)
    {
        this.bIncludeDigits = false;
    }

    public void setbIncludeSpecialChars(boolean bIncludeSpecialChars)
    {
        this.bIncludeSpecialChars = false;
    }

    public void setbIncludeEZToRead(boolean bIncludeEZToRead)
    {
        this.bIncludeEZToRead = false;
    }

    public void setbIncludeAllUpperCase(boolean bIncludeAllUpperCase)
    {
        this.bIncludeAllUpperCase = false;
    }

    public void setbIncludeAllLowerCase(boolean bIncludeAllLowerCase)
    {
        this.bIncludeAllLowerCase = false;
    }

    public void setbIncludeMixedCase(boolean bIncludeMixedCase)
    {
        this.bIncludeMixedCase = false;
    }

    public void setMinLength(int minLength)
    {
        this.minLength = minLength;

    }

    public void setMaxLength(int maxLength)
    {
        this.maxLength = maxLength;
    }

    public void initializeValues()
    {
        upperAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        lowerAlphabet = "abcdefghijklmnopqrstuvwxyz";
        digits = "0123456789";
        bIncludeDigits = false;
        bIncludeSpecialChars = false;
        bIncludeEZToRead = false;
        bIncludeAllUpperCase = false;
        bIncludeAllLowerCase = false;
        bIncludeMixedCase = false;

    }
}
