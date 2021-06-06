package com.applicances.profile;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

//Controller which will handle the http request
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class AppliancesJPAProfileController {

	@Autowired
	private AppliancesProfileRepository appliancesProfileRepository;

	@GetMapping(path = "/basicAuth")
	public AuthenticationBean helloWorldBean() {
		System.out.println("You Are Authenticated");
		return new AuthenticationBean("You Are Authenticated");

	}

	@GetMapping(path = "/jpa/getApplianceList")
	public List<AppliancesList> getAllApplianceList() {
		System.out.println("Hitting this getAllApplianceList");
		return appliancesProfileRepository.findAll();

	}

	@GetMapping(path = "/jpa/getEmpProfileById/{serialNo}")
	public AppliancesList getEmpProfilesById(@PathVariable long serialNo) {

		return appliancesProfileRepository.findById(serialNo).get();

	}

	@DeleteMapping(path = "/jpa/deleteAppliance/{serialNo}")
	public ResponseEntity<Void> deleteEmpProfile(@PathVariable Long serialNo) {

		appliancesProfileRepository.deleteById(serialNo);
		return ResponseEntity.noContent().build();

	}

	@PostMapping(path = "/jpa/updateAppliance/{serialNo}")
	public ResponseEntity<AppliancesList> updateEmpProfile(@PathVariable long serialNo,
			@RequestBody AppliancesList applianceProfile) {
		System.out.println(" ::: updateAppliance :::");
		applianceProfile.setSerialNo(serialNo);
		appliancesProfileRepository.save(applianceProfile);

		return new ResponseEntity<AppliancesList>(applianceProfile, HttpStatus.OK);
	}

	@PostMapping(path = "/jpa/createAppliance/{serialNo}")
	//@Query("select rd from APPLIANCES_LIST rd where rd.serial_no = :#{#applianceProfile.serialNo} and rd.brand = :#{#applianceProfile.brand}")
	public ResponseEntity<Void> createNewApplianceProfile(@PathVariable String serialNo,
			@RequestBody AppliancesList applianceProfile) {
		
		
	//	Optinal<AppliancesList> optRecord = appliancesProfileRepository.findQuestionDetails(qDetails);
		System.out.println(" ::: createNewApplianceProfile :::");

		AppliancesList appProfile2 = appliancesProfileRepository.save(applianceProfile);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{empId}")
				.buildAndExpand(appProfile2.getSerialNo()).toUri();
		return ResponseEntity.created(uri).build();
	}
}
