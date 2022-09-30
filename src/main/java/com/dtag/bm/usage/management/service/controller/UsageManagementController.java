package com.dtag.bm.usage.management.service.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dtag.bm.usage.management.service.exception.UsageMandateFieldsException;
import com.dtag.bm.usage.management.service.model.Usage;
import com.dtag.bm.usage.management.service.service.UsageManagementService;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/usageManagement/v1")
@JsonIgnoreProperties(ignoreUnknown = true)
public class UsageManagementController {

	@Autowired
	private UsageManagementService service;

	/**
	 * @param usage
	 * @return
	 */
	@PostMapping("/usage")
	public ResponseEntity<Object> createUsage(@RequestBody Usage usage) {

		UUID uuid = UUID.randomUUID();
		String generatedId = uuid.toString();
		usage.setId(generatedId);

		Resource<Usage> resource = new Resource<Usage>(usage);
		ControllerLinkBuilder links = linkTo(methodOn(this.getClass()).getUsagebyId(generatedId));
		resource.add(links.withRel("get-Product-details"));
		usage.setHref(links.toString());
		
		if(null == usage.getDate() || usage.getDate() == "")
			throw new UsageMandateFieldsException("Date is manadetory field, it should not be blank or null");
		if(null == usage.getType() || usage.getType() == "")
			throw new UsageMandateFieldsException("Type is manadetory field,it should not be blank or null");		
		
		Usage usageCreated = service.createUsage(usage);
		return new ResponseEntity<>(usageCreated, HttpStatus.OK);
	}

	/**
	 * @return
	 */
	@GetMapping("/usages")
	public List<Usage> getUsages() {
		return service.getUsages();
	}

	/**
	 * @param usageId
	 * @return
	 */
	@GetMapping("/usage")
	public Usage getUsagebyId(@RequestParam String usageId) {
		return service.getUsageById(usageId);
	}

	/**
	 * @param Id
	 * @return
	 */
	@DeleteMapping("/usage")
	public ResponseEntity<?> deleteUsageById(@RequestParam String Id) {

		String usageId = service.deleteUsgeById(Id);
		return new ResponseEntity<>("Successfully deleted", HttpStatus.OK);
	}

	/**
	 * @param usageId
	 * @param usage
	 * @return
	 */
	@PutMapping("/updateUsage")
	public ResponseEntity<Object> usageUpdate(@RequestParam String usageId, @RequestBody Usage usage) {
		Usage usageNew = service.updateUsge(usageId, usage);
		return new ResponseEntity<>(usageNew, HttpStatus.OK);

	}

}