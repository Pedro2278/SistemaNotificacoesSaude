🏥 SISTEMA NOTIFCAÇÔES SAÙDE
📄 Descrição do Projeto

O SistemaNotificacoesSaude é um sistema desenvolvido em Java 25 para o registro, consulta e análise de notificações de saúde pública.

Ele utiliza uma interface de linha de comando (CLI) e arquivos de texto para armazenamento dos dados. O projeto segue boas práticas de Programação Orientada a Objetos (POO), garantindo organização, manutenção e extensibilidade.

⚙️ Funcionalidades
1️⃣ Registrar Notificações

O sistema permite registrar notificações com os seguintes dados:

-Nome do paciente
-Bairro
-Data da notificação
-Agravo
-Idade
-Sexo
-Raça/Cor
-Escolaridade

Os registros são salvos em data/notificacoes.txt.

2️⃣ Consultar Notificações

-Permite consultas com base nos seguintes critérios:
-Por nome do paciente
-Por bairro
-Por período (data início e fim)
-Por agravo

As consultas exibem todas as notificações que correspondem aos critérios informados.

3️⃣ Gerar Relatórios

O sistema gera relatórios estatísticos das notificações registradas:

-Total de notificações por agravo
-Total de notificações por bairro
-Total de notificações por mês/ano
-Total de notificações por faixa etária
-Total de notificações por sexo
-Total de notificações por raça/cor
-Total de notificações por escolaridade

Os relatórios podem ser exibidos na tela ou exportados para arquivos de texto.

🏗 Estrutura do Projeto
SistemaNotificacoesSaude/
├── src/
│   ├── Main.java                   // Classe principal com menu CLI
│   ├── model/
│   │   └── Notificacao.java        // Representa uma notificação
│   ├── service/
│   │   └── NotificacaoService.java // Lógica de CRUD e relatórios
│   └── util/
│       └── ArquivoUtil.java        // Utilitário para manipulação de arquivos
└── data/
    └── notificacoes.txt            // Armazenamento das notificações

💻 Tecnologias Utilizadas

Java 25
Interface CLI
Arquivos de texto para armazenamento
Programação Orientada a Objetos (POO)
Streams e Collections para manipulação de dados

🚀 Como Executar

Clonar o projeto ou baixar os arquivos.
Abrir o projeto em IntelliJ IDEA, VS Code ou outro IDE compatível com Java 25.
Certificar-se de que a pasta data/ existe com o arquivo notificacoes.txt (pode estar vazio).
Executar a classe Main.java.
Seguir o menu CLI para registrar, consultar ou gerar relatórios.

📌 Exemplo de Uso
Registrar uma Notificação
Nome do paciente: Maria Silva
Bairro: Centro
Data (yyyy-mm-dd): 2025-10-26
Agravo: Dengue
Idade: 32
Sexo: Feminino
Raça/Cor: Parda
Escolaridade: Ensino Médio

Consultar por Bairro
Bairro: Centro

Gerar Relatório por Agravo
Agravo: Dengue
Total de notificações: 12

✅ Boas Práticas Implementadas

-Separação de responsabilidades: Model, Service, Util e Main.
-Persistência de dados: Arquivos de texto garantem armazenamento entre execuções.
-Uso de Streams: Para consultas e filtragens eficientes.
-CLI amigável: Menu intuitivo para o usuário.

🌟 Possíveis Melhorias Futuras

-Exportação de relatórios em PDF ou CSV.
-Adição de interface gráfica (GUI).
-Consultas combinadas e filtros avançados.
-Sistema de autenticação para usuários.
-Backups automáticos do arquivo de notificações.
Sistema de autenticação para usuários.

Backups automáticos do arquivo de notificações.
