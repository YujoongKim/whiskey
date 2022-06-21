import axios from 'axios';

export default{


    getAllWhisky(){
        return axios.get('/allWhiskey')
    },

    getWhiskeyById(id) {
        return axios.get('/getWhiskeyById/'+id)
    },

    createWhiskey(whiskey){
        return axios.post('/newWhiskey', whiskey)
    },

    updateWhiskey(id, volume){
        console.log('here?')
        return axios.put('/updateWhiskey?id='+id+"&volume=" + volume);
    }




}