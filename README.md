SistemaNotificacoesSaude
Descrição do Projeto

O SistemaNotificacoesSaude é um sistema desenvolvido em Java 25, que permite o registro, consulta e análise de notificações de saúde pública com base em fichas de notificação/investigação. O sistema oferece uma interface de linha de comando (CLI) para interação com o usuário e armazena os dados em arquivos de texto.

O projeto segue boas práticas de Programação Orientada a Objetos (POO), utilizando classes separadas para modelagem, serviços e manipulação de arquivos, garantindo organização e manutenção fácil do código.

Funcionalidades
1. Registrar Notificações

O sistema permite registrar notificações de pacientes com os seguintes dados:

Nome do paciente

Bairro

Data da notificação

Agravo

Idade

Sexo

Raça/Cor

Escolaridade

Os registros são salvos em um arquivo de texto (data/notificacoes.txt) de forma persistente.

2. Consultar Notificações

O sistema permite consultas com base nos seguintes critérios:

Por nome do paciente

Por bairro

Por período (data início e fim)

Por agravo

As consultas exibem na tela todas as notificações que correspondem aos critérios informados.

3. Gerar Relatórios

O sistema é capaz de gerar relatórios com dados estatísticos das notificações registradas, como:

Total de notificações por agravo

Total de notificações por bairro

Total de notificações por mês/ano

Total de notificações por faixa etária

Total de notificações por sexo

Total de notificações por raça/cor

Total de notificações por escolaridade

Observação: Os relatórios podem ser exibidos na tela ou exportados para arquivos de texto, dependendo da implementação adicional.

Estrutura do Projeto
SistemaNotificacoesSaude/
├── src/
│   ├── Main.java                   // Classe principal com menu CLI
│   ├── model/
│   │   └── Notificacao.java        // Classe que representa uma notificação
│   ├── service/
│   │   └── NotificacaoService.java // Classe com lógica de CRUD e relatórios
│   └── util/
│       └── ArquivoUtil.java        // Classe utilitária para manipulação de arquivos
└── data/
    └── notificacoes.txt            // Arquivo onde as notificações são armazenadas

Tecnologias Utilizadas

Java 25

Interface de linha de comando (CLI)

Armazenamento em arquivos de texto

Conceitos de Programação Orientada a Objetos (POO)

Streams e Collections para filtragem e manipulação de dados

Como Executar

Clonar o projeto ou baixar os arquivos para o seu computador.

Abrir o projeto em um IDE compatível com Java 25, como IntelliJ IDEA ou VS Code com extensão Java.

Certificar-se de que a pasta data/ existe e contém o arquivo notificacoes.txt (pode estar vazio inicialmente).

Executar a classe Main.java.

Seguir as instruções do menu CLI para registrar, consultar ou gerar relatórios de notificações.

Exemplo de Uso

Registrar uma notificação:

Nome do paciente: Maria Silva
Bairro: Centro
Data (yyyy-mm-dd): 2025-10-26
Agravo: Dengue
Idade: 32
Sexo: Feminino
Raça/Cor: Parda
Escolaridade: Ensino Médio


Consultar notificações por bairro:

Bairro: Centro


Gerar relatório de total por agravo:

Agravo: Dengue
Total de notificações: 12

Boas Práticas Implementadas

Separação de responsabilidades: Cada classe possui uma responsabilidade clara (modelo, serviço, utilitário e interface).

Persistência de dados: Todos os registros são salvos em arquivo de texto para manter os dados entre execuções.

Uso de Streams: Para consultas e filtragens de dados de forma eficiente.

CLI amigável: Menu simples e intuitivo para interação do usuário.

Possíveis Melhorias Futuras

Implementar exportação de relatórios em PDF ou CSV.

Adicionar interface gráfica (GUI) para melhor usabilidade.

Implementar filtros combinados para consultas mais avançadas.

Adicionar autenticação de usuário para acesso ao sistema.

Criar backups automáticos do arquivo de notificações.
