# language: pt
# encoder: utf-8

@Products
Funcionalidade: Produtos

  Contexto:
    Dado que eu acesse o site com as credenciais validas

  @AdicionarProdutoCarrinho
  Esquema do Cenário: CT01 - Adicionar produtos ao carrinho
    Quando adicionar o produto "<produto>" no carrinho
    Então eu valido que o produto "<produto>" está no carrinho

    Exemplos: 
    | produto               |
    | Sauce Labs Backpack   |
    | Sauce Labs Bike Light |

  @RemoverProdutoCarrinho
  Esquema do Cenário: CT02 - Remover produtos do carrinho
    Quando adicionar o produto "<produto>" no carrinho
    E remover o produto "<produto>" do carrinho
    Então valido que o produto "<produto>" não está no carrinho

    Exemplos: 
    | produto               |
    | Sauce Labs Backpack   |
    | Sauce Labs Bike Light |
