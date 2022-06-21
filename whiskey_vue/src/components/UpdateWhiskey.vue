<template>
  <div>
    <form id = "update" class = "update-whiskey"  v-on:submit.prevent >
        <h1> How much did you drink? </h1>
        <br>
        <label for ="Whiskey"> Update whiskey volume </label>
         <input
          type="text"
          id="volume"
          class = "form-control"
          placeholder="how much did you drink?"
          required
          v-model = "volume"
          />
          <br>
        <button v-on:click="updateWhiskey">Submit</button>
    </form>
  </div>
</template>

<script>
import WhiskeyService from '../services/WhiskeyService.js';

export default {
name : "update-whiskey",

data () {
    return {
        whiskey:{
            id:"",
            name:"",
            distiller:"",
            type:"",
            region:"",
            volume:"",
            proof:"",
            aged:"",
            price:""
        },

        volume:"",
    };
},

methods: {

    updateWhiskey() {
       
        const volume = this.volume;
        const id = this.$route.params.id;
        const config = {
            headers: { Authorization: `Bearer ${this.$store.state.token}` },
        };

        WhiskeyService.updateWhiskey(id, volume, config).then(
            (response) => {
                if( (this.$route.params.volume <= 0) && (response.status == 202)){
                    alert("Your bottle is empty")
                    this.$router.push("/whiskey-list"); // put the path not the name 
                    document.getElementById("update").reset();
                }

                if(response.status == 202){
                    if(volume > 30) {
                        alert("Don't drink too much! Save it for later!")
                        this.$router.push("/whiskey-list"); // put the path not the name 
                        document.getElementById("update").reset();
                    }else{
                        alert("Your bottle has new volume!")
                        this.$router.push("/whiskey-list"); // put the path not the name 
                        document.getElementById("update").reset();
                    }
                    
                }
            }
        );
    }

},

created() {
        WhiskeyService.getWhiskeyById(this.$route.params.id).then(
            (resp) => {console.log(resp.data);this.whiskey=resp.data }
        )
    }

}
</script>

<style>

</style>