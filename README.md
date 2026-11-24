# Rota Segura — TP2
Aplicação desktop Java Swing com JDBC e banco relacional embarcado HSQLDB 1.8 (driver incluído para execução offline). Projeto acadêmico local, não destinado à produção. Não requer MySQL ou servidor separado.

## Executar no Windows
Instale JDK 17 ou 21, configure PATH, extraia o ZIP e execute `Iniciar.bat`. No Eclipse: File > Import > Existing Projects into Workspace, selecione esta pasta e execute `rotasegura.Principal` como Java Application. Configure UTF-8 e JDK 17/21.

Linux/macOS: `mkdir -p bin; javac -encoding UTF-8 -cp lib/hsqldb.jar -d bin $(find src -name '*.java')` e `java -cp bin:lib/hsqldb.jar rotasegura.Principal`.

## Uso
Cadastre cliente com CPF de 11 dígitos; selecione Veículos para cadastrar/editar/consultar a frota. Na aba Locações abra contrato escolhendo CPF, placa disponível e dias. Selecione contrato para editar dias, cancelar contrato aberto ou devolver. Na devolução informe dias efetivos, confira resumo, confirme e salve relatório TXT. Contratos fechados permanecem no histórico; exclusões de clientes/veículos referenciados são impedidas pelo banco. CPF e placa são chaves imutáveis na edição. O banco é criado automaticamente em `dados/rota`, com os três veículos originais; mantenha a pasta para preservar dados. Não publique dados reais no GitHub.

## Arquitetura
- model: classes originais Cliente, Veiculo, Popular, Sedan, SUV e Locacao; diárias originais R$ 80, 120 e 180, respectivamente.
- service: validação e cálculo polimórfico; total = diária × dias efetivos.
- dao: SQL parametrizado, tabelas relacionais com chaves estrangeiras, transações de abertura, fechamento e cancelamento com rollback.
- gui: formulários Swing, tabelas, filtros e diálogos.

## Teste e entrega
`testes/Teste.java` é um teste de integração em memória. Compile com classpath bin e lib/hsqldb.jar e execute Teste. A aplicação é para uso local por uma instância de cada vez. Para entregar, crie um repositório GitHub e envie o conteúdo desta pasta (incluindo README, src e lib). O link do repositório é o entregável exigido pelo enunciado.
