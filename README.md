# Docker
### Starting up docker containers
```
docker compose up -d
```
### Starts container exposing on port 80
```
docker run --rm -p 80:80 \
amigoscode/kubernetes:hello-world
```
### Retrieving logs from given container
```
docker logs customer
```
### List currently running Docker containers
``` 
docker ps --format "table {{.ID}}\t{{.Names}}\t{{.Image}}\t{{.Status}}\t{{.Ports}}"
```
```
docker-compose ps
```
### Pulls latest version of Docker containers(as per docker-compose.yml)
```
docker compose pull
```
### Stops and removes the Docker containers
```
docker compose down
```
### Forcefully stop a running container
```
docker kill pgadmin
```
### Remove all Docker containers, including those that are currently running
```
docker rm -f $(docker ps -aq)
```
### List all the locally available Docker images  
```
docker image ls
```
### Displays information about Docker daemon
```
docker info
```
----------------
# Maven 
### Clean, Compile and Package Code. Activates `build-docker-image` maven profile.
```
mvn clean package -P build-docker-image
```
### Creates new Maven project from archetype
```
mvn archetype:generate \
-DgroupId=com.adityaja.app \
-DartefactId=my-app \
-DarchetypeArtefactId=maven-archetype-quickstart
-DarchetypeVersion=1.0
-DinteractiveMode=True
```
----------------
# Java
### Execute a Java application packaged as an executable JAR
```
java -jar eureka-server/target/eureka-server-1.jar
```
----------------
# Kubernetes
### Creating new Kubernetes deployment with name:`bye-world` using image: `amigoscode/kubernetes:hello-world` 
```
kubectl run bye-world \
--image=amigoscode/kubernetes:hello-world \
--port=80
```
### Retrieve currently running pods
```
kubectl get pods
```
### sets up a port forwarding from your local machine to a specific pod running in your Kubernetes cluster.
#### Any traffic sent to localhost:8080 on local machine will be forwarded to port 80 of the hello-world pod in your Kubernetes cluster.
```
kubectl port-forward pod/hello-world 8080:80
```
### Delete "hello-world" pod
```
kubectl delete pod hello-world
```
### Describes details and Status for the given pod
```
kubectl describe pod postgres-0
```
### Retrieve logs from pod `postgres`
```
kubeclt logs postgres-0
```
### Create/Update Kubernetes all the resources using specifications files mentioned at `bootstrap/postgres`
```
kubectl apply -f bootstrap/postgres
```
### Current kubernetes version
```
kubectl version
```
### Display current Kubernetes configuration
```
kubectl config view
```
----------------
# Minikube
### Retrieve IP address of locally running Kubernetes cluster
```
minikube ip
```
### Start Kubernetes cluster locally
```
minikube start --memory=4g
```
----------------
# References
### Maven
- https://www.baeldung.com/maven-multi-module
### Hibernate
- https://www.youtube.com/watch?v=PMR0ld5h938&list=PLsyeobzWxl7qBZtsEvp_n2A7sJs2MpF3r
- https://www.baeldung.com/hibernate-entity-lifecycle
- https://thorben-janssen.com/entity-lifecycle-model/
### Rest Template
- https://www.baeldung.com/rest-template
### Service Discovery
- https://www.nginx.com/blog/service-discovery-in-a-microservices-architecture/
- https://devopscube.com/open-source-service-discovery/
- EurekaServer: https://www.baeldung.com/spring-cloud-netflix-eureka
- Consul: https://developer.hashicorp.com/consul
- https://www.javatpoint.com/microservices-components-and-standardizing-port-and-url
- https://stackoverflow.com/questions/66124729/microservice-architecture-can-you-eliminate-the-synchronous-calls-between-servi
### Distributed key-value(Config store)
- ETCD: https://etcd.io/
### Spring
- https://www.youtube.com/results?search_query=spring+smart+lifecycle
- https://start.spring.io/
### Distributed Tracing
- https://medium.com/@karthickrangasamy11/distributed-tracing-in-springboot-3-with-zipkin-micrometer-f0e542991042
- Prometheus: https://www.youtube.com/watch?v=STVMGrYIlfg
- Grafana: https://www.youtube.com/watch?v=lILY8eSspEo
### Free APIs
- https://rapidapi.com/collection/free-sms-apis
- https://rapidapi.com/collection/list-of-free-apis
### Free cloud 
- https://github.com/cloudcommunity/Cloud-Free-Tier-Comparison?tab=readme-ov-file
### Docker
- https://docs.docker.com/compose/gettingstarted/