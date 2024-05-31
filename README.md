# Survey Application

## Overview

  - This Survey Application enables admins to create surveys and users to respond to them. It incorporates robust authentication and authorization mechanisms to ensure secure access control.


## Features
  - User Authorization

  - Role based authentication

  - Survey Creation: Admins can create surveys with any number of questions and options.

  - Password Encryption  

  - Response Submission
  
  - Database Integration

## Technologies Used

  -Spring Boot

  -Html , Css , Javascript

  -Thymeleaf

  -Spring Security

  -Spring Data Jpa

  -Hibernate

  -MySql


## Demo


This comprehensive Survey Application features role-based authentication with Admin and User roles.

## Home Page

- The home page includes buttons for login and signup

  ![Screenshot 2024-05-31 131928](https://github.com/Kedhar193/full-stack-projects-2/assets/115712936/be86c233-0011-46f1-a033-621f1fbd0d8d)


## Authentication Mechanisms  

- The application includes secure login and signup mechanisms. Passwords are encrypted and stored securely in the database.

## Role-Based Authentication

The application supports two roles:

**Admin**: Can create surveys.

**User**: Can respond to surveys.

## Admin Access

Admins can access the createsurvey.html page to create surveys. Each survey can have multiple questions, and each question can have multiple options.

 ![Screenshot 2024-05-31 132245](https://github.com/Kedhar193/full-stack-projects-2/assets/115712936/612702a0-a82b-4ded-85e6-cb0d83dc7f97)





- ###### Here I am able to access create survey page since i am logging using admin mail and password .

  
  ![Screenshot 2024-05-31 142251](https://github.com/Kedhar193/full-stack-projects-2/assets/115712936/585787f5-1e4b-48c7-88db-31136d1bc95b)


## User Access

- ###### Here I am logging in with user mail and password instead of admin


  ![Screenshot 2024-05-31 142942](https://github.com/Kedhar193/full-stack-projects-2/assets/115712936/3f633c9b-a968-4bed-aea3-43c3097fcb92)





- ###### I couldnot access the create survey html page since i am using user mail and password

  ![project2-5](https://github.com/Kedhar193/full-stack-projects-2/assets/115712936/e7fea351-cf61-470b-a447-fefd1c6b1c8f)




- ###### But user can give response to the surveys

  ![Screenshot 2024-05-31 143128](https://github.com/Kedhar193/full-stack-projects-2/assets/115712936/9ffc2843-ed7b-457d-bbc3-2091ef912fa8)



## Response Submission

- ###### when user submits the response the option count for that particular question is incremented in database


  ![Screenshot (78)](https://github.com/Kedhar193/full-stack-projects-2/assets/115712936/995f1571-4ed6-41e9-b31d-a8c6606bddc1)



