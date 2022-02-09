import axios from "axios";

const URL_PRODUCTS = "http://localhost:8080/api/v1/districts";

class DistrictService {
    getAll(){
        return axios.get(URL_PRODUCTS);
    }

}

export default new DistrictService();