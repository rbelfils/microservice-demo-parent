---
Les commandes swarm

docker pull phpmyadmin/phpmyadmin:latest 
docker pull dockersamples/visualizer:latest

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


7) Faire une requete post :


curl -H docker -d '{
  "rdvDate" : "2017-11-27T00:00:00.000+0000",
    "customer" : {
        "name" : "BELFILS",
          "firstname" : "Romain",
            "email" : "romain.belfils@gmail.com"
    }
}' -H "Content-Type: application/json" -X POST http://<url>/micro-rdv/rdvs

curl GET http://<url>/micro-customer/customers/1

phpmyadmin ou adminer port 8383 permet de visualiser les ligne

voir les event kafka aussi pour montrer les messages:
  Lecture kafka topic : 
	Se connecter au conteneur :
		docker exec -it <nom_conteneur> /bin/sh
	puis en console :
		kafka-console-consumer.sh --topic customer --group keyteo --bootstrap-server kafka:9092

Maintenance: 

	docker service update --label-add "traefik.frontend.rule=PathPrefix:/" demo_maintenance
	docker service update --label-add "traefik.frontend.priority=15" demo_maintenance
