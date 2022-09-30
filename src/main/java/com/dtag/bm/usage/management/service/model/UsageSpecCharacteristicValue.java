
package com.dtag.bm.usage.management.service.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "valueType", "default", "value", "valueFrom", "valueTo" })
@Setter
@Getter
@ToString
public class UsageSpecCharacteristicValue {

	@JsonProperty("valueType")
	public String valueType;
	@JsonProperty("default")
	public Boolean _default;
	@JsonProperty("value")
	public String value;
	@JsonProperty("valueFrom")
	public String valueFrom;
	@JsonProperty("valueTo")
	public String valueTo;

}
