# Beleza Pura

[![Build Status](https://travis-ci.org/saraivaugioni/belezapura.svg?branch=master)](https://travis-ci.org/saraivaugioni/belezapura)
[![SonarQube Coverage](https://sonarcloud.io/api/project_badges/measure?project=com.ugioni%3Abelezapura&metric=coverage)](https://sonarcloud.io/component_measures?id=com.ugioni%3Abelezapura&metric=coverage)
[![GitHub stars](https://img.shields.io/github/stars/saraivaugioni/belezapura.svg)](https://github.com/saraivaugioni/belezapura/stargazers)

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
