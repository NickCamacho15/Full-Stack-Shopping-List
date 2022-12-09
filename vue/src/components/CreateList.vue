<template>
  <div class="create-list-form">
    <form v-on:submit.prevent>
      <div class="field">
        <label for="Name">Please enter a list name:</label>
        <input type="text" v-model="list.listName" />
      </div>
      <div class="actions">
        <button
          class="create-list"
          type="submit"
          v-on:click.prevent="saveList()"
        >
          Create list
        </button>
      </div>
    </form>
  </div>
</template>

<script>
import listService from "../services/ListService.js";

export default {
  name: "create-list",
  data() {
    return {
      list: {
        listId: "",
        listName: "",
        numOfItems: "",
      },
    };
  },
  methods: {
    saveList() {
      const listName = this.list.listName;
      listService.createNewList(this.groupName, listName).then((response) => {
        if (response.status === 201) {
          this.$router.push({ name: "lists" });
        }
      });
    },
  },
  computed: {
    currentGroupName() {
      return this.$store.state.group.groupName;
    },
  },
};
</script>

<style>
@import url("https://fonts.googleapis.com/css?family=Raleway:400,700");
.field {
  padding-top: 250px;
  align-items: center;
  margin: auto;
  text-align: center;
}
.actions {
  align-items: center;
  text-align: center;
}
</style>