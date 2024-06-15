package cue.edu.co.VeloceRentalsSpring.velocerentals.controllers;

import cue.edu.co.VeloceRentalsSpring.velocerentals.Dto.TransactionDto;
import cue.edu.co.VeloceRentalsSpring.velocerentals.services.implementations.TransactionServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Controller for handling transaction-related requests.
 * Uses Spring MVC annotations to map HTTP requests to specific methods.
 */
@RestController
@RequestMapping("/transactions")
public class TransactionController {

    private final TransactionServiceImpl transactionService;

    @Autowired
    public TransactionController(TransactionServiceImpl transactionService) {
        this.transactionService = transactionService;
    }

    /**
     * Handles HTTP GET requests to /transactions/list.
     * Fetches all transactions from the database and returns them as a list.
     *
     * @return a list of TransactionDto
     * @throws SQLException if a database access error occurs
     */
    @GetMapping("/list")
    public List<TransactionDto> fetchAllTransactions() throws SQLException {
        return transactionService.findAll();
    }

    /**
     * Handles HTTP GET requests to /transactions/{id}.
     * Retrieves a transaction by its id from the database and returns it.
     *
     * @param id the id of the transaction to retrieve
     * @return a TransactionDto
     * @throws SQLException if a database access error occurs
     */
    @GetMapping("/{id}")
    public TransactionDto fetchTransactionById(@PathVariable @Valid Long id) throws SQLException {
        return transactionService.findById(id);
    }

    /**
     * Handles HTTP POST requests to /transactions.
     * Saves a new transaction to the database.
     *
     * @param transactionDto the transaction to save
     * @param bindingResult  the result of the validation of the transactionDto
     * @return a map with a success message if the transaction is saved successfully,
     *         or a map with field errors if the transactionDto is not valid
     * @throws SQLException if a database access error occurs
     */
    @PostMapping
    public Map<String, String> createTransaction(@RequestBody @Valid TransactionDto transactionDto, BindingResult bindingResult) throws SQLException {
        if (bindingResult.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            bindingResult.getFieldErrors().forEach(
                    error -> errors.put(error.getField(), error.getDefaultMessage())
            );
            return errors;
        }
        transactionService.create(transactionDto);
        return Map.of("message", "Transaction created successfully");
    }

    /**
     * Handles HTTP DELETE requests to /transactions/{id}.
     * Deletes a transaction by its id from the database.
     *
     * @param id the id of the transaction to delete
     */
    @DeleteMapping("/{id}")
    public void removeTransaction(@PathVariable @Valid Long id) {
        transactionService.remove(id);
    }
}
