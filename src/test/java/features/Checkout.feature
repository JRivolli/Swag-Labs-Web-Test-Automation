# language: pt
# encoder: utf-8

@Checkout
Funcionalidade: Efetuar checkout

  Contexto: 
    Dado que eu acesse o site com as credenciais validas

  @CheckoutInformacoesValidas
  Esquema do Cenário: CT01 - Efetuar Checkout com informações validas
    Quando adicionar o produto "<produto>" no carrinho
    E efetuar o checkout "com informacoes validas"
    Entao valido que a compra foi finalizada

    Exemplos: 
    | produto             |
    | Sauce Labs Backpack |

  @CheckoutCampoNomeVazio
  Esquema do Cenário: CT02 - Efetuar Checkout com campo nome vazio
    Quando adicionar o produto "<produto>" no carrinho
    E efetuar o checkout "com campo nome vazio"
    Entao valido a mensagem de erro "nome requerido" no checkout

    Exemplos: 
    | produto             |
    | Sauce Labs Backpack |

  @CheckoutCampoSobrenomeVazio
  Esquema do Cenário: CT03 - Efetuar Checkout com campo sobrenome vazio
    Quando adicionar o produto "<produto>" no carrinho
    E efetuar o checkout "com campo sobrenome vazio"
    Entao valido a mensagem de erro "sobrenome requerido" no checkout

    Exemplos: 
    | produto             |
    | Sauce Labs Backpack |

  @CheckoutCampoCodigoPostalVazio
  Esquema do Cenário: CT03 - Efetuar Checkout com campo codigo Postal vazio
    Quando adicionar o produto "<produto>" no carrinho
    E efetuar o checkout "com campo codigo postal vazio"
    Entao valido a mensagem de erro "codigo postal requerido" no checkout

    Exemplos: 
    | produto             |
    | Sauce Labs Backpack |
