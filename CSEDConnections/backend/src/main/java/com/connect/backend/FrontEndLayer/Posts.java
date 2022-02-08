package com.connect.backend.FrontEndLayer;

import java.util.List;

import com.connect.backend.Controllers.DisplayController;
import com.connect.backend.Controllers.DisplayedGrads;
import com.connect.backend.Controllers.Graduate;
import com.connect.backend.Controllers.PostController;
import com.connect.backend.DatabaseLayer.Database;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController

public class posts {
    @GetMapping("/post")
    public void post(@RequestParam(value = "post") String post) {
        
        PostController postController = new PostController() ;
        postController.post(new Sign().getuser(),post);
   
    }
    
    
}
