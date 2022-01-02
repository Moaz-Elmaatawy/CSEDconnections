package com.connect.backend.Controllers;

public class DisplayedGrads {
  public String name, email, company, location, img;

  public DisplayedGrads(String n, String e, Experience ex, String i) {
    name = n;
    email = e;
    company = ex.companyName;
    location = ex.location;
    img = i;
  }

  public DisplayedGrads() {
  }
}
