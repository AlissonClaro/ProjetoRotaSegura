@echo off
setlocal
cd /d "%~dp0" || goto erro
where javac >nul 2>&1 || goto semjdk
where java >nul 2>&1 || goto semjdk
if not exist "bin" mkdir "bin"
if not exist "lib\hsqldb.jar" goto erro
 echo Compilando Rota Segura...
javac -encoding UTF-8 -cp "lib\hsqldb.jar" -d "bin" "src\rotasegura\Principal.java" "src\rotasegura\dao\Repositorio.java" "src\rotasegura\gui\Tela.java" "src\rotasegura\model\Cliente.java" "src\rotasegura\model\Locacao.java" "src\rotasegura\model\Popular.java" "src\rotasegura\model\SUV.java" "src\rotasegura\model\Sedan.java" "src\rotasegura\model\Veiculo.java" "src\rotasegura\service\Locadora.java"
if errorlevel 1 goto erro
echo Iniciando Rota Segura...
java -cp "bin;lib\hsqldb.jar" rotasegura.Principal
if errorlevel 1 goto erro
exit /b 0
:semjdk
echo Instale o JDK 17 ou 21 e configure o PATH.
pause
exit /b 1
:erro
echo Falha ao compilar ou executar. Confira a mensagem acima.
pause
exit /b 1
