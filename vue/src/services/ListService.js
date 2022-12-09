import axios from 'axios';



export default {
    getListsByGroup(groupName) {
        return axios.get(`/lists/${groupName}`)
    }
}