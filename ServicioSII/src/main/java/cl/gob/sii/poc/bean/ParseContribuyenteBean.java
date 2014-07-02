package cl.gob.sii.poc.bean;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.jboss.jbpm.impl.Jbpm6ClientImpl;
import org.jboss.jbpm.impl.Jbpm6ClientObjects;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.manager.RuntimeEngine;
import org.kie.api.runtime.process.ProcessInstance;
import org.kie.services.client.api.RemoteRestRuntimeFactory;
import org.switchyard.component.bean.Service;

import cl.gob.sii.poc.vo.CasoVO;

@Service(ParseContribuyente.class)
public class ParseContribuyenteBean implements ParseContribuyente {

	@Override
	public void parseIniciaProceso(File contribuyente) {
		CasoVO casoVo = new CasoVO();
		try {
			FileInputStream fis = new FileInputStream(contribuyente);
			 
			//Construct BufferedReader from InputStreamReader
			BufferedReader br = new BufferedReader(new InputStreamReader(fis));
			/*
		     private static final String DEPLOYMENT_ID = "org.redhat:sampleProject:1.0";
		     //private static final String APP_URL = "http://localhost:8080/business-central/";
		     private static final String APP_URL = "http://192.168.1.101:8080/business-central/";
		     private static final String USER = "erics";
		     private static final String PASSWORD = "bpmsuite";
		     */

		     final String DEPLOYMENT_ID = "cii.sii.domain:Nomina_contribuyentes:1.0";
		     //private static final String DEPLOYMENT_ID =  "org.redhat:sampleProject:1.0";
		     final String APP_URL = 	"http://10.216.121.1:8080/business-central/";
		     //private static final String APP_URL ="http://192.168.1.101:8080/business-central/";
		     final String USER = "javier";
		     final String PASSWORD = "Redhat2014.";
		     /*Jbpm6ClientImpl client;
		     Jbpm6ClientObjects clientObjects;
		     client=new Jbpm6ClientImpl(APP_URL, USER, PASSWORD, true);
		     clientObjects=new Jbpm6ClientObjects(APP_URL,USER,PASSWORD);
		     */
			String line = null;
			while ((line = br.readLine()) != null) {
				String [] casoNomina = line.split("\\,");
				casoVo = new CasoVO();
				System.out.println("Rut: " + casoNomina[0] );
				Map<String, Object> processVariables = new HashMap<String, Object>();
				String diferencia = casoNomina[2].trim();
				processVariables.put( "rut", Integer.parseInt(casoNomina[0]) );
				processVariables.put( "anio", Integer.parseInt(casoNomina[1]));
				processVariables.put( "diferencia", Integer.parseInt(diferencia) );

				URL url = new URL(APP_URL);
		        RemoteRestRuntimeFactory restSessionFactory = new RemoteRestRuntimeFactory(DEPLOYMENT_ID,  url, USER, PASSWORD);
		        RuntimeEngine engine = restSessionFactory.newRuntimeEngine();
		        KieSession ksession = engine.getKieSession();

		       
		        ProcessInstance processInstance = ksession.startProcess("Nomina_contribuyentes.Asignacion_casos", processVariables);
		        long procId = processInstance.getId();


			}
			br.close();
			fis.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
