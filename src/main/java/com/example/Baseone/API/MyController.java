package com.example.Baseone.API;


import com.example.Baseone.BACK.HibernateBase;
import com.example.Baseone.BACK.JDBCBase;
import com.example.Baseone.BACK.Strategy;
import com.example.Baseone.MODEL.RecordModel;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org. springframework. stereotype. Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org. springframework. web. bind. annotation. RequestMapping;
import org. springframework. web. bind. annotation. RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
public class MyController {

    @Autowired
    @Value("${user.password}")
    private String password;
    @Autowired
    @Value("${user.user}")
    private String user;
    @Autowired
    @Value("${user.db_url}")
    private String db_url;

    private Strategy dbo = null;

    @RequestMapping(value = "/records", method = RequestMethod. GET)
    public ResponseEntity<List<RecordModel>> retjson(){
        if (dbo == null) {
            dbo = new JDBCBase(db_url,user,password);
        }
        dbo.createconnection();
        ResponseEntity<List<RecordModel>> res = dbo.select();

        dbo.close();
        return res;
    }

    @RequestMapping(value = "/records", method = RequestMethod. POST)
    public void postjson(@RequestBody RecordModel o){
        String r = o.toString();
        System.out.println(r);

        if (dbo == null) {
            dbo = new JDBCBase(db_url,user,password);
        }

        dbo.createconnection();

        dbo.insert(o.getName(), o.getData());
        dbo.close();

    }
    @RequestMapping(value = "/strategy", method = RequestMethod. POST)
    public void strategyswitch(String str){

        if (str.toUpperCase().equals("JDBC")) {
            dbo = new JDBCBase(db_url,user,password);
            dbo.createconnection();
            dbo.close();
        }
        else if (str.toUpperCase().equals("HIBER")) {
            dbo = new HibernateBase(db_url,user,password);

        }


    }

}

