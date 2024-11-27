package com.skylot222.service.impl;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;



import com.skylot222.dao.GenericDAO;
import com.skylot222.service.GenericService;
import com.skylot222.service.impl.GenericServiceImpl;
import com.skylot222.dao.TicketResponseDAO;
import com.skylot222.domain.TicketResponse;
import com.skylot222.dto.TicketResponseDTO;
import com.skylot222.dto.TicketResponseSearchDTO;
import com.skylot222.dto.TicketResponsePageDTO;
import com.skylot222.dto.TicketResponseConvertCriteriaDTO;
import com.skylot222.dto.common.RequestDTO;
import com.skylot222.dto.common.ResultDTO;
import com.skylot222.service.TicketResponseService;
import com.skylot222.util.ControllerUtils;





@Service
public class TicketResponseServiceImpl extends GenericServiceImpl<TicketResponse, Integer> implements TicketResponseService {

    private final static Logger logger = LoggerFactory.getLogger(TicketResponseServiceImpl.class);

	@Autowired
	TicketResponseDAO ticketResponseDao;

	


	@Override
	public GenericDAO<TicketResponse, Integer> getDAO() {
		return (GenericDAO<TicketResponse, Integer>) ticketResponseDao;
	}
	
	public List<TicketResponse> findAll () {
		List<TicketResponse> ticketResponses = ticketResponseDao.findAll();
		
		return ticketResponses;	
		
	}

	public ResultDTO addTicketResponse(TicketResponseDTO ticketResponseDTO, RequestDTO requestDTO) {

		TicketResponse ticketResponse = new TicketResponse();

		ticketResponse.setTicketResponseId(ticketResponseDTO.getTicketResponseId());


		ticketResponse.setResponseDate(ticketResponseDTO.getResponseDate());


		ticketResponse.setResponseContent(ticketResponseDTO.getResponseContent());


		LocalDate localDate = LocalDate.now();
		ZoneId defaultZoneId = ZoneId.systemDefault();
		Date date = Date.from(localDate.atStartOfDay(defaultZoneId).toInstant());

		ticketResponse = ticketResponseDao.save(ticketResponse);
		
		ResultDTO result = new ResultDTO();
		return result;
	}
	
	public Page<TicketResponse> getAllTicketResponses(Pageable pageable) {
		return ticketResponseDao.findAll(pageable);
	}

	public Page<TicketResponse> getAllTicketResponses(Specification<TicketResponse> spec, Pageable pageable) {
		return ticketResponseDao.findAll(spec, pageable);
	}

	public ResponseEntity<TicketResponsePageDTO> getTicketResponses(TicketResponseSearchDTO ticketResponseSearchDTO) {
	
			Integer ticketResponseId = ticketResponseSearchDTO.getTicketResponseId(); 
   			String responseContent = ticketResponseSearchDTO.getResponseContent(); 
 			String sortBy = ticketResponseSearchDTO.getSortBy();
			String sortOrder = ticketResponseSearchDTO.getSortOrder();
			String searchQuery = ticketResponseSearchDTO.getSearchQuery();
			Integer page = ticketResponseSearchDTO.getPage();
			Integer size = ticketResponseSearchDTO.getSize();

	        Specification<TicketResponse> spec = Specification.where(null);

			spec = ControllerUtils.andIfNecessary(spec, ticketResponseId, "ticketResponseId"); 
			
 			
			spec = ControllerUtils.andIfNecessary(spec, responseContent, "responseContent"); 
			

		if (searchQuery != null && !searchQuery.isEmpty()) {
			spec = spec.and((root, query, cb) -> cb.or(

             cb.like(cb.lower(root.get("responseContent")), "%" + searchQuery.toLowerCase() + "%") 
		));}
		
		Sort sort = Sort.unsorted();
		if (sortBy != null && !sortBy.isEmpty() && sortOrder != null && !sortOrder.isEmpty()) {
			if (sortOrder.equalsIgnoreCase("asc")) {
				sort = Sort.by(sortBy).ascending();
			} else if (sortOrder.equalsIgnoreCase("desc")) {
				sort = Sort.by(sortBy).descending();
			}
		}
		Pageable pageable = PageRequest.of(page, size, sort);

		Page<TicketResponse> ticketResponses = this.getAllTicketResponses(spec, pageable);
		
		//System.out.println(String.valueOf(ticketResponses.getTotalElements()) + " total ${classNamelPlural}, viewing page X of " + String.valueOf(ticketResponses.getTotalPages()));
		
		List<TicketResponse> ticketResponsesList = ticketResponses.getContent();
		
		TicketResponseConvertCriteriaDTO convertCriteria = new TicketResponseConvertCriteriaDTO();
		List<TicketResponseDTO> ticketResponseDTOs = this.convertTicketResponsesToTicketResponseDTOs(ticketResponsesList,convertCriteria);
		
		TicketResponsePageDTO ticketResponsePageDTO = new TicketResponsePageDTO();
		ticketResponsePageDTO.setTicketResponses(ticketResponseDTOs);
		ticketResponsePageDTO.setTotalElements(ticketResponses.getTotalElements());
		return ResponseEntity.ok(ticketResponsePageDTO);
	}

	public List<TicketResponseDTO> convertTicketResponsesToTicketResponseDTOs(List<TicketResponse> ticketResponses, TicketResponseConvertCriteriaDTO convertCriteria) {
		
		List<TicketResponseDTO> ticketResponseDTOs = new ArrayList<TicketResponseDTO>();
		
		for (TicketResponse ticketResponse : ticketResponses) {
			ticketResponseDTOs.add(convertTicketResponseToTicketResponseDTO(ticketResponse,convertCriteria));
		}
		
		return ticketResponseDTOs;

	}
	
	public TicketResponseDTO convertTicketResponseToTicketResponseDTO(TicketResponse ticketResponse, TicketResponseConvertCriteriaDTO convertCriteria) {
		
		TicketResponseDTO ticketResponseDTO = new TicketResponseDTO();
		
		ticketResponseDTO.setTicketResponseId(ticketResponse.getTicketResponseId());

	
		ticketResponseDTO.setResponseDate(ticketResponse.getResponseDate());

	
		ticketResponseDTO.setResponseContent(ticketResponse.getResponseContent());

	

		
		return ticketResponseDTO;
	}

	public ResultDTO updateTicketResponse(TicketResponseDTO ticketResponseDTO, RequestDTO requestDTO) {
		
		TicketResponse ticketResponse = ticketResponseDao.getById(ticketResponseDTO.getTicketResponseId());

		ticketResponse.setTicketResponseId(ControllerUtils.setValue(ticketResponse.getTicketResponseId(), ticketResponseDTO.getTicketResponseId()));

		ticketResponse.setResponseDate(ControllerUtils.setValue(ticketResponse.getResponseDate(), ticketResponseDTO.getResponseDate()));

		ticketResponse.setResponseContent(ControllerUtils.setValue(ticketResponse.getResponseContent(), ticketResponseDTO.getResponseContent()));



        ticketResponse = ticketResponseDao.save(ticketResponse);
		
		ResultDTO result = new ResultDTO();
		return result;
	}

	public TicketResponseDTO getTicketResponseDTOById(Integer ticketResponseId) {
	
		TicketResponse ticketResponse = ticketResponseDao.getById(ticketResponseId);
			
		
		TicketResponseConvertCriteriaDTO convertCriteria = new TicketResponseConvertCriteriaDTO();
		return(this.convertTicketResponseToTicketResponseDTO(ticketResponse,convertCriteria));
	}







}
