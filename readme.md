# Microservice Kafka Sample


```
enabled: true
built_in_css: true
level_classes: [yellow, red, blue, green]
```

Il s'agit d'une application en lien avec l'auteur principal de certains composant (https://github.com/ewolff/microservice-kafka).

Il y a 2 micro service fat jar  en spring boot :
    - microservice-demo-create-customer
    - microservice-demo-create-rdv
    
Ces micro-services sont lié par des images docker MYSQL et KAFKA + ZOOKEEPER

Les micro service sont liéq par traefic un reverse proxy.


Exemple d'appel de requetes :

Sans traefik et en exposant le port 8080 sur l'interface public (0.0.0.0) dans le docker-compose.yml.
1) microservice-demo-create-rdv (http://localhost:8080/rdv/rdvs)

- RDV (POST)
```{
  "rdvDate" : "2017-11-27T00:00:00.000+0000",
    "customer" : {
        "name" : "BELFILS",
          "firstname" : "Romain",
            "email" : "romain.belfils@gmail.com"
    }
}
```

Ce micro-service pousse dans la file kafka un customer qui sera enregistré avec le microservice 'microservice-demo-create-customer':

2) Le customer sera lu en se connectant au topic 'customer' et créera le customer dans sa base de données. 

3) check kafka consume
Pour vérifier les éléments contenus dans kafka :<br/>
Se connecter au docker kafka (`docker exec -it  demo_kafka_1 /bin/sh`)
executer la commande suivante (`kafka-console-consumer.sh --bootstrap-server kafka:9092 --topic customer --from-beginning`)


# Utilisation de TRAEFIK

- Mise en place d'un Reverse-Proxy (traefik)
- Mise en place d'une health dans les micro service avec spring

1) Mettre dans son fichier host la ligne suivante : ```127.0.0.1 docker```
2) Ouvrir sont navigateur et vérifier les docker existant avec l'URL suivante : 
- http://docker:8080/dashboard/

3) Vous pouvez-accéder aux micro services avec les URL suivante :
    - http://docker/micro-customer/customers
    - http://docker/micro-customer/health
    
    - http://docker/micro-rdv/admin/ping
    - http://docker/micro-rdv/health
    
    [POST]
    - http://docker/micro-rdv/rdvs
 
