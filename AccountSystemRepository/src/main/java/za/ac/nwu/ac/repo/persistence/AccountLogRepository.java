package za.ac.nwu.ac.repo.persistence;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import za.ac.nwu.ac.domain.persistence.AccountLog;
import za.ac.nwu.ac.domain.persistence.TypeAccount;


@Repository
public interface AccountLogRepository extends JpaRepository<AccountLog, Long>{
//    @Query(value = "SELECT " +
//            "       TYPE_ACCOUNT_ID," +
//            "       ACCOUNT_NAME," +
//            "       START_DATE," +
//            "       MNEMONIC," +
//            "      FROM " +
//            "       cmpg323ACCOUNTSYSTEM.TypeAccount" +
//            "      WHERE MNEMONIC = :mnemonic ", nativeQuery = true)
//    TypeAccount getAccountTypeByMnemonic(String mnemonic);
}
