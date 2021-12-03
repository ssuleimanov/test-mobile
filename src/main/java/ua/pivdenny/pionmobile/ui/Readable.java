package ua.pivdenny.pionmobile.ui;

public interface Readable {

    Readable verifyContainsText(String expectedText);

    Readable verifyExactText(String expectedText);

}
