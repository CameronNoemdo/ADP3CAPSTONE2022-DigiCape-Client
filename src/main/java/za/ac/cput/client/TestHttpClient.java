package za.ac.cput.client;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import za.ac.cput.entity.TestModel;

import java.util.Set;
/*
    Author: Themba Khanyile
    Student Number:217238173
    Date: 21/10/2022
 */
public class TestHttpClient
{

        private static RestTemplate restTemplate = new RestTemplate();

        private final static String CREATE_URL = "http://localhost:8080/test/create";
        private final static String READ_URL = "http://localhost:8080/test/read";
        private final static String UPDATE_URL = "http://localhost:8080/test/update";
        private final static String DELETE_URL = "http://localhost:8080/test/delete";
        private final static String GET_ALL_URL = "http://localhost:8080/test/getAll";


        public static TestModel create(TestModel testModel)
        {
                ResponseEntity<TestModel> response = restTemplate.postForEntity(CREATE_URL,testModel,TestModel.class);

                if(response.getStatusCode().equals(HttpStatus.OK))
                {
                        return response.getBody();
                }
                return null;
        }

        public static TestModel read(String testId)
        {
                String pathURL = READ_URL+ "/" + testId;

                ResponseEntity<TestModel> response = restTemplate.getForEntity(pathURL,TestModel.class);

                if(response.getStatusCode().equals(HttpStatus.OK))
                {
                        return response.getBody();
                }
                return null;
        }

        public static TestModel update(TestModel testModel)
        {
                ResponseEntity<TestModel> response = restTemplate.postForEntity(UPDATE_URL,testModel,TestModel.class);

                if(response.getStatusCode().equals(HttpStatus.OK))
                {
                        return response.getBody();
                }
                return null;
        }

        public static void delete(String id)
        {
                String pathURL = DELETE_URL + "/" + id;

                restTemplate.delete(pathURL);
        }

        public static Set<TestModel> getAll()
        {
                HttpHeaders headers = new HttpHeaders();
                HttpEntity<String> entity = new HttpEntity(null, headers);
                ResponseEntity<Set<TestModel>> response = restTemplate.exchange(GET_ALL_URL, HttpMethod.GET, entity, new ParameterizedTypeReference<Set<TestModel>>(){});

                if(response.getStatusCode().equals(HttpStatus.OK))
                {
                        return response.getBody();
                }
                return null;
        }


        public static TestModel[] rows() {
                int i = 0;
                Set<TestModel> testModelSet = getAll();
                TestModel[] testModels = new TestModel[testModelSet.size()];

                for (TestModel c : testModelSet) {
                        if (c != null) {
                                testModels[i] = c;
                                i++;
                        }
                }
                return testModels;

        }


}
