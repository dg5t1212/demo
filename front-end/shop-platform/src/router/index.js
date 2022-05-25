import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'

const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView
  },
  {
    path: '/foodsMenu',
    name: 'FoodsMenuView',
    component: () => import('../views/FoodsMenuView.vue')
  },
  {
    path: '/resturantTwoColumn',
    name: 'ResturantTwoColumnView',
    component: () => import('../views/ResturantTwoColumnView.vue')
  },
  // {
  //   path: '/test',
  //   name: 'test',
  //   component: () => import(/* webpackChunkName: "about" */ '../views/TestView.vue')
  // },
  // {
  //   path: '/login',
  //   name: 'login',
  //   component: () => import(/* webpackChunkName: "about" */ '../views/LoginView.vue')
  // }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
