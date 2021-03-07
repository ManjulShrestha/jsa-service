# Job Search Application

This application has four main components:
1. Identity (User, Roles, Authentication)
2. Company/Employer
3. Candidate
4. Job

User- A user can be an employee, and employeer or an admin. Depending upon the type the user, each user has their own roles and resources that they can access, RBAC is mainly handled in fronted rather than in service layer.

Authenication - Authentication is done using JWT, as this code was previously build without using spring framework there is conflict in spring security and old security. For now both of them are enabled and working side by side.

Company - A company is considered as a user with user type as company, a company will have its own profile, and after a company agrees to take a subscription, a company is able to post jobs.

Candidate - A candidate or a job seeker is able to create profile, search for jobs and apply for jobs, a candidate is not required to get subscription.

Job - Job can only be added by company that has a subscription, job can be viewed by any one, but a candidate needs to be registered to apply for job.

Payment - Payment is acheived using stripe, it still needs some work to be done in the front end to complete payment module.

# jsa-service
This is a service code build in spring-boot using hibernate and Mariadb as datbase.

To run the code you can use your favourite IDE, I personally use Intellij, it can also run using the mvn command
./mvnw spring-boot:run
