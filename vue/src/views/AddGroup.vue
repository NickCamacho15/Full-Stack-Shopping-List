<template>
  <div>
    <img
      class="image1"
      src="../assets/pexels-tirachard-kumtanom-733852.jpg"
      alt="background image"
    />
    <h1>Create new group</h1>
    <create-group />
  </div>
</template>

<script>
import CreateGroup from "../components/CreateGroup.vue";
export default {
  components: { CreateGroup },
};
</script>

<style scoped>
.image1 {
  min-height: 100%;
  min-width: 1024px;
  width: 100%;
  height: auto;
  position: fixed;
  top: 0px;
  left: 0px;
  z-index: -3;
}
</style>