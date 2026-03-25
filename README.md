# city-api

## Démarrage avec Docker

### Prérequis

Assurez-vous d'avoir installé sur votre machine :

- [Docker](https://docs.docker.com/engine/install/) et [Docker Compose](https://docs.docker.com/compose/install/)
- [Maven](https://maven.apache.org/install.html)

### Compilation et lancement

Placez-vous à la racine du projet et tapez :

```bash
mvn package
docker compose up --build -d
```

L'API sera accessible sur le port **2022**.
Pour vérifier : `curl http://localhost:2022/_health`
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
mvn quarkus:dev
```

L'API est sur le port **2022**.
La Dev UI est accessible sur : `http://localhost:2022/q/dev-ui`

---

## Packaging

Pour compiler l'application de façon classique :

```bash
mvn package
```

Le fichier généré peut être exécuté avec :

```bash
java -jar target/quarkus-app/quarkus-run.jar
```
