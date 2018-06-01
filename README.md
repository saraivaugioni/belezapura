# Beleza Pura

[![Build Status](https://travis-ci.org/saraivaugioni/belezapura.svg?branch=master)](https://travis-ci.org/saraivaugioni/belezapura)
[![GitHub stars](https://img.shields.io/github/stars/saraivaugioni/belezapura.svg)](https://github.com/saraivaugioni/belezapura/stargazers)
[![SonarQube Coverage](https://img.shields.io/sonar/http/sonar.petalslink.com/org.ow2.petals%3Apetals-se-ase/coverage.svg)](https://sonarcloud.io/dashboard?id=com.ugioni%3Abelezapura)

## Projeto

Software Beleza Pura / Java 8 + AngularJS + Wildfly-Swarm

## Instalação e execução local do projeto

- Build e dependências: [Maven](https://maven.apache.org/)
- Stack: [WildFly Swarm](http://wildfly-swarm.io/)

```
mvn clean wildfly-swarm:run
```

## Testes unitários e Cobertura de código

- [JUnit 5](https://junit.org/junit5/)

```
mvn clean test
```

## Integração contínua e Análise estática

- [Travis CI](https://travis-ci.org/saraivaugioni/belezapura)
- [SonarCloud](https://sonarcloud.io/dashboard?id=com.ugioni%3Abelezapura)
