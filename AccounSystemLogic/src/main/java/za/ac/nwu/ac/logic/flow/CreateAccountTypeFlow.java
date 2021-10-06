package za.ac.nwu.ac.logic.flow;

import org.springframework.stereotype.Component;
import za.ac.nwu.ac.domain.dto.AccountTypeDto;
import za.ac.nwu.ac.repo.persistence.AccountTypeRepository;


public interface CreateAccountTypeFlow {
    AccountTypeDto create(AccountTypeDto accountType);

}


