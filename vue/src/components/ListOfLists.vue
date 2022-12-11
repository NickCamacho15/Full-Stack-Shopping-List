<template>
  <section>
    <table id="listTable">
      <thead>
        <th class="header"></th>
      </thead>
      <tbody>
        <tr
          class="body"
          v-for="list in this.$store.state.lists"
          :key="list.list_id"
        >
          <td class="lists">
            <list :list="list" />
          </td>
        </tr>
      </tbody>
    </table>
  </section>
</template>

<script>
import List from "../components/List.vue";
import ListService from "../services/ListService.js";

export default {
  name: "lists-list",
  props: ["groupId"],
  components: { List },
  data() {
    return {};
  },
  computed: {
    setLists() {
      return this.$store.state.lists;
    },
    currentGroupId() {
      return this.$store.state.lists.groupId;
    },
  },
  methods: {
    listLists() {
      ListService.getListsByGroup(this.groupId).then((response) => {
        this.$store.commit("SET_LISTS", response.data);
      });
    },
  },
  created() {
    this.listLists();
  },
};
</script>

<style scoped>
#listTable {
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