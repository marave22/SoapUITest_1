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

import java.io.IOException;

public class restRunner2 {

    @Test
    public void RestTest2() throws XmlException, IOException, SoapUIException {
        //Grab the project
        WsdlProject project = new WsdlProject("C:\\Users\\Mariam\\Downloads\\LibraryAPI.xml");
        //Grab the Test suite in the project

        for (int j = 0; j < project.getTestSuiteCount(); j++) {
            WsdlTestSuite testSuite = project.getTestSuiteAt(j);

            for (int i = 0; i < testSuite.getTestCaseCount(); i++) {
                WsdlTestCase testCase = testSuite.getTestCaseAt(i);

                //Run the TestCase
                TestRunner runner = testCase.run(new PropertiesMap(), false);
                Assert.assertEquals(TestRunner.Status.FINISHED, runner.getStatus());
            }
        }
    }
}
