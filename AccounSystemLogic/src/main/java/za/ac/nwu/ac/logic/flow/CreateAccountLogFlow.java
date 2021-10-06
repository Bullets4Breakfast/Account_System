package za.ac.nwu.ac.logic.flow;

import za.ac.nwu.ac.domain.dto.AccountLogDto;

public interface CreateAccountLogFlow {
  public AccountLogDto create(AccountLogDto accountLogDto);
}
