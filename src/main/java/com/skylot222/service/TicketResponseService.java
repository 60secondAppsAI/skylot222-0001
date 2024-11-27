package com.skylot222.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;

import com.skylot222.domain.TicketResponse;
import com.skylot222.dto.TicketResponseDTO;
import com.skylot222.dto.TicketResponseSearchDTO;
import com.skylot222.dto.TicketResponsePageDTO;
import com.skylot222.dto.TicketResponseConvertCriteriaDTO;
import com.skylot222.service.GenericService;
import com.skylot222.dto.common.RequestDTO;
import com.skylot222.dto.common.ResultDTO;
import java.util.List;
import java.util.Optional;





public interface TicketResponseService extends GenericService<TicketResponse, Integer> {

	List<TicketResponse> findAll();

	ResultDTO addTicketResponse(TicketResponseDTO ticketResponseDTO, RequestDTO requestDTO);

	ResultDTO updateTicketResponse(TicketResponseDTO ticketResponseDTO, RequestDTO requestDTO);

    Page<TicketResponse> getAllTicketResponses(Pageable pageable);

    Page<TicketResponse> getAllTicketResponses(Specification<TicketResponse> spec, Pageable pageable);

	ResponseEntity<TicketResponsePageDTO> getTicketResponses(TicketResponseSearchDTO ticketResponseSearchDTO);
	
	List<TicketResponseDTO> convertTicketResponsesToTicketResponseDTOs(List<TicketResponse> ticketResponses, TicketResponseConvertCriteriaDTO convertCriteria);

	TicketResponseDTO getTicketResponseDTOById(Integer ticketResponseId);







}





