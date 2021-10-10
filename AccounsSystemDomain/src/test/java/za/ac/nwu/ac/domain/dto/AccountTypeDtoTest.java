package za.ac.nwu.ac.domain.dto;

import static org.junit.jupiter.api.Assertions.*;

class AccountTypeDtoTest {

    @org.junit.jupiter.api.Test
    void getMnemonic() {
        AccountTypeDto accountTypeDto = new AccountTypeDto();
        assertNull(accountTypeDto.getMnemonic());
    }
}