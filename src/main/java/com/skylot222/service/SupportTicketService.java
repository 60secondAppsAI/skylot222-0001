package com.skylot222.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;

import com.skylot222.domain.SupportTicket;
import com.skylot222.dto.SupportTicketDTO;
import com.skylot222.dto.SupportTicketSearchDTO;
import com.skylot222.dto.SupportTicketPageDTO;
import com.skylot222.dto.SupportTicketConvertCriteriaDTO;
import com.skylot222.service.GenericService;
import com.skylot222.dto.common.RequestDTO;
import com.skylot222.dto.common.ResultDTO;
import java.util.List;
import java.util.Optional;





public interface SupportTicketService extends GenericService<SupportTicket, Integer> {

	List<SupportTicket> findAll();

	ResultDTO addSupportTicket(SupportTicketDTO supportTicketDTO, RequestDTO requestDTO);

	ResultDTO updateSupportTicket(SupportTicketDTO supportTicketDTO, RequestDTO requestDTO);

    Page<SupportTicket> getAllSupportTickets(Pageable pageable);

    Page<SupportTicket> getAllSupportTickets(Specification<SupportTicket> spec, Pageable pageable);

	ResponseEntity<SupportTicketPageDTO> getSupportTickets(SupportTicketSearchDTO supportTicketSearchDTO);
	
	List<SupportTicketDTO> convertSupportTicketsToSupportTicketDTOs(List<SupportTicket> supportTickets, SupportTicketConvertCriteriaDTO convertCriteria);

	SupportTicketDTO getSupportTicketDTOById(Integer supportTicketId);







}





