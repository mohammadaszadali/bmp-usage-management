
package com.dtag.bm.usage.management.service.model;

import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "href", "name" })
@Setter
@Getter
@ToString
public class UsageSpecification {
	@Id
	@JsonProperty("id")
	private String id;
	@JsonProperty("href")
	private String href;
	@JsonProperty("name")
	private String name;

}
