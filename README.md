# API 2

Este projeto é o gabarito de um desafio ministrado para a formação de desenvolvedor backend, no processo interno
na empresa Insoft 4.

O processo foi aberto para os colaboradores interessados na migração para área de desenvolvimento backend.

Para mim, foi designada a tarefa de mentoria nos assuntos Java e Grails. Durante esse processo foi realizado 
aulas/mentorias com os alunos, onde duvidas eram esclarecidas, também foram realizadas provas, onde a Prova 2 de Grails
consistia no desenvolvimento dessa API.

## Informações técnicas
Projeto desenvolvido usando as seguintes tecnologias:

* Grails 5
* Java 11
* Oracle para conexão de banco
* Postman (para realizar as [requisições](./src/main/request/postman/Mentoria.postman_collection.json))

## Enunciado

Para acessar o enunciado do desafio clique [aqui](./Desafio-2-Grails.md).

## Conexão de banco de dados

Para a execução é necessário conectar em um serviço de banco de dados pelo `application.yml`:

```yml
dataSource:
  username: '<user>'
  password: '<pass>'
  url: '<url-data-base>'
```
