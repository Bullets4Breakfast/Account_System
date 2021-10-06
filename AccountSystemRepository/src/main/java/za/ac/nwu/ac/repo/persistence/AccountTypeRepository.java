package za.ac.nwu.ac.repo.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import za.ac.nwu.ac.domain.dto.AccountTypeDto;
import za.ac.nwu.ac.domain.persistence.TypeAccount;

@Repository
public interface AccountTypeRepository extends JpaRepository<TypeAccount, Long>{
//    @Query(value = "SELECT " +
//            "       TYPE_ACCOUNT_ID," +
//            "       ACCOUNT_NAME," +
//            "       START_DATE," +
//            "       MNEMONIC," +
//            "      FROM " +
//            "       TypeAccount.DiscoveryVitality" +
//            "      WHERE MNEMONIC = :mnemonic: ", nativeQuery = true)
//    TypeAccount getAccountTypeByMnemonicNativeQuery(String mnemonic);
//
//    @Query(value = "SELECT " +
//            "       at" +
//            "      FROM " +
//            "           TypeAccount at" +
//            "       WHERE at.mnemonic = :mnemonic ")
//    TypeAccount getAccountTypeByMnemonic(String mnemonic);
//
//    @Query(value = "SELECT new za.ac.nwu.ac.domain.dto.AccountTypeDto( " +
//            "       at.mnemonic," +
//            "       at.account_Name," +
//            "       at.start_Date," +
//            "    FROM," +
//            "       TypeAccount at" +
//            "    WHERE at.mnemonic = :mnemonic " )
//    AccountTypeDto getAccountTypeDtoByMnemonic(String mnemonic);


}
