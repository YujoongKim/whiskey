<template>
  <div class="add-whiskey">
      <form class = "whiskey-form" v-on:submit.prevent>
        <h1 class="whiskey-header"> Add New Whiskey </h1>
        <br>
        <label for = "Whiskey"> Name : </label>
        <input class = "whiskey-name"
          type="text"
          placeholder="name"
          required
          v-model = "whiskey.name"
          />
          <br>
        <label for = "Whiskey"> Distiller : </label>
        <input class = "whiskey-distiller"
          type="text"
          placeholder="distiller"
          required
          v-model = "whiskey.distiller"
          />
          <br>
        <label for = "Whiskey"> Whiskey Type : </label>
           <input class = "whiskey-type"
          type="text"
          placeholder="type"
          required
          v-model = "whiskey.type"
          />
          <br>
        <label for = "Whiskey"> Region : </label>
           <input class = "whiskey-region"
          type="text"
          placeholder="region"
          required
          v-model = "whiskey.region"
          />
          <br>
        <label for = "Whiskey"> Volume : </label>
           <input class = "whiskey-volume"
          type="text"
          placeholder="volume in ml"
          required
          v-model = "whiskey.volume"
          />
          <br>
        <label for = "Whiskey"> Proof : </label>
           <input class = "whiskey-proof"
          type="text"
          placeholder="proof"
          required
          v-model = "whiskey.proof"
          />
          <br>
        <label for = "Whiskey"> Aged : </label>
         <input class = "whiskey-aged"
          type="text"
          placeholder="Years"
          required
          v-model = "whiskey.aged"
          />
          <br>
        <label for = "Whiskey"> Price : </label>
           <input class = "whiskey-price"
          type="text"
          placeholder="price in doller"
          required
          v-model = "whiskey.price"
          />
          <br>
          <button v-on:click='addWhiskey'>Submit</button>
      </form>
  </div>
</template>

<script>
import WhiskeyService from '../services/WhiskeyService';

export default {
name : "new-whiskey",

data() {
    return {
       whiskey: {
           name:"",
           distiller:"",
           type:"",
           region:"",
           volume:"",
           proof:"",
           aged:"",
           price:"",
       },
    };
},

methods : {
    addWhiskey(){
        const whiskey = {
            name: this.whiskey.name,
            distiller: this.whiskey.distiller,
            type: this.whiskey.type,
            region: this.whiskey.region,
            volume: this.whiskey.volume,
            proof: this.whiskey.proof,
            aged: this.whiskey.aged,
            price: this.whiskey.price,
        };
        
        const config = {
        headers: { Authorization: `Bearer ${this.$store.state.token}` }, 
        };

        WhiskeyService.createWhiskey(whiskey, config).then((response) => { 
            if(response.status == 201 ) {
             alert("Whiskey just added!");
             this.$router.push("/whiskey-list");
             document.getElementsByClassName("whiskey-form").reset();
            }
        });
    }
},

mounted() {
    WhiskeyService.createWhiskey().then((response) => {
        this.whiskey = response.data
    })
}

}

</script>

<style>

</style>