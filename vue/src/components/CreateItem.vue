<template>
  <div class="create-item-form">
    <form class="content" v-on:submit.prevent>
      <div class="field">
        <label class="header" for="Name">Please enter item name:</label>
        <input type="text" class="form-control" v-model="item.itemName" />
        <label class="quantity" for="Quantity"
          >Please enter item quantity:</label
        >
        <input
          type="number"
          class="form-control"
          v-model.number="item.quantity"
        />
      </div>
      <div class="actions">
        <button
          class="create-item"
          type="submit"
          v-on:click.prevent="saveItem()"
        >
          Add Item
        </button>
      </div>
    </form>
  </div>
</template>

<script>
import ItemService from "../services/ItemService.js";

export default {
  name: "create-item",
  props: ["listId"],
  data() {
    return {
      item: {
        itemId: "",
        itemName: "",
        quantity: 0,
        listId: this.listId,
      },
    };
  },
  methods: {
    saveItem() {
      //   const itemName = this.item.itemName;
      //   const quantity = this.item.quantity;
      ItemService.createNewItem(
        this.listId,
        this.item.itemName,
        this.item.quantity
      ).then((response) => {
        if (response.status === 201) {
          this.$router.push({
            name: "items",
            params: { listId: this.listId },
          });
        }
      });
    },
  },
  computed: {
    currentList() {
      return this.item.listId;
    },
  },
};
</script>

<style>
@import url("https://fonts.googleapis.com/css?family=Raleway:400,700");

.content {
  background: rgba(255, 255, 255, 0.911);
  padding-bottom: 100px;
  width: 760px;
  height: 600px;
  box-shadow: 0px 0px 10px black;
  /* display: flex;
  flex-direction: column;
  align-content: stretch; */
}
.field {
  padding-top: 250px;
  /* align-items: center; */
  margin: auto;
  /* text-align: center; */
}
.header {
  padding-bottom: 100px;
  font-size: 30px;
}
.create-item {
  background: #fff;
  position: relative;
  justify-content: center;
  margin-right: auto;
  margin-left: auto;
  font-size: 14px;
  margin-top: 20px;
  padding-top: 120px;
  padding: 16px 20px;
  border: 1px solid #d4d3e8;
  text-transform: uppercase;
  font-weight: 700;
  align-items: center;
  width: 50%;
  color: black;
  box-shadow: 0px 2px 2px black;
  cursor: pointer;
  transition: 0.2s;
}
.create-item:active,
.create-item:focus,
.create-item.hover {
  border-color: #6a679e;
  outline: none;
}
/* .content {
  padding-bottom: 50px;
} */

/* .actions {
  align-items: center;
  text-align: center;
} */
</style>