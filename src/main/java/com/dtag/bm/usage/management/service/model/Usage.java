
package com.dtag.bm.usage.management.service.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "href", "date", "type", "description", "status", "usageSpecification", "usageCharacteristic",
		"relatedParty", "ratedProductUsage" })
@Setter
@Getter
@ToString
@Document(collection = "UsageDetails")
public class Usage {
	
    @Id
	@JsonProperty("id")
	private String id;
	@JsonProperty("href")
	private String href;
	@JsonProperty("date")
	private String date;
	@JsonProperty("type")
	private String type;
	@JsonProperty("description")
	private String description;
	@JsonProperty("status")
	private String status;
	@JsonProperty("usageSpecification")
	private UsageSpecification usageSpecification;
	@JsonProperty("usageCharacteristic")
	private List<UsageCharacteristic> usageCharacteristic = null;
	@JsonProperty("relatedParty")
	private List<RelatedParty> relatedParty = null;
	@JsonProperty("ratedProductUsage")
	private List<RatedProductUsage> ratedProductUsage = null;

}
