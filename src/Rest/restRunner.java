package Rest;

import com.eviware.soapui.impl.wsdl.WsdlProject;
import com.eviware.soapui.impl.wsdl.WsdlTestSuite;
import com.eviware.soapui.impl.wsdl.testcase.WsdlTestCase;
import com.eviware.soapui.model.support.PropertiesMap;
import com.eviware.soapui.model.testsuite.TestRunner;
import com.eviware.soapui.support.SoapUIException;
import org.apache.xmlbeans.XmlException;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.TestNG;

import java.io.IOException;

public class restRunner {

    @Test
    public void RestTest() throws XmlException, IOException, SoapUIException {
        //Grab the project
        WsdlProject project = new WsdlProject("C:\\Users\\Mariam\\Downloads\\LibraryAPI.xml");
        //Grab the Test suite in the project
        WsdlTestSuite testSuite = project.getTestSuiteByName("Testing");

        //Grab the testCases present in test suite
        for (int i = 0; i < testSuite.getTestCaseCount(); i++) {
            WsdlTestCase testCase = testSuite.getTestCaseAt(i);

            //Run the TestCase
            TestRunner runner = testCase.run(new PropertiesMap(), false);
            Assert.assertEquals(TestRunner.Status.FINISHED, runner.getStatus());
        }
    }
}
