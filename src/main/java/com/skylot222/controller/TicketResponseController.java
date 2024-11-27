package com.skylot222.controller;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.List;
import java.util.ArrayList;


import com.skylot222.util.Util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.sql.Timestamp;
import java.util.Date;

import com.skylot222.domain.TicketResponse;
import com.skylot222.dto.TicketResponseDTO;
import com.skylot222.dto.TicketResponseSearchDTO;
import com.skylot222.dto.TicketResponsePageDTO;
import com.skylot222.service.TicketResponseService;
import com.skylot222.dto.common.RequestDTO;
import com.skylot222.dto.common.ResultDTO;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.multipart.MultipartFile;




@CrossOrigin(origins = "*")
@RequestMapping("/ticketResponse")
@RestController
public class TicketResponseController {

	private final static Logger logger = LoggerFactory.getLogger(TicketResponseController.class);

	@Autowired
	TicketResponseService ticketResponseService;



	@RequestMapping(value="/", method = RequestMethod.GET)
	public List<TicketResponse> getAll() {

		List<TicketResponse> ticketResponses = ticketResponseService.findAll();
		
		return ticketResponses;	
	}

	@GetMapping(value = "/{ticketResponseId}")
	@ResponseBody
	public TicketResponseDTO getTicketResponse(@PathVariable Integer ticketResponseId) {
		
		return (ticketResponseService.getTicketResponseDTOById(ticketResponseId));
	}

 	@RequestMapping(value = "/addTicketResponse", method = RequestMethod.POST)
	public ResponseEntity<?> addTicketResponse(@RequestBody TicketResponseDTO ticketResponseDTO, HttpServletRequest request) {

		RequestDTO requestDTO = new RequestDTO(request);
		ResultDTO result = ticketResponseService.addTicketResponse(ticketResponseDTO, requestDTO);
		
		return result.asResponseEntity();
	}

	@GetMapping("/ticketResponses")
	public ResponseEntity<TicketResponsePageDTO> getTicketResponses(TicketResponseSearchDTO ticketResponseSearchDTO) {
 
		return ticketResponseService.getTicketResponses(ticketResponseSearchDTO);
	}	

	@RequestMapping(value = "/updateTicketResponse", method = RequestMethod.POST)
	public ResponseEntity<?> updateTicketResponse(@RequestBody TicketResponseDTO ticketResponseDTO, HttpServletRequest request) {
		RequestDTO requestDTO = new RequestDTO(request);
		ResultDTO result = ticketResponseService.updateTicketResponse(ticketResponseDTO, requestDTO);
		
//		if (result.isSuccessful()) {
//		}

		return result.asResponseEntity();
	}



}
