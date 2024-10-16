O projeto implementado utiliza diversos conceitos de Programação Orientada a Objetos (POO), como abstração, encapsulamento, herança, polimorfismo, interfaces, e exceções, para modelar uma aplicação de uma pizzaria. A seguir, será feita uma breve explicação técnica dos principais elementos usados no código.

1. Abstração e Herança
A abstração foi aplicada nas classes Pizza, Ingrediente, e Cobertura, que são classes abstratas e definem a estrutura e comportamento comuns para todos os tipos de pizza, ingredientes, e coberturas. Essas classes são posteriormente especializadas em subclasses, como PizzaCalabresa e PizzaMargherita, que herdam os atributos e métodos dessas classes abstratas, garantindo a reutilização de código e maior flexibilidade na adição de novos tipos de pizzas ou ingredientes.

abstract class Pizza {
    protected String nome;
    public abstract double getPreco();
}
Aqui, a classe Pizza define o método abstrato getPreco(), que será implementado de forma específica em cada subclasse, garantindo a personalização do comportamento.

. Encapsulamento
O conceito de encapsulamento é aplicado nas classes ao proteger os atributos, como nome e ingredientes, por meio do modificador de acesso protected ou private, garantindo que esses atributos só possam ser acessados ou modificados por métodos específicos, como getters e setters. Esse conceito aumenta a segurança e a integridade dos dados no sistema.

public String getNome() {
    return nome;
}
Aqui, o método getNome() encapsula o acesso ao atributo nome da pizza.

Polimorfismo
O polimorfismo é explorado através da implementação de interfaces e da sobrescrita de métodos. Tanto a PizzaCalabresa quanto a PizzaMargherita implementam as interfaces Preparavel e Entregavel, forçando-as a definir os métodos preparar() e entregar(). Isso permite que as instâncias de Pizza sejam tratadas de maneira polimórfica, garantindo que o comportamento de preparação e entrega seja específico para cada tipo de pizza.


public class PizzaCalabresa extends Pizza implements Preparavel, Entregavel {
    @Override
    public void preparar() {
        System.out.println("Preparando a pizza de calabresa...");
    }
}

Aqui, a pizza de calabresa define seu próprio comportamento para o método preparar().


4. Interfaces
O uso de interfaces como Entregavel, Comestivel, e Preparavel permite uma maior flexibilidade no design do código, garantindo que classes diferentes possam compartilhar comportamentos comuns, independentemente de sua hierarquia. Ao implementar essas interfaces, as classes de pizza garantem que sempre terão métodos relacionados a essas ações.

interface Entregavel {
    void entregar();
}

5. Tratamento de Exceções
O tratamento de exceções foi implementado com classes de exceção personalizadas, como PizzariaException e IngredienteIndisponivelException. Isso permite capturar e tratar erros específicos relacionados ao funcionamento da pizzaria, garantindo um controle mais refinado sobre as operações.

private List<Ingrediente> ingredientes = new ArrayList<>();

7. Classe Pizzaria
A classe Pizzaria gerencia o menu de pizzas, permitindo adicionar pizzas ao menu e listar todas as opções disponíveis. Essa classe organiza as operações da pizzaria e encapsula a lógica de exibir as pizzas disponíveis com seus respectivos preços.

public void listarMenu() {
    System.out.println("Menu:");
    for (Pizza pizza : menu) {
        System.out.println("- " + pizza.getNome() + " - R$" + pizza.getPreco());
    }
}

Mesmo sendo um código simples, ele utiliza de maneira eficaz os principais conceitos de POO, criando uma aplicação flexível e modular. As pizzas, ingredientes e coberturas são abstraídos em suas próprias classes, enquanto as interfaces definem contratos de comportamento que garantem a coerência entre as diferentes funcionalidades implementadas. Além disso, as exceções personalizadas asseguram o tratamento adequado de possíveis erros, contribuindo para a robustez do sistema. Essa estrutura torna o código da pizzaria altamente expansível, permitindo a fácil adição de novos tipos de pizzas, ingredientes e funcionalidades conforme necessário, sem comprometer a integridade da aplicação
