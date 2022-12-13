<template>
  <div class="create-item-form">
    <form class="content" v-on:submit.prevent>
      <div class="field">
        <label class="label1" for="Name">Please enter item name:</label>
        <input type="text" class="form-control" v-model="item.itemName" />

        <label class="label2" for="Quantity">Please enter item quantity:</label>
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
.create-item-form {
  align-items: center;
  justify-content: center;
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
  align-items: center;
  background: #fff;
  position: relative;
  justify-content: center;
  margin-right: auto;
  margin-left: auto;
  font-size: 14px;
  margin-top: 50px;
  padding-top: 150px;
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

.actions {
  align-items: center;
  text-align: center;
}
.form-control {
  border: none;
  border-bottom: 2px solid #d1d1d4;
  background: none;
  padding: 10px;
  padding-top: 50px;
  padding-left: 24px;
  font-weight: 700;
  width: 75%;
  transition: 0.2s;
}
.label1 {
  position: fixed;
  left: 600px;
  bottom: 490px;
}
.label2 {
  position: fixed;
  left: 600px;
  bottom: 420px;
}
</style>