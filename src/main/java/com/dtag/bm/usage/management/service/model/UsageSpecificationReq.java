
package com.dtag.bm.usage.management.service.model;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "href", "name", "description", "validFor", "usageSpecCharacteristic" })
@Setter
@Getter
@ToString
@Document(collection = "UsageSpecificationDetails")
public class UsageSpecificationReq {

	@JsonProperty("id")
	public String id;
	@JsonProperty("href")
	public String href;
	@JsonProperty("name")
	public String name;
	@JsonProperty("description")
	public String description;
	@JsonProperty("validFor")
	public ValidFor validFor;
	@JsonProperty("usageSpecCharacteristic")
	public List<UsageSpecCharacteristic> usageSpecCharacteristic = null;

}
