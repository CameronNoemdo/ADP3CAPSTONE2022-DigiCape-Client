package za.ac.cput.client;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import za.ac.cput.entity.Student;
import java.util.Set;
/*
    Author: Themba Khanyile
    Student Number:217238173
    Date: 21/10/2022
 */
public class StudentHttpClient
{

    private static RestTemplate restTemplate = new RestTemplate();

    private final static String CREATE_URL = "http://localhost:8080/student/create";
    private final static String READ_URL = "http://localhost:8080/student/read";
    private final static String UPDATE_URL = "http://localhost:8080/student/update";
    private final static String DELETE_URL = "http://localhost:8080/student/delete";
    private final static String GET_ALL_URL = "http://localhost:8080/student/getAll";


    public static Student create(Student student)
    {
        ResponseEntity<Student> response = restTemplate.postForEntity(CREATE_URL,student,Student.class);

        if(response.getStatusCode().equals(HttpStatus.OK))
        {
            return response.getBody();
        }
        return null;
    }

    public static Student read(String studentId)
    {
        String pathURL = READ_URL+ "/" + studentId;

        ResponseEntity<Student> response = restTemplate.getForEntity(pathURL,Student.class);

        if(response.getStatusCode().equals(HttpStatus.OK))
        {
            return response.getBody();
        }
        return null;
    }

    public static Student update(Student student)
    {
        ResponseEntity<Student> response = restTemplate.postForEntity(UPDATE_URL,student,Student.class);

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

    public static Set<Student> getAll()
    {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity(null, headers);
        ResponseEntity<Set<Student>> response = restTemplate.exchange(GET_ALL_URL, HttpMethod.GET, entity, new ParameterizedTypeReference<Set<Student>>(){});

        if(response.getStatusCode().equals(HttpStatus.OK))
        {
            return response.getBody();
        }
        return null;
    }


    public static Student[] rows() {
        int i = 0;
        Set<Student> studentSet = getAll();
        Student[] students = new Student[studentSet.size()];

        for (Student c : studentSet) {
            if (c != null) {
                students[i] = c;
                i++;
            }
        }
        return students;

    }


}
