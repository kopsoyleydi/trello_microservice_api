package com.example.user_service.service;



import com.example.user_service.dto.mapper.UserPaginationMapper;
import com.example.user_service.model.ModelImpliments.RoleIMPL;
import com.example.user_service.model.ModelImpliments.UserIMPL;
import com.example.user_service.config.bucket.S3Service;
import com.example.user_service.dto.UserDTO;
import com.example.user_service.dto.mapper.UserMapper;
import com.example.user_service.model.ModelImpliments.UserPaginationIMPL;
import com.example.user_service.model.Role;
import com.example.user_service.model.User;
import com.example.user_service.model.repository.UserRepository;
import com.example.user_service.requestBodies.UserRequest;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.logging.Logger;

@Service
@Slf4j
public class UserRestService implements UserDetailsService {

    @Autowired
    private UserIMPL userIMPL;

    @Autowired
    private RoleIMPL roleIMPL;

    @Autowired
    private UserPaginationIMPL userPaginationIMPL;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserPaginationMapper userPaginationMapper;

    @Autowired
    private S3Service s3Service;

    @Autowired
    private UserRepository userRepository;


    private static final Logger logger = Logger.getLogger(String.valueOf(UserRestService.class));

    public Page<UserDTO> getAllUsers(Pageable pageable){
        return userPaginationMapper.toPageList(userPaginationIMPL.getPageWithAllUsers(pageable));
    }

    public UserDTO getUserById(Long id){
        return userMapper.toDto(userIMPL.getUserById(id));
    }

    public void changeUser(UserDTO userDTO){
        userMapper.toDto(userIMPL.changeUserInformation(userMapper.toModel(userDTO)));
    }

    public UserDTO addNewUser(UserRequest userRequest){
        Role role = roleIMPL.getRoleById(1L);
        List<Role> roles = new ArrayList<>();
        roles.add(role);
        User user = User.builder()
                .name(userRequest.getName())
                .password(userRequest.getPassword())
                .dateOfBirth(userRequest.getDateOfBirth())
                .surname(userRequest.getSurname())
                .email(userRequest.getEmail())
                .roles(roles).
                build();
        logger.info("success");
        return userMapper.toDto(userIMPL.addNewUser(user));
    }

    public UserDTO putProfileImage(MultipartFile multipartFile, Long userId) throws IOException {
        String profileImageId = UUID.randomUUID().toString();
        UserDTO user = getUserById(userId);
        s3Service.putObject(
                "bekscloud",
                "trello_service/user_avatars/%s/%s".formatted(userId,profileImageId),
                multipartFile.getBytes()
        );
        user.setProfileUrl(profileImageId);
        changeUser(user);
        logger.info("success");
        return user;
    }

    public byte[] getFileFromAws(Long userId) throws IOException{
        try {
            User user = userIMPL.getUserById(userId);
            logger.info("Success");
            byte[] ImageBytes =
                    s3Service.getObject(
                            "bekscloud", "trello_service/user_avatars/%s/%s"
                                    .formatted(user.getId(),
                                            user.getProfileUrl()));
            return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(ImageBytes).getBody();
        }
        catch (Exception e){
            e.getStackTrace();
        }
        return null;
    }

    public UserDTO changeUserInformation(UserRequest userRequest){
        User user = User.builder()
                        .id(userRequest.getId())
                                .surname(userRequest.getSurname())
                                        .name(userRequest.getName())
                                                .dateOfBirth(userRequest.getDateOfBirth()).build();
        return userMapper.toDto(userIMPL.changeUserInformation(user));
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> credential = userRepository.findByEmail(username);
        return credential.map(User::new)
                .orElseThrow(() -> new UsernameNotFoundException(
                        "user not found with name :" + username));
    }
}
