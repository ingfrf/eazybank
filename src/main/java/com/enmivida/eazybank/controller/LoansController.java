package com.enmivida.eazybank.controller;

import com.enmivida.eazybank.model.Loans;
import com.enmivida.eazybank.repository.LoanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class LoansController {

    private LoanRepository loanRepository;

    @GetMapping("/myLoans")
    public List<Loans> getLoansDetails(@RequestParam int id) {
        List<Loans> loans = loanRepository.findByCustomerIdOrderByStartDtDesc(id);
        if (loans != null) {
            return loans;
        }
        return null;
    }
}
