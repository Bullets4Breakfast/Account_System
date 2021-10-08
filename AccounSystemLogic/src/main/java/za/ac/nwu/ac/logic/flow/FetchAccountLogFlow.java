package za.ac.nwu.ac.logic.flow;

import za.ac.nwu.ac.domain.dto.AccountLogDto;
import za.ac.nwu.ac.domain.dto.AccountTypeDto;

import java.util.List;

public interface FetchAccountLogFlow {
    //List<AccountLogDto> getAllAccountLog();

    List<AccountLogDto> getAllAccountLogs();

    AccountLogDto getAccountTypeByTransactionID(Long transactionID);



}
