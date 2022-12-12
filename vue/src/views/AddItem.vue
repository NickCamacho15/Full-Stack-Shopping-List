<template>
  <div class="create">
    <img
      class="image1"
      src="../assets/pexels-tirachard-kumtanom-733852.jpg"
      alt="background image"
    />

    <!-- <h1>Create new item</h1> -->
    <create-item class="component" v-bind:listId="currentList" />
  </div>
</template>

<script>
import CreateItem from "../components/CreateItem.vue";
export default {
  components: { CreateItem },
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