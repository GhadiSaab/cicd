# city-api 🏙️

## 🚀 Démarrage rapide (Le plus simple avec Docker)

Assurez-vous d'avoir [Docker](https://docs.docker.com/get-docker/) et [Docker Compose](https://docs.docker.com/compose/install/) installés.

Pour compiler l'application puis lancer toute la stack (Base de données PostgreSQL + API Java), placez-vous à la racine du projet et tapez :

```bash
mvn package
docker compose up --build -d
```

L'API sera alors accessible localement sur le port **2022** (et la base de données sur le port **5433**).

Vous pouvez vérifier que l'API est en ligne en appelant la route de santé interne :

```bash
curl http://localhost:2022/_health
```

Pour arrêter le projet proprement (sans perdre les données de la base) :

```bash
docker compose down
```

Pour arrêter le projet ET réinitialiser la base de données :

```bash
docker compose down -v
```

---

## 🛠️ Mode Développement (Live Coding & Dev UI)

En mode développement, Quarkus offre le "Live Coding" (rechargement à chaud de votre code) et une **Dev UI** contenant plein d'outils bien pratiques.
Pour l'utiliser, il faut déléguer la base de données à Docker, mais lancer l'application Quarkus "localement" via Maven :

1. **Lancer uniquement la base de données** avec Docker :

```bash
docker compose up db -d
```

1. **Démarrer Quarkus en mode dev** :

```bash
mvn quarkus:dev
```

L'API sera disponible sur le port **2022** (défini dans le `.env`) et la **Dev UI** sera accessible à l'adresse suivante :
👉 **<http://localhost:2022/q/dev-ui>** ou **<http://localhost:2022/q/dev>**

---

*Note: Les explications ci-dessous ont été générées automatiquement par Quarkus à la création du projet.*

## Packaging and running the application

The application can be packaged using:

```shell script
mvn package
```

It produces the `quarkus-run.jar` file in the `target/quarkus-app/` directory.
Be aware that it’s not an *über-jar* as the dependencies are copied into the `target/quarkus-app/lib/` directory.

The application is now runnable using `java -jar target/quarkus-app/quarkus-run.jar`.

If you want to build an *über-jar*, execute the following command:

```shell script
mvn package -Dquarkus.package.jar.type=uber-jar
```

The application, packaged as an *über-jar*, is now runnable using `java -jar target/*-runner.jar`.

## Creating a native executable

You can create a native executable using:

```shell script
mvn package -Dnative
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using:

```shell script
mvn package -Dnative -Dquarkus.native.container-build=true
```

You can then execute your native executable with: `./target/city-api-1.0.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult <https://quarkus.io/guides/maven-tooling>.

## Related Guides

- Hibernate ORM with Panache ([guide](https://quarkus.io/guides/hibernate-orm-panache)): Simplify your persistence code for Hibernate ORM via the active record or the repository pattern
- REST Jackson ([guide](https://quarkus.io/guides/rest#json-serialisation)): Jackson serialization support for Quarkus REST. This extension is not compatible with the quarkus-resteasy extension, or any of the extensions that depend on it
- SmallRye Health ([guide](https://quarkus.io/guides/smallrye-health)): Monitor service health
- JDBC Driver - PostgreSQL ([guide](https://quarkus.io/guides/datasource)): Connect to the PostgreSQL database via JDBC
- YAML Configuration ([guide](https://quarkus.io/guides/config-yaml)): Use YAML to configure your Quarkus application
