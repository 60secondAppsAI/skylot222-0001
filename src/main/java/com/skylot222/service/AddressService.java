package com.skylot222.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;

import com.skylot222.domain.Address;
import com.skylot222.dto.AddressDTO;
import com.skylot222.dto.AddressSearchDTO;
import com.skylot222.dto.AddressPageDTO;
import com.skylot222.dto.AddressConvertCriteriaDTO;
import com.skylot222.service.GenericService;
import com.skylot222.dto.common.RequestDTO;
import com.skylot222.dto.common.ResultDTO;
import java.util.List;
import java.util.Optional;





public interface AddressService extends GenericService<Address, Integer> {

	List<Address> findAll();

	ResultDTO addAddress(AddressDTO addressDTO, RequestDTO requestDTO);

	ResultDTO updateAddress(AddressDTO addressDTO, RequestDTO requestDTO);

    Page<Address> getAllAddresss(Pageable pageable);

    Page<Address> getAllAddresss(Specification<Address> spec, Pageable pageable);

	ResponseEntity<AddressPageDTO> getAddresss(AddressSearchDTO addressSearchDTO);
	
	List<AddressDTO> convertAddresssToAddressDTOs(List<Address> addresss, AddressConvertCriteriaDTO convertCriteria);

	AddressDTO getAddressDTOById(Integer addressId);







}





