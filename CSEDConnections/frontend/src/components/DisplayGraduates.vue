<template>
 <div id="container"> 
   
    
    
     <h1 >Products</h1> 
     
    <div class="category">
    <div id="categorycontainer" v-for="graduate in graduates" :key="graduate.graduatename">
      <img id="img" :src="graduate.imgpath"/>
      <br>
       <a id="a2"  >{{graduate.graduatename}}</a>
        <br>
        <a id="a1">${{graduate.name}}</a>
        <br>
        <a id="a1">${{graduate.company}}</a>
        
   
    </div>  
    </div>
  </div>
</template>

<script>
  import axios from 'axios'
export default {
   data() {
    return {
     graduates:[],
      msg:'',
      productname: '',
      tempproducts : []
      
    }
  },
  methods: {  
    
  },
 
  mounted(){
      //when the page loads we call the api 
      //to get graduates data retrieved from database
      
        axios.post("http://localhost:8085/get_graduates")
        .then(response =>{ 
         if(response.data.length>0){
              for (var i = 0; i < response.data.length; i++){
                  var obj = response.data[i]
                  this.graduates.push(obj)
                } 
                
         }
        });  
  }
}
</script>

<style>
#a1{
  text-decoration: underline;
  cursor: pointer;
}
#img{
    object-fit: cover;
      object-fit: fill;
    cursor: pointer;
    height: 250px;
    width: 450px;
   
}
#categorycontainer{
 
    border: 1.7px;
    border-style: solid;
}
.category{
    display: grid;
  
    grid-column-gap: 10px;
    grid-row-gap: 10px;
    grid-template-columns: 1fr 1fr 1fr;
   
}
#container{
    background-color: darkkhaki;
}
#a2{
    font-size: 30px; 
    color:rgb(37, 115, 192);
    cursor: pointer;   
}
#a1{
    font-size: 22px; 
    color: rgb(227, 236, 248) ;
      
}
#h1{
    padding-right: 1400px;
}
#img2{
   
   padding-right: 1300px;
   object-fit: cover;
      object-fit: fill;
    width: 50px;
    height: 50px;
    cursor: pointer;
}
.input{
    width: 35%;
    height: 25px;
    border:2px solid cornflowerblue;
    border-radius: 6px;

}

</style>
