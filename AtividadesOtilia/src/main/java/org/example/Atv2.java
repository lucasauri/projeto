package org.example;

public class Atv2 {

    public static String obterDataPorExtenso() {
        // Obtendo a data e hora atual
        LocalDateTime agora = LocalDateTime.now();

        // Extraindo informações
        String diaSemana = agora.getDayOfWeek().getDisplayName(TextStyle.FULL, new Locale("pt", "BR"));
        int dia = agora.getDayOfMonth();
        String mes = agora.getMonth().getDisplayName(TextStyle.FULL, new Locale("pt", "BR"));
        int ano = agora.getYear();
        int hora = agora.getHour();
        int minuto = agora.getMinute();

        // Formatando a data por extenso
        return String.format(
                "Hoje é %s, dia %02d de %s de %d, e agora são %02d horas e %02d minutos.",
                diaSemana, dia, mes, ano, hora, minuto
        );
    }

    public static void main(String[] args) {
        // Exibindo a data por extenso
        System.out.println(obterDataPorExtenso());
    }
}

