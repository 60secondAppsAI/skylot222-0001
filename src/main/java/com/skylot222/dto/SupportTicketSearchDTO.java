package com.skylot222.dto;

import java.sql.Timestamp;
import java.time.Year;
import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class SupportTicketSearchDTO {

	private Integer page = 0;
	private Integer size;
	private String sortBy;
	private String sortOrder;
	private String searchQuery;

	private Integer supportTicketId;
	
	private String subject;
	
	private String description;
	
	private Date openDate;
	
	private Date closeDate;
	
}