package com.javatech.banking.controller;

import com.javatech.banking.dto.AccountDto;
import com.javatech.banking.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    private AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

       @PostMapping
    public ResponseEntity<AccountDto>addAccount(@RequestBody AccountDto accountDto){          // Add Account Rest Api
        return new ResponseEntity<>(accountService.createAccount(accountDto), HttpStatus.CREATED);

    }
                                                                      // Get Account Rest Api
           @GetMapping("/{id}")
            public ResponseEntity<AccountDto> getAccountById(@PathVariable Long id){
        AccountDto accountDto = accountService.getAccountById(id);
        return ResponseEntity.ok(accountDto);
            }
                                                                   // Deposit Rest Api
     @PutMapping("/{id}/deposit")
    public ResponseEntity<AccountDto> deposit(@PathVariable Long id, @RequestBody Map<String,Double>request){
        Double amount = request.get("amount");
        AccountDto accountDto = accountService.deposit(id, amount);
        return ResponseEntity.ok(accountDto);
    }

      @PutMapping("/{id}/withdraw")                                                        //Withdraw Rest Api
    public ResponseEntity<AccountDto> withdraw(@PathVariable Long id,@RequestBody Map<String, Double>request){
        double amount = request.get("amount");
        AccountDto accountDto = accountService.withdraw(id,amount);
        return ResponseEntity.ok(accountDto);
    }

 @GetMapping                                                                  //Get All Account Rest Api
public ResponseEntity<List<AccountDto>> getAllAccounts(){
        List<AccountDto> accounts = accountService.getAllAccounts();
        return ResponseEntity.ok(accounts);
}

   @DeleteMapping ("/{id}")                                                                 // Delete Account Rest Api
   public ResponseEntity<String> deleteAccount(@PathVariable Long id){
    accountService.deleteAccount(id);
    return ResponseEntity.ok("Account is deleted successfully");
   }

}

