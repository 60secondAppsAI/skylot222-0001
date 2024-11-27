package com.skylot222.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;

import com.skylot222.domain.Transaction;
import com.skylot222.dto.TransactionDTO;
import com.skylot222.dto.TransactionSearchDTO;
import com.skylot222.dto.TransactionPageDTO;
import com.skylot222.dto.TransactionConvertCriteriaDTO;
import com.skylot222.service.GenericService;
import com.skylot222.dto.common.RequestDTO;
import com.skylot222.dto.common.ResultDTO;
import java.util.List;
import java.util.Optional;





public interface TransactionService extends GenericService<Transaction, Integer> {

	List<Transaction> findAll();

	ResultDTO addTransaction(TransactionDTO transactionDTO, RequestDTO requestDTO);

	ResultDTO updateTransaction(TransactionDTO transactionDTO, RequestDTO requestDTO);

    Page<Transaction> getAllTransactions(Pageable pageable);

    Page<Transaction> getAllTransactions(Specification<Transaction> spec, Pageable pageable);

	ResponseEntity<TransactionPageDTO> getTransactions(TransactionSearchDTO transactionSearchDTO);
	
	List<TransactionDTO> convertTransactionsToTransactionDTOs(List<Transaction> transactions, TransactionConvertCriteriaDTO convertCriteria);

	TransactionDTO getTransactionDTOById(Integer transactionId);







}





