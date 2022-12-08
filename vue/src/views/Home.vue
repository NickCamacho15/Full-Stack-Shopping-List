<template>
  <div class="home">
    <groups-list></groups-list>
    <router-link
      tag="button"
      class="open-create-form"
      :to="{ name: 'AddGroup' }"
      >Add a group</router-link
    >
  </div>
</template>

<script>
import GroupsList from "@/components/GroupsList.vue";

export default {
  components: { GroupsList },
};
</script>
