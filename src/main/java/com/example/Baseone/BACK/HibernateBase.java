package com.example.Baseone.BACK;

import com.example.Baseone.MODEL.RecordModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class HibernateBase implements Strategy {
    String db_url;

    static final String JDBC_DRIVER = "org.postgresql.Driver";

    String user;

    String password;

    public HibernateBase(String db_url,String user,String password){
        this.user = user;
        this.password = password;
        this.db_url = db_url;


    }



    public void createconnection()  {

//        Statement statement = null;
//        try {
//            Class.forName(JDBC_DRIVER);
//            connection = DriverManager.getConnection(db_url, user, password);
//        }
//        catch(SQLException | ClassNotFoundException e) {
//            e.printStackTrace();
//        }
    }


    public ResponseEntity<List<RecordModel>> select() {
//        List<RecordModel> list = new ArrayList<>();
//        Statement stm = null;
//        try {
//            stm = connection.createStatement();
//            ResultSet rs = stm.executeQuery("select * from bruh");
//            System.out.println(rs);
//
//            while(rs.next()){
//                System.out.println(rs.getInt(1));
//                System.out.println(rs.getString(2));
//                System.out.println(rs.getString(3));
//
//                list.add(new RecordModel(rs.getInt(1),rs.getString(2),rs.getString(3)));
//
//            }
//
//
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//        return new ResponseEntity<List<RecordModel>>(list, HttpStatus.OK);
        return new ResponseEntity<List<RecordModel>>(HttpStatus.OK);

    }

    public void insert(String name, String data) {
//        Statement stm = null;
//        try {
//            stm = connection.createStatement();
//            stm.executeUpdate("insert into public.bruh (name,data) values ('" + name + "','" + data + "')");
//
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }

    }

    public void close() {
//        if (connection != null) {
//            try {
//                connection.close();
//            } catch (SQLException throwables) {
//                throwables.printStackTrace();
//            }
//        }
    }
}
