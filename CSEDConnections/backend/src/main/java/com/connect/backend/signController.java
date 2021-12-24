package com.connect.backend;

import com.fasterxml.jackson.core.JsonParser;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:8081")
@RequestMapping("api")
@RestController
public class signController {
    

/*
    @PostMapping("/signup")
    public String signup(@RequestBody String info) {
        JsonParser jsonObject = new JsonParser().parse(info).getAsJsonObject().get("body").getAsJsonObject();
        String email = jsonObject.get("email").getAsString();
        String password = jsonObject.get("pass1word").getAsString();
        String username = jsonObject.get("username").getAsString();
        String x = "";
        Gson gson = new Gson();
        String json = "";

        return info;
    }
*/
    @GetMapping("/signUp/graduate")
    public String SignUpGraduate(@RequestParam(value = "email")String email,
                        @RequestParam(value = "firstname")String firstname,
                        @RequestParam(value = "company")String company,
                        @RequestParam(value = "location")String location,
                        @RequestParam(value = "pass1word")String pass1word)
    {
        System.out.println(email + " " + company);
         return "true";
    }

    @GetMapping("/signUp/student")
    public String SignUpStudent(@RequestParam(value = "email")String email,
                        @RequestParam(value = "firstname")String firstname,
                        @RequestParam(value = "pass1word")String pass1word)
    {
        System.out.println(email + " " + email);
         return "true";
    }
/*
/*
    @PostMapping("/addContact")
    public String addContact(@RequestBody Contact contact)
    {
        return this.services.addContact(contact);
    }
*/


@GetMapping("/signin")
    public String Login(@RequestParam(value = "email")String Emailaddress,
                      @RequestParam(value = "pass1word")String password)
    { System.out.println("Name");
        //String access=this.services.login(Emailaddress,password);
        //this.services.getUser();
        String access = "7mada kofta";
        return access;
    }

}
