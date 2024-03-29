# Whiskey Application

## Back End

This is an application that performs storing information of your own whiskey library in DB. 
It supports the following calls:

## Add Whiskey into DB (POST): 

Create a whiskey list
Sample call: 

```http://localhost:8080/newWhiseky```


## Whiskey in the DB (GET): 

Returns the present value of a single Whiskey
  
Sample call: 

```http://localhost:8080/getWhiskeyById/{id}```


## Update Whiskey in the DB (PUT): 

Updates value of a single Whiskey in DB
  
Sample call: 

```http://localhost:8080/updateWhiskey```

    
## Architecture

* Server:
    * SpringBoot (in Java)
    * Maven

* Testing:
    * Unit Tests through JUnit
    * Endpoint Testing through RestAssured

## Front End

This is a VUE application that create whiskey library. It allows the user save whiskey bottle in DB with detailed information and it's volume. Also the app has an update function it calculate whiskey volume when the user put the volume they consumed.

* Whiskey List 
* Whiskey Details
* Update whiskey information from DB
* Update the volume of the wiskey after comsuming  

## Project setup

```
npm install
npm run serve
```
### Customize configuration

See [Configuration Reference](https://cli.vuejs.org/config/).


## Visuals

![screenshot](https://github.com/YujoongKim/readme-files/blob/63c7c26d4830e1d111c1b4d665a5aae7eadeee41/whiskey.png)

