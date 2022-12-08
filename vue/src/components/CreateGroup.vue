<template>
  <form v-on:submit.prevent>
    <div class="field">
      <label for="Name">Please enter a group name:</label>
      <input type="text" v-model="group.name" />
    </div>
    <div class="actions">
      <button type="submit" v-on:click.prevent="saveGroup()">
        Create group
      </button>
    </div>
  </form>
</template>

<script>
import groupService from "../services/GroupService";

export default {
  name: "create-group",
  data() {
    return {
      group: {
        id: Math.floor(Math.random() * (1000 - 100) + 100),
        name: "",
      },
    };
  },
  methods: {
    saveGroup() {
      const groupName = this.group.name;
      groupService.create(this.currentUsername, groupName).then((response) => {
        if (response.status === 201) {
          this.$router.push({ name: "home" });
        }
      });
    },
  },
  computed: {
    currentUsername() {
      return this.$store.state.user.username;
    },
  },
};
</script>

<style>
</style>