package com.connect.backend.Controllers;

import com.connect.backend.DatabaseLayer.Database;

public class PostController {
    public void post(String email,String post){
        Database db = new Database();
        db.postdb(email,post);
    }
}
