package za.ac.nwu.ac.domain.persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "TypeAccount", schema = "RUBENACC")
public class TypeAccount implements Serializable {
    private static final long serialVersionUID = -161245225444051659L;

    private Long Type_Account_Id;
    private String mnemonic;
    private String Account_Name;
    private LocalDate Start_Date;

    private Set<AccountLog> accountLogs;

    public TypeAccount(Long type_Account_Id, String mnemonic, String account_Name,LocalDate start_Date) {
        this.Type_Account_Id = type_Account_Id;
        this.mnemonic = mnemonic;
        this.Account_Name = account_Name;
        this.Start_Date = start_Date;
    }

    public TypeAccount(String mnemonic, String account_name, LocalDate start_date) {
        this.mnemonic = mnemonic;
        this.Account_Name = account_name;
        this.Start_Date = start_date;
    }

    public TypeAccount() {
    }

    @Id
    @SequenceGenerator(name = "TYPE_ACCOUNT_SEQ", sequenceName = "RUBENACC.TYPE_ACCOUNT_SEQ",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TYPE_ACCOUNT_SEQ")


    @Column(name = "TYPE_ACCOUNT_ID")
    public Long getType_Account_Id() {
        return Type_Account_Id;
    }

    public void setType_Account_Id(Long type_Account_Id) {
        Type_Account_Id = type_Account_Id;
    }
    @Column(name = "MNEMONIC")
    public String getMnemonic() {
        return mnemonic;
    }

    public void setMnemonic(String mnemonic) {
        this.mnemonic = mnemonic;
    }
    @Column(name = "ACCOUNT_NAME")
    public String getAccount_Name() {
        return Account_Name;
    }

    public void setAccount_Name(String account_Name) {
        Account_Name = account_Name;
    }

    @Column(name = "TART_DATE")
    public LocalDate getStart_Date() {
        return Start_Date;
    }



    @OneToMany(targetEntity = AccountLog.class, fetch = FetchType.LAZY, mappedBy = "TYPE_ACCOUNT_ID", orphanRemoval = true, cascade = CascadeType.PERSIST)
    public Set<AccountLog> getAccountLog(){
        return accountLogs;
    }

    public void setAccountLog(Set<AccountLog> accountLogs){
        this.accountLogs = accountLogs;
    }

    public void setStart_Date(LocalDate start_Date) {

        this.Start_Date = start_Date;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TypeAccount that = (TypeAccount) o;
        return Objects.equals(Type_Account_Id, that.Type_Account_Id) && Objects.equals(mnemonic, that.mnemonic) && Objects.equals(Account_Name, that.Account_Name) && Objects.equals(Start_Date, that.Start_Date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Type_Account_Id, mnemonic, Account_Name, Start_Date);
    }

    @Override
    public String toString() {
        return "TypeAccount{" +
                "Type_Account_Id=" + Type_Account_Id +
                ", mnemonic='" + mnemonic + '\'' +
                ", Account_Name='" + Account_Name + '\'' +
                ", Start_Date=" + Start_Date +
                '}';
    }


}
