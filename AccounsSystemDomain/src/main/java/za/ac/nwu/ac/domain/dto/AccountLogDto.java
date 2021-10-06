package za.ac.nwu.ac.domain.dto;

import za.ac.nwu.ac.domain.persistence.TypeAccount;
import za.ac.nwu.ac.domain.persistence.AccountLog;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;


public class AccountLogDto implements Serializable {

    private static final long serialVersionUID = -8510683858813529847L;
    private Long ACCOUNT_LOG_ID;
    private TypeAccount TYPE_ACCOUNT_ID;
    private Long MEMBER_ID;
    private Long MILES_GAIN;
    private Long MILES_USED;
    private LocalDate DATE_OF_TRANSACTION;

    public AccountLogDto() {
    }

    public AccountLogDto(Long ACCOUNT_LOG_ID, TypeAccount typeAccount, Long MEMBER_ID, Long MILES_GAIN, Long MILES_USED, LocalDate DATE_OF_TRANSACTION ){
        this.ACCOUNT_LOG_ID = ACCOUNT_LOG_ID;
        this.TYPE_ACCOUNT_ID = typeAccount;
        this.MEMBER_ID = MEMBER_ID;
        this.MILES_GAIN = MILES_GAIN;
        this.MILES_USED = MILES_USED;
        this.DATE_OF_TRANSACTION = DATE_OF_TRANSACTION;

    }

    public AccountLogDto(AccountLog accountLog ){
        this.ACCOUNT_LOG_ID = accountLog.getACCOUNT_LOG_ID();
        this.MEMBER_ID = accountLog.getMEMBER_ID();
        this.MILES_GAIN = accountLog.getMILES_GAIN();
        this.MILES_USED = accountLog.getMILES_USED();
        this.DATE_OF_TRANSACTION = accountLog.getDATE_OF_TRANSACTION();

    }

    public AccountLog buildAccountLog(TypeAccount typeAccount){
        return new AccountLog(this.getACCOUNT_LOG_ID(),typeAccount, this.getMEMBER_ID(),this.getMILES_GAIN(),this.getMILES_USED(),this.getDATE_OF_TRANSACTION());
    }
    public Long getACCOUNT_LOG_ID() {
        return ACCOUNT_LOG_ID;
    }

    public void setACCOUNT_LOG_ID(Long ACCOUNT_LOG_ID) {
        this.ACCOUNT_LOG_ID = ACCOUNT_LOG_ID;
    }

    public TypeAccount getTYPE_ACCOUNT_ID() {
        return TYPE_ACCOUNT_ID;
    }

    public void setTYPE_ACCOUNT_ID(TypeAccount TYPE_ACCOUNT_ID) {
        this.TYPE_ACCOUNT_ID = TYPE_ACCOUNT_ID;
    }

    public Long getMEMBER_ID() {
        return MEMBER_ID;
    }

    public void setMEMBER_ID(Long MEMBER_ID) {
        this.MEMBER_ID = MEMBER_ID;
    }

    public Long getMILES_GAIN() {
        return MILES_GAIN;
    }

    public void setMILES_GAIN(Long MILES_GAIN) {
        this.MILES_GAIN = MILES_GAIN;
    }

    public Long getMILES_USED() {
        return MILES_USED;
    }

    public void setMILES_USED(Long MILES_USED) {
        this.MILES_USED = MILES_USED;
    }

    public LocalDate getDATE_OF_TRANSACTION() {
        return DATE_OF_TRANSACTION;
    }

    public void setDATE_OF_TRANSACTION(LocalDate DATE_OF_TRANSACTION) {
        this.DATE_OF_TRANSACTION = DATE_OF_TRANSACTION;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountLog that = (AccountLog) o;
        return Objects.equals(ACCOUNT_LOG_ID, that.getACCOUNT_LOG_ID()) && Objects.equals(TYPE_ACCOUNT_ID, that.getTYPE_ACCOUNT_ID()) && Objects.equals(MEMBER_ID, that.getMEMBER_ID()) && Objects.equals(MILES_GAIN, that.getMILES_GAIN()) && Objects.equals(MILES_USED, that.getMILES_USED()) && Objects.equals(DATE_OF_TRANSACTION, that.getDATE_OF_TRANSACTION());
    }

    @Override
    public int hashCode() {
        return Objects.hash(ACCOUNT_LOG_ID, TYPE_ACCOUNT_ID, MEMBER_ID, MILES_GAIN, MILES_USED, DATE_OF_TRANSACTION);
    }

    @Override
    public String toString() {
        return "AccountLogDto{" +
                "ACCOUNT_LOG_ID=" + ACCOUNT_LOG_ID +
                ", TYPE_ACCOUNT_ID=" + TYPE_ACCOUNT_ID +
                ", MEMBER_ID=" + MEMBER_ID +
                ", MILES_GAIN=" + MILES_GAIN +
                ", MILES_USED=" + MILES_USED +
                ", DATE_OF_TRANSACTION=" + DATE_OF_TRANSACTION +
                '}';
    }
}
