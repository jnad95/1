# starting up docker containers
docker compose up -d

docker run --rm -p 80:80 \
amigoscode/kubernetes:hello-world

docker logs customer

docker ps --format=$FORMAT



#
docker compose pull

# shut down docker containers
docker compose down

docker kill pgadmin

docker rm -f $(docker ps -aq)

# current running docker container
docker compose ps

# logs for apigw container
docker logs apigw

# list locally checkout docker images
docker image ls

----------------

launch ctl print dockerd

----------------

mvn clean package -P build-docker-image

mvn archetype:generate \
-DgroupId=com.adityaja.app \
-DartefactId=my-app \
-DarchetypeArtefactId=maven-archetype-quickstart
-DarchetypeVersion=1.0
-DinteractiveMode=True

# Running web services from cli
java -jar eureka-server/target/eureka-server-1.jar

----------------
kubectl run hello-world \
--image=amigoscode/kubernetes:hello-world \
--port=80

kubectl get pods

minikube ip

minikube start --memory=4g

kubectl port-forward pod/hello-world 8080:80

kubectl delete pod hello-world

kubectl describe pod postgres-0

kubeclt logs postgres-0

kubectl apply -f bootstrap/postgres

kubectl version 

docker ps | grep kube-apiserver

kubectl config view


Maven
https://www.baeldung.com/maven-multi-module

Hibernate
https://www.youtube.com/watch?v=PMR0ld5h938&list=PLsyeobzWxl7qBZtsEvp_n2A7sJs2MpF3r
https://www.baeldung.com/hibernate-entity-lifecycle


Rest Template
https://www.baeldung.com/rest-template

Service Discovery
https://www.nginx.com/blog/service-discovery-in-a-microservices-architecture/

https://www.javatpoint.com/microservices-components-and-standardizing-port-and-url
https://stackoverflow.com/questions/66124729/microservice-architecture-can-you-eliminate-the-synchronous-calls-between-servi

https://www.nginx.com/blog/service-discovery-in-a-microservices-architecture/

https://devopscube.com/open-source-service-discovery/

https://etcd.io/

https://thorben-janssen.com/entity-lifecycle-model/

https://www.youtube.com/results?search_query=spring+smart+lifecycle

https://medium.com/@karthickrangasamy11/distributed-tracing-in-springboot-3-with-zipkin-micrometer-f0e542991042

https://rapidapi.com/collection/free-sms-apis

https://rapidapi.com/collection/list-of-free-apis

https://github.com/cloudcommunity/Cloud-Free-Tier-Comparison?tab=readme-ov-file
https://docs.docker.com/compose/gettingstarted/



prometheus
https://www.youtube.com/watch?v=STVMGrYIlfg


grafana
https://www.youtube.com/watch?v=lILY8eSspEo

EurekaServer
https://www.baeldung.com/spring-cloud-netflix-eureka

consul
https://developer.hashicorp.com/consul

grafana
https://grafana.com/