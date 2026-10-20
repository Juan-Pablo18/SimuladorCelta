🚗 Simulador Chevrolet Celta





📌 Sobre o projeto

O Simulador Chevrolet Celta é um projeto desenvolvido em Java que tem como objetivo simular, de maneira interativa e didática, algumas funcionalidades de um veículo Chevrolet Celta.

O sistema funciona por meio de um menu interativo no terminal, permitindo que o usuário selecione diferentes operações e acompanhe as mudanças no estado simulado do veículo.

O projeto foi desenvolvido para praticar conceitos fundamentais de programação, como variáveis, métodos, estruturas condicionais, laços de repetição, entrada de dados e organização do código.

Importante: este é um simulador educacional. Ele não controla um veículo real, e os valores apresentados são apenas ilustrativos.

🎯 Objetivos do projeto

Desenvolver habilidades de programação utilizando Java.

Praticar lógica de programação por meio de situações simuladas.

Criar um sistema interativo com opções selecionadas pelo usuário.

Trabalhar com variáveis que representam o estado de um veículo.

Implementar condições para controlar o funcionamento das operações.

Aprender a organizar, documentar e publicar um projeto no GitHub.

⚙️ Funcionalidades

O simulador reúne diferentes controles organizados em um menu.

Funcionalidade

Descrição

Motor

Ligar e desligar o motor do veículo.

Painel

Consultar informações sobre o estado atual do carro.

Setas direcionais

Acionar a seta esquerda ou direita.

Pisca-alerta

Ligar ou desligar o pisca-alerta.

Iluminação

Controlar farol baixo, farol alto e luz interna.

Buzina

Simular o acionamento da buzina.

Aceleração

Aumentar a velocidade respeitando as condições programadas.

Frenagem

Reduzir a velocidade do veículo.

Embreagem

Pressionar ou soltar a embreagem.

Marchas

Selecionar ré, neutro ou marchas de 1 a 5.

Freio de mão

Simular o acionamento e a liberação do freio de mão.

Cinto de segurança

Alternar entre cinto afivelado e desafivelado.

Portas e travas

Simular o travamento, destravamento e abertura das portas.

Vidros

Alternar entre vidros abertos e fechados.

Recursos internos

Controlar ar-condicionado, ventilação, desembaçador e rádio.

Limpador de para-brisa

Ligar ou desligar o limpador.

Abastecimento

Adicionar combustível ao tanque simulado.

Hodômetro parcial

Zerar a distância parcial da viagem.

Encerramento

Finalizar a execução do programa.

O comportamento de cada funcionalidade depende das regras implementadas na versão do código-fonte publicada neste repositório.

🛠️ Tecnologias utilizadas

Java: linguagem utilizada no desenvolvimento do simulador.

JDK (Java Development Kit): ferramenta necessária para compilar e executar o código.

Visual Studio Code: editor utilizado para escrever e organizar o projeto.

Terminal: interface para interação com o usuário.

Git: ferramenta de controle de versão.

GitHub: plataforma utilizada para hospedar e compartilhar o código-fonte.

📂 Estrutura do projeto

SimuladorCelta/
│
├── Main.java
│   └── Código-fonte principal do simulador
│
├── README.md
│   └── Documentação do projeto
│
└── .gitignore
    └── Arquivos e pastas ignorados pelo Git

O arquivo Main.class é gerado durante a compilação do programa. Ele pode ser recriado a partir do arquivo Main.java, portanto não é necessário mantê-lo no repositório.

💻 Pré-requisitos

Antes de executar o projeto, verifique se você possui:

Um computador com Windows, Linux ou macOS.

O JDK instalado.

Um editor de código ou terminal para executar os comandos.

Para verificar a versão do Java instalada, abra o terminal e execute:

java -version

Para verificar a versão do compilador:

javac -version

É importante que as versões utilizadas para compilar e executar o programa sejam compatíveis.

▶️ Como executar o projeto

1. Baixar ou clonar o repositório

Caso o projeto esteja no GitHub, você pode cloná-lo com:

git clone URL_DO_REPOSITORIO

Substitua URL_DO_REPOSITORIO pelo endereço real do repositório.

2. Abrir a pasta

Abra a pasta do projeto no Visual Studio Code ou acesse-a pelo terminal.

3. Compilar o programa

Execute o comando:

javac -encoding UTF-8 Main.java

Se não aparecer nenhuma mensagem de erro, a compilação foi concluída.

4. Executar o simulador

Execute:

java Main

O menu principal será apresentado no terminal.

5. Interagir com o sistema

Digite o número da funcionalidade desejada e pressione Enter. Siga as instruções apresentadas para concluir cada operação.

Para finalizar, selecione a opção de saída exibida no menu.

🧠 Conceitos de programação aplicados

O desenvolvimento deste projeto permite praticar os seguintes conceitos:

Variáveis e tipos de dados

Utilização de variáveis para representar informações como estado do motor, velocidade, marcha e combustível.

Estruturas condicionais

Uso de condições para verificar se determinadas operações podem ser realizadas, como acelerar somente quando as condições necessárias forem atendidas.

Estruturas de repetição

Utilização de repetição para manter o menu ativo até que o usuário escolha encerrar o programa.

Métodos

Organização das funcionalidades em métodos, facilitando a leitura e a manutenção do código.

Entrada de dados

Utilização da classe Scanner para receber as opções digitadas pelo usuário no terminal.

Validação de entradas

Verificação das opções informadas para evitar que valores inválidos sejam processados como operações válidas.

Controle de estado

Atualização das variáveis conforme as ações realizadas, permitindo que o painel apresente as informações mantidas durante a execução.

⚠️ Limitações conhecidas

O sistema funciona no terminal e não possui interface gráfica.

Os dados são mantidos durante a execução, sem persistência em banco de dados.

Os valores de velocidade, combustível, RPM e distância são simulados.

O projeto não utiliza sensores ou componentes eletrônicos de um veículo real.

As regras de funcionamento são simplificadas para fins de aprendizagem.

🚀 Melhorias futuras

Algumas possibilidades para evoluir o projeto são:

Separar as funcionalidades em classes específicas, como Veiculo, Motor e Painel.

Implementar testes automatizados.

Melhorar as mensagens e validações do menu.

Registrar o histórico das ações realizadas.

Salvar informações em arquivos ou banco de dados.

Desenvolver uma interface gráfica.

Adicionar documentação técnica e diagramas.

Criar novas funcionalidades de simulação.

🎓 Finalidade acadêmica

Este projeto tem finalidade educacional e busca consolidar conhecimentos introdutórios de programação em Java por meio de um exemplo prático e interativo.

A simulação permite exercitar a lógica de programação e compreender como diferentes variáveis e condições podem trabalhar juntas para representar o comportamento de um sistema.

👨‍💻 Autor

Nome: Juan Pablo

Curso: Análise e Desenvolvimento de Sistemas

Linguagem: Java

Projeto: Simulador Chevrolet Celta

⭐ Se este projeto contribuir para seus estudos, considere deixar uma estrela no repositório.