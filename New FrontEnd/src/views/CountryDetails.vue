<template>
  <v-container>
    <v-row
      ><v-col
        ><v-btn class="btn" @click="goBack"
          ><v-icon>mdi-arrow-left</v-icon> Back</v-btn
        ></v-col
      ></v-row
    >
    <v-row>
      <v-col md="6" sm="12" xs="12">
        <v-img :src="country.flag"></v-img>
      </v-col>
      <v-col md="6" sm="12" xs="12" class="pa-2">
        <div class="mt-8">
          <h2>{{ country.name }}</h2>
          <v-row class="mt-3">
            <v-col lg="12" md="12" sm="12" xs="12">
              <div
                :class="`d-flex justify-space-between flex-wrap `"
                style="height: 100%"
              >
                <div>
                  <div>
                    <b>Native Name: </b
                    >{{ country.nativeName ? country.nativeName : "NA" }}
                  </div>
                  <div>
                    <b>Population: </b
                    >{{ country.population | numberFormatter }}
                  </div>
                  <div><b>Region: </b>{{ country.region }}</div>
                  <div><b>Sub Region: </b>{{ country.subregion }}</div>
                  <div><b>Capital: </b>{{ country.capital }}</div>
                </div>
                <div>
                  <div>
                    <b>Top Level Domain: </b
                    ><span
                      class="mr-2"
                      v-for="domain in country.topLevelDomain"
                      :key="domain"
                      >{{ domain }}</span
                    >
                  </div>
                  <div>
                    <b>Currencies: </b
                    ><span
                      class="mr-2"
                      v-for="currency in country.currencies"
                      :key="currency.code"
                      >{{ country.name }}</span
                    >
                  </div>
                  <div>
                    <b>Languages: </b
                    ><span
                      class="mr-2"
                      v-for="language in country.languages"
                      :key="language.name"
                      >{{ language.name }}
                    </span>
                  </div>
                </div>
              </div>
            </v-col>
          </v-row>
          <div class="mt-2">
            Border Countries:
            <span>
              <v-btn
                class="mr-2 mb-2"
                v-for="border in country.borders"
                @click="getBorder(border)"
                :key="border"
                >{{ border }}</v-btn
              >
            </span>
          </div>
        </div>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
export default {
  data() {
    return {
      country: {},
      code: null,
    };
  },
  mounted() {
    this.init();
  },
  methods: {
    init() {
      if (this.$route.params.code) {
        let data = atob(this.$route.params.code);
        this.code = data;
        this.getCountryDetails();
      }
    },
    getCountryDetails() {
      this.$http
        .get(`alpha/${this.code}`)
        .then((response) => {
          if (response.status == 200) {
            const data = response.data;
            this.country = data;
          }
        })
        .catch((error) => {
          console.log(error);
        });
    },
    goBack() {
      this.$router.push({
        name: "Home",
      });
    },
    getBorder(border) {
      this.code = border;
      this.getCountryDetails();
    },
  },
};
</script>

<style>
</style>