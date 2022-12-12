<template>
  <div class="items">
    <h1 class="item-names">{{ item.itemName }}</h1>
    <h2 class="items-on-list">{{ item.quantity }}</h2>
  </div>
</template>

<script>
export default {
  name: "item-card",
  props: ["item"],
};
</script>

<style scoped>
</style>