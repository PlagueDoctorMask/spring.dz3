package com.example.spring.dz3.services;

import com.example.spring.dz3.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {

    public DataProcessingService getDataProcessingService() {
        return dataProcessingService;
    }



    @Autowired
    private DataProcessingService dataProcessingService;

    @Autowired
    private UserService userService;
    @Autowired
    private NotificationService notificationService;

    public void processRegistration(String name, int age, String email){
        User user = new User();
        user.setName(name);
        user.setAge(age);
        user.setEmail(email);

        // Отправляем уведомление о создании нового пользователя
        notificationService.notifyUser(user);

        getDataProcessingService().getRepository().getUsers().add(user);

        notificationService.sendNotification("Пользователь добавлен в репозиторий");

    }

    //Поля UserService, NotificationService

    //Метод processRegistration
}
