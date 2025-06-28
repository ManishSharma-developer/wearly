package com.myorganisation.wearly.service;

import com.myorganisation.wearly.dto.UserRequestDTO;
import com.myorganisation.wearly.dto.UserResponseDTO;
import com.myorganisation.wearly.model.User;
import com.myorganisation.wearly.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;


    @Override
    public UserResponseDTO registerUser(UserRequestDTO userRequestDTO) {
        User user = new User();
        user.setName(userRequestDTO.getName());
        user.setGender(userRequestDTO.getGender());
        user.setEmail(userRequestDTO.getEmail());
        user.setPhone(userRequestDTO.getPhone());
        user.setPassword(userRequestDTO.getPassword());

        userRepository.save(user);

        return maptodto(user);
    }


    @Override
    public UserResponseDTO getUser(Long id) {
        User user = userRepository.findById(id).orElse(null);

        UserResponseDTO userResponseDTO = new UserResponseDTO();
        userResponseDTO.setId(user.getId());
        userResponseDTO.setName(user.getName());
        userResponseDTO.setGender(user.getGender());
        userResponseDTO.setEmail(user.getEmail());
        userResponseDTO.setPhone(user.getPhone());
        return userResponseDTO;
    }

    @Override
    public List<UserResponseDTO> getAllUsers() {
        List<User> userList = userRepository.findAll();
        List<UserResponseDTO> userResponseDTOList = new LinkedList<>();
        for (User user : userList) {
            UserResponseDTO userResponseDTO = new UserResponseDTO();
            userResponseDTO.setId(user.getId());
            userResponseDTO.setName(user.getName());
            userResponseDTO.setGender(user.getGender());
            userResponseDTO.setEmail(user.getEmail());
            userResponseDTO.setPhone(user.getPhone());
            userResponseDTOList.add(userResponseDTO);
        }
        return userResponseDTOList;
    }

    @Override
    public UserResponseDTO updateUser(Long id, UserRequestDTO userRequestDTO) {
        User user = userRepository.findById(id).orElse(null);

        if (user == null) {
            System.out.println("user does not exits");
        } else {
            user.setName(userRequestDTO.getName());
            user.setGender(userRequestDTO.getGender());
            user.setEmail(userRequestDTO.getEmail());
            user.setPhone(userRequestDTO.getPhone());
            user.setPassword(userRequestDTO.getPassword());

            userRepository.save(user);
        }
        return maptodto(user);

    }

    @Override
    public String removeUser(Long id) {
        String name = userRepository.findById(id).orElse(null).getName();
        userRepository.deleteById(id);
        return "User name: " + name + "( " + id + ") has been removed successfully!";

    }

    @Override
    public UserResponseDTO searchByEmail(String email) {
        User user = userRepository.findByEmail(email);

        UserResponseDTO userResponseDTO = new UserResponseDTO();

        userResponseDTO.setId(user.getId());
        userResponseDTO.setName(user.getName());
        userResponseDTO.setGender(user.getGender());
        userResponseDTO.setEmail(user.getEmail());
        userResponseDTO.setPhone(user.getPhone());

        return userResponseDTO;
    }

    @Override
    public List<UserResponseDTO> searchByName(String name) {
        List<User> userList = userRepository.findByNameContaining(name  );

        List<UserResponseDTO> userResponseDTOList = new LinkedList<>();

        for(User user : userList){

            UserResponseDTO userResponseDTO = new UserResponseDTO();

            userResponseDTO.setId(user.getId());
            userResponseDTO.setName(user.getName());
            userResponseDTO.setGender(user.getGender());
            userResponseDTO.setEmail(user.getEmail());
            userResponseDTO.setPhone(user.getPhone());

            userResponseDTOList.add(userResponseDTO);
        }
        return userResponseDTOList;
    }

    private UserResponseDTO maptodto (User user){
        if(user ==null ) return null ;

        UserResponseDTO dto = new UserResponseDTO();
        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setGender(user.getGender());
        dto.setEmail(user.getEmail());
        dto.setPhone(user.getPhone());
        return dto;
    }


}
