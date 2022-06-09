<template>
  <v-app>
    <v-app-bar
      app
      color="primary"
      dark
      dense
      class="text-capitalize"
    >

    </v-app-bar>

      <product-page></product-page>
  </v-app>
</template>

<script>
import ProductPage from './components/Product.vue'

export default {
  name: 'App',
  components: {
    ProductPage
  },
  data: () => ({
    //
  }),
};
</script>
