import Vue from "vue";
import VueRouter from "vue-router";

import Home from "../views/Home";
import GraduateDetails from "../views/GraduateDetails";
import NotFound from "../views/NotFound";
import SignIn from '@/components/SignIn'
import SignUpGraduate from '@/components/SignUpGraduate'
import SignUpStudent from '@/components/SignUpStudent'
import Start from '@/components/Start'

Vue.use(VueRouter);

const routes = [
  {
    path: '/GraduateProfile',
    name: 'GraduateProfile',
    component: GraduateProfile
  },
  //Login
  {
    name: "Home",
    path: "/Home",
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
    path: "/details",
    component: GraduateDetails,
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
  {
    path: '/SignIn',
    name: 'SignIn',
    component: SignIn
  },
  {
    path: '/SignUpGraduate',
    name: 'SignUpGraduate',
    component: SignUpGraduate
  },
  {
    path: '/SignUpStudent',
    name: 'SignUpStudent',
    component: SignUpStudent 
  },
  {
    path: '/',
    name: 'Start',
    component: Start 
  },

];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes,
});

export default router;
