# Projeto Naruto POO

Este projeto é uma simulação de batalha entre personagens do anime Naruto, desenvolvida para praticar conceitos de Programação Orientada a Objetos em Java. O sistema utiliza herança, interfaces e polimorfismo para gerenciar diferentes tipos de ninjas e suas habilidades.

## Funcionalidades Principais

* **Gerenciamento de Atributos**: Controle de Nome, Idade, Aldeia, Vida e Chakra.
* **Sistema de Jutsus**: Uso de Map para armazenar habilidades vinculadas a danos e consumos de chakra especificos.
* **Mecânica de Combate**: Cálculo de dano, gasto de energia e chance de esquiva.
* **Regeneração Passiva**: Recuperação de Chakra para personagens.
* **Condição de Vitória**: Identificação do ninja sobrevivente quando o oponente zerar a vida.

## Estrutura de Comandos

O programa opera via console e aceita os seguintes comandos:

* **ajuda**: Lista todos os comandos disponíveis no sistema.
* **listar**: Exibe as informações do personagem como nome, idade, aldeia, etc.
* **catalogo**: Mostra a biblioteca de jutsus disponíveis para aprendizado.
* **aprender [ninja] [jutsu]**: Adiciona uma habilidade do catálogo ao inventário de um ninja específico.
* **atacar [atacante] [jutsu] [alvo]**: Executa a ação de usar um jutsu, indicando o uso da técnica e aplicando danos ao inimigo.
* **sair**: Encerra a execução do programa.

## Regras de Negocio

1. **Chakra**: Um ninja só pode atacar enquanto possuir pontos de chakra. Uma parte do chakra é regenerado quando o oponente ataca.
2. **Esquiva**: Caso o personagem tenha sucesso ao desviar, ele não perde vida; caso contrário, perde vida equivalente ao dano recebido.
3. **Derrota**: Se o ninja zerar a vida, ele perde.
4. **Padronização**: O sistema utiliza a interface Map para associar nomes de jutsus a suas respectivas instâncias e atributos.

## Tecnologias Utilizadas

* Java SE 
* Java Collections API (Interface Map) 
* Scanner para entrada de dados via console.