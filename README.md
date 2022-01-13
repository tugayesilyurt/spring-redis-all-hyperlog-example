# Docker Compose Spring Boot,Redis All example also using Hyperlog for daily monitoring user

## Run the System
We can easily run the whole with only a single command:

* `docker-compose up --scale redis-sentinel=3 -d`

## Redis All Example in here

+ ValueOperations
+ ListOperations
+ SetOperations
+ HashOperations
+ HyperLogLogOperations

### EndPoints ###

| Service           | EndPoint                      | Method | Description               |
| ----------------- | ----------------------------- | :-----:| ------------------------- |
| Redis Key Value   | /v1/redis/add    				| POST   | ValueOperations           |
| Redis Key Value   | /v1/redis?key={key}        	| GET    | ValueOperations       	 |
| Redis List        | /v1/redis/add/list        	| POST   | ListOperations     	     |
| Redis List        | /v1/redis/list        		| GET    | ListOperations     	     |
| Redis Set         | /v1/redis/add/set         	| POST   | SetOperations     	     |
| Redis Set         | /v1/redis/set        	      	| GET    | SetOperations     	     |
| Redis Hash        | /v1/redis/add/hash    	    | POST   | HashOperations     	     |
| Redis Hash        | /v1/redis/hash/{id}    	    | GET    | HashOperations     	     |
| Redis Hash        | /v1/redis/hash/{id}    	    | DELETE | HashOperations     	     |
| Redis Hyperlog    | /v1/redis/hyperlog/add   	    | POST   | HyperLogLogOperations     |
| Redis Hyperlog    | /v1/redis/hyperlog     	    | GET    | HyperLogLogOperations     |


### Hyperlog Monitoring for daily using app ###

- **Hyperlog Monitoring**

![Hyperlog](https://github.com/tugayesilyurt/spring-redis-all-hyperlog-example/blob/main/assets/Grafana.PNG)

--------------------------------------------------------------------------------------------------------------

- **Redis GUI**

![Redis GUI](https://github.com/tugayesilyurt/spring-redis-all-hyperlog-example/blob/main/assets/RedisGUI.PNG)

--------------------------------------------------------------------------------------------------------------

- **DockerSentinel**

![DockerSentinel](https://github.com/tugayesilyurt/spring-redis-all-hyperlog-example/blob/main/assets/DockerSentinel.PNG)

--------------------------------------------------------------------------------------------------------------
	
- **Docker**

![Docker](https://github.com/tugayesilyurt/spring-redis-all-hyperlog-example/blob/main/assets/Docker.PNG)

--------------------------------------------------------------------------------------------------------------
	
- **Postman**

![Postman](https://github.com/tugayesilyurt/spring-redis-all-hyperlog-example/blob/main/assets/Postman.PNG)