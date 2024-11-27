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

import com.skylot222.domain.Role;
import com.skylot222.dto.RoleDTO;
import com.skylot222.dto.RoleSearchDTO;
import com.skylot222.dto.RolePageDTO;
import com.skylot222.service.RoleService;
import com.skylot222.dto.common.RequestDTO;
import com.skylot222.dto.common.ResultDTO;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.multipart.MultipartFile;




@CrossOrigin(origins = "*")
@RequestMapping("/role")
@RestController
public class RoleController {

	private final static Logger logger = LoggerFactory.getLogger(RoleController.class);

	@Autowired
	RoleService roleService;



	@RequestMapping(value="/", method = RequestMethod.GET)
	public List<Role> getAll() {

		List<Role> roles = roleService.findAll();
		
		return roles;	
	}

	@GetMapping(value = "/{roleId}")
	@ResponseBody
	public RoleDTO getRole(@PathVariable Integer roleId) {
		
		return (roleService.getRoleDTOById(roleId));
	}

 	@RequestMapping(value = "/addRole", method = RequestMethod.POST)
	public ResponseEntity<?> addRole(@RequestBody RoleDTO roleDTO, HttpServletRequest request) {

		RequestDTO requestDTO = new RequestDTO(request);
		ResultDTO result = roleService.addRole(roleDTO, requestDTO);
		
		return result.asResponseEntity();
	}

	@GetMapping("/roles")
	public ResponseEntity<RolePageDTO> getRoles(RoleSearchDTO roleSearchDTO) {
 
		return roleService.getRoles(roleSearchDTO);
	}	

	@RequestMapping(value = "/updateRole", method = RequestMethod.POST)
	public ResponseEntity<?> updateRole(@RequestBody RoleDTO roleDTO, HttpServletRequest request) {
		RequestDTO requestDTO = new RequestDTO(request);
		ResultDTO result = roleService.updateRole(roleDTO, requestDTO);
		
//		if (result.isSuccessful()) {
//		}

		return result.asResponseEntity();
	}



}
