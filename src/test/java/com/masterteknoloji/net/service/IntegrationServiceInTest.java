package com.masterteknoloji.net.service;

import java.io.IOException;

import org.apache.http.ParseException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.masterteknoloji.net.Passengercounter2App;
import com.masterteknoloji.net.web.rest.vm.kbb.BusLocationInformationVM;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Passengercounter2App.class)
public class IntegrationServiceInTest {

	@Autowired
	IntegrationService integrationService;

	@Test
	public void getData() throws ParseException, IOException {
		BusLocationInformationVM busLocationInformationVM = integrationService.getInformationOfBus(1446l);
		System.out.println("");
	}
}
