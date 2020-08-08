# cake-factory

In this liveProject you will help create an e-commerce web application for a company called “Cake Factory.” It is a small, independent bakery located in North London which focuses on high-quality bread and pastries with quick delivery to local residents (within 30 minutes). The founder of the bakery has a simple idea for her business: people want high-quality pastries and bread delivered for breakfast or lunch, but they don’t have enough time to go pick them up.[Manning liveProject](https://www.manning.com/liveproject/building-an-e-commerce-web-application-with-spring-boot)

# To install and test PostgreSQL using Docker
- ``docker pull postgres:latest``
- ``docker run --name [use-any-name-you like] -p 5432:5432 -e POSTGRES_PASSWORD=[your-password] -d postgres:latest``
- ``docker exec dev-postgres psql -U postgres -c"CREATE DATABASE [your-dbname]" postgres``

## Delete and create a new PostgreSQL database instance

- ``docker rm -f dev-postgres``
- ``docker run --name [use-any-name-you like] -p 5432:5432 -e POSTGRES_PASSWORD=[your-password] -d postgres:latest``
- ``[use-any-name-you like]``

## Entering the postgres container
docker exec -it [name-of-container] psql -U postgres

#### Connecting to a database
``\c <database_name>``

#### Viewing the tables

To check all the tables:
``\d`` 

To check the details of a particular table:
``\d+ <table_name>``

## Useful Resouces
- [Domain Object Persistence](https://dzone.com/articles/domain-object-persistence)
- [Persistence Model and Domain Model](https://stackoverflow.com/questions/14024912/ddd-persistence-model-and-domain-model)
- [Access the PostgreSQL command line terminal through Docker](https://github.com/Radu-Raicea/Dockerized-Flask/wiki/%5BDocker%5D-Access-the-PostgreSQL-command-line-terminal-through-Docker)





