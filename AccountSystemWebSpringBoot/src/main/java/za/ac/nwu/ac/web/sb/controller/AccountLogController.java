package za.ac.nwu.ac.web.sb.controller;


import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.nwu.ac.domain.dto.AccountLogDto;
import za.ac.nwu.ac.domain.dto.AccountTypeDto;
import za.ac.nwu.ac.domain.persistence.AccountLog;
import za.ac.nwu.ac.domain.service.GeneralResponse;
import za.ac.nwu.ac.logic.flow.CreateAccountLogFlow;
import za.ac.nwu.ac.logic.flow.CreateAccountLogFlow;
import za.ac.nwu.ac.logic.flow.FetchAccountLogFlow;

import java.util.List;

@RestController
@RequestMapping("account-type")

public class AccountLogController {
    private FetchAccountLogFlow fetchAccountLogFlow;
    private  CreateAccountLogFlow createAccountLogFlow;
    private Object AccountLog;

    public AccountLogController(CreateAccountLogFlow createAccountLogFlow, FetchAccountLogFlow fetchAccountLogFlow) {
        this.fetchAccountLogFlow = fetchAccountLogFlow;
        this.createAccountLogFlow = createAccountLogFlow;
    }


        @PostMapping("")
        @ApiOperation(value = "Creates a new AccountLog.", notes = "Creates a new AccountLog in the DB.")
        @ApiResponses(value = {
                @ApiResponse(code = 200, message = "The AccountType was created successfully", response = GeneralResponse.class),
                @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
                @ApiResponse(code = 404, message = "Not found", response = GeneralResponse.class),
                @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})
        public ResponseEntity<GeneralResponse<AccountLogDto>> create(
                @ApiParam(value = "Request body to create a new AccountLog.", required = true)
                @RequestBody AccountLogDto AccountLog) {
            AccountLogDto AccountLogResponse = createAccountLogFlow.create(AccountLog);
            GeneralResponse<AccountLogDto> response = new GeneralResponse<>(true, AccountLogResponse);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        }

    @GetMapping("/all")
    @ApiOperation(value = "Gets all the configured Account Types", notes = "Returns a list of account Types")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Account types was returned", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Not found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})
    public ResponseEntity<GeneralResponse<List<AccountLogDto>>> getAll() {
        List<AccountLogDto> AccountLog = fetchAccountLogFlow.getAllAccountLogs();
        GeneralResponse<List<AccountLogDto>> response = new GeneralResponse<>(true, AccountLog);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

//    @GetMapping("{mnemonic}")
//    @ApiOperation(value = "Fetches the specified AccountType.", notes = "Fetches the AccountType corresponding to the given mnemonic.")
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "Goal found"),
//            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
//            @ApiResponse(code = 404, message = "Resource not found", response = GeneralResponse.class),
//            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class),
//    })
//    public ResponseEntity<GeneralResponse<AccountTypeDto>> getAccountType(
//            @ApiParam(value = "The mnemonic that uniquely identifies the AccountType.",
//            example = "MILES",
//            name = "mnemonic",
//            required = true)
//        @PathVariable("mnemonic") final String mnemonic){
//
//        AccountTypeDto acccountLog = fetchAccountLogFlow.getAccountTypeByMnemonic(mnemonic);
//
//        GeneralResponse<AccountTypeDto> response = new GeneralResponse<>(true , accountType);
//
//        return new ResponseEntity<>(response, HttpStatus.OK);
//    }


}
