package com.atossyntel.webapi;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atossyntel.connection.UserDAO;
import com.atossyntel.entities.User;
import java.util.Map;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
public class Controller {

    @RequestMapping("/hello")
    public String display() throws JSONException {
        UserDAO createuser = new UserDAO();
        User user = createuser.getUser("Christopher_Foose@Syntelinc.com");
        JSONObject json = new JSONObject();
        json.put("username", user.getUserId());
        return json.toString();
    }
    @CrossOrigin
    @RequestMapping(value = "/process", method = RequestMethod.POST)
    public void process(@RequestBody Map<String, Object> payload)
            throws Exception {
        System.out.println("hello");
        System.out.println(payload);
    }
}
