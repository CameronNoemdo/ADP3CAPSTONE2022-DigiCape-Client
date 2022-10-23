package za.ac.cput.client;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import za.ac.cput.entity.University;

import java.util.Set;

public class UniversityHttpClient {
    private static final RestTemplate restTemplate=new RestTemplate();

    private final static String CREATE_URL = "http://localhost:8080/university/create";

    private final static String READ_URL = "http://localhost:8080/university/read";

    private final static String UPDATE_URL = "http://localhost:8080/university/update";

    private final static String DELETE_URL = "http://localhost:8080/university/delete";

    private final static String GET_ALL_URL = "http://localhost:8080/university/getall";

    public static University create(University university) {
        ResponseEntity<University> response = restTemplate.postForEntity(CREATE_URL,university,University.class);

        if(response.getStatusCode().equals(HttpStatus.OK)) {
            return response.getBody();
        }
        return null;
    }

    public static University read(String universityId) {
        String pathURL = READ_URL+ "/" + universityId;

        ResponseEntity<University> response = restTemplate.getForEntity(pathURL,University.class);

        if(response.getStatusCode().equals(HttpStatus.OK)) {
            return response.getBody();
        }
        return null;
    }

    public static University update(University university) {
        ResponseEntity<University> response = restTemplate.postForEntity(UPDATE_URL,university,University.class);

        if(response.getStatusCode().equals(HttpStatus.OK)) {
            return response.getBody();
        }
        return null;
    }

    public static void delete(String id) {
        String pathURL = DELETE_URL + "/" + id;

        restTemplate.delete(pathURL);
    }

    public static Set<University> getAll() {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity(null, headers);
        ResponseEntity<Set<University>> response = restTemplate.exchange(GET_ALL_URL, HttpMethod.GET, entity, new ParameterizedTypeReference<Set<University>>(){});

        if(response.getStatusCode().equals(HttpStatus.OK)) {
            return response.getBody();
        }
        return null;
    }

    public static University[] rows() {
        int i = 0;
        Set<University> universitySet = getAll();
        University[] universityArray = new University[universitySet.size()];

        for (University university : universitySet) {
            if (university != null) {
                universityArray[i] = university;
                i++;
            }
        }
        return universityArray;
    }
}
