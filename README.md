# Proposta

## Amâzonia R.C, Inc.

A empresa de representação comercial, Amâzonia Representação Comercial está modernizando seus sistemas legados e você recebeu a missão de remodelar uma das aplicações cores que atualmente é responsável pelo carrinho de compra, checkout, confirmação do pedido por e-mail e realizar a cotação do frete de forma integrada ao sistema do Correios.

Por está razão você como Engenheiro de Software foi designado redesenhar buscando melhorar a manutenibilidade, legibilidade, testabilidade e qualidade da aplicação.

* Caso o cliente informe um cupom de desconto, deve-se aplicar somente para os produtos que estão em promoção
  
* Caso o cliente escolha receber o produto no formato de mídia digital (filmes/séries, livros ou músicas), não deve-se cobrado o frete

* Caso os itens sejam livros, jornais, revistas ou eReaders, o sistema deve idetificar e aplicar a isenção de imposto conforme disposto na Constituição Art. 150, VI, d.

* Para o calculo do frete deve-se utilizar o WebService dos Correios (Collection do Postman de exemplo no repositório)

* Ao final do checkout o cliente deverá receber um e-mail com a confirmação da compra

### O que é necessário fazer?

Você ficou designado a prototipar como poderá ser feita a nova versão deste fluxo de venda e envio do produtos, pois a versão atual é frágil, encadeada em if/else, switch/case, exigindo modificações grandes a cada nova regra de envio/processamento inserida ou removida.

Crie as classes, métodos e suas respectivas chamadas (a seu critério) para que você consiga tratar os cenários acima.

Não é necessário criar as implementações para envio de e-mails. Para este caso crie apenas as chamadas de métodos, para indicar que ali seria o local aonde o envio ocorreria.

Entretanto, levaremos isso como bonus points. É permitido o uso de libs para facilitar a implementação dos testes.

### O que será avaliado?

Sua capacidade de analisar, projetar e codificar uma solução guiando-se com Design Orientado a Objetos, Princípios de Orientação a Objetos, Clean Code e melhores práticas de engenharia e arquitetura de software.

### O que não vale?

* Frameworks

### Qual linguagem?

* Java

### Apresentação

* Código funcional
* Cobertura de testes em pelo menos 90%
* Explicação da solução em Markdown ou PPT

### Avalição

Para nos enviar o seu código, você pode:

* Fazer um fork desse repositório, e nos mandar um pull-request
* Enviar o link do repositório de código fonte (que seja público)

# Solucao.

Para diminuir o acoplamento foram criadas interfaces com a finalidade de servir contrato para as principais etapas em uma compra, são elas:

* Aplicar Desconto
* Calcular o Frete
* Calcular os Tributos
* Executar o Pagamento

Assim é possivel extender comportamentos, incluir novos comportamentos.
Foi abusado de conceitos de herança, onde foi preparada uma classe de identificador para gerar ID caso no futuro seja implementado uma base de dados. Foi criado uma super classe para Produto e outras super classes com a finalidade de identificar produtos que podem ser vendidos de forma digital, essa classe tem o nome **EmMidia**. Dessa mesma forma foi criado um conceito iqual para produtos de leitura com a classe **ParaLeitura**.

Foram criados enums para representar constates necessárias.

Essa solução teve aplicação de **O**rientação a **O**bjetos e **Herança** que unido ao padrão **STRATEGY** foi usado para criar uma "lista de ações", ações essas que usam o padrão **DECORATOR** da interface Venda.

Ao executar a aplicação foi feito um teste em Console para exemplificar a utilização da aplicação.