<template>
  <div class="create-form">
    <form v-on:submit.prevent>
      <div class="field">
        <label for="Name">Please enter a group name:</label>
        <input type="text" v-model="group.groupName" />
      </div>
      <div class="actions">
        <button
          class="create-group"
          type="submit"
          v-on:click.prevent="saveGroup()"
        >
          Create group
        </button>
      </div>
    </form>
  </div>
</template>

<script>
import groupService from "../services/GroupService";

export default {
  name: "create-group",
  data() {
    return {
      group: {
        groupId: "",
        groupName: "",
      },
    };
  },
  methods: {
    saveGroup() {
      const groupName = this.group.groupName;
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