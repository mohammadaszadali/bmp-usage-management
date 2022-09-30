
package com.dtag.bm.usage.management.service.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "ratingDate",
    "usageRatingTag",
    "isBilled",
    "ratingAmountType",
    "taxIncludedRatingAmount",
    "taxExcludedRatingAmount",
    "taxRate",
    "isTaxExempt",
    "offerTariffType",
    "bucketValueConvertedInAmount",
    "currencyCode",
    "productRef"
})
@Setter
@Getter
@ToString
public class RatedProductUsage {

    @JsonProperty("ratingDate")
    private String ratingDate;
    @JsonProperty("usageRatingTag")
    private String usageRatingTag;
    @JsonProperty("isBilled")
    private Boolean isBilled;
    @JsonProperty("ratingAmountType")
    private String ratingAmountType;
    @JsonProperty("taxIncludedRatingAmount")
    private float taxIncludedRatingAmount;
    @JsonProperty("taxExcludedRatingAmount")
    private float taxExcludedRatingAmount;
    @JsonProperty("taxRate")
    private float taxRate;
    @JsonProperty("isTaxExempt")
    private Boolean isTaxExempt;
    @JsonProperty("offerTariffType")
    private String offerTariffType;
    @JsonProperty("bucketValueConvertedInAmount")
    private float bucketValueConvertedInAmount;
    @JsonProperty("currencyCode")
    private String currencyCode;
    @JsonProperty("productRef")
    private String productRef;

}
