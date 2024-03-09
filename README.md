# full-stack-projects-2

A comprehensive Survey Application with role based authentication (Admin and User roles).

- The home page of the application has two links one for login and one for signup

  ![project2-1](https://github.com/Kedhar193/full-stack-projects-2/assets/115712936/03c0954c-32ad-405b-8368-0f276b5ea3c2)

  

- This application has **login and signup** mechanisms to authorize users . **The passwords are encrypted** carefully and stored in the database with the username .

  

- The application implements role based authentication . It basically contains two roles 1. admin   2. user


- **Only admin is able to access createsurvey.html page** which is to create surveys . The surveys are stored in MySql database maintaining proper structure and organization of questions and dynamic options . A survey can have any number of questions and each question can have any number of options . Only admin can create Survey and user can only access and answer surveys .

  ![project2-2](https://github.com/Kedhar193/full-stack-projects-2/assets/115712936/4b20a668-31da-476e-ac35-2b77833f0be6)

  ###### Here I am able to access create survey page since i am logging using admin mail and password .

  
  ![project2-3](https://github.com/Kedhar193/full-stack-projects-2/assets/115712936/156176a3-ba27-4275-b98a-13d575f2aa72)

  ###### Here I am logging in with user mail and password instead of admin


  ![project2-4](https://github.com/Kedhar193/full-stack-projects-2/assets/115712936/2f288013-8a6c-4eeb-8e25-8dedd69fb4e1)


  ###### I couldnot access the create survey html page since i am using user mail and password

  ![project2-5](https://github.com/Kedhar193/full-stack-projects-2/assets/115712936/e7fea351-cf61-470b-a447-fefd1c6b1c8f)


  ###### But user can give response to the surveys

  ![project2-6](https://github.com/Kedhar193/full-stack-projects-2/assets/115712936/3608e295-d13e-4696-a872-8147feb78307)


  when user submits the response the option count for that particular question is incremented in database


  ![Screenshot (78)](https://github.com/Kedhar193/full-stack-projects-2/assets/115712936/995f1571-4ed6-41e9-b31d-a8c6606bddc1)



