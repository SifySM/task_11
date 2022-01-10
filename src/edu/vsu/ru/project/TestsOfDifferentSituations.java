package edu.vsu.ru.project;

import org.junit.Assert;
import org.junit.Test;

import ru.vsu.cs.util.SwingUtils;
import java.io.FileNotFoundException;

public class TestsOfDifferentSituations {
    @Test
    public void Test1() throws FileNotFoundException {
        String strFromFile = SwingUtils.readStrFromFile("TestCase/inputText1.txt");
        String resultOfProgramString = LongestSentence.searchForLongestSentence(strFromFile);

        String trueString = SwingUtils.readStrFromFile("TestResult/ResultOfTest1.txt");

        Assert.assertEquals(resultOfProgramString, trueString);
    }

    @Test
    public void Test2() throws FileNotFoundException {
        String strFromFile = SwingUtils.readStrFromFile("TestCase/inputText2.txt");
        String resultOfProgramString = LongestSentence.searchForLongestSentence(strFromFile);

        String trueString = SwingUtils.readStrFromFile("TestResult/ResultOfTest2.txt");

        Assert.assertEquals(resultOfProgramString, trueString);
    }

    @Test
    public void Test3() throws FileNotFoundException {
        String strFromFile = SwingUtils.readStrFromFile("TestCase/inputText3.txt");
        String resultOfProgramString = LongestSentence.searchForLongestSentence(strFromFile);

        String trueString = SwingUtils.readStrFromFile("TestResult/ResultOfTest3.txt");

        Assert.assertEquals(resultOfProgramString, trueString);
    }

    @Test
    public void Test4() throws FileNotFoundException {
        String strFromFile = SwingUtils.readStrFromFile("TestCase/inputText4.txt");
        String resultOfProgramString = LongestSentence.searchForLongestSentence(strFromFile);

        String trueString = SwingUtils.readStrFromFile("TestResult/ResultOfTest4.txt");

        Assert.assertEquals(resultOfProgramString, trueString);
    }

    @Test
    public void Test5() throws FileNotFoundException {
        String strFromFile = SwingUtils.readStrFromFile("TestCase/inputText5.txt");
        String resultOfProgramString = LongestSentence.searchForLongestSentence(strFromFile);

        String trueString = SwingUtils.readStrFromFile("TestResult/ResultOfTest5.txt");

        Assert.assertEquals(resultOfProgramString, trueString);
    }
}
