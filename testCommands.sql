use csedconnections;
insert into graduate values ("moaz1@gmail.com", "moaz" , "2000-02-23" , "M" , "01021695101" , "123456" ,"url" ,"Hi i am moaz","2023");
insert into graduate values ("omar@gmail.com", "moaz" , "2000-02-23" , "M" , "01021695102" , "123456" ,"url" ,"Hi i am moaz","2023");
insert into graduate values ("moaz3@gmail.com", "moaz" , "2000-02-23" , "M" , "01021695103" , "123456" ,"url" ,"Hi i am moaz","2023");
insert into graduate values ("moa4z@gmail.com", "moaz" , "2000-02-23" , "M" , "01021695104" , "123456" ,"url" ,"Hi i am moaz","2023");
insert into graduate values ("ahmed@gmail.com", "moaz" , "2000-02-23" , "M" , "01021695104" , "123456" ,"url" ,"Hi i am moaz","2023");
insert into graduate values ("abelrahman@gmail.com", "moaz" , "2000-02-23" , "M" , "01021695104" , "123456" ,"url" ,"Hi i am moaz","2023");

insert into experience values("moaz1@gmail.com" , "google" ,"silicon vally" ,"ceo" ,"2024","20--");
insert into experience values("omar@gmail.com" , "google" ,"silicon vally" ,"ceo" ,"2023","20--");
insert into experience values("abelrahman@gmail.com" , "facebook" ,"al atf" ,"ceo" ,"2024","20--");
insert into experience values("ahmed@gmail.com" , "apple" ,"silicon vally" ,"ceo" ,"2024","20--");

select graduate.name ,graduate.email ,graduate.imageURL,experience.company ,experience.location
from graduate JOIN experience 
on experience.email=graduate.email;
