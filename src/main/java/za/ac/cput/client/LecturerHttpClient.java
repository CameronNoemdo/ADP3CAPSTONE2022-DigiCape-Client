package za.ac.cput.client;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import za.ac.cput.entity.Lecturer;

import java.util.Set;

public class LecturerHttpClient {
    private static final RestTemplate restTemplate=new RestTemplate();

    private final static String CREATE_URL = "http://localhost:8080/lecturer/create";

    private final static String READ_URL = "http://localhost:8080/lecturer/read";

    private final static String UPDATE_URL = "http://localhost:8080/lecturer/update";

    private final static String DELETE_URL = "http://localhost:8080/lecturer/delete";

    private final static String GET_ALL_URL = "http://localhost:8080/lecturer/getall";


    public static Lecturer create(Lecturer lecturer) {
        ResponseEntity<Lecturer> response = restTemplate.postForEntity(CREATE_URL,lecturer,Lecturer.class);

        if(response.getStatusCode().equals(HttpStatus.OK)) {
            return response.getBody();
        }
        return null;
    }

    public static Lecturer read(String lecturerId) {
        String pathURL = READ_URL+ "/" + lecturerId;

        ResponseEntity<Lecturer> response = restTemplate.getForEntity(pathURL,Lecturer.class);

        if(response.getStatusCode().equals(HttpStatus.OK)) {
            return response.getBody();
        }
        return null;
    }

    public static Lecturer update(Lecturer lecturer) {
        ResponseEntity<Lecturer> response = restTemplate.postForEntity(UPDATE_URL,lecturer,Lecturer.class);

        if(response.getStatusCode().equals(HttpStatus.OK)) {
            return response.getBody();
        }
        return null;
    }

    public static void delete(String id) {
        String pathURL = DELETE_URL + "/" + id;

        restTemplate.delete(pathURL);
    }

    public static Set<Lecturer> getAll() {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity(null, headers);
        ResponseEntity<Set<Lecturer>> response = restTemplate.exchange(GET_ALL_URL, HttpMethod.GET, entity, new ParameterizedTypeReference<Set<Lecturer>>(){});

        if(response.getStatusCode().equals(HttpStatus.OK)) {
            return response.getBody();
        }
        return null;
    }

    public static Lecturer[] rows() {
        int i = 0;
        Set<Lecturer> lecturerSet = getAll();
        Lecturer[] lecturerArray = new Lecturer[lecturerSet.size()];

        for (Lecturer lecturer : lecturerSet) {
            if (lecturer != null) {
                lecturerArray[i] = lecturer;
                i++;
            }
        }
        return lecturerArray;
    }

}
