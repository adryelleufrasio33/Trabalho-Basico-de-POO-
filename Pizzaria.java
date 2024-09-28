import java.util.ArrayList;
import java.util.List;

// Classes abstratas
abstract class Pizza {
    protected String nome;

    public String getNome() {
        return nome;
    }

    public abstract double getPreco();

    @Override
    public String toString() {
        return nome;
    }
}

abstract class Ingrediente {
    protected String nome;

    public String getNome() {
        return nome;
    }

    public abstract double getPreco();

    @Override
    public String toString() {
        return nome;
    }
}

abstract class Cobertura {
    protected String nome;

    public String getNome() {
        return nome;
    }

    public abstract double getPreco();

    @Override
    public String toString() {
        return nome;
    }
}

// Interfaces
interface Entregavel {
    void entregar();
}

interface Comestivel {
    void comer();
}

interface Preparavel {
    void preparar();
}

// Classes concretas
class PizzaCalabresa extends Pizza implements Preparavel, Entregavel {
    private List<Ingrediente> ingredientes;
    private List<Cobertura> coberturas;

    public PizzaCalabresa() {
        nome = "Pizza de Calabresa";
        ingredientes = new ArrayList<>();
        ingredientes.add(new Calabresa());
        ingredientes.add(new Queijo());

        coberturas = new ArrayList<>();
        coberturas.add(new Cebola());
        coberturas.add(new Azeitona());
    }

    public double getPreco() {
        double preco = 0;
        for (Ingrediente ingrediente : ingredientes) {
            preco += ingrediente.getPreco();
        }
        for (Cobertura cobertura : coberturas) {
            preco += cobertura.getPreco();
        }
        return preco;
    }

    @Override
    public void preparar() {
        System.out.println("Preparando a pizza de calabresa...");
    }

    @Override
    public void entregar() {
        System.out.println("Entregando a pizza de calabresa...");
    }
}

class PizzaMargherita extends Pizza implements Preparavel, Entregavel {
    private List<Ingrediente> ingredientes;
    private List<Cobertura> coberturas;

    public PizzaMargherita() {
        nome = "Pizza Margherita";
        ingredientes = new ArrayList<>();
        ingredientes.add(new Queijo());
        ingredientes.add(new Tomate());

        coberturas = new ArrayList<>();
        coberturas.add(new Manjericao());
    }

    public double getPreco() {
        double preco = 0;
        for (Ingrediente ingrediente : ingredientes) {
            preco += ingrediente.getPreco();
        }
        for (Cobertura cobertura : coberturas) {
            preco += cobertura.getPreco();
        }
        return preco;
    }

    @Override
    public void preparar() {
        System.out.println("Preparando a pizza Margherita...");
    }

    @Override
    public void entregar() {
        System.out.println("Entregando a pizza Margherita...");
    }
}

class Calabresa extends Ingrediente {
    public Calabresa() {
        nome = "Calabresa";
    }

    public double getPreco() {
        return 2.5;
    }
}

class Queijo extends Ingrediente {
    public Queijo() {
        nome = "Queijo";
    }

    public double getPreco() {
        return 1.5;
    }
}

class Cebola extends Cobertura {
    public Cebola() {
        nome = "Cebola";
    }

    public double getPreco() {
        return 1.0;
    }
}

class Azeitona extends Cobertura {
    public Azeitona() {
        nome = "Azeitona";
    }

    public double getPreco() {
        return 0.5;
    }
}

class Tomate extends Ingrediente {
    public Tomate() {
        nome = "Tomate";
    }

    public double getPreco() {
        return 1.0;
    }
}

class Manjericao extends Cobertura {
    public Manjericao() {
        nome = "Manjericão";
    }

    public double getPreco() {
        return 0.5;
    }
}

// Classes de exceção
class PizzariaException extends Exception {
    public PizzariaException(String message) {
        super(message);
    }
}

class IngredienteIndisponivelException extends PizzariaException {
    public IngredienteIndisponivelException(String message) {
        super(message);
    }
}

// Classe Pizzaria
class Pizzaria {
    private List<Pizza> menu;

    public Pizzaria() {
        menu = new ArrayList<>();
    }

    public void adicionarPizza(Pizza pizza) {
        menu.add(pizza);
    }

    public void listarMenu() {
        System.out.println("Menu:");
        for (Pizza pizza : menu) {
            System.out.println("- " + pizza.getNome() + " - R$" + pizza.getPreco());
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Pizzaria pizzaria = new Pizzaria();
        pizzaria.adicionarPizza(new PizzaCalabresa());
        pizzaria.adicionarPizza(new PizzaMargherita());
        pizzaria.listarMenu();
    }
}