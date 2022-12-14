<template>
  <div id="app">
<<<<<<< HEAD
    <div id="nav">
      <router-link v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp;
=======
    <div id="nav" class="navigation">
      <router-link v-bind:to="{ name: 'home' }"
        ><i class="fa fa-home" aria-hidden="true"></i></router-link
      >&nbsp;|

>>>>>>> a51380b5b8cd19b2ed0fd3ddf07a1a4745343943
      <router-link
        v-bind:to="{ name: 'logout' }"
        v-if="$store.state.token != ''"
        ><i class="fa fa-sign-out" aria-hidden="true"></i>
      </router-link>
    </div>
    <router-view />
  </div>
</template>
<style scoped>
.navigation {
  text-decoration: none;
}
</style>
