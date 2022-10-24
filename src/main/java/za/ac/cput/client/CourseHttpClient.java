package za.ac.cput.client;

/*
CourseHttpClient.java
Http Client for the Course Entity
Author:Mathew Fortuin (219069514)
Date: 20/10/2022
 */

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import za.ac.cput.entity.Course;

import java.util.Set;

public class CourseHttpClient {

    private static RestTemplate restTemplate = new RestTemplate();

    private final static String CREATE_URL = "http://localhost:8080/course/create";
    private final static String READ_URL = "http://localhost:8080/course/read";
    private final static String UPDATE_URL = "http://localhost:8080/course/update";
    private final static String DELETE_URL = "http://localhost:8080/course/delete";
    private final static String GET_ALL_URL = "http://localhost:8080/course/getAll";


    public static Course create(Course course)
    {
        ResponseEntity<Course> response = restTemplate.postForEntity(CREATE_URL,course,Course.class);

        if(response.getStatusCode().equals(HttpStatus.OK))
        {
            return response.getBody();
        }
        return null;
    }

    public static Course read(Integer courseId)
    {
        String pathURL = READ_URL+ "/" + courseId;

        ResponseEntity<Course> response = restTemplate.getForEntity(pathURL,Course.class);

        if(response.getStatusCode().equals(HttpStatus.OK))
        {
            return response.getBody();
        }
        return null;
    }

    public static Course update(Course course)
    {
        ResponseEntity<Course> response = restTemplate.postForEntity(UPDATE_URL,course,Course.class);

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

    public static Set<Course> getAll()
    {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity(null, headers);
        ResponseEntity<Set<Course>> response = restTemplate.exchange(GET_ALL_URL, HttpMethod.GET, entity, new ParameterizedTypeReference<Set<Course>>(){});

        if(response.getStatusCode().equals(HttpStatus.OK))
        {
            return response.getBody();
        }
        return null;
    }


    public static Course[] rows() {
        int i = 0;
        Set<Course> courseSet = getAll();
        Course[] courses = new Course[courseSet.size()];

        for (Course a : courseSet) {
            if (a != null) {
                courses[i] = a;
                i++;
            }
        }
        return courses;

    }

}
