package org.example;

public class Atv1 {

    public static void contaTempo(int dia, int mes, int ano) {
        // Obtendo a data atual do sistema
        LocalDate dataAtual = LocalDate.now();

        // Criando a data fornecida como parâmetro
        LocalDate dataFutura = LocalDate.of(ano, mes, dia);

        // Verificando se a data fornecida é no futuro
        if (dataFutura.isBefore(dataAtual)) {
            System.out.println("A data fornecida já passou!");
        } else {
            // Calculando a diferença entre as datas
            Period periodo = Period.between(dataAtual, dataFutura);

            // Exibindo o tempo restante
            System.out.printf("Faltam %d ano(s), %d mês(es) e %d dia(s) para a data fornecida.%n",
                    periodo.getYears(), periodo.getMonths(), periodo.getDays());
        }
    }

    public static void main(String[] args) {
        // Exemplo de uso
        contaTempo(4, 4, 2024); // Ajuste a data conforme necessário
    }
}

