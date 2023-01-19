# Introduction


## Useful Links
-H2 DataBase : http://localhost:8080/h2-console


### How to use the API

- Create a user

To create a user we need to input the user name, the user birthdate and the residence country to create the user in the database. We can also input the phone number and the gender, which are not obligatory. As only adult French residents are allowed to create an account, so it will return a code 400 if the user is not adult or ot a french.

Link : POST http://localhost:8080/api/users

- Find a user by ID

An id is entitled to a user when it's created. If it's found, it will be returned which the necessary infos stored in the database.
If not, it will return a http status 404.

Link : GET http://localhost:8080/api//users/{id}

### How to build from the source

-Git clone

-Install maven dependencies

-Build and run the project


