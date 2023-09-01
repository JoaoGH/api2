## Requisitos

- O desafio deve ser desenvolvido com Grails 5 e JDK 11;
- Editor de texto ou IDE de sua escolha;
- Banco de dados Oracle, utilizar owners da etapa de PL/SQL;
- Postman para realizar as requisições.

## Criação do projeto

O projeto deve ser criado com o comando `create-app` com o nome **api2**, utilize o profile `rest-api`.

### Conexão do banco de dados

- Adicione a dependência do driver de banco de dados `com.oracle.database.jdbc:ojdbc8:21.8.0.0` ao `build.gradle`;
- Altere as seguintes propriedades  arquivo de configuração `application.yml`:
```yaml
environments:
    development:
		dataSource:
			...
		    driverClassName: 'oracle.jdbc.OracleDriver'
		    username: '<usuario>'
		    password: '<senha>'
		    url: '<url_do_banco>'
			dbCreate: 'create-drop'
```

### Mapeamento de URLs

Sobrescreva a closure `mappings` no arquivo `UrlMappings.groovy` para utilizar **somente** o mapeamento dinâmico:

```groovy
static mappings = {
	"/$controller/$action?/$id?"()
}
```

### Mockup

Ao subir a aplicação deve ser inserido registros na base para servirem de mockup, sendo 3 cidades, 2 funcionários e 1 reajuste de salário.

### Context-path

Deve ser configurado o contexto da aplicação no arquivo `aplication.yml`, da mesma forma que foi feito na primeira avaliação de Grails.

```yml
serve.servlet.context-path: '/${info.app.name}'
```

## Classes de domínio

- As classes devem utilizar o gerador de id `increment`; 
- O versionamento deve estar desabilitado nas classes;
- Devem também ser mapeados os atributos abaixo com suas respectivas constraints:

1. Cidade
  
| Atributo | Tipo   | Nulo | Tamanho | 
|----------|--------|------|---------| 
| nome     | String | Não  | 50      |

2. Funcionario

| Atributo | Tipo   | Nulo | Tamanho |
|----------|--------|------|---------|
| nome     | String | Não  | 50      |
| cidade   | Cidade | Não  | -       |

3. ReajusteSalario

| Atributo     | Tipo        | Nulo | Tamanho |
|--------------|-------------|------|---------|
| dataReajuste | LocalDate   | Não  | -       |
| valorSalario | BigDecimal  | Não  | 6,2     |
| funcionario  | Funcionario | Não  | -       |

## Endpoints

O nome de cada controller deve ser coerente com seu intuito, por isso os nomes devem ser: CidadeController, FuncionarioController e ReajusteSalarioController.

Cada controller deve ter os métodos `save`,  `list`,  `update`,  `delete` e  `get`, sendo o método `get` a ação padrão de cada controller.

O formato de data, tanto para entrada quanto saída de dados, deve ser no padrão `dd/MM/yyyy`.

* Para o método de `save`.
	* Só devem ser aceitas requisições do tipo `POST`;
	* O conteúdo deve ser enviado unicamente em JSON.
* Para o método de `list`.
	* Só devem ser aceitas requisições do tipo `GET`;
	* Sem filtros na busca de dados.
* Para o método de `update`.
	* Só devem ser aceitas requisições do tipo `PUT`;
	* O identificador do registro deve ser informado como queryParams (por exemplo http://localhost:8080/nome_controller/update/id_registro);
	* O conteúdo deve ser enviado unicamente em JSON.
* Para o método de `delete`
	* Só devem ser aceitas requisições do tipo `DELETE`;
	* O identificador do registro deve ser informado como queryParams.
* Para o método de `get`
	* Só devem ser aceitas requisições do tipo `GET`;
	* O identificador do registro deve ser informado como queryParams.

## Retornos

**Todos** os retornos deve ser no formato JSON, incluindo os de erro.

> Para abranger e tratar exceptions inesperadas consulte [aqui](https://docs.grails.org/5.3.2/guide/single.html#controllerExceptionHandling).

## Regras

* Toda e qualquer regra de negócio deve ser implementada na camada de service;
* É completamente proibida a cópia de codigo entre os participantes;
* Não devem ser usadas IAs para programar o código por você, implemente-o você;
* As ações de CRUD devem ser implementadas por você, sem utilizar a lógica capenga já feita pelo Grails.

## Entregáveis

Deve ser entregue o link do repositório no github.

Esse repositório deve conter o código fonte da aplicação e em `./src/main/request/postman/` deve haver a collection usada durante o desenvolvimento.
