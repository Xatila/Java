package services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.AccountRepository;

import java.math.BigDecimal;
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository){
        this.accountRepository = accountRepository;
    }

    @Override
    public void withdrawMoney(BigDecimal balance, Long id) {

    }

    @Override
    public void transferMoney(BigDecimal balance, Long id) {

    }
}
