package za.ac.nwu.ac.domain.persistence;



import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


@Entity
@Table(name = "ACCOUNT_LOG", schema = "RUBENACC")
public class AccountLog implements Serializable{
    private static final long serialVersionUID = -3422032160685297948L;

    private Long ACCOUNT_LOG_ID;
    private TypeAccount TYPE_ACCOUNT;
    private Long MEMBER_ID;
    private Long MILES_GAIN;
    private Long MILES_USED;
    private LocalDate DATE_OF_TRANSACTION;

    public AccountLog(Long ACCOUNT_LOG_ID, TypeAccount TYPE_ACCOUNT, Long MEMBER_ID, Long MILES_GAIN, Long MILES_USED, LocalDate DATE_OF_TRANSACTION) {
        this.ACCOUNT_LOG_ID = ACCOUNT_LOG_ID;
        this.TYPE_ACCOUNT = TYPE_ACCOUNT;
        this.MEMBER_ID = MEMBER_ID;
        this.MILES_GAIN = MILES_GAIN;
        this.MILES_USED = MILES_USED;
        this.DATE_OF_TRANSACTION = DATE_OF_TRANSACTION;
    }

    public AccountLog() {
    }

    @Id
    @SequenceGenerator(name = "ACCOUNT_LOG_SEQ", sequenceName = "RUBENACC.ACCOUNT_LOG_SEQ",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ACCOUNT_LOG_SEQ")


    @Column(name = "ACCOUNT_LOG_ID")
    public Long getACCOUNT_LOG_ID() {
        return ACCOUNT_LOG_ID;
    }

    public void setACCOUNT_LOG_ID(Long ACCOUNT_LOG_ID) {
        this.ACCOUNT_LOG_ID = ACCOUNT_LOG_ID;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TYPE_ACCOUNT_ID")
    public TypeAccount getTYPE_ACCOUNT() {
        return TYPE_ACCOUNT;
    }
    public void setTYPE_ACCOUNT(TypeAccount typeAccount) { this.TYPE_ACCOUNT = typeAccount;
    }


    @Column(name = "MEMBER_ID")
    public Long getMEMBER_ID() {
        return MEMBER_ID;
    }

    public void setMEMBER_ID(Long MEMBER_ID) {
        this.MEMBER_ID = MEMBER_ID;
    }
    @Column(name = "MILES_GAIN")
    public Long getMILES_GAIN() {
        return MILES_GAIN;
    }

    public void setMILES_GAIN(Long MILES_GAIN) {
        this.MILES_GAIN = MILES_GAIN;
    }
    @Column(name = "MILES_USED")
    public Long getMILES_USED() {
        return MILES_USED;
    }

    public void setMILES_USED(Long MILES_USED) {
        this.MILES_USED = MILES_USED;
    }
    @Column(name = "DATE_OF_TRANSACTION")
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
        return Objects.equals(ACCOUNT_LOG_ID, that.ACCOUNT_LOG_ID) && Objects.equals(TYPE_ACCOUNT, that.TYPE_ACCOUNT) && Objects.equals(MEMBER_ID, that.MEMBER_ID) && Objects.equals(MILES_GAIN, that.MILES_GAIN) && Objects.equals(MILES_USED, that.MILES_USED) && Objects.equals(DATE_OF_TRANSACTION, that.DATE_OF_TRANSACTION);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ACCOUNT_LOG_ID, TYPE_ACCOUNT, MEMBER_ID, MILES_GAIN, MILES_USED, DATE_OF_TRANSACTION);
    }

    @Override
    public String toString() {
        return "AccountLog{" +
                "ACCOUNT_LOG_ID=" + ACCOUNT_LOG_ID +
                ", TYPE_ACCOUNT_ID=" + TYPE_ACCOUNT +
                ", MEMBER_ID=" + MEMBER_ID +
                ", MILES_GAIN=" + MILES_GAIN +
                ", MILES_USED=" + MILES_USED +
                ", DATE_OF_TRANSACTION=" + DATE_OF_TRANSACTION +
                '}';
    }
}
