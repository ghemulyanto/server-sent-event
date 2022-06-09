import axios from 'axios'

const API_URL = "http://localhost:8080/products/";

class ProductService {
    buy(productId){
        return axios.post(API_URL + productId);
    }
}

export default new ProductService();