<template>
  <v-container>
    <v-row>
      <v-col>
        <v-text-field
          label="Search"
          v-model="search"
          solo
          prepend-inner-icon="mdi-magnify"
          clearable
          @click:clear="clearSearch"
        >
        </v-text-field
      ></v-col>
      <v-spacer class="d-none d-md-flex d-lg-flex"></v-spacer>
      <v-col>
        <v-select
          v-model="region"
          @change="regionChange"
          label="Filter by region"
          :items="regions"
          item-text="name"
          item-value="code"
          solo
          clearable
        >
        </v-select>
      </v-col>
    </v-row>
    <v-row>
      <v-col v-for="graduate in graduates" :key="graduate.email" md="3">
        <country-card v-bind="graduate"></country-card>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
import CountryCard from "../components/CountryCard.vue";
import axios from 'axios';
export default {
  name: "Home",
  components: {
    "country-card": CountryCard,
  },
  data() {
    return {
      graduates:[],
      name: '',
      search: null,
      region: null,
      regions: ["Africa", "Americas", "Asia", "Europe", "Oceania"],
      
    };
  },
  mounted() {
    this.getGraduates();
  },

  watch: {
    
    search: {
      immediate: true,
      handler(val) {
        if (val) {
          this.region = null;
          this.getGraduates();
        }
      },
    },
    
  },
  methods: {
  
    regionChange() {
      this.search = null;
      this.getGraduates();
    },
    clearSearch() {
      setTimeout(() => {
        this.search = null;
        this.getGraduates();
      }, 100);
    },
    
    getGraduates() {
      //when the page loads we call the api 
      //to get graduates data retrieved from database
      
      axios.post('http://localhost:8085/get_graduates',{
          })
          .then(Response =>  {
            this.graduates.length=0;
            for (var i = 0; i < Response.data.length; i++){
              var obj = Response.data[i]
              this.graduates.push(obj)
            }
        });
    },
  },
};
</script>
