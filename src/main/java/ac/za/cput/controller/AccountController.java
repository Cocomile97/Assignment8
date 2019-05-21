package ac.za.cput.controller;
import ac.za.cput.domain.Account;
import ac.za.cput.domain.Student;
import ac.za.cput.domain.Year;
import ac.za.cput.service.AccountService;
import ac.za.cput.service.StudentService;
import ac.za.cput.service.YearService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired
    @Qualifier("ServiceImpl")
    private AccountService service;

    @PostMapping("/create")
    @ResponseBody
    public Account create(Account account) {
        return service.create(account);
    }

    @PostMapping("/update")
    @ResponseBody
    public Account update(Account account) {
        return service.create(account);
    }

    @GetMapping("/delete/{name}")
    @ResponseBody
    public void delete(@PathVariable String accountName) {
        service.delete(accountName);

    }

    @GetMapping("/read/{name}")
    @ResponseBody
    public Account read(@PathVariable String accountName) {
        return service.read(accountName);
    }

    @GetMapping("/read/all")
    @ResponseBody
    public Set<Account> getAll() {
        return service.getAll();
    }

}