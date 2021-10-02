package za.ac.nwu.ac.domain.dto;


import io.swagger.annotations.ApiModelProperty;
import za.ac.nwu.ac.domain.persistence.AccountLog;
import za.ac.nwu.ac.domain.persistence.TypeAccount;
import io.swagger.annotations.ApiModel;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;
import java.time.LocalDate;
import java.util.Objects;

@ApiModel(value = "AccountType", description = "a Dto that represents AccountType")
public class AccountTypeDto{



    private String mnemonic;
        private String Account_Name;
        private LocalDate Start_Date;

        private Set<AccountLog> accountLogs;



        public AccountTypeDto(String mnemonic, String account_Name, LocalDate start_Date) {
            this.mnemonic = mnemonic;
            this.Account_Name = account_Name;
            this.Start_Date = start_Date;
        }

        public AccountTypeDto(TypeAccount typeAccount) {
            this.setAccount_Name(typeAccount.getAccount_Name());
            this.setStart_Date(typeAccount.getStart_Date());
            this.setMnemonic(typeAccount.getMnemonic());
        }
    public AccountTypeDto() {
    }

    @ApiModelProperty(position = 1,
            value = "AccountType Mnemonic",
            name = "Mnemonic",
            notes = "Uniquely identifies the account type",
            dataType = "java.lang.String",
            example = "MILES",
            required = true)

    public String getMnemonic() {
        return mnemonic;
    }

    public void setMnemonic(String mnemonic) {
        this.mnemonic = mnemonic;
    }


    @ApiModelProperty(position = 2,
            value = "AccountType Name",
            name = "Name",
            notes = "The name of the AccountType",
            dataType = "java.lang.String",
            example = "Miles",
            allowEmptyValue = false,
            required = true)

    public String getAccount_Name() {
        return Account_Name;
    }
    public void setAccount_Name(String account_Name) {
            Account_Name = account_Name;
        }

    @ApiModelProperty(position = 3,
            value = "AccountType Creation Date",
            name = "CreationDate",
            notes = "This is the date on which the AccountType was created",
            dataType = "java.lang.String",
            example = "2020-01-01",
            allowEmptyValue = true,
            required = false)

    public LocalDate getStart_Date() {
        return Start_Date;
    }

    public void setStart_Date(LocalDate start_Date) {
        Start_Date = start_Date;
    }


    @JsonIgnore
    public TypeAccount getAccountType(){
        return new TypeAccount(getMnemonic(),getAccount_Name(), getStart_Date());
    }


        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            TypeAccount that = (TypeAccount) o;
            return Objects.equals(mnemonic, that.getMnemonic()) && Objects.equals(Account_Name, that.getAccount_Name()) && Objects.equals(Start_Date, that.getStart_Date());
        }



        @Override
        public int hashCode() {
            return Objects.hash(mnemonic, Account_Name, Start_Date);
        }

        @Override
        public String toString() {
            return "AccountTypeDto{" +
                    "mnemonic='" + mnemonic + '\'' +
                    ", Account_Name='" + Account_Name + '\'' +
                    ", Start_Date=" + Start_Date +
                    '}';
        }
    }



