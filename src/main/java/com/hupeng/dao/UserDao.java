package com.hupeng.dao;

import com.hupeng.model.User;
import com.mysql.cj.xdevapi.Result;

import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserDao implements IUserDao {
    @Override
    public boolean saveUser(Connection con, User user) throws SQLException {
        //insert
        String sql="INSERT INTO usertable" +
                "VALUES("+user.getId()+","+user.getBirthDate()+","+user.getUsername()+","
        +user.getPassword()+","+user.getEmail()+","+user.getGender()+")";
        PreparedStatement st=con.prepareStatement(sql);
       /* int result=st.*/
        return false;
    }

    @Override
    public int deleteUser(Connection con, User user) throws SQLException {
        //delete where id=?
        String sql="delete * from usertable where ID='"+user.getId()+"'";
        PreparedStatement st=con.prepareStatement(sql);
        int result=st.executeUpdate(sql);
        return result;
    }

    @Override
    public int updateUser(Connection con, User user) throws SQLException {
        //update where id=?
        String sql="update usertable set Username='"+user.getUsername()+"'"+"Gender='"+user.getGender()+"'"+"Password='"+user.getPassword()
                +"'"+"Email='"+user.getEmail()+"'"+"Birthdate='"+user.getBirthDate()+"'"+"where ID='"+user.getId()+"'";
        PreparedStatement st=con.prepareStatement(sql);
        int result=st.executeUpdate();
        return result;
    }

    @Override
    public User findById(Connection con, Integer id) throws SQLException {
        String sql="select * from usertable where ID='"+id+"'";
        PreparedStatement st=con.prepareStatement(sql);
        ResultSet result=st.executeQuery();
        User user=null;
        while(result.next()){
            user=new User();
            user.setId(result.getInt("ID"));
            user.setUsername(result.getString("UserName"));
            user.setPassword(result.getString("Password"));
            user.setEmail(result.getString("Email"));
            user.setGender(result.getString("Gender"));
            user.setBirthDate(result.getDate("Birthdate"));
        }
        return user;
    }

    @Override
    public User findByUsernamePassword(Connection con, String username, String password) throws SQLException {
        //select where username=?and password=?
        String sql="select * from usertable where UserName='"+username+"'and Password='"+password+"'";
        PreparedStatement st=con.prepareStatement(sql);
        ResultSet result=st.executeQuery();
        User user=null;
        if(result.next()){
            user=new User();
            user.setId(result.getInt("ID"));
            user.setUsername(result.getString("UserName"));
            user.setPassword(result.getString("Password"));
            user.setEmail(result.getString("Email"));
            user.setGender(result.getString("Gender"));
            user.setBirthDate(result.getDate("Birthdate"));
        }

        return user;
    }

    @Override
    public List<User> findByUsername(Connection con, String username) throws SQLException {
        String sql="select * from usertable where UserName='"+username+"'";
        PreparedStatement st=con.prepareStatement(sql);
        ResultSet result=st.executeQuery();
        List<User> users=new ArrayList<>();
        while(result.next()){
            User user=new User();
            user.setId(result.getInt("ID"));
            user.setUsername(result.getString("UserName"));
            user.setPassword(result.getString("Password"));
            user.setEmail(result.getString("Email"));
            user.setGender(result.getString("Gender"));
            user.setBirthDate(result.getDate("Birthdate"));
            users.add(user);
        }
        return users;
    }

    @Override
    public List<User> findByPassword(Connection con, String password) throws SQLException {
        String sql="select * from usertable where Password='"+password+"'";
        PreparedStatement st=con.prepareStatement(sql);
        ResultSet result=st.executeQuery();
        List<User> users=new ArrayList<>();
        while(result.next()){
            User user=new User();
            user.setId(result.getInt("ID"));
            user.setUsername(result.getString("UserName"));
            user.setPassword(result.getString("Password"));
            user.setEmail(result.getString("Email"));
            user.setGender(result.getString("Gender"));
            user.setBirthDate(result.getDate("Birthdate"));
            users.add(user);
        }
        return users;
    }

    @Override
    public List<User> findByEmail(Connection con, String email) throws SQLException {
        String sql="select * from usertable where Email='"+email+"'";
        PreparedStatement st=con.prepareStatement(sql);
        ResultSet result=st.executeQuery();
        List<User> users=new ArrayList<>();
        while(result.next()){
            User user=new User();
            user.setId(result.getInt("ID"));
            user.setUsername(result.getString("UserName"));
            user.setPassword(result.getString("Password"));
            user.setEmail(result.getString("Email"));
            user.setGender(result.getString("Gender"));
            user.setBirthDate(result.getDate("Birthdate"));
            users.add(user);
        }
        return users;
    }

    @Override
    public List<User> findByGender(Connection con, String gender) throws SQLException {
        String sql="select * from usertable where Gender='"+gender+"'";
        PreparedStatement st=con.prepareStatement(sql);
        ResultSet result=st.executeQuery();
        List<User> users=new ArrayList<>();
        while(result.next()){
            User user=new User();
            user.setId(result.getInt("ID"));
            user.setUsername(result.getString("UserName"));
            user.setPassword(result.getString("Password"));
            user.setEmail(result.getString("Email"));
            user.setGender(result.getString("Gender"));
            user.setBirthDate(result.getDate("Birthdate"));
            users.add(user);
        }
        return users;
    }

    @Override
    public List<User> findByBirthdate(Connection con, Date birthDate) throws SQLException {
        String sql="select * from usertable where Birthday='"+birthDate+"'";
        PreparedStatement st=con.prepareStatement(sql);
        ResultSet result=st.executeQuery();
        List<User> users=new ArrayList<>();
        while(result.next()){
            User user=new User();
            user.setId(result.getInt("ID"));
            user.setUsername(result.getString("UserName"));
            user.setPassword(result.getString("Password"));
            user.setEmail(result.getString("Email"));
            user.setGender(result.getString("Gender"));
            user.setBirthDate(result.getDate("Birthdate"));
            users.add(user);
        }
        return users;
    }

    @Override
    public List<User> findAllUser(Connection con) throws SQLException {
        String sql="select * from usertable";
        PreparedStatement st=con.prepareStatement(sql);
        ResultSet result=st.executeQuery();
        List<User> users=new ArrayList<>();
        while(result.next()){
            User user=new User();
            user.setId(result.getInt("ID"));
            user.setUsername(result.getString("UserName"));
            user.setPassword(result.getString("Password"));
            user.setEmail(result.getString("Email"));
            user.setGender(result.getString("Gender"));
            user.setBirthDate(result.getDate("Birthdate"));
            users.add(user);
        }
        return users;
    }
}
