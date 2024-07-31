# Back-End Cursos 

# Descrição

<p>O Back-end de Cursos é um exercício da Rocketseat Java, esta API visa o aprendizado ne Java Spring, separando os aquicos em Controllers, Services, Repositories e Entities </p>

# Tecnologias

- Java
- Postgresql
- Docker

## Para clonar o repositório siga o passo a passo


```bash

$ git clone https://github.com/lucasnather/courses.git

$ cd courses

$ npm install

```

## Rodando a aplicação

```bash

#preencha seus dados em resources/aplication properties e no docker-compose.yaml

# subindo o banco de dados postgres
# o "-d" é para o container subir em modo detach
$ docker-compose up -d

# ver se o container está em execução
$ docker ps

# rodar a aplicação
$ Vá até o CoursesApplication.java e inicie o app ou "Shift + f10"
```

# Api Endpoints

1. Criar Cursos

<ul>
    <li>Metódo: POST</li>
    <li>URL: http://localhost:8080/courses</li>
    <li>Description: Cria Curso</li>
    <li>Response status: 201 CREATED</li>
    <li>Request Body:</li>

</ul>


```bash

  {
    "name": "Front-End",
    "category": "programming",
    "isActive": false
  }

```



2. Buscar todos os Cursos

<ul>
    <li>Metódo: GET</li>
    <li>URL: http://localhost:8080/courses</li>
    <li>Description: lista todos os cursos cadastrados </li>
    <li>Response status: 200 OK</li>
    <li>Response Payload: </li>
</ul>

```bash

    [
        {
            "id": "028916e1-3401-46f8-90eb-654cb683d098",
            "name": "Front-End",
            "isActive": false,
            "createdAt": "2024-07-29T17:27:49.789186",
            "updatedAt": "null",
            "category": "programming",
        }
  ]

```
3. Deletar Curso por Id

<ul>
    <li>Metódo: DELETE</li>
    <li>URL: http://localhost:8080/courses/{uuid}</li>
    <li>Description: deletar curso por id </li>
    <li>Response status: 203</li>
    <li>Request Param: UUID</li>
    <li>Response Payload: </li>

```bash

    {
        "message": "Curso deletado"
    }

```
</ul>

4. Atualizar Curso por Id

<ul>
    <li>Metódo: Put</li>
    <li>URL: http://localhost:8080/courses/{uuid}</li>
    <li>Description: atualizar curso por id </li>
    <li>Response status: 203</li>
    <li>Request Param: UUID</li>
    <li>Response Payload: </li>

```bash

    {
    "id": "cdc0fb7b-7736-4d98-afea-60d99ad593d0",
    "name": "Back-End",
    "isActive": false,
    "createdAt": "2024-07-31T08:19:15.99201",
    "updatedAt": "2024-07-31T08:19:28.382427",
    "category": "Server side"
}

```
</ul>

4. Atualizar Curso para ativo por Id

<ul>
    <li>Metódo: patch</li>
    <li>URL: http://localhost:8080/courses/{uuid}/active</li>
    <li>Description: atualizar curso para tivo por id </li>
    <li>Response status: 203</li>
    <li>Request Param: UUID</li>
    <li>Response Payload: </li>

```bash

    {
    "id": "cdc0fb7b-7736-4d98-afea-60d99ad593d0",
    "name": "Back-End",
    "isActive": true,
    "createdAt": "2024-07-31T08:19:15.99201",
    "updatedAt": "2024-07-31T08:19:28.382427",
    "category": "Server side"
}

```
</ul>


### Entidades

[X] Courses
id
name
category
isActive
createdAt
updatedAt

### Casos de Uso

[X] Deve se criar um curso
[X]  Deve se listar todos os cursos
[X] Deve se deletar um curso pelo Id
[x] Deve se atualizar qualquer campo um curso
[X] Deve se marcar o campo ativo como True


# Meus Objetivos com esta aplicação

<p>Aprimorando e aprendendo mais sobre Java e trazendo sabedorias de outras linguagens para melhorar a lógica</p>

# Fluxo da app

<p>Como eu desenvolvi a aplicação passo a passo (Pastas).</p>

<p>Entities -> Repository -> Service -> Controller </p>
