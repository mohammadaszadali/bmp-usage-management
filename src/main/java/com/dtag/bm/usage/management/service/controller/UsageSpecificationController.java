package com.dtag.bm.usage.management.service.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dtag.bm.usage.management.service.exception.UsageMandateFieldsException;
import com.dtag.bm.usage.management.service.model.UsageSpecificationReq;
import com.dtag.bm.usage.management.service.service.UsageSpecificationService;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/usageManagement/v1")
@JsonIgnoreProperties(ignoreUnknown = true)
public class UsageSpecificationController {

	@Autowired
	private UsageSpecificationService specservice;

	/**
	 * @param usageSpec
	 * @return
	 */
	@PostMapping("/usageSpecification")
	public ResponseEntity<UsageSpecificationReq> createUsageSprecification(
			@RequestBody UsageSpecificationReq usageSpec) {
		UUID uuid = UUID.randomUUID();
		String generatedId = uuid.toString();
		usageSpec.setId(generatedId);

		Resource<UsageSpecificationReq> resource = new Resource<UsageSpecificationReq>(usageSpec);
		ControllerLinkBuilder links = linkTo(methodOn(this.getClass()).getUsageSpecificationById(generatedId));
		resource.add(links.withRel("get-Product-details"));
		usageSpec.setHref(links.toString());
		
		if(!usageSpec.getUsageSpecCharacteristic().isEmpty()) {
			throw new UsageMandateFieldsException("UsageSpecification Characteristic is manadetory field");
		}

		UsageSpecificationReq usageSpecification = specservice.createUsageSpecification(usageSpec);
		return new ResponseEntity<UsageSpecificationReq>(usageSpecification, HttpStatus.OK);

	}

	/**
	 * @param Id
	 * @return
	 */
	@GetMapping("/usgeSpecification")
	public UsageSpecificationReq getUsageSpecificationById(@RequestParam String Id) {
		return specservice.getUsageSpecificationById(Id);
	}

	/**
	 * @param Id
	 * @return
	 */
	@DeleteMapping("/usgeSpecification")
	public ResponseEntity<?> deleteUsgeSpecById(@RequestParam String Id) {
		specservice.deleteUsgespecById(Id);
		return new ResponseEntity<>("Successfully deleted", HttpStatus.OK);
	}

}
