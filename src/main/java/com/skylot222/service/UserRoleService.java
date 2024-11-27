package com.skylot222.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;

import com.skylot222.domain.UserRole;
import com.skylot222.dto.UserRoleDTO;
import com.skylot222.dto.UserRoleSearchDTO;
import com.skylot222.dto.UserRolePageDTO;
import com.skylot222.dto.UserRoleConvertCriteriaDTO;
import com.skylot222.service.GenericService;
import com.skylot222.dto.common.RequestDTO;
import com.skylot222.dto.common.ResultDTO;
import java.util.List;
import java.util.Optional;





public interface UserRoleService extends GenericService<UserRole, Integer> {

	List<UserRole> findAll();

	ResultDTO addUserRole(UserRoleDTO userRoleDTO, RequestDTO requestDTO);

	ResultDTO updateUserRole(UserRoleDTO userRoleDTO, RequestDTO requestDTO);

    Page<UserRole> getAllUserRoles(Pageable pageable);

    Page<UserRole> getAllUserRoles(Specification<UserRole> spec, Pageable pageable);

	ResponseEntity<UserRolePageDTO> getUserRoles(UserRoleSearchDTO userRoleSearchDTO);
	
	List<UserRoleDTO> convertUserRolesToUserRoleDTOs(List<UserRole> userRoles, UserRoleConvertCriteriaDTO convertCriteria);

	UserRoleDTO getUserRoleDTOById(Integer userRoleId);







}





