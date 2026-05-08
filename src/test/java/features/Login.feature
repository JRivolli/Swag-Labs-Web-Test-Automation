# language: pt
# encoder: utf-8

@Login
Funcionalidade: Efetuar login

  Contexto: 
    Dado que eu acesse o site da Swag Labs

  @LoginValido
  Cenario: CT01 - Realizar login com usuário valido
    Quando preencho com o usuario e senha "validos"
    Entao valido o acesso

  @LoginInvalido
  Cenario: CT02 - Realizar login com usuário invalido
    Quando preencho com o usuario e senha "invalidos"
    Entao valido a mensagem de erro "usuario e senha invalidos"

  @LoginCampoUsuarioVazio
  Cenario: CT03 - Realizar login com campo usuario vazio
    Quando tento logar com o campo "usuario" vazio
    Entao valido a mensagem de erro "usuario requerido"

  @LoginCampoSenhaVazio
  Cenario: CT04 - Reliazar login com campo senha vazio
    Quando tento logar com o campo "senha" vazio
    Entao valido a mensagem de erro "senha requerida"

  @LoginUsuarioBloqueado
  Cenario: CT05 - Realizar login com usuario bloqueado
    Quando tento logar com um usuario bloqueado
    Entao valido a mensagem de erro "usuario bloqueado"

  @Logout
  Cenario: CT06 - Realizar logout
    Dado que eu acesse o site com as credenciais validas
    Quando efetuo o logout
    Entao valido a pagina inicial de login
