package Soap;

import com.eviware.soapui.impl.wsdl.WsdlProject;
import com.eviware.soapui.impl.wsdl.WsdlTestSuite;
import com.eviware.soapui.impl.wsdl.testcase.WsdlTestCase;
import com.eviware.soapui.model.support.PropertiesMap;
import com.eviware.soapui.model.testsuite.TestRunner;
import com.eviware.soapui.support.SoapUIException;
import org.apache.xmlbeans.XmlException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class testRunner2 {

    @Test
    public void singleTest() throws XmlException, IOException, SoapUIException {
        //Grab the project
        WsdlProject project = new WsdlProject("C:\\Users\\Mariam\\Downloads\\Employee.xml");
        //Grab the Test suite in the project
        WsdlTestSuite testSuite = project.getTestSuiteByName("Testing");

        WsdlTestCase testCase = testSuite.getTestCaseByName("GetEmployee");

        //Run the TestCase
        TestRunner runner = testCase.run(new PropertiesMap(), false);
        Assert.assertEquals(TestRunner.Status.FINISHED, runner.getStatus());
    }
}