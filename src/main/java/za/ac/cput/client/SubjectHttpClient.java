package za.ac.cput.client;

/*
SubjectHttpClient.java
Http Client for the Subject Entity
Author:Mathew Fortuin (219069514)
Date: 20/10/2022
 */

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import za.ac.cput.entity.Subject;

import java.util.Set;

public class SubjectHttpClient {

    private static RestTemplate restTemplate = new RestTemplate();

    private final static String CREATE_URL = "http://localhost:8080/subject/create";
    private final static String READ_URL = "http://localhost:8080/subject/read";
    private final static String UPDATE_URL = "http://localhost:8080/subject/update";
    private final static String DELETE_URL = "http://localhost:8080/subject/delete";
    private final static String GET_ALL_URL = "http://localhost:8080/subject/getAll";


    public static Subject create(Subject subject)
    {
        ResponseEntity<Subject> response = restTemplate.postForEntity(CREATE_URL,subject,Subject.class);

        if(response.getStatusCode().equals(HttpStatus.OK))
        {
            return response.getBody();
        }
        return null;
    }

    public static Subject read(Integer subjectId)
    {
        String pathURL = READ_URL+ "/" + subjectId;

        ResponseEntity<Subject> response = restTemplate.getForEntity(pathURL,Subject.class);

        if(response.getStatusCode().equals(HttpStatus.OK))
        {
            return response.getBody();
        }
        return null;
    }

    public static Subject update(Subject subject)
    {
        ResponseEntity<Subject> response = restTemplate.postForEntity(UPDATE_URL,subject,Subject.class);

        if(response.getStatusCode().equals(HttpStatus.OK))
        {
            return response.getBody();
        }
        return null;
    }

    public static void delete(Integer id)
    {
        String pathURL = DELETE_URL + "/" + id;

        restTemplate.delete(pathURL);
    }

    public static Set<Subject> getAll()
    {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity(null, headers);
        ResponseEntity<Set<Subject>> response = restTemplate.exchange(GET_ALL_URL, HttpMethod.GET, entity, new ParameterizedTypeReference<Set<Subject>>(){});

        if(response.getStatusCode().equals(HttpStatus.OK))
        {
            return response.getBody();
        }
        return null;
    }


    public static Subject[] rows() {
        int i = 0;
        Set<Subject> subjectSet = getAll();
        Subject[] subjects = new Subject[subjectSet.size()];

        for (Subject a : subjectSet) {
            if (a != null) {
                subjects[i] = a;
                i++;
            }
        }
        return subjects;

    }
}
