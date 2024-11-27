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
import com.skylot222.dao.SupportTicketDAO;
import com.skylot222.domain.SupportTicket;
import com.skylot222.dto.SupportTicketDTO;
import com.skylot222.dto.SupportTicketSearchDTO;
import com.skylot222.dto.SupportTicketPageDTO;
import com.skylot222.dto.SupportTicketConvertCriteriaDTO;
import com.skylot222.dto.common.RequestDTO;
import com.skylot222.dto.common.ResultDTO;
import com.skylot222.service.SupportTicketService;
import com.skylot222.util.ControllerUtils;





@Service
public class SupportTicketServiceImpl extends GenericServiceImpl<SupportTicket, Integer> implements SupportTicketService {

    private final static Logger logger = LoggerFactory.getLogger(SupportTicketServiceImpl.class);

	@Autowired
	SupportTicketDAO supportTicketDao;

	


	@Override
	public GenericDAO<SupportTicket, Integer> getDAO() {
		return (GenericDAO<SupportTicket, Integer>) supportTicketDao;
	}
	
	public List<SupportTicket> findAll () {
		List<SupportTicket> supportTickets = supportTicketDao.findAll();
		
		return supportTickets;	
		
	}

	public ResultDTO addSupportTicket(SupportTicketDTO supportTicketDTO, RequestDTO requestDTO) {

		SupportTicket supportTicket = new SupportTicket();

		supportTicket.setSupportTicketId(supportTicketDTO.getSupportTicketId());


		supportTicket.setSubject(supportTicketDTO.getSubject());


		supportTicket.setDescription(supportTicketDTO.getDescription());


		supportTicket.setOpenDate(supportTicketDTO.getOpenDate());


		supportTicket.setCloseDate(supportTicketDTO.getCloseDate());


		LocalDate localDate = LocalDate.now();
		ZoneId defaultZoneId = ZoneId.systemDefault();
		Date date = Date.from(localDate.atStartOfDay(defaultZoneId).toInstant());

		supportTicket = supportTicketDao.save(supportTicket);
		
		ResultDTO result = new ResultDTO();
		return result;
	}
	
	public Page<SupportTicket> getAllSupportTickets(Pageable pageable) {
		return supportTicketDao.findAll(pageable);
	}

	public Page<SupportTicket> getAllSupportTickets(Specification<SupportTicket> spec, Pageable pageable) {
		return supportTicketDao.findAll(spec, pageable);
	}

	public ResponseEntity<SupportTicketPageDTO> getSupportTickets(SupportTicketSearchDTO supportTicketSearchDTO) {
	
			Integer supportTicketId = supportTicketSearchDTO.getSupportTicketId(); 
 			String subject = supportTicketSearchDTO.getSubject(); 
 			String description = supportTicketSearchDTO.getDescription(); 
     			String sortBy = supportTicketSearchDTO.getSortBy();
			String sortOrder = supportTicketSearchDTO.getSortOrder();
			String searchQuery = supportTicketSearchDTO.getSearchQuery();
			Integer page = supportTicketSearchDTO.getPage();
			Integer size = supportTicketSearchDTO.getSize();

	        Specification<SupportTicket> spec = Specification.where(null);

			spec = ControllerUtils.andIfNecessary(spec, supportTicketId, "supportTicketId"); 
			
			spec = ControllerUtils.andIfNecessary(spec, subject, "subject"); 
			
			spec = ControllerUtils.andIfNecessary(spec, description, "description"); 
			
 			
 			

		if (searchQuery != null && !searchQuery.isEmpty()) {
			spec = spec.and((root, query, cb) -> cb.or(

             cb.like(cb.lower(root.get("subject")), "%" + searchQuery.toLowerCase() + "%") 
             , cb.like(cb.lower(root.get("description")), "%" + searchQuery.toLowerCase() + "%") 
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

		Page<SupportTicket> supportTickets = this.getAllSupportTickets(spec, pageable);
		
		//System.out.println(String.valueOf(supportTickets.getTotalElements()) + " total ${classNamelPlural}, viewing page X of " + String.valueOf(supportTickets.getTotalPages()));
		
		List<SupportTicket> supportTicketsList = supportTickets.getContent();
		
		SupportTicketConvertCriteriaDTO convertCriteria = new SupportTicketConvertCriteriaDTO();
		List<SupportTicketDTO> supportTicketDTOs = this.convertSupportTicketsToSupportTicketDTOs(supportTicketsList,convertCriteria);
		
		SupportTicketPageDTO supportTicketPageDTO = new SupportTicketPageDTO();
		supportTicketPageDTO.setSupportTickets(supportTicketDTOs);
		supportTicketPageDTO.setTotalElements(supportTickets.getTotalElements());
		return ResponseEntity.ok(supportTicketPageDTO);
	}

	public List<SupportTicketDTO> convertSupportTicketsToSupportTicketDTOs(List<SupportTicket> supportTickets, SupportTicketConvertCriteriaDTO convertCriteria) {
		
		List<SupportTicketDTO> supportTicketDTOs = new ArrayList<SupportTicketDTO>();
		
		for (SupportTicket supportTicket : supportTickets) {
			supportTicketDTOs.add(convertSupportTicketToSupportTicketDTO(supportTicket,convertCriteria));
		}
		
		return supportTicketDTOs;

	}
	
	public SupportTicketDTO convertSupportTicketToSupportTicketDTO(SupportTicket supportTicket, SupportTicketConvertCriteriaDTO convertCriteria) {
		
		SupportTicketDTO supportTicketDTO = new SupportTicketDTO();
		
		supportTicketDTO.setSupportTicketId(supportTicket.getSupportTicketId());

	
		supportTicketDTO.setSubject(supportTicket.getSubject());

	
		supportTicketDTO.setDescription(supportTicket.getDescription());

	
		supportTicketDTO.setOpenDate(supportTicket.getOpenDate());

	
		supportTicketDTO.setCloseDate(supportTicket.getCloseDate());

	

		
		return supportTicketDTO;
	}

	public ResultDTO updateSupportTicket(SupportTicketDTO supportTicketDTO, RequestDTO requestDTO) {
		
		SupportTicket supportTicket = supportTicketDao.getById(supportTicketDTO.getSupportTicketId());

		supportTicket.setSupportTicketId(ControllerUtils.setValue(supportTicket.getSupportTicketId(), supportTicketDTO.getSupportTicketId()));

		supportTicket.setSubject(ControllerUtils.setValue(supportTicket.getSubject(), supportTicketDTO.getSubject()));

		supportTicket.setDescription(ControllerUtils.setValue(supportTicket.getDescription(), supportTicketDTO.getDescription()));

		supportTicket.setOpenDate(ControllerUtils.setValue(supportTicket.getOpenDate(), supportTicketDTO.getOpenDate()));

		supportTicket.setCloseDate(ControllerUtils.setValue(supportTicket.getCloseDate(), supportTicketDTO.getCloseDate()));



        supportTicket = supportTicketDao.save(supportTicket);
		
		ResultDTO result = new ResultDTO();
		return result;
	}

	public SupportTicketDTO getSupportTicketDTOById(Integer supportTicketId) {
	
		SupportTicket supportTicket = supportTicketDao.getById(supportTicketId);
			
		
		SupportTicketConvertCriteriaDTO convertCriteria = new SupportTicketConvertCriteriaDTO();
		return(this.convertSupportTicketToSupportTicketDTO(supportTicket,convertCriteria));
	}







}
