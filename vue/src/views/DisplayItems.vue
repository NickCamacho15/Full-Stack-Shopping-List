<template>
  <div class="items">
    <img
      class="image1"
      src="../assets/pexels-tirachard-kumtanom-733852.jpg"
      alt="background image"
    />
    <div class="item-lists">
      <h1 class="items-list-title">Items for this list</h1>
      <router-link
        tag="button"
        class="open-create-form"
        :to="{ name: 'AddItem', params: { listId: currentList } }"
        >Add a item to this list</router-link
      >
      <item-list v-bind:listId="currentList"></item-list>
    </div>
  </div>
</template>

<script>
import ItemList from "../components/ItemList.vue";
export default {
  components: { ItemList },
  computed: {
    currentList() {
      return this.$route.params.listId;
    },
  },
};
</script>

<style scoped>
.image1 {
  z-index: -1;
}
</style>