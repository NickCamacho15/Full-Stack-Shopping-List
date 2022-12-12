<template>
  <section>
    <table id="itemTable">
      <thead>
        <th class="header"></th>
      </thead>
      <tbody>
        <tr
          class="body"
          v-for="item in this.$store.state.items"
          :key="item.itemId"
        >
          <td class="items">
            <item :item="item" />
          </td>
        </tr>
      </tbody>
    </table>
  </section>
</template>

<script>
import ItemService from "../services/ItemService.js";
import Item from "../components/Item.vue";
export default {
  name: "items-list",
  props: ["listId"],
  components: { Item },
  data() {
    return {};
  },
  computed: {
    setItems() {
      return this.$store.state.items;
    },
  },
  methods: {
    itemLists() {
      ItemService.getItemsByListId(this.listId).then((response) => {
        this.$store.commit("SET_ITEMS", response.data);
      });
    },
  },
  created() {
    this.itemLists();
  },
};
</script>

<style scoped>
</style>