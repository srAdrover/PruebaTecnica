# PruebaTecnica

1. Introduction
2. Used Software
3. Api Endpoints
4. Deployment


### 1. Introduction

This application allows the management of the superheroes school. 
You can consult all data of the superheroes, update it and delete it.

### 2. Used Software

- Java 11.0.17 as development language
- Maven 3.5.4 as project manager
- Spring Boot 2.0.7 as Framework to simplify the development
- IntelIJ as development IDE
- Docker 20.10.22 as deployment tool

### 3. Api endpoints

The application is deployed on the port 8080.

- ***GET*** <localhost:8080/prueba-tecnica/allSuperHeroes>
  + To get the data of the all superheroes
- ***GET*** <localhost:8080/prueba-tecnica/superHero/{heroID}>
  + To get the data of the specific superhero
- ***GET*** <localhost:8080/prueba-tecnica/superHeroByName/{superHeroName}>
  + To get all the data of the superheros whose name matches with the introduced word
- ***POST*** <localhost:8080/prueba-tecnica/updateSuperHero>
  + To update the data of the superhero with the data introduced on the body request. Yoy need to specify the superhero id
- ***DELETE*** <localhost:8080/prueba-tecnica/deleteSuperHero/{heroID}>
  + To delete the superhero specified by id
- ***GET*** <localhost:8080/prueba-tecnica/clearCache>
  + To clean the cache

### 4. Deployment

The application is dockerized. You only need Docker to deploy this application. [Download Docker](https://www.docker.com/products/docker-desktop/)

You have to:
- download this repository 
- build an image of the application
- run it.

Once the application is downloaded, you have to open your terminal and direct you into the main directory of the project

``cd {PATH}/pruebaTecnica``

When you have Docker installed then you build an image

``docker build -t docker-hub/prueba-tecnica:0.0.1 .``

Finally, run the image

``docker run -p 8080:8080 docker-hub/prueba-tecnica:0.0.1``

Your application is running on the port 8080