<template>
  <div class="create-form">
    <form class="content" v-on:submit.prevent>
      <div class="field">
        <h1 class="header">Create a group</h1>
        <label class="prompt" for="Name">Please enter a group name:</label>
        <input type="text" class="form-control" v-model="group.groupName" />
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
.header {
  padding-bottom: 200px;
  font-size: 30px;
}
.field {
  padding-top: 25px;
  align-items: center;
  margin: auto;
  text-align: center;
}
.actions {
  justify-content: center;
  align-items: center;
  text-align: center;
}
.create-form {
  justify-content: center;
  align-content: center;
}
.create-group {
  justify-content: center;
  margin-right: auto;
  margin-left: auto;
  background: #fff;
  font-size: 14px;
  margin-top: 30px;
  padding: 16px 20px;
  /* border-radius: 26px; */
  border: 1px solid #d4d3e8;
  text-transform: upp ercase;
  font-weight: 700;
  position: relative;
  align-items: center;
  width: 50%;
  color: black;
  box-shadow: 0px 2px 2px black;
  cursor: pointer;
  transition: 0.2s;
}
.create-group:active,
.create-group:focus,
.create-group.hover {
  border-color: #6a679e;
  outline: none;
}
.form-control {
  border: none;
  border-bottom: 2px solid #d1d1d4;
  background: none;
  padding: 10px;
  padding-left: 24px;
  font-weight: 700;
  width: 75%;
  transition: 0.2s;
}
</style>