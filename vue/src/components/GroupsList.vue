<template>
  <section>
    <table id="groupTable">
      <thead>
        <th class="header"></th>
      </thead>
      <tbody>
        <tr class="body" v-for="group in setGroups" :key="group.groupId">
          <td class="groups">
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
#groupTable {
  display: flex;
  justify-content: center;
  margin: 200px;
}

.header {
  font-size: 28px;
  justify-content: center;
}
.body {
  justify-content: center;
}
.groups {
  padding-bottom: 20px;
}
</style>