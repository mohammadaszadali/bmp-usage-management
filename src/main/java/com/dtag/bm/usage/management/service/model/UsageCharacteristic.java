
package com.dtag.bm.usage.management.service.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "name", "value" })

@Setter
@Getter
@ToString
public class UsageCharacteristic {

	@JsonProperty("name")
	private String name;
	@JsonProperty("value")
	private String value;

}
