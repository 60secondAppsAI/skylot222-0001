package com.skylot222.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;
import java.util.List;
import java.sql.Timestamp;
import java.time.Year;
import jakarta.persistence.Transient;



@Entity
@Table(name="support_tickets")
@Getter @Setter @NoArgsConstructor
public class SupportTicket {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
  	@Column(name="support_ticket_id")
	private Integer supportTicketId;
    
  	@Column(name="subject")
	private String subject;
    
  	@Column(name="description")
	private String description;
    
  	@Column(name="open_date")
	private Date openDate;
    
  	@Column(name="close_date")
	private Date closeDate;
    
	




}
