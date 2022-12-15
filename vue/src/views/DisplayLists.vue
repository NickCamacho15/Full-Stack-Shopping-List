<template>
  <div class="main-div">
    <img
      class="image1"
      src="../assets/pexels-tirachard-kumtanom-733852.jpg"
      alt="background image"
    />
    <div class="list">
      <h1 class="list-title">{{ currentGroup.groupName }}</h1>
      <list-of-lists v-bind:groupId="currentGroup"></list-of-lists>
      <router-link
        tag="button"
        class="add-list-button"
        :to="{ name: 'AddList', params: { groupId: currentGroup.group_id } }"
        >Add List +</router-link
      >
    </div>
  </div>
</template>

<script>
import ListOfLists from "../components/ListOfLists.vue";

export default {
  components: {
    ListOfLists,
  },
  computed: {
    currentGroup() {
      return this.$store.state.groups.find(
        (group) => group.groupId === this.$route.params.groupId
      );
    },
  },
};
</script>
<style scoped>
.main-div {
  display: flex;
  align-items: center;
  justify-content: center;
  min-height: 100vh;
}
.list-title {
  font-size: 32px;
}

.image1 {
  min-height: 100%;
  min-width: 1024px;
  width: 100%;
  height: auto;
  position: fixed;
  top: 0px;
  left: 0px;
  z-index: -1;
}
.list {
  align-items: center;
  background: rgba(255, 255, 255, 0.911);
  width: 760px;
  padding: 30px;
  margin: auto;
  text-align: center;
  padding-top: 120px;
  box-shadow: 0px 0px 10px black;
  /* height: 600px; */
}
.add-list-button {
  justify-content: center;
  margin: 0 auto;
  width: 50%;
  background: #fff;
  font-size: 14px;
  margin-top: 30px;
  padding: 16px 20px;
  /* border-radius: 26px; */
  border: 1px solid #d4d3e8;
  text-transform: uppercase;
  text-align: justify;
  font-weight: 700;
  display: flex;
  align-items: center;
  width: 50%;
  color: black;
  box-shadow: 0px 2px 2px black;
  cursor: pointer;
  transition: 0.2s;
}
</style>
