package com.model.bo;

import com.model.bean.Account;
import com.model.dao.AccountDAO;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class AccountBO {
    AccountDAO accountDAO;
    public AccountBO(){
        accountDAO = new AccountDAO();
    }
    public boolean checkLogin(String username,String password){
        List<Account> accounts = accountDAO.getAllAccount();
        for(Account i: accounts){
            if(password.equals(i.password) && username.equals(i.username))
                return true;
        }
        return false;
    }
    public List<Account> getAllAccounts(){
        return accountDAO.getAllAccount();
    }
    public Account getAccountById(int id){
        return accountDAO.getAccountbyId(id);
    }
    public List<Account> getAccountsbyFind(String search){
        List<Account> accounts = accountDAO.getAllAccount();
        List<Account> accountList = new ArrayList<>();
        for(Account i: accounts){
            if(((i.firstname+i.lastname).toLowerCase()).equals(search.toLowerCase()))
                accountList.add(i);
        }
        return accountList;
    }
    public Account getAccountByUsername(String username){
        List<Account> accounts = accountDAO.getAllAccount();
        for(Account i: accounts){
            if(username.equals(i.username))
                return i;
        }
        return null;
    }
    public boolean addNewAccount(Account account){
        return accountDAO.addNewAccount(account);
    }
    public boolean updateAccount(Account account){
        return accountDAO.updateAccount(account);
    }
    public boolean updateRole(int id, boolean role){
        Account account = accountDAO.getAccountbyId(id);
        account.role = role;
        return accountDAO.updateAccount(account);
    }
    public boolean deleteAccount(int id){
        return accountDAO.deleteAccount(id);
    }
}
