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
          v-model="Company"
          @change="CompanyChange"
          label="Filter by Company"
          :items="Companies"
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
        <graduate-card v-bind="graduate"></graduate-card>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
import GraduateCard from "../components/GraduateCard.vue";
import axios from 'axios';

export default {
  name: "Home",
  components: {
    "graduate-card": GraduateCard,
  },
  data() {
    return {
      graduates:[],
      name: '',
      search: "",
      company: null,
      Companies: ["company_1", "company_2", "company_3", "company_4", "company_5"],
      
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
          this.Company = null; 
        }
        this.getGraduates();
      },
    },
    
  },
  methods: {
  
    CompanyChange() {
      this.search = "";
      this.getGraduates();
    },
    clearSearch() {
      setTimeout(() => {
        this.search = "";
        this.getGraduates();
      }, 10);
    },
    
    getGraduates() {
      //when the page loads we call the api 
      //to get graduates data retrieved from database
      
      axios.get('http://localhost:8085/get_graduates',{
            params: {
              Search:this.search
            }
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
