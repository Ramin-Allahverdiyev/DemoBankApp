package com.example.demoBankApp.mapper;

import com.example.demoBankApp.dto.request.AccountRequest;
import com.example.demoBankApp.dto.response.AccountResponse;
import com.example.demoBankApp.entity.Account;
import com.example.demoBankApp.entity.Branch;
import com.example.demoBankApp.entity.Client;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-03-01T11:52:02+0400",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.5.jar, environment: Java 20.0.1 (Oracle Corporation)"
)
public class AccountMapperImpl extends AccountMapper {

    @Override
    public Account dtoToEntity(AccountRequest request) {
        if ( request == null ) {
            return null;
        }

        Account.AccountBuilder account = Account.builder();

        if ( request != null ) {
            account.branch( accountRequestToBranch( request ) );
        }
        if ( request != null ) {
            account.client( accountRequestToClient( request ) );
        }
        if ( request.getAmount() != null ) {
            account.amount( request.getAmount() );
        }
        if ( request.getIBAN() != null ) {
            account.IBAN( request.getIBAN() );
        }
        if ( request.getCurrencyName() != null ) {
            account.currencyName( request.getCurrencyName() );
        }
        if ( request.getAccountName() != null ) {
            account.accountName( request.getAccountName() );
        }

        return account.build();
    }

    @Override
    public void dtoToEntity(Account account, AccountRequest request) {
        if ( request == null ) {
            return;
        }

        if ( account.getBranch() == null ) {
            account.setBranch( Branch.builder().build() );
        }
        accountRequestToBranch1( request, account.getBranch() );
        if ( account.getClient() == null ) {
            account.setClient( Client.builder().build() );
        }
        accountRequestToClient1( request, account.getClient() );
        if ( request.getAmount() != null ) {
            account.setAmount( request.getAmount() );
        }
        if ( request.getIBAN() != null ) {
            account.setIBAN( request.getIBAN() );
        }
        if ( request.getCurrencyName() != null ) {
            account.setCurrencyName( request.getCurrencyName() );
        }
        if ( request.getAccountName() != null ) {
            account.setAccountName( request.getAccountName() );
        }
    }

    @Override
    public AccountResponse entityToDto(Account account) {
        if ( account == null ) {
            return null;
        }

        AccountResponse.AccountResponseBuilder accountResponse = AccountResponse.builder();

        Integer id = accountBranchId( account );
        if ( id != null ) {
            accountResponse.branchId( id );
        }
        Integer id1 = accountClientId( account );
        if ( id1 != null ) {
            accountResponse.clientId( id1 );
        }
        if ( account.getAmount() != null ) {
            accountResponse.amount( account.getAmount() );
        }
        if ( account.getIBAN() != null ) {
            accountResponse.IBAN( account.getIBAN() );
        }
        if ( account.getCurrencyName() != null ) {
            accountResponse.currencyName( account.getCurrencyName() );
        }
        if ( account.getAccountName() != null ) {
            accountResponse.accountName( account.getAccountName() );
        }

        return accountResponse.build();
    }

    @Override
    public List<AccountResponse> entityListToDtoList(List<Account> accounts) {
        if ( accounts == null ) {
            return null;
        }

        List<AccountResponse> list = new ArrayList<AccountResponse>( accounts.size() );
        for ( Account account : accounts ) {
            list.add( entityToDto( account ) );
        }

        return list;
    }

    protected Branch accountRequestToBranch(AccountRequest accountRequest) {
        if ( accountRequest == null ) {
            return null;
        }

        Branch.BranchBuilder branch = Branch.builder();

        if ( accountRequest.getBranchId() != null ) {
            branch.id( accountRequest.getBranchId() );
        }

        return branch.build();
    }

    protected Client accountRequestToClient(AccountRequest accountRequest) {
        if ( accountRequest == null ) {
            return null;
        }

        Client.ClientBuilder client = Client.builder();

        if ( accountRequest.getClientId() != null ) {
            client.id( accountRequest.getClientId() );
        }

        return client.build();
    }

    protected void accountRequestToBranch1(AccountRequest accountRequest, Branch mappingTarget) {
        if ( accountRequest == null ) {
            return;
        }

        if ( accountRequest.getBranchId() != null ) {
            mappingTarget.setId( accountRequest.getBranchId() );
        }
    }

    protected void accountRequestToClient1(AccountRequest accountRequest, Client mappingTarget) {
        if ( accountRequest == null ) {
            return;
        }

        if ( accountRequest.getClientId() != null ) {
            mappingTarget.setId( accountRequest.getClientId() );
        }
    }

    private Integer accountBranchId(Account account) {
        if ( account == null ) {
            return null;
        }
        Branch branch = account.getBranch();
        if ( branch == null ) {
            return null;
        }
        Integer id = branch.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Integer accountClientId(Account account) {
        if ( account == null ) {
            return null;
        }
        Client client = account.getClient();
        if ( client == null ) {
            return null;
        }
        Integer id = client.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
