package za.ac.nwu.ac.repo.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import za.ac.nwu.ac.domain.dto.AccountTypeDto;
import za.ac.nwu.ac.domain.persistence.TypeAccount;

@Repository
public interface AccountTypeRepository extends JpaRepository<TypeAccount, Long>{
    @Query(value = "SELECT " +
            "       TYPE_ACCOUNT_ID," +
            "       MNEMONIC," +
            "       ACCOUNT_NAME," +
            "       TART_DATE" +
            "      FROM " +
            "       RUBENACC.TYPE_ACCOUNT" +
            "      WHERE MNEMONIC = :mnemonic ", nativeQuery = true)
    TypeAccount getAccountTypeByMnemonicNativeQuery(String mnemonic);

    @Query(value = "SELECT " +
            "       at" +
            "      FROM " +
            "           TypeAccount at" +
            "       WHERE at.mnemonic = :mnemonic ")
    TypeAccount getAccountTypeByMnemonic(String mnemonic);

//    @Query(value = "SELECT new za.ac.nwu.ac.domain.dto.AccountTypeDto( " +
//            "       at.MNEMONIC," +
//            "       at.ACCOUNT_NAME," +
//            "       at.TART_DATE) " +
//            "    FROM" +
//            "       TypeAccount at" +
//            "    WHERE at.mnemonic = :mnemonic " )
//    AccountTypeDto getAccountTypeDtoByMnemonic(String mnemonic);


}
