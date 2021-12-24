import Vue from 'vue'
import Router from 'vue-router'
import SignIn from '@/components/SignIn'
import SignUpGraduate from '@/components/SignUpGraduate'
import SignUpStudent from '@/components/SignUpStudent'
import Start from '@/components/Start'


Vue.use(Router)

export default new Router({
    routes: [

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
        path: '/Start',
        name: 'Start',
        component: Start 
      },
    ]
  })
