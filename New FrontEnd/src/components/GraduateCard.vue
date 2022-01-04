<template>
  <v-card @click="gotoDetails()">
    <v-img height="200" :src="img"></v-img>
    <v-card-text>
      <div class="card_title">{{ name }}</div>
      <div><b>Email: </b>{{ email }}</div>
      <div><b>Company: </b>{{ company }}</div>
      <div><b>Location: </b>{{ location }}</div>
    </v-card-text>
  </v-card>
</template>

<script>
import axios from 'axios'

export default {
  props: {
    img: { type: String, default: "/assets/anonymous-person.jpg" },
    name: { type: String, default: "NA" },
    email: { type: String, default: "NA" },
    company: { type: String, default: "NA" },
    location: { type: String, default: "NA" }
  },
  
  methods: {

    gotoDetails() {
      axios.get('http://localhost:8085/opengraduate',{
                params: {
                    email:this.email    
                }
            }).then(Response=>{
                const Data = Response.data;
                if(Data == "done"){
                   this.$router.push('/GraduateProfile');
                }
            });
   
       
    },
    
  },
};
</script>

<style>
.card_title {
  font-weight: bold;
  font-size: 16px;
  margin-bottom: 10px;
}
.card img {
  width: 100%;
  border-top-left-radius: 4px;
  border-top-right-radius: 4px;
  object-fit: cover;
  object-position: 50% 100%;
}
</style>