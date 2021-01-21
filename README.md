# Objetivo
- Criar uma aplicativo que consuma uma REST API e exiba uma listagem de eventos;
- Cada item da lista deve permitir acesso à detalhes do evento;
- No detalhe do evento é importante exibir suas informações e opções de check-in e compartilhamento.

### Requisitos mínimos
- App deve compilar sem a necessidade de nenhum ajuste após ser clonado
- Suporte à API 19 e funcionar com a API 29
- Código deve ser escrito em Kotlin

### Layout
- A escolha do layout e disposição dos itens é livre.

### Sobre seu código Analisaremos:
- Organização do código;
- Boas práticas de programação;
- Possíveis bugs;
- Tratamento de erros;
- O uso de frameworks e libraries é livre.

#### API
A API de eventos está disponivel em:
http://5f5a8f24d44d640016169133.mockapi.io/api/events

Para acessar cada detalhe do evento basta adicionar o ID do item ao final da URL. Ex: http://5f5a8f24d44d640016169133.mockapi.io/api/events/1

Para realizar o check-in faça um POST no seguinte endereço: http://5f5a8f24d44d640016169133.mockapi.io/api/checkin

O POST deve conter os dados do interessado (Nome, e-mail) e o id do evento. Ex:

{ "eventId": "1", "name": "Otávio", "email": "otavio_souza@..." }

### Itens extras
- Explicação breve do porquê das escolhas de frameworks e arquitetura;
- Uso de testes unitários e de aceitação (interface).

### Dicas
- Dê atenção especial às recomendações do Material Design;
- Fique a vontade para utilizar animações e recursos especias (ex: parallax etc...);
- Teste bem seu aplicativo, evite crashes.

### Observações importantes
- Não inicie o teste sem sanar todas as dúvidas;
- A API pode ter falhas, prepare seu aplicativo para contorná-las.
Bom teste!
