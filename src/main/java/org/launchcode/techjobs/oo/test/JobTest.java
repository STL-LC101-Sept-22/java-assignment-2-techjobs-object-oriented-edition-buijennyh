package org.launchcode.techjobs.oo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import static org.junit.Assert.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {

    @Test
    public void testSettingJobId() {
        Job jobOne = new Job();
        Job jobTwo = new Job();
        assertNotEquals(jobOne.getId() , jobTwo.getId());
        // compare Ids of the two jobs
       // assertNotEquals
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job newJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertEquals("Product tester", newJob.getName());
        assertEquals("ACME", newJob.getEmployer().getValue());
        assertEquals("Desert", newJob.getLocation().getValue());
        assertEquals("Quality control", newJob.getPositionType().getValue());
        assertEquals("Persistence", newJob.getCoreCompetency().getValue());


        assertTrue(newJob.getName() instanceof String);
        assertTrue(newJob.getEmployer() instanceof Employer);
        assertTrue(newJob.getLocation() instanceof Location);
        assertTrue(newJob.getPositionType() instanceof PositionType);
        assertTrue(newJob.getCoreCompetency() instanceof CoreCompetency);
        // true if the object is an instance of the class

    }
    @Test
    public void testJobsForEquality() {
        Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job anotherJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertFalse(job.equals(anotherJob));

    }

    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        Job jobTest = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        // ToString(job) //
        char firstChar = jobTest.toString().charAt(0);
        char lastChar = jobTest.toString().charAt(jobTest.toString().length()-1);
        assertEquals(firstChar, '\n');
        assertEquals(lastChar, '\n');

    }
    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        Job jobTest = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String jobString = jobTest.toString();
        String expected = "\nID: 4" +
                "\nName: Product tester" +
                "\nEmployer: ACME" +
                "\nLocation: Desert" +
                "\nPosition Type: Quality control" +
                "\nCore Competency: Persistence\n";
        assertEquals(expected, jobString);

    }
    @Test
    public void testToStringHandlesEmptyField() {
        Job jobTest = new Job("", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String expected = String.format("\nID: %d" +
                "\nName: Data not available" +
                "\nEmployer: %s" +
                "\nLocation: %s" +
                "\nPosition Type: %s" +
                "\nCore Competency: %s\n", jobTest.getId(), jobTest.getEmployer(), jobTest.getLocation(), jobTest.getPositionType(), jobTest.getCoreCompetency());
        String actual = jobTest.toString();

        assertEquals(expected, actual);

    }
}


