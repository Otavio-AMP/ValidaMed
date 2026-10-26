# ValidaMed

Aplicação desktop desenvolvida em **Java**, com interface gráfica
construída utilizando **Java Swing** e desenvolvimento realizado no
**Apache NetBeans**.

O ValidaMed permite registrar informações de receitas médicas, incluindo
dados da receita, medicamentos prescritos e informações básicas do
paciente. Ao iniciar o cadastro, a aplicação apresenta uma sequência de
janelas para coletar os dados e, ao final, pergunta se o usuário deseja
salvar as informações.

## Funcionalidades

-   Tela inicial com a opção **Adicionar Receitas**.
-   Cadastro dos dados da receita:
    -   Data de emissão;
    -   CRM do médico;
    -   Indicação de receita carimbada;
    -   Quantidade de medicamentos.
-   Cadastro dos medicamentos, com informações como:
    -   Nome do medicamento;
    -   Dosagem em miligramas (mg);
    -   Quantidade de comprimidos por dia;
    -   Intervalos de administração ao longo do dia.
-   Cadastro dos dados do paciente:
    -   Nome;
    -   Idade;
    -   Sexo.
-   Confirmação para salvar ou não os dados informados ao final do
    fluxo.

## Tecnologias utilizadas

-   **Java** --- linguagem de programação.
-   **Java Swing** --- construção da interface gráfica.
-   **Apache NetBeans IDE** --- ambiente de desenvolvimento.

## Como executar

1.  Clone este repositório:

    ``` bash
    git clone https://github.com/Otavio-AMP/ValidaMed.git
    ```

2.  Abra o Apache NetBeans.

3.  Selecione **File (Arquivo) → Open Project (Abrir Projeto)** e
    escolha a pasta clonada.

4.  Aguarde o NetBeans reconhecer e carregar o projeto.

5.  Execute o projeto pela opção **Run Project (Executar Projeto)**.

> **Observação:** os passos podem variar conforme a estrutura do projeto
> e a versão do Apache NetBeans instalada.

## Fluxo de utilização

1.  Abra a aplicação.
2.  Na tela inicial, selecione **Adicionar Receitas**.
3.  Preencha os dados solicitados sobre a receita.
4.  Informe os medicamentos e suas respectivas informações.
5.  Preencha os dados do paciente.
6.  Escolha se deseja salvar os dados informados.

## Objetivo do projeto

O projeto tem como objetivo praticar o desenvolvimento de aplicações
desktop em Java, a criação de interfaces gráficas com Swing, a
organização de classes e a coleta de dados por meio de uma sequência de
telas.

## Aviso

O ValidaMed é um projeto de software e não substitui a avaliação de
profissionais de saúde nem sistemas clínicos validados. Utilize dados
fictícios durante testes e desenvolvimento. Caso sejam armazenados dados
reais de pacientes, é necessário implementar medidas adequadas de
segurança, privacidade e controle de acesso.

## Autor

Desenvolvido por [Otavio-AMP](https://github.com/Otavio-AMP).
