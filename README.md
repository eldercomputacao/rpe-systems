# rpe-systems

A arquitetura na imagem logo abaixo apresenta uma possível solução para o desafio técnico proposto pelo time da RPE.

A solução apresenta um sistema com três aplicativos: 
- Um para controle de produto (app-products) 
- Um para controle de cartão (app-card) 
- E outro para controle de portador (app-customer) 

<img src="/img/diagrama-rpe.png">

Os fluxos de comunicação entre os aplicativos é bem simples de entender. 

A comunicação entre os aplicativos (app-customer e app-card) funciona de duas formas; primeira, através da \
fila (queue-card), onde app-customer envia dados de cartão para serem validados e salvos no app-card; \
e também, através de chamada HTTP, onde o app-customer pode obter dados de cartão e produto para um portador.

A comunicação entre os aplicativos (app-card e app-card) funciona apenas através da chamada HTTP, \
onde o app-card pode obter dados de produtos. 

A seguir execute os passos descritos abaixo para rodar todo o sistema e testar algumas funcionalidades disponíveis.

### 1. Rodando sistema localmente

Clone o projeto do GitHub em um diretório de sua preferência:

```bash
  git clone git@github.com:eldercomputacao/rpe-systems.git
```

Entre no diretório do projeto

```bash
  cd rpe-systems
```

Inicie todo sistema

```bash
  docker-compose up -d
```

Verifique se todo sistema está UP

```bash
  docker-compose ps
```

### 2. Teste algumas funcionalidades disponíveis

Em caso de todo sistema estiver executando, podemos testar algumas funcionalidades.

### 2.1 app-products

Use essa URL (http://localhost:8080/swagger-ui/index.html) para ter acesso ao swagger do aplicativo. \
A base de dados do aplicativo de produtos já tem alguns dados cadastrados para fazer alguns testes.

Funcionalidades:
- Busca de produto por id
- Cadastro de produto

Teste 01) busca de produto
- Localize o recurso (GET /products/{id}) de busca de produtos no swagger do aplicativo
- Busque algum produto já cadastro usando um desses ids (1, 2, 3, 4, 5)

Teste 02) cadastro de produto
- Localize o recurso (POST /products) de cadastro de produtos no swagger do aplicativo.
- Cadastre um novo produto usando o modelo JSON disponibilizado pelo swagger


### 2.2 app-card

Use essa URL (http://localhost:8081/swagger-ui/index.html) para ter acesso ao swagger do aplicativo. \
A base de dados do aplicativo de cartões já tem alguns dados cadastrados para fazer alguns testes.

Funcionalidades:
- Busca de cartões e produtos por id do portador
- Cadastro de cartões via fila SQS (funcionalidade ainda não foi implementada)

Teste 01) busca de cartões e produtos
- Localize o recurso (GET /cards/customerId/{id}) de busca no swagger do aplicativo
- Busque alguns cartões e produtos já cadastro usando um desses customersIds (1, 2)


### 2.3 app-customers

Use essa URL (http://localhost:8082/swagger-ui/index.html) para ter acesso ao swagger do aplicativo. \
A base de dados do aplicativo de portador já tem alguns dados cadastrados para fazer alguns testes.

Funcionalidades:
- Busca de cartões e produtos por id do portador
- Cadastro de portador e cartão

Teste 01) busca de cartões e produtos por id do portador
- Localize o recurso (GET /customers/{id}) de busca no swagger do aplicativo
- Busque portador já cadastro usando esse id (1)

Teste 02) cadastro de portador e cartão
- Localize o recurso (POST /customers) de cadastro no swagger do aplicativo
- Cadastre um novo portador usando o modelo JSON disponibilizado pelo swagger
  - A parte de cadastro do registro do portador é feito no aplicativo (app-customer)
  - A parte de envio da mensagem (registro de cartão) para o aplicativo (app-card) via fila SQA ainda não foi finalizada  

### Roadmap

- Falta adicionar a comunicação entre os aplicativos (app-customer, app-card) por meio da fila SQS.
- Falta adicionar securaça com token JWT no aplicativo (app-customer)