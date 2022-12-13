import axios from 'axios'

export default {
    getItemsByListId(listId) {
        return axios.get(`/items/${listId}`)
    },

    createNewItem(listId, item) {
        return axios.post(`/items/${listId}/additem`, item)
    }
}