<template>
<div class="header">
     <h2>Whiskey List</h2>

    <div class="whiskey-list" >
     
      <div class="whiskey" v-for = "whiskey in whiskeyList" v-bind:key="whiskey.id">
      Id : {{whiskey.id}}<br>
      Name : {{whiskey.name}}<br>
      Distiller : {{whiskey.distiller}}<br>
      Type : {{whiskey.type}}<br>
      Region : {{whiskey.region}}<br>
      Volume : {{whiskey.volume}}<br>
      Proof : {{whiskey.proof}}<br>
      Aged : {{whiskey.aged}}<br>
      Price : {{whiskey.price}}<br>

      <router-link :to="{name: 'update-whiskey', params:{ id:whiskey.id } }">Did you drink your whiskey?</router-link>
  
        </div>
     </div>
  </div>
</template>

<script>
import WhiskeyService from '../services/WhiskeyService.js';

export default {

    data() {
        return {
            whiskeyList: [],
        };
    },

    created() {
        WhiskeyService.getAllWhisky().then((response) => {
            this.whiskeyList=response.data
            })
        },
}
</script>

<style scoped>
.whiskey-list { 
   display: flex;
   flex-wrap: wrap;
   flex-direction: row;
    justify-content: space-around;
    align-items: center;
    align-content: center;
    background-color: brown;
    border-radius: 10px;
}

.whiskey {
    width: 300px;
    margin: 10px;
    background-color: rgb(243, 170, 115);
    text-align: left;
    padding-top: 10px;
    padding-bottom:10px;
    border-radius: 10px;
    padding-left: 1rem;
    padding-right: 1rem;
    display: flexbox;
    align-content: center;
  

  

}
</style>