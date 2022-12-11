import axios from 'axios';



export default {
    getListsByGroup(groupName) {
        return axios.get(`/lists/${groupName}`)
    },

    createNewList(groupName, listName) {
        return axios.post(`/lists/${groupName}/addlist?listName=${listName}`);
    },

}