package za.ac.nwu.ac.translator.impl;


import org.springframework.stereotype.Component;
import za.ac.nwu.ac.domain.persistence.AccountLog;
import za.ac.nwu.ac.repo.persistence.AccountLogRepository;
import za.ac.nwu.ac.translator.AccountLogTranslator;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccountLogTranslatorImpl implements AccountLogTranslator {

    private AccountLogRepository repo;

    public AccountLogTranslatorImpl(AccountLogRepository accountLogRepository){
        this.repo = accountLogRepository;
    }

    @Override
    public AccountLog save(AccountLog accountLog) {
        return repo.save(accountLog);
    }

    @Override
    public List<AccountLog> getAllAccountLogs(){
        List<AccountLog> accountLogs;

        accountLogs = new ArrayList<>(repo.findAll());
        return accountLogs;
    }

    @Override
    public AccountLog getAccountLogByPK(long transactionID) {
        return repo.findById(transactionID).orElse(null) ;
    }


}
