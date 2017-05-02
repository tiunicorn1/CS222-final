package edu.mcckc.exceptions;

/**
 * Created by rharris on 5/1/2017.
 */
public class PasswordException extends Exception
{
    public PasswordException()
    {
        super("An unknown Password Exception occurred.");
    }

    public PasswordException(String message)
    {
        super(message);
    }
}
