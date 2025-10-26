Sistema de Notificações de Saúde Pública

Um sistema simples para registrar, consultar e gerar relatórios de notificações de agravos de saúde pública (Hanseníase, Tuberculose e Malária), desenvolvido em Java 25 com interface de linha de comando (CLI).

---

💻 Funcionalidades

Registrar Notificação

Permite registrar notificações de pacientes com dados completos:

- Nome, sexo, idade, raça/cor, escolaridade, data de nascimento, cartão SUS.

- Agravo (Hanseníase, Tuberculose, Malária), tipo de notificação, data da notificação.

- Endereço completo: logradouro, número, complemento, bairro, município, UF, CEP, país e zona.

- Dados clínicos: número de lesões cutâneas, classificação operacional e forma clínica.

Consultar Notificações
Possibilidade de busca por:

- Nome do paciente
- Bairro
- Período (datas inicial e final)
-Tipo de agravo

Gerar Relatórios
Relatórios detalhados com contagem por:

- Agravo
- Bairro
- Mês/Ano
- Sexo
- Faixa etária
- Raça/Cor
- Escolaridade
- Validações implementadas:

Dados obrigatórios não podem ficar vazios
Idade entre 0 e 120 anos
Datas não podem estar no futuro
Opções múltiplas apresentadas claramente ao usuário (Raça/Cor, Escolaridade, Tipo de Notificação, Zona, Agravo, UF, etc.)
Formatos de CEP e datas validados

---

📁 Estrutura do Projeto

SistemaNotificacoesSaude/
│
├── src/
│   └── system/
│       ├── Main.java
│       ├── cli/
│       │   └── MenuCLI.java
│       ├── model/
│       │   ├── Agravo.java
│       │   ├── Endereco.java
│       │   ├── Notificacao.java
│       │   └── Paciente.java
│       └── repository/
│           └── NotificacaoRepository.java
│
└── notificacoes.txt  (arquivo de dados)

---

🚀 Como Executar

1 - Clone o repositório:
git clone https://github.com/SEU_USUARIO/NomeDoRepositorio.git
2 - Abra no VS Code ou IDE de sua preferência.
3 - Compile e execute Main.java.
4 - Interaja com o sistema pelo menu de linha de comando.

---
📌 Observações
- O sistema grava os dados no arquivo notificacoes.txt.
- Ao iniciar, o usuário deve escolher a opção desejada no menu principal.
- Todas as opções de escolha múltipla são apresentadas ao usuário para evitar erros de digitação.
---
📝 Autores
Daniel Sousa Crisostomo 

Pedro Maia
📧 pm9203872@gmail.com
