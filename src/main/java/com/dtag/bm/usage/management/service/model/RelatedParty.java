
package com.dtag.bm.usage.management.service.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "href", "role", "name", "validFor" })
@Setter
@Getter
@ToString
public class RelatedParty {

	@JsonProperty("id")
	private String id;
	@JsonProperty("href")
	private String href;
	@JsonProperty("role")
	private String role;
	@JsonProperty("name")
	private String name;
	@JsonProperty("validFor")
	private ValidFor validFor;

}
