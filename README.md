# Server Sent Event Using Spring Webflux, MongoDB and VueJS
### Prerequisite
  + Mongo DB version 5 or above
  + Java version 11
  + Node Js version 16 or above
  + Maven 3.8.4 or above

## Steps to Setup the Spring Boot Backend app (sse-service)
1. **Create database call "sse" on your MongoDB**
      
2. **Clone The Application**

      ```
	git clone https://github.com/ghemulyanto/server-sent-event.git
	```

3. **Run the app**

	Go to "sse-service" folder and you can run the spring boot app by typing the following command -

	```
	mvn spring-boot:run
	```

	The server will start on port 8080.
  
## Steps to run Frontend app (client-web-app)

1. **Go to the `client-web-app` folder**

   ```
   cd client-web-app
   ```
   
2. **Then type the following command to install the dependencies and start the application**

   ```
   npm i && npm run serve
   ```

  The front-end server will start on port `8081`.



