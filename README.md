# Brazilian cities Project

This project uses Quarkus and MongoDB to provide a list of brazilian cities using GraphQL interface.

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```shell script
./mvnw compile quarkus:dev
```

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at http://localhost:8080/q/dev/.

## Packaging and running the application

The application can be packaged using:
```shell script
./mvnw package
```
It produces the `quarkus-run.jar` file in the `target/quarkus-app/` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/quarkus-app/lib/` directory.

If you want to build an _über-jar_, execute the following command:
```shell script
./mvnw package -Dquarkus.package.type=uber-jar
```

The application is now runnable using `java -jar target/quarkus-app/quarkus-run.jar`.

## Creating a native executable

You can create a native executable using: 
```shell script
./mvnw package -Pnative
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using: 
```shell script
./mvnw package -Pnative -Dquarkus.native.container-build=true
```

You can then execute your native executable with: `./target/ws-munic-quarkus-graphql-1.0.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult https://quarkus.io/guides/maven-tooling.html.

## Related Guides

- RESTEasy JAX-RS ([guide](https://quarkus.io/guides/rest-json)): REST endpoint framework implementing JAX-RS and more

- SMALLRYE GRAPHQL ([guide](https://quarkus.io/guides/smallrye-graphql))

## Provided Code

### RESTEasy JAX-RS

Easily start your RESTful Web Services

[Related guide section...](https://quarkus.io/guides/getting-started#the-jax-rs-resources)

### Quarkus GraphQL

Quarkus offers out-of-the-box graphql integration, by accessing the following places:

- To play around with your GraphQL queries: [GraphQL UI...] http://localhost:8080/q/graphql-ui

- To check out your GraphQL schema: [GraphQL Schema...] http://localhost:8080/graphql/schema.graphql

### GraphQL call examples
```graphql
{
  cities {
  	codIbge
  	codTOM
  	state
  	name
  }
  
  citiesByState(state: AC){
    codIbge
  	codTOM
  	name
    municipalizationLevel
  }
  
  cityByIbge(code: 4208203){
  	codTOM
  	state
  	name
    municipalizationLevel
    police {
      name
    }
    regional {
      resume
      description
      abbreviation
    }
    basin {
      name
    }
  }
}
```