# list4u_backend

### pull mongodb image
> docker pull mongo

### create mongoDB container

> docker run --name list4u_mongodb -e MONGO_INITDB_ROOT_USERNAME=root -e MONGO_INITDB_ROOT_PASSWORD=dqm50vnc -p 27017:27017 -d mongo

### download mongodb GUI (Robo 3T)

> https://robomongo.org/

### add mongodb-driver-sync dependency

> implementation 'org.mongodb:mongodb-driver-sync:4.2.3'