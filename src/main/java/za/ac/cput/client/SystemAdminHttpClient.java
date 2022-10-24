package za.ac.cput.client;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import za.ac.cput.entity.SystemAdmin;

import java.util.Set;

public class SystemAdminHttpClient {

    private static RestTemplate restTemplate = new RestTemplate();

    private final static String CREATE_URL = "http://localhost:8080/systemAdmin/create";
    private final static String READ_URL = "http://localhost:8080/systemAdmin/read";
    private final static String UPDATE_URL = "http://localhost:8080/systemAdmin/update";
    private final static String DELETE_URL = "http://localhost:8080/systemAdmin/delete";
    private final static String GET_ALL_URL = "http://localhost:8080/systemAdmin/getAll";

    public static SystemAdmin create(SystemAdmin studentAdmin)
    {
        ResponseEntity<SystemAdmin> response = restTemplate.postForEntity(CREATE_URL, studentAdmin, SystemAdmin.class); //Create the request

        if(response.getStatusCode().equals(HttpStatus.OK))
        {
            return response.getBody();
        }

        return null;
    }
    public static SystemAdmin read(String id)
    {
        String pathURL = READ_URL + "/" + id;

        ResponseEntity<SystemAdmin> response = restTemplate.getForEntity(pathURL, SystemAdmin.class);

        if(response.getStatusCode().equals(HttpStatus.OK))
        {
            return response.getBody();
        }

        return null;
    }

    public static SystemAdmin update(SystemAdmin systemAdmin)
    {
        ResponseEntity<SystemAdmin> response = restTemplate.postForEntity(UPDATE_URL, systemAdmin, SystemAdmin.class); //Create the request

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

    public static Set<SystemAdmin> getAll()
    {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity(null, headers);
        ResponseEntity<Set<SystemAdmin>> response = restTemplate.exchange(GET_ALL_URL, HttpMethod.GET, entity, new ParameterizedTypeReference<Set<SystemAdmin>>() {});

        if(response.getStatusCode().equals(HttpStatus.OK))
        {
            return response.getBody();
        }

        return null;
    }

    public static SystemAdmin[] rows()
    {
        int i = 0;
        Set<SystemAdmin> systemAdminSet = getAll();
        SystemAdmin[] systemAdmin = new SystemAdmin[systemAdminSet.size()];

        for(SystemAdmin s : systemAdminSet)
        {
            if(s != null)
            {
                systemAdmin[i] = s;
                i++;
            }
        }

        return systemAdmin;
    }
}



