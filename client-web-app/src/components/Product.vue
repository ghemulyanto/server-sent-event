<template>
  <div class="hello">
    <v-container fluid grid-list-md>
      <v-layout row wrap>
        <v-flex v-for="item in items" :key="item.id" xs12 md6 lg2>
          <v-card  class="mx-auto my-12" max-width="300" height="450">
            <v-img class="mx-auto" max-height="200" max-width="200" :src="item.imageUrl"></v-img>
            <v-card-title>{{item.name}}</v-card-title>
            <v-card-text>
              <v-row align="center" class="mx-0">
                <v-rating
                  :value="item.rating"
                  color="amber"
                  dense
                  half-increments
                  readonly
                  size="14"
                ></v-rating>
                  {{item.rating}} (1M)
                <v-spacer></v-spacer>
              <div>
                Stok <span class="font-weight-black">{{item.stock}}</span>
              </div>
              </v-row>

              <div class="my-4 text-subtitle-1">
              • Indonesia, Sandal
              </div>

              <div>{{item.description}}</div>
            </v-card-text>
            <v-divider class="mx-4"></v-divider>
            <v-card-actions>
              <v-btn block rounded color="primary" dark @click="buyItem(item.id)">
                <span class="text-capitalize">Beli</span>
              </v-btn>
            </v-card-actions>
          </v-card>
        </v-flex>
      </v-layout>
    </v-container>
  </div>
</template>

<script>
import ProductService from "../services/product.service"

let sseClient;
export default {
  name: "product-page",
  data: () => ({
     items: []
    }),

    mounted(){
        sseClient = this.$sse.create({
            url: 'http://localhost:8080/products',
            format: 'json'
        });

        sseClient.on('message', this.handleMessage);

         sseClient.connect()
      .then(sse => {
        console.log('We\'re connected!');

        setTimeout(() => {
          sse.off('end', this.handleChat);
          console.log('Stopped listening to server event!');
        }, 14000);
      })
      .catch((err) => {
        
        console.error('Failed to connect to server', err);
      });
    },

    methods: {
         handleMessage(data) {
            console.warn('Received a message w/o an event!', data);
            this.items = data;
        },
        buyItem(item){
          ProductService.buy(item);
        }
    },

    beforeDestroy() {
        sseClient.disconnect();
  },
};
</script>