import Vue from "vue";
import VueRouter from "vue-router";

import Home from "../views/Home";
import CountryDetails from "../views/CountryDetails";
import NotFound from "../views/NotFound";

Vue.use(VueRouter);

const routes = [
  //Login
  {
    name: "Home",
    path: "/",
    component: Home,
    meta: {
      item: null,
      module: {
        id: null,
      },
      title: "Home",
    },
  },
  {
    name: "Details",
    path: "/details/:code",
    component: CountryDetails,
    meta: {
      item: null,
      module: {
        id: null,
      },
      title: "Details",
    },
  },
  //404
  {
    name: "NotFound",
    path: "*",
    component: NotFound,
    meta: {
      item: null,
      module: {
        id: null,
      },
      title: "Not FOund",
    },
  },
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes,
});

export default router;
