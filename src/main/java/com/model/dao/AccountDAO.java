package com.model.dao;

import com.model.bean.Account;
import com.model.bo.AccountBO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccountDAO {
    Statement stmt;
    public AccountDAO(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test888","root","");
            stmt = con.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public List<Account> getAllAccount(){
        List<Account> accounts = new ArrayList<>();
        try {
            String sql = "select * from account";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){
                accounts.add(new Account(
                        rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("firstname"),
                        rs.getString("lastname"),
                        rs.getBoolean("role")
                ));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return accounts;
    }
    public Account getAccountbyId(int id){
        try {
            String sql = "select * from account where id="+id;
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){
                return new Account(
                        rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("firstname"),
                        rs.getString("lastname"),
                        rs.getBoolean("role")
                );
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
    public boolean addNewAccount(Account account){
        String sql = "INSERT INTO `account`(`username`, `password`, `firstname`, `lastname`, `role`) " +
                    "VALUES ('"+account.username+"','"+account.password+"','"+account.firstname+"'" +
                    ",'"+account.lastname+"',"+account.role+")";
        try {
            return stmt.execute(sql);
        } catch (SQLException throwables) {
            System.out.println("Error in AccountDao line 67 "+throwables.getMessage());
        }
        return false;
    }
    public boolean updateAccount(Account account){
        String sql = "UPDATE `account` SET `username`='"+account.username+"',`password`='"+account.password+"'," +
                    "`firstname`='"+account.firstname+"',`lastname`='"+account.lastname+"',`role`="+account.role+" WHERE id="+account.getId();
        try {
            return stmt.execute(sql);
        } catch (SQLException throwables) {
            System.out.println("Error in AccountDao line 77 "+throwables.getMessage());
        }
        return false;
    }
    public boolean deleteAccount(int id){
        String sql = "DELETE FROM `account` WHERE id="+id;
        try {
            return stmt.execute(sql);
        } catch (SQLException throwables) {
            System.out.println("Error in AccountDao line 86 "+throwables.getMessage());
        }
        return false;
    }

}
