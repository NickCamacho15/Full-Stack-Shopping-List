import axios from 'axios'

export default {
    getItemsByListId(listId) {
        return axios.get(`/items/${listId}`)
    },

    createNewItem(listId, itemName, quantity) {
        return axios.post(`/items/${listId}/additem?itemName=${itemName}&quantity=${quantity}`);
    },
}