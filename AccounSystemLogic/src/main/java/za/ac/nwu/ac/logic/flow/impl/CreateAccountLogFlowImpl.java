package za.ac.nwu.ac.logic.flow.impl;


import org.springframework.stereotype.Component;
import za.ac.nwu.ac.domain.dto.AccountLogDto;
import za.ac.nwu.ac.domain.persistence.AccountLog;
import za.ac.nwu.ac.domain.persistence.TypeAccount;
import za.ac.nwu.ac.logic.flow.CreateAccountLogFlow;
import za.ac.nwu.ac.logic.flow.FetchAccountTypeFlow;
import za.ac.nwu.ac.translator.AccountLogTranslator;

@Component
public class CreateAccountLogFlowImpl implements CreateAccountLogFlow {
    private final AccountLogTranslator accountLogTranslator;
    private final FetchAccountTypeFlow fetchAccountTypeFlow;

    public CreateAccountLogFlowImpl(AccountLogTranslator accountLogTranslator, FetchAccountTypeFlow fetchAccountTypeFlow){
        this.accountLogTranslator = accountLogTranslator;
        this.fetchAccountTypeFlow = fetchAccountTypeFlow;
    }




    public AccountLogDto create(AccountLogDto accountLogDto){
        accountLogDto.setACCOUNT_LOG_ID(null);

        TypeAccount typeAccount = fetchAccountTypeFlow.getAccountTypeDbEntityByMnemonic(accountLogDto.getAccountTypeByMnemonic());
        AccountLog accountLog = accountLogDto.buildAccountLog(typeAccount);

        AccountLog createdAccountLog = accountLogTranslator.save(accountLog);
        return new AccountLogDto(createdAccountLog);
    }

}
