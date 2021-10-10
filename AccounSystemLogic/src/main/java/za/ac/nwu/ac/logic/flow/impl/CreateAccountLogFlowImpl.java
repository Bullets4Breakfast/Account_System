package za.ac.nwu.ac.logic.flow.impl;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import za.ac.nwu.ac.domain.dto.AccountLogDto;
import za.ac.nwu.ac.domain.persistence.AccountLog;
import za.ac.nwu.ac.domain.persistence.TypeAccount;
import za.ac.nwu.ac.logic.flow.CreateAccountLogFlow;
import za.ac.nwu.ac.logic.flow.FetchAccountTypeFlow;
import za.ac.nwu.ac.translator.AccountLogTranslator;


@Component
public class CreateAccountLogFlowImpl implements CreateAccountLogFlow {

    private static final Logger LOGGER = LoggerFactory.getLogger(CreateAccountLogFlowImpl.class);

    private final AccountLogTranslator accountLogTranslator;
    private final FetchAccountTypeFlow fetchAccountTypeFlow;

    public CreateAccountLogFlowImpl(AccountLogTranslator accountLogTranslator, FetchAccountTypeFlow fetchAccountTypeFlow){
        this.accountLogTranslator = accountLogTranslator;
        this.fetchAccountTypeFlow = fetchAccountTypeFlow;
    }


    public AccountLogDto create(AccountLogDto accountLogDto){

        LOGGER.info("The input object was {} ",accountLogDto);


        accountLogDto.setACCOUNT_LOG_ID(null);

        TypeAccount typeAccount = fetchAccountTypeFlow.getAccountTypeDbEntityByMnemonic(accountLogDto.getAccountTypeByMnemonic());
        LOGGER.info("Got TypeAccount for {} and the TypeAccountID{} ",accountLogDto.getAccountTypeByMnemonic(), typeAccount.getType_Account_Id());
        AccountLog accountLog = accountLogDto.buildAccountLog(typeAccount);


        AccountLog createdAccountLog = accountLogTranslator.save(accountLog);
        AccountLogDto results = new AccountLogDto(createdAccountLog);
        LOGGER.info("The return object is {} ",results);
        return results;
    }

}
