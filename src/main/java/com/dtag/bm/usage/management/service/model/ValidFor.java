
package com.dtag.bm.usage.management.service.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "startDateTime",
    "endDateTime"
})
public class ValidFor {

    @JsonProperty("startDateTime")
    public String startDateTime;
    @JsonProperty("endDateTime")
    public String endDateTime;

}
