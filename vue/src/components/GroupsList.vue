<template>
  <section>
    <table>
      <thead>
        <th>My Groups</th>
      </thead>
      <tbody>
        <tr v-for="group in setGroups" :key="group.group_id">
          <td>
            <group :group="group" />
          </td>
        </tr>
      </tbody>
    </table>
  </section>
</template>

<script>
import Group from "../components/Group.vue";
import GroupService from "@/services/GroupService.js";

export default {
  name: "group-list",
  components: { Group },
  data() {
    return {};
  },
  computed: {
    setGroups() {
      return this.$store.state.groups;
    },
    currentUsername() {
      return this.$store.state.user.username;
    },
  },
  methods: {
    listGroup() {
      GroupService.getGroups(this.currentUsername).then((response) => {
        this.$store.commit("SET_GROUPS", response.data);
      });
    },
  },
  created() {
    this.listGroup();
  },
};
</script>

<style scoped>
</style>