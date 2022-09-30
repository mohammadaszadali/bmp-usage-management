
package com.dtag.bm.usage.management.service.model;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "name", "description", "configurable", "usageSpecCharacteristicValue" })
@Setter
@Getter
@ToString
public class UsageSpecCharacteristic {

	@JsonProperty("name")
	public String name;
	@JsonProperty("description")
	public String description;
	@JsonProperty("configurable")
	public Boolean configurable;
	@JsonProperty("usageSpecCharacteristicValue")
	public List<UsageSpecCharacteristicValue> usageSpecCharacteristicValue = null;

}
