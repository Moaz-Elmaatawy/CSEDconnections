<template>
  
    <div >
        <a>Your Announcement</a>
        <br>
        <textarea id="txt" v-model="post" placeholder="Your Post"></textarea>
        <br>
         <button class="button" @click=Post()>Post Announcement</button>
          
    </div>
    
</template>

<script>
import axios from 'axios';
export default {
  name: "App",
  
  data() {
    return {      
      post: '',
    }
  },
  methods: {
      Post(){
          axios.get('http://localhost:8085/post',{
            params: {
              post:this.post
            }
        })
      }
  }
};
</script>
<style>

#txt{

 width: 50%;
  height: 200px;
  padding: 12px 20px;
  box-sizing: border-box;
  border: 2px solid #ccc;
  border-radius: 4px;
  background-color: #f8f8f8;
  font-size: 16px;
  resize: none;
  

}
.button {
  background-color: #3c3fcf; 
  border: none;
  color: white;
  padding: 15px 32px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
 
  cursor: pointer;
}
</style>
