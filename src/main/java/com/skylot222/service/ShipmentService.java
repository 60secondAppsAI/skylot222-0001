package com.skylot222.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;

import com.skylot222.domain.Shipment;
import com.skylot222.dto.ShipmentDTO;
import com.skylot222.dto.ShipmentSearchDTO;
import com.skylot222.dto.ShipmentPageDTO;
import com.skylot222.dto.ShipmentConvertCriteriaDTO;
import com.skylot222.service.GenericService;
import com.skylot222.dto.common.RequestDTO;
import com.skylot222.dto.common.ResultDTO;
import java.util.List;
import java.util.Optional;





public interface ShipmentService extends GenericService<Shipment, Integer> {

	List<Shipment> findAll();

	ResultDTO addShipment(ShipmentDTO shipmentDTO, RequestDTO requestDTO);

	ResultDTO updateShipment(ShipmentDTO shipmentDTO, RequestDTO requestDTO);

    Page<Shipment> getAllShipments(Pageable pageable);

    Page<Shipment> getAllShipments(Specification<Shipment> spec, Pageable pageable);

	ResponseEntity<ShipmentPageDTO> getShipments(ShipmentSearchDTO shipmentSearchDTO);
	
	List<ShipmentDTO> convertShipmentsToShipmentDTOs(List<Shipment> shipments, ShipmentConvertCriteriaDTO convertCriteria);

	ShipmentDTO getShipmentDTOById(Integer shipmentId);







}





