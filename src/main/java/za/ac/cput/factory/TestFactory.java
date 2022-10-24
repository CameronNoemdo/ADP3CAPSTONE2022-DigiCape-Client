package za.ac.cput.factory;
import za.ac.cput.entity.Student;
import za.ac.cput.entity.TestModel;
import za.ac.cput.generic.GenericHelper;
import za.ac.cput.entity.TestModel;

public class TestFactory
{


    public static TestModel createTest(String subjectId, String testName, String testDate, String duration, int resultInPercent){

        String testId = GenericHelper.generateID();

        TestModel test = new TestModel.Builder()
                .setTestId(testId)
                .setSubjectId(subjectId)
                .setTestName(testName)
                .setTestDate(testDate)
                .setDuration(duration)
                .setResultInPercent(resultInPercent)
                .build();

        return test;
    }
    public static TestModel updateTest(String testId,String subjectId, String testName, String testDate, String duration, int resultInPercent)
    {

        return new TestModel.Builder()
                .setTestId(testId)
                .setSubjectId(subjectId)
                .setTestName(testName)
                .setTestDate(testDate)
                .setDuration(duration)
                .setResultInPercent(resultInPercent)
                .build();
    }
}
