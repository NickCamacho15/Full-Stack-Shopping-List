<template>
  <div class="group">
    <h1 class="group-name">{{ group.groupName }}</h1>
    <h2>{{ group.createDate }}</h2>
  </div>
</template>

<script>
export default {
  name: "group-card",
  props: ["group"],
};
</script>

<style>
</style>