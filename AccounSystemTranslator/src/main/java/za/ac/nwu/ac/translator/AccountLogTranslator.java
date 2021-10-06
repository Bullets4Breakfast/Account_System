package za.ac.nwu.ac.translator;

import za.ac.nwu.ac.domain.persistence.AccountLog;

import java.util.List;

public interface AccountLogTranslator {

    AccountLog save(AccountLog accountLog);

    List<AccountLog> getAllAccountLogs();

}
