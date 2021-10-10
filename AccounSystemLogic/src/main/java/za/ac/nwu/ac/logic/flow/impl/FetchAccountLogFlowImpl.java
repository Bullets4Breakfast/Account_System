package za.ac.nwu.ac.logic.flow.impl;


import org.springframework.stereotype.Component;
import za.ac.nwu.ac.domain.dto.AccountLogDto;
import za.ac.nwu.ac.domain.dto.AccountTypeDto;
import za.ac.nwu.ac.domain.persistence.AccountLog;
import za.ac.nwu.ac.logic.flow.FetchAccountLogFlow;
import za.ac.nwu.ac.repo.persistence.AccountLogRepository;
import za.ac.nwu.ac.logic.flow.FetchAccountTypeFlow;
import za.ac.nwu.ac.translator.AccountLogTranslator;
import za.ac.nwu.ac.translator.AccountTypeTranslator;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Component
public class FetchAccountLogFlowImpl implements FetchAccountLogFlow {
    private AccountLogTranslator translator;

    public FetchAccountLogFlowImpl(AccountLogTranslator translator){this.translator = translator;}

//    @Override
//    public List<AccountLogDto> getAllAccountLogs() {
//        return null;
//    }

    @Override
    public List<AccountLogDto> getAllAccountLogs() {
        List<AccountLogDto> accountLogDtos = new ArrayList<>();
        for (AccountLog accountLog : translator.getAllAccountLogs()) {
            accountLogDtos.add(new AccountLogDto(accountLog));
        }

        return accountLogDtos;
    }

    @Override
    public AccountLogDto getAccountTypeByTransactionID(Long transactionID) {
        AccountLog accountLog = translator.getAccountLogByPK((transactionID));
        return null != accountLog ? new AccountLogDto(accountLog):null;
    }
}
