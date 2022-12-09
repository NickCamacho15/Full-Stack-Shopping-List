<template>
  <div class="group">
    <h1 class="group-name">{{ group.groupName }}</h1>
    <h2 class="date">created on: {{ group.createDate }}</h2>
  </div>
</template>

<script>
export default {
  name: "group-card",
  props: ["group"],
};
</script>

<style>
.group {
  align-content: center;
  margin: 25px;
}
.date {
  font-size: 12px;
  padding-top: 10px;
}
</style>