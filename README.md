# Adobe Coding Assignment

This repository contains the source code for a RESTful API that allows users to create, update, and delete posts, as well as view various analytics about users and posts. The API was built using Java with the Spring Boot framework and is connected to a MySQL database.

## Live API

You can access the live API at https://adobeassignment-production.up.railway.app/. 

### User Endpoints

- POST /users: Create a new user.
- GET /users/{id}: Retrieve a user by id.
- PUT /users/{id}: Update a user's name or bio by id.
- DELETE /users/{id}: Delete a user by id.
- GET /analytics/users: Retrieve the total number of users.
- GET /analytics/users/top-active: Retrieve the top 5 most active users, based on the number of posts.

### Post Endpoints

- POST /posts: Create a new post. The request should include the user_id.
- GET /posts/{id}: Retrieve a post by id.
- PUT /posts/{id}: Update a post's content by id.
- DELETE /posts/{id}: Delete a post by id.
- POST /posts/{id}/like: Increment the like count of a post by id.
- POST /posts/{id}/unlike: Decrement the like count of a post by id. The count should not go below 0.
- GET /analytics/posts: Retrieve the total number of posts.
- GET /analytics/posts/top-liked: Retrieve the top 5 most liked posts.

### Validation

Basic validation is implemented for input data to ensure required fields are present and in the correct format, and the maximum length of string fields is not exceeded.

## Swagger UI

You can explore and test the API using the Swagger UI at https://adobeassignment-production.up.railway.app/swagger-ui/index.html#/.

## Deployment

The API is deployed on [Railway](https://railway.app/), a platform for deploying and managing web apps and databases.

## Technology Used

- Java
- Spring Boot
- MySQL
- Swagger UI

## Author

This API was created by [Rahul Kumar](https://github.com/Rahul9332935).
