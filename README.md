Este projeto consiste em um sistema de gerenciamento para um mini mercado desenvolvido em Java. O software permite o controle completo de produtos, clientes, movimentações de estoque e a simulação de vendas com carrinho de compras.
Os dados de produtos e clientes são persistidos de forma automática em arquivos .csv separados, garantindo que as informações não sejam perdidas ao fechar o programa.
Participantes: Pedro Ramos Leal RA:826194099 e Gabriel Silva Oliveira RA:826189579

Manual de Uso (Fluxo do Sistema)
Ao iniciar o programa, o Menu Principal será exibido no console. Digite o número correspondente à ação desejada e pressione ENTER:

====================
========MENU========
Produtos
Clientes
Realizar Compra
Controle de Estoque
Sair
====================
Módulo de Produtos (Menu 1)
Acessa o submenu para gerenciar as mercadorias do mercado. Todas as alterações aqui atualizam o arquivo produtos.csv em tempo real.
Cadastrar Produtos: Solicita o código (numérico), nome, preço e estoque inicial.
Listar Produtos: Exibe todos os produtos atualmente salvos no sistema.
Buscar Produto: Digite o código do produto para visualizar seus detalhes isolados.
Alterar Produto: Localiza um produto pelo código e permite sobrescrever todos os seus dados.
Remover Produto: Exclui permanentemente um produto da base de dados.

Módulo de Clientes (Menu 2)
Acessa o submenu para gerenciar a base de clientes do mini mercado. Todas as alterações salvam no arquivo clientes.csv.
Cadastrar Cliente: Solicita ID (pode ser um número ou apelido), CPF, Nome, Telefone e E-mail.
Listar Clientes: Exibe a ficha de todos os clientes cadastrados.
Buscar Clientes: Localiza um cliente específico digitando o seu ID.
Alterar Clientes: Atualiza as informações de contato de um cliente existente através do ID.
Remover Cliente: Remove o cliente do sistema.

Realizar Compra (Menu 3)
Simula o fluxo de venda do caixa do mini mercado:
O sistema perguntará se o cliente é cadastrado (S/N).
Se responder S, o operador deve digitar o ID do cliente cadastrado. Se o ID existir, o nome do cliente será validado na tela.
Em seguida, o sistema abre o carrinho de compras e solicita o Código do Produto e a Quantidade.
O sistema valida se o produto existe e se há estoque suficiente:
Havendo estoque, a quantidade é deduzida da memória e o arquivo produtos.csv é atualizado imediatamente.
Não havendo estoque ou caso o produto não exista, o sistema exibe um alerta e permite tentar novamente.
O operador pode digitar 1 para continuar adicionando itens ou 2 para fechar o carrinho.
Ao finalizar, um Cupom Fiscal detalhado é impresso na tela contendo os subtotais e o valor total geral da compra.

Controle de Estoque (Menu 4)
Aba simplificada voltada para o repositor do mercado.
Listar Estoque: Atalho para verificar os níveis de quantidade de todos os produtos.
Alterar Estoque: Permite dar entrada em novas mercadorias ou corrigir manualmente o estoque de um produto existente (salvando as alterações no CSV logo em seguida).
