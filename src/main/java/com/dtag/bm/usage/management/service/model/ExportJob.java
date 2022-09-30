package com.dtag.bm.usage.management.service.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class ExportJob {

	private String id;
	private String href;
	private String path;
	private String contentType;
	private String status;
	private String url;
	private String completionDate;
	private String creationDate;
	private String errorLog;

}
