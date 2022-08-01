package services;

import java.math.BigDecimal;

public interface AccountService {
    void withdrawMoney(BigDecimal balance, Long id);
    void transferMoney(BigDecimal balance, Long id);

}
