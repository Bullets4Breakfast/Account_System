package za.ac.nwu.ac.translator.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import za.ac.nwu.ac.domain.dto.AccountTypeDto;
import za.ac.nwu.ac.domain.persistence.TypeAccount;
import za.ac.nwu.ac.repo.persistence.AccountTypeRepository;
import za.ac.nwu.ac.translator.AccountTypeTranslator;

import java.util.ArrayList;
import java.util.List;

@Transactional
//@ComponentScan(basePackages = {"za.ac.nwu.ac.repo"})
@Component
public class AccountTypeTranslatorImpl implements AccountTypeTranslator {



    private final AccountTypeRepository accountTypeRepository;

    @Autowired
    public AccountTypeTranslatorImpl(AccountTypeRepository accountTypeRepository){
        this.accountTypeRepository = accountTypeRepository;
    }

    @Override
    public List<AccountTypeDto> getAllAccountTypes(){

        List<AccountTypeDto> accountTypeDtos = new ArrayList<>();
        try {
            for (TypeAccount typeAccount : accountTypeRepository.findAll()){
                accountTypeDtos.add(new AccountTypeDto(typeAccount));
            }
        }catch (Exception e){
            // TODO: Log
            throw new RuntimeException("Unable to read from the DB", e);
        }
        return accountTypeDtos;
    }



    @Override
    public AccountTypeDto create(AccountTypeDto accountTypeDto){
        try {
            TypeAccount accountType = accountTypeRepository.save(accountTypeDto.getAccountType());
            return new AccountTypeDto(accountType);
        }catch (Exception e){
            throw new RuntimeException("Unable to save to the DB",e);
        }


    }

    @Override
    public AccountTypeDto getAccountTypeByMnemonicNativeQuery(String mnemonic){
        try {
            TypeAccount typeAccount = accountTypeRepository.getAccountTypeByMnemonicNativeQuery(mnemonic);
            return new AccountTypeDto(typeAccount);
        }catch (Exception e){
            throw new RuntimeException("Unable to read from DB", e);
        }
    }
//
//    @Override
//    public AccountTypeDto getAccountTypeByMnemonic(String mnemonic){
//        try {
//            TypeAccount typeAccount = accountTypeRepository.getAccountTypeByMnemonic(mnemonic);
//            return new AccountTypeDto(typeAccount);
//        }catch (Exception e){
//            throw new RuntimeException("unable to read from DB", e);
//        }
//
//    }
//
//
//    @Override
//    public AccountTypeDto getAccountTypeDtoByMnemonic(String mnemonic){
//        try {
//            return accountTypeRepository.getAccountTypeDtoByMnemonic(mnemonic);
//        }catch (Exception e){
//            throw new RuntimeException("unable to read from DB", e);
//        }
//
//    }



}
