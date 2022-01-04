package com.connect.backend.Controllers;

public class SignController {
    private char type;

    public SignController(char t) {
        type = t;
    }

    public boolean signIn(String email, String password) {
        Data data = new Data(type);
        return data.checkSignIn(email, password);
    }

    public int signUp(Graduate newGrad) {
        Data data = new Data(type);
        if (data.existsBefore(newGrad.mail))
            return 2;
        if (data.createnewGrad(newGrad))
            return 0;
        return 1;
    }

    public int signUp(Student newStudent) {
        Data data = new Data(type);
        if (data.existsBefore(newStudent.mail))
            return 2;
        if (data.createnewStudent(newStudent))
            return 0;
        return 1;
    }

}
