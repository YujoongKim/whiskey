<template>
  <div class="home">
    <h1>Home</h1>
    <router-link :to="{name: 'add-whiskey' }">
    <h1>Let's add new whiskey on your shelf!</h1>
    </router-link>
    
    
  </div>
</template>

<script>


export default {
 
  name: "home"
};
</script>
