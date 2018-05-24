---
Les commandes swarm

0) mvn clean package <= sur le projet parent
1) docker-compose -f docker-compose-stack.yml build
2) docker stack deploy -c docker-compose-stack.yml demo
3) Définir dans le fichier Host de windows le DNS "127.0.0.1 docker"
4) URL localhost:8080 <= dashboard traefik
5) POST et un GEt a faire
6) docker stack rm demo <= suppression de demo

pour la scalabilite d'un service : "docker service ls" puis "docker service scale <nom_ms>=3"
docker container kill <id_container>
Vérifier qu'il est remonté dans le swarm.
