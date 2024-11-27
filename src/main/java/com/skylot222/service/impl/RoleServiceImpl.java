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
import com.skylot222.dao.RoleDAO;
import com.skylot222.domain.Role;
import com.skylot222.dto.RoleDTO;
import com.skylot222.dto.RoleSearchDTO;
import com.skylot222.dto.RolePageDTO;
import com.skylot222.dto.RoleConvertCriteriaDTO;
import com.skylot222.dto.common.RequestDTO;
import com.skylot222.dto.common.ResultDTO;
import com.skylot222.service.RoleService;
import com.skylot222.util.ControllerUtils;





@Service
public class RoleServiceImpl extends GenericServiceImpl<Role, Integer> implements RoleService {

    private final static Logger logger = LoggerFactory.getLogger(RoleServiceImpl.class);

	@Autowired
	RoleDAO roleDao;

	


	@Override
	public GenericDAO<Role, Integer> getDAO() {
		return (GenericDAO<Role, Integer>) roleDao;
	}
	
	public List<Role> findAll () {
		List<Role> roles = roleDao.findAll();
		
		return roles;	
		
	}

	public ResultDTO addRole(RoleDTO roleDTO, RequestDTO requestDTO) {

		Role role = new Role();

		role.setRoleId(roleDTO.getRoleId());


		role.setRoleName(roleDTO.getRoleName());


		LocalDate localDate = LocalDate.now();
		ZoneId defaultZoneId = ZoneId.systemDefault();
		Date date = Date.from(localDate.atStartOfDay(defaultZoneId).toInstant());

		role = roleDao.save(role);
		
		ResultDTO result = new ResultDTO();
		return result;
	}
	
	public Page<Role> getAllRoles(Pageable pageable) {
		return roleDao.findAll(pageable);
	}

	public Page<Role> getAllRoles(Specification<Role> spec, Pageable pageable) {
		return roleDao.findAll(spec, pageable);
	}

	public ResponseEntity<RolePageDTO> getRoles(RoleSearchDTO roleSearchDTO) {
	
			Integer roleId = roleSearchDTO.getRoleId(); 
 			String roleName = roleSearchDTO.getRoleName(); 
 			String sortBy = roleSearchDTO.getSortBy();
			String sortOrder = roleSearchDTO.getSortOrder();
			String searchQuery = roleSearchDTO.getSearchQuery();
			Integer page = roleSearchDTO.getPage();
			Integer size = roleSearchDTO.getSize();

	        Specification<Role> spec = Specification.where(null);

			spec = ControllerUtils.andIfNecessary(spec, roleId, "roleId"); 
			
			spec = ControllerUtils.andIfNecessary(spec, roleName, "roleName"); 
			

		if (searchQuery != null && !searchQuery.isEmpty()) {
			spec = spec.and((root, query, cb) -> cb.or(

             cb.like(cb.lower(root.get("roleName")), "%" + searchQuery.toLowerCase() + "%") 
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

		Page<Role> roles = this.getAllRoles(spec, pageable);
		
		//System.out.println(String.valueOf(roles.getTotalElements()) + " total ${classNamelPlural}, viewing page X of " + String.valueOf(roles.getTotalPages()));
		
		List<Role> rolesList = roles.getContent();
		
		RoleConvertCriteriaDTO convertCriteria = new RoleConvertCriteriaDTO();
		List<RoleDTO> roleDTOs = this.convertRolesToRoleDTOs(rolesList,convertCriteria);
		
		RolePageDTO rolePageDTO = new RolePageDTO();
		rolePageDTO.setRoles(roleDTOs);
		rolePageDTO.setTotalElements(roles.getTotalElements());
		return ResponseEntity.ok(rolePageDTO);
	}

	public List<RoleDTO> convertRolesToRoleDTOs(List<Role> roles, RoleConvertCriteriaDTO convertCriteria) {
		
		List<RoleDTO> roleDTOs = new ArrayList<RoleDTO>();
		
		for (Role role : roles) {
			roleDTOs.add(convertRoleToRoleDTO(role,convertCriteria));
		}
		
		return roleDTOs;

	}
	
	public RoleDTO convertRoleToRoleDTO(Role role, RoleConvertCriteriaDTO convertCriteria) {
		
		RoleDTO roleDTO = new RoleDTO();
		
		roleDTO.setRoleId(role.getRoleId());

	
		roleDTO.setRoleName(role.getRoleName());

	

		
		return roleDTO;
	}

	public ResultDTO updateRole(RoleDTO roleDTO, RequestDTO requestDTO) {
		
		Role role = roleDao.getById(roleDTO.getRoleId());

		role.setRoleId(ControllerUtils.setValue(role.getRoleId(), roleDTO.getRoleId()));

		role.setRoleName(ControllerUtils.setValue(role.getRoleName(), roleDTO.getRoleName()));



        role = roleDao.save(role);
		
		ResultDTO result = new ResultDTO();
		return result;
	}

	public RoleDTO getRoleDTOById(Integer roleId) {
	
		Role role = roleDao.getById(roleId);
			
		
		RoleConvertCriteriaDTO convertCriteria = new RoleConvertCriteriaDTO();
		return(this.convertRoleToRoleDTO(role,convertCriteria));
	}







}
