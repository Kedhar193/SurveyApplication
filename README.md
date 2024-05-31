# Survey Application

## Overview

  - This Survey Application allows admin to create surveys . Users can give response to the surveys . Application incorporates proper authentication and authorization .

## Features
  - User authorization

  - Role based authentication

  - Survey creation . Each survey can have any number of questions and each question can have any number of options (dynamic questions and options).

  - Password Encryption  

  - Response submission
  
  - Data base integration

## Technologies Used

  -Spring Boot

  -Html , Css , Javascript

  -Thymeleaf

  -Spring Security

  -Spring Data Jpa

  -Hibernate

  -MySql


## Demo


A comprehensive Survey Application with role based authentication (Admin and User roles).

- The home page of the application has two links one for login and one for signup

  ![Screenshot 2024-05-31 131928](https://github.com/Kedhar193/full-stack-projects-2/assets/115712936/be86c233-0011-46f1-a033-621f1fbd0d8d)


  

- This application has **login and signup** mechanisms to authorize users . **The passwords are encrypted** carefully and stored in the database with the username .

  

- The application implements role based authentication . It basically contains two roles 1. admin   2. user




- **Only admin is able to access createsurvey.html page** which is to create surveys . The surveys are stored in MySql database maintaining proper structure and organization of questions and dynamic options . A survey can have any number of questions and each question can have any number of options . Only admin can create Survey and user can only access and answer surveys .

 ![Screenshot 2024-05-31 132245](https://github.com/Kedhar193/full-stack-projects-2/assets/115712936/612702a0-a82b-4ded-85e6-cb0d83dc7f97)





- ###### Here I am able to access create survey page since i am logging using admin mail and password .

  
  ![Screenshot 2024-05-31 142251](https://github.com/Kedhar193/full-stack-projects-2/assets/115712936/585787f5-1e4b-48c7-88db-31136d1bc95b)




- ###### Here I am logging in with user mail and password instead of admin


  ![project2-4](https://github.com/Kedhar193/full-stack-projects-2/assets/115712936/2f288013-8a6c-4eeb-8e25-8dedd69fb4e1)




- ###### I couldnot access the create survey html page since i am using user mail and password

  ![project2-5](https://github.com/Kedhar193/full-stack-projects-2/assets/115712936/e7fea351-cf61-470b-a447-fefd1c6b1c8f)




- ###### But user can give response to the surveys

  ![project2-6](https://github.com/Kedhar193/full-stack-projects-2/assets/115712936/3608e295-d13e-4696-a872-8147feb78307)




- ###### when user submits the response the option count for that particular question is incremented in database


  ![Screenshot (78)](https://github.com/Kedhar193/full-stack-projects-2/assets/115712936/995f1571-4ed6-41e9-b31d-a8c6606bddc1)



