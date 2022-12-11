import axios from 'axios'

export default {
    getItemsByListId(listId) {
        return axios.get(`/items/${listId}`)
    },
}