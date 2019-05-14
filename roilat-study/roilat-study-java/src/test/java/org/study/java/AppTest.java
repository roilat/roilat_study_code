package org.study.java;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
    	int num = 707829217;
    	doWork(num);
        assertTrue( true );
    }
    
    public void doWork(int num){
    	int end = (int) Math.sqrt(num);
    	System.out.println(end);
    	for (int i = 3; i < end; i+=2) {
			if(num % i == 0){
				System.out.println(i + "*" + num/i);
				doWork(i);
				doWork(num/i);
			}
		}
    }
}
