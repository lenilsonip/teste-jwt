Aplicação simples usando JWT, que ao iniciar cria um usuário do tipo ADMIN com usuário e senha "admin"
Ao se autenticar, é retornado um token
Esse token deve ser passado na header para garantir que o usuário é o mesmo que foi autenticado


CURL autenticação:
curl -X POST \
  http://localhost:8080/authenticate \
  -H 'Content-Type: application/json' \
  -d '{"username": "admin", "password": "admin"}'

CURL consulta todos os usuários:
curl -X GET \
  http://localhost:8080/api/users \
  -H 'Authorization: Bearer SEU_TOKEN_JWT_AQUI'
