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
  props: ["groupId"],
  data() {
    return {
      list: {
        listId: "",
        listName: "",
        numOfItems: "",
        groupId: this.groupId,
      },
    };
  },
  methods: {
    saveList() {
      const listName = this.list.listName;
      listService
        .createNewList(this.currentGroup, listName)
        .then((response) => {
          if (response.status === 201) {
            this.$router.push({
              name: "lists",
              params: { listId: this.list.groupId },
            });
          }
        });
    },
  },
  computed: {
    currentGroup() {
      return this.$store.state.lists.groupId;
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