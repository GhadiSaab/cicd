# city-api

## Démarrage avec Docker

### Prérequis

Assurez-vous d'avoir installé sur votre machine :

- [Docker](https://docs.docker.com/engine/install/) et [Docker Compose](https://docs.docker.com/compose/install/)
- [Maven](https://maven.apache.org/install.html)

### Compilation et lancement

Placez-vous à la racine du projet et tapez :

```bash
./mvnw package
docker compose up --build -d
```

L'API sera accessible sur le port **2022**.

### Exemples de requêtes

**Lister les villes (GET) :**

```bash
curl http://localhost:2022/city
```

**Ajouter une ville (POST) :**

```bash
curl -X POST http://localhost:2022/city \
-H "Content-Type: application/json" \
-d '{
  "name": "Marseille",
  "departmentCode": "13",
  "inseeCode": "13055",
  "zipCode": "13000",
  "lat": 43.2965,
  "lon": 5.3698
}'
```

Pour vérifier la santé de l'application : `curl http://localhost:2022/_health -v`
La base de données PostgreSQL est sur le port **5433**.

### Arrêt

Arrêt standard (conserve les données) :

```bash
docker compose down
```

Arrêt avec réinitialisation de la base de données :

```bash
docker compose down -v
```

---

## Mode Développement

Pour utiliser le rechargement à chaud (Live Coding) et la Quarkus Dev UI :

1. Lancer uniquement la base de données :

```bash
docker compose up db -d
```

1. Démarrer Quarkus en mode dev :

```bash
./mvnw quarkus:dev
```

L'API est sur le port **2022**.
La Dev UI est accessible sur : `http://localhost:2022/q/dev-ui`

---

## Packaging

Pour compiler l'application de façon classique :

```bash
./mvnw package
```

Le fichier généré peut être exécuté avec :

```bash
java -jar target/quarkus-app/quarkus-run.jar
```
