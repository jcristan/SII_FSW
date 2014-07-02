package cl.gob.sii.poc.bean;

import java.io.File;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.switchyard.component.test.mixins.cdi.CDIMixIn;
import org.switchyard.test.Invoker;
import org.switchyard.test.ServiceOperation;
import org.switchyard.test.SwitchYardRunner;
import org.switchyard.test.SwitchYardTestCaseConfig;
import org.switchyard.test.SwitchYardTestKit;

@RunWith(SwitchYardRunner.class)
@SwitchYardTestCaseConfig(config = SwitchYardTestCaseConfig.SWITCHYARD_XML, mixins = { CDIMixIn.class })
public class ParseContribuyenteTest {

	private SwitchYardTestKit testKit;
	private CDIMixIn cdiMixIn;
	@ServiceOperation("ParseContribuyente")
	private Invoker service;

	@Test
	public void testParseIniciaProceso() throws Exception {
		// TODO Auto-generated method stub
		// initialize your test message
		File message = new File("/home/jreinoso/nomina.txt");
		service.operation("parseIniciaProceso").sendInOnly(message);

		// validate the results
		//Assert.assertTrue("Implement me", false);
	}

}
