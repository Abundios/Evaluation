package org.pruebaEY.controller;

import org.pruebaEY.dto.PhoneDto;
import org.pruebaEY.model.User;
import org.pruebaEY.model.Phone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import javax.xml.transform.Result;

import org.pruebaEY.dto.UserDto;
import org.pruebaEY.repository.*;
import org.pruebaEY.service.UserService;
import org.pruebaEY.service.PhoneService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Pattern;

@RestController
public class UserController {

    final UserService userService;
    final PhoneService phoneService;

    //@GetMapping("/")
    //public String index(Model model) {
    //    return "index";
    //}

    public UserController(UserService userService,
                          PhoneService phoneService) {
        this.userService = userService;
        this.phoneService = phoneService;
    }

    //@RequestMapping(value = "/users")
    //public ResponseEntity<Object> createUser(@RequestBody UserDto userDto) {
    //public String listUsers(WebRequest request) {

    @GetMapping("/users")
    public ResponseEntity findUsers()
    {
        try {
            //List<User> users = userService.findAll();
            //return ResponseEntity.ok(users);
            //return userService.findAllUsers();
            return ResponseEntity.ok(userService.findAllUsers());
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }

    }

    //@GetMapping
    //public Result createUser(UserDto userDto) throws Exception {
    //    return sampleService.getFolderList(param);
    //}

    //@PostMapping (value = "/createUser")
    //@ResponseStatus(HttpStatus.CREATED)
    //@Produces(MediaType.APPLICATION_JSON)
    //@RequestMapping(value = "/createUser", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    //@ResponseBody
    //@RequestMapping(value = "/createUser", method = RequestMethod.POST)
    @RequestMapping(value = "/createUser",method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> createUser(@RequestBody UserDto userDto) {
        //public Boolean createUser(@RequestBody Map<String, String> json_Input) {
            //Post post = convertToEntity(postDto);
            //Post postCreated = postService.createPost(post));
            //return convertToDto(postCreated);
            //
        try {
            return userService.createUser(userDto);
            /*
            boolean validPassword = Pattern.compile("^([A-Z]{1}+[a-z]{1,}[0-9]{2})$")
                    .matcher(userDto.getPassword())
                    .matches();
            if (!validPassword) {
                return ResponseHandler.generateResponse("Password no válida",
                        HttpStatus.ACCEPTED, userDto);
            }
            boolean validEmail = Pattern.compile("^([a-zA-Z0-9._%-]+@[a-zA-Z0-9.-]+\\.cl)$")
                    .matcher(userDto.getEmail())
                    .matches();
            if (!validEmail) {
                return ResponseHandler.generateResponse("Email no válido",
                        HttpStatus.ACCEPTED, userDto);
            }

            List<User> usersWithEmail = userService.findByEmail(userDto.getEmail());
            if (!usersWithEmail.isEmpty()) {
                return ResponseHandler.generateResponse("El correo ya registrado",
                                                        HttpStatus.ACCEPTED, userDto);
            }


            User user = new User();
            //UUID id = UUID.randomUUID();
            //user.setId(id);
            //user.setId(new Integer(2));
            user.setName(userDto.getName());
            user.setEmail(userDto.getEmail());
            user.setPassword(userDto.getPassword());
            List<PhoneDto> phonesDto = userDto.getPhones();
            List<Phone> phones = new ArrayList<>();
            for (PhoneDto phoneDto : phonesDto) {
                Phone phone = new Phone();
                phone.setNumber(phoneDto.getNumber());
                phone.setCitycode(phoneDto.getCitycode());
                phone.setCountrycode(phoneDto.getContrycode());
                //phoneService.persist(phone);
                phones.add(phone);
            }
            user.setPhones(phones);
            userService.persist(user);

            System.out.println("por fin");
            //return ResponseEntity.ok(HttpStatus.OK);
            return ResponseHandler.generateResponse("Successfully added data!", HttpStatus.OK, userDto);
            */
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }

    }

    /*
    @GetMapping(value = "/users")    @ResponseBody
    public List<PostDto> getPosts(...) {
        //...
        List<Post> posts = postService.getPostsList(page, size, sortDir, sort);
        return posts.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }
*/

}
