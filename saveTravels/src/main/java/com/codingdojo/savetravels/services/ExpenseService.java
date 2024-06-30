package com.codingdojo.savetravels.services;

import java.awt.print.Book;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.savetravels.models.Expense;
import com.codingdojo.savetravels.repositories.ExpenseRepository;

@Service
public class ExpenseService {
	@Autowired
     ExpenseRepository expenseRepository;
  
    public List<Expense> allExpenses() {
        return expenseRepository.findAll();
    }
  
    public Expense createExpense(Expense b) {
        return expenseRepository.save(b);
    }
    
    public Expense findExpense(Long id) {
        Optional<Expense> optionalExpense = expenseRepository.findById(id);
        if(optionalExpense.isPresent()) {
            return optionalExpense.get();
        } else {
            return null;
        }
    }
    public Expense updateExpense(Expense b) {
        return expenseRepository.save(b);
    }
    public void deleteExpense(Long id) {
    	expenseRepository.deleteById(id);
	}
    
}
