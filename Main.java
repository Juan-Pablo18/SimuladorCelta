import java.util.Scanner;

public class Main {

    private static Scanner entrada = new Scanner(System.in);

    // Estado do veiculo
    private static boolean ignicao = false;
    private static boolean setaEsquerda = false;
    private static boolean setaDireita = false;
    private static boolean piscaAlerta = false;

    private static boolean farolBaixo = false;
    private static boolean farolAlto = false;
    private static boolean lanternas = false;
    private static boolean luzFreio = false;
    private static boolean luzRe = false;
    private static boolean luzInterna = false;
    private static boolean limpador = false;
    private static boolean buzina = false;

    private static boolean arCondicionado = false;
    private static boolean ventilacao = false;
    private static boolean desembacador = false;
    private static boolean radio = false;

    private static boolean embreagem = false;
    private static boolean freioDeMao = true;
    private static boolean pedalFreio = false;
    private static boolean cinto = false;

    private static boolean portasAbertas = false;
    private static boolean vidrosAbertos = false;
    private static boolean travas = true;

    private static int velocidade = 0;
    // -1 = re, 0 = ponto morto, 1 a 5 = marchas
    private static int marcha = 0;
    private static int rpm = 0;
    private static int temperatura = 25;
    private static int combustivel = 50;

    private static int hodometro = 0;
    private static int hodometroParcial = 0;
    private static int contadorConsumo = 0;

    private static boolean direcaoEsquerda = false;
    private static boolean direcaoDireita = false;

    public static void main(String[] args) {

        int opcao;

        System.out.println("====================================");
        System.out.println("   SIMULADOR AVANCADO - CELTA");
        System.out.println("====================================");
        System.out.println("1 - Ligar o carro");
        System.out.println("2 - Sair");
        System.out.print("Escolha: ");

        opcao = lerInteiro();

        if (opcao != 1) {
            System.out.println("Simulador encerrado.");
            entrada.close();
            return;
        }

        ligarMotor();

        do {
            mostrarMenu();
            opcao = lerInteiro();

            switch (opcao) {
                case 0:
                    mostrarStatus();
                    break;
                case 1:
                    alternarIgnicao();
                    break;
                case 2:
                    controlarSetas();
                    break;
                case 3:
                    alternarPiscaAlerta();
                    break;
                case 4:
                    controlarFarois();
                    break;
                case 5:
                    acionarBuzina();
                    break;
                case 6:
                    acelerar();
                    break;
                case 7:
                    frear();
                    break;
                case 8:
                    alternarEmbreagem();
                    break;
                case 9:
                    aumentarMarcha();
                    break;
                case 10:
                    diminuirMarcha();
                    break;
                case 11:
                    alternarFreioDeMao();
                    break;
                case 12:
                    alternarMarchaRe();
                    break;
                case 13:
                    alternarCinto();
                    break;
                case 14:
                    alternarPortas();
                    break;
                case 15:
                    alternarLuzInterna();
                    break;
                case 16:
                    alternarArCondicionado();
                    break;
                case 17:
                    alternarVentilacao();
                    break;
                case 18:
                    alternarDesembacador();
                    break;
                case 19:
                    alternarVidros();
                    break;
                case 20:
                    alternarTravas();
                    break;
                case 21:
                    alternarRadio();
                    break;
                case 22:
                    controlarDirecao();
                    break;
                case 23:
                    alternarLimpador();
                    break;
                case 24:
                    abastecer();
                    break;
                case 25:
                    hodometroParcial = 0;
                    System.out.println("Hodometro parcial zerado.");
                    break;
                case 99:
                    if (velocidade > 0) {
                        System.out.println(
                            "Pare o carro antes de encerrar."
                        );
                        opcao = 0;
                    } else {
                        System.out.println(
                            "Simulador encerrado com seguranca."
                        );
                    }
                    break;
                default:
                    System.out.println("Opcao invalida!");
            }

        } while (opcao != 99);

        entrada.close();
    }

    // MENU PRINCIPAL

    static void mostrarMenu() {
        System.out.println("\n========== MENU DO CELTA ==========");
        System.out.println(" 0 - Painel e status completo");
        System.out.println(" 1 - Ligar/desligar motor");
        System.out.println(" 2 - Setas");
        System.out.println(" 3 - Pisca-alerta");
        System.out.println(" 4 - Farois e lanternas");
        System.out.println(" 5 - Buzina");
        System.out.println(" 6 - Acelerar");
        System.out.println(" 7 - Frear");
        System.out.println(" 8 - Embreagem");
        System.out.println(" 9 - Aumentar marcha");
        System.out.println("10 - Diminuir marcha");
        System.out.println("11 - Freio de mao");
        System.out.println("12 - Marcha a re");
        System.out.println("13 - Cinto de seguranca");
        System.out.println("14 - Abrir/fechar portas");
        System.out.println("15 - Luz interna");
        System.out.println("16 - Ar-condicionado");
        System.out.println("17 - Ventilacao");
        System.out.println("18 - Desembacador traseiro");
        System.out.println("19 - Vidros eletricos");
        System.out.println("20 - Travas das portas");
        System.out.println("21 - Radio");
        System.out.println("22 - Direcao");
        System.out.println("23 - Limpador de para-brisa");
        System.out.println("24 - Abastecer");
        System.out.println("25 - Zerar hodometro parcial");
        System.out.println("99 - Encerrar simulador");
        System.out.println("===================================");
        System.out.print("Escolha: ");
    }

    // LEITURA SEGURA DE NUMEROS

    static int lerInteiro() {
        while (!entrada.hasNextInt()) {
            System.out.print("Digite um numero valido: ");
            entrada.next();
        }
        return entrada.nextInt();
    }

    // MOTOR E IGNICAO

    static void ligarMotor() {
        if (combustivel <= 0) {
            System.out.println(
                "Nao ha combustivel suficiente para ligar o motor."
            );
            return;
        }

        ignicao = true;
        freioDeMao = true;
        marcha = 0;
        rpm = 800;

        System.out.println("Motor ligado!");
        System.out.println("Marcha em ponto morto.");
        System.out.println("Freio de mao acionado.");
    }

    static void alternarIgnicao() {
        if (ignicao) {
            if (velocidade > 0) {
                System.out.println(
                    "Nao e permitido desligar o motor em movimento."
                );
                return;
            }

            ignicao = false;
            rpm = 0;
            marcha = 0;

            farolBaixo = false;
            farolAlto = false;
            lanternas = false;
            luzFreio = false;
            luzRe = false;
            limpador = false;
            arCondicionado = false;
            ventilacao = false;
            desembacador = false;
            embreagem = false;

            System.out.println("Motor desligado.");
        } else {
            ligarMotor();
        }
    }

    // PAINEL

    static void mostrarStatus() {
        System.out.println("\n========== PAINEL DO CELTA ==========");
        System.out.println("Motor: " + (ignicao ? "Ligado" : "Desligado"));
        System.out.println("Velocidade: " + velocidade + " km/h");
        System.out.println("RPM simulado: " + rpm);
        System.out.println("Temperatura: " + temperatura + " graus C");
        System.out.println("Combustivel: " + combustivel + "%");
        System.out.println("Hodometro: " + hodometro + " km");
        System.out.println("Hodometro parcial: " + hodometroParcial + " km");

        System.out.println("Marcha: " + nomeMarcha());
        System.out.println("Freio de mao: "
                + (freioDeMao ? "Acionado" : "Liberado"));
        System.out.println("Embreagem: "
                + (embreagem ? "Pressionada" : "Solta"));
        System.out.println("Pedal do freio: "
                + (pedalFreio ? "Pressionado" : "Solto"));
        System.out.println("Cinto: "
                + (cinto ? "Afivelado" : "Desafivelado"));
        System.out.println("Portas: "
                + (portasAbertas ? "Abertas" : "Fechadas"));
        System.out.println("Vidros: "
                + (vidrosAbertos ? "Abertos" : "Fechados"));
        System.out.println("Travas: "
                + (travas ? "Travadas" : "Destravadas"));

        System.out.println("Seta esquerda: " + estado(setaEsquerda));
        System.out.println("Seta direita: " + estado(setaDireita));
        System.out.println("Pisca-alerta: " + estado(piscaAlerta));
        System.out.println("Farol baixo: " + estado(farolBaixo));
        System.out.println("Farol alto: " + estado(farolAlto));
        System.out.println("Lanternas: " + estado(lanternas));
        System.out.println("Luz de freio: " + estado(luzFreio));
        System.out.println("Luz de re: " + estado(luzRe));
        System.out.println("Luz interna: " + estado(luzInterna));
        System.out.println("Limpador: " + estado(limpador));
        System.out.println("Ar-condicionado: " + estado(arCondicionado));
        System.out.println("Ventilacao: " + estado(ventilacao));
        System.out.println("Desembacador: " + estado(desembacador));
        System.out.println("Radio: " + estado(radio));
        System.out.println("Buzina: " + estado(buzina));

        System.out.println("Direcao: "
                + (direcaoEsquerda ? "Esquerda"
                : direcaoDireita ? "Direita" : "Centralizada"));

        System.out.println("======================================");

        if (combustivel <= 10) {
            System.out.println("ALERTA: combustivel baixo!");
        }

        if (temperatura >= 100) {
            System.out.println("ALERTA: motor superaquecido!");
        }

        if (ignicao && velocidade > 0 && !cinto) {
            System.out.println("ALERTA: coloque o cinto de seguranca!");
        }

        if (portasAbertas && velocidade > 0) {
            System.out.println("ALERTA: portas abertas em movimento!");
        }

        if (combustivel == 0) {
            System.out.println("ALERTA: tanque vazio!");
        }
    }

    static String estado(boolean valor) {
        return valor ? "Ligado" : "Desligado";
    }

    static String nomeMarcha() {
        if (marcha == -1) {
            return "Re";
        }
        if (marcha == 0) {
            return "Ponto morto";
        }
        return marcha + "a marcha";
    }

    // ILUMINACAO E SINALIZACAO

    static void controlarSetas() {
        System.out.println("1 - Esquerda");
        System.out.println("2 - Direita");
        System.out.println("3 - Desligar setas");
        System.out.print("Escolha: ");

        int lado = lerInteiro();

        if (lado == 1) {
            setaEsquerda = true;
            setaDireita = false;
            piscaAlerta = false;
            System.out.println("Seta esquerda ligada.");
        } else if (lado == 2) {
            setaDireita = true;
            setaEsquerda = false;
            piscaAlerta = false;
            System.out.println("Seta direita ligada.");
        } else if (lado == 3) {
            setaEsquerda = false;
            setaDireita = false;
            System.out.println("Setas desligadas.");
        } else {
            System.out.println("Opcao invalida.");
        }
    }

    static void alternarPiscaAlerta() {
        piscaAlerta = !piscaAlerta;

        setaEsquerda = piscaAlerta;
        setaDireita = piscaAlerta;

        System.out.println("Pisca-alerta "
                + (piscaAlerta ? "ligado." : "desligado."));
    }

    static void controlarFarois() {
        System.out.println("1 - Farol baixo");
        System.out.println("2 - Farol alto");
        System.out.println("3 - Lanternas");
        System.out.println("4 - Desligar iluminacao");
        System.out.print("Escolha: ");

        int tipo = lerInteiro();

        switch (tipo) {
            case 1:
                farolBaixo = true;
                farolAlto = false;
                lanternas = true;
                System.out.println("Farol baixo ligado.");
                break;
            case 2:
                farolAlto = true;
                farolBaixo = false;
                lanternas = true;
                System.out.println("Farol alto ligado.");
                break;
            case 3:
                lanternas = true;
                farolBaixo = false;
                farolAlto = false;
                System.out.println("Lanternas ligadas.");
                break;
            case 4:
                lanternas = false;
                farolBaixo = false;
                farolAlto = false;
                System.out.println("Iluminacao desligada.");
                break;
            default:
                System.out.println("Opcao invalida.");
        }
    }

    static void acionarBuzina() {
        buzina = true;
        System.out.println("Buzina acionada: BIBI!");
        buzina = false;
    }

    // ACELERACAO E FRENAGEM

    static void acelerar() {
        if (!ignicao) {
            System.out.println("Ligue o motor primeiro.");
            return;
        }

        if (combustivel <= 0) {
            velocidade = 0;
            rpm = 0;
            System.out.println("Sem combustivel. Motor parou.");
            return;
        }

        if (freioDeMao) {
            System.out.println("Libere o freio de mao primeiro.");
            return;
        }

        if (embreagem) {
            System.out.println("Solte a embreagem antes de acelerar.");
            return;
        }

        if (pedalFreio) {
            System.out.println("Solte o freio antes de acelerar.");
            return;
        }

        if (portasAbertas) {
            System.out.println("Feche as portas antes de sair.");
            return;
        }

        if (!cinto) {
            System.out.println("ALERTA: coloque o cinto antes de sair.");
            return;
        }

        if (marcha == 0) {
            rpm = Math.min(rpm + 500, 4000);
            System.out.println("Motor acelerando em ponto morto.");
            System.out.println("RPM: " + rpm);
            System.out.println("O carro nao ganhou velocidade.");
            return;
        }

        int limite;

        if (marcha == -1) {
            limite = 10;
        } else {
            limite = marcha * 20;

            if (marcha == 4) {
                limite = 90;
            } else if (marcha == 5) {
                limite = 130;
            }
        }

        if (velocidade >= limite) {
            System.out.println("Limite desta marcha atingido.");
            System.out.println("Reduza ou aumente a marcha.");
            return;
        }

        int incremento = marcha == -1 ? 5 : 10;

        velocidade = Math.min(velocidade + incremento, limite);

        luzRe = marcha == -1;
        rpm = Math.min(1000 + velocidade * 100, 6000);

        contadorConsumo++;

        if (contadorConsumo >= 5) {
            combustivel = Math.max(0, combustivel - 1);
            contadorConsumo = 0;
        }

        temperatura = Math.min(temperatura + 1, 120);

        // Quilometragem simplificada para cada acao de movimento.
        hodometro++;
        hodometroParcial++;

        System.out.println(marcha == -1
                ? "Manobrando em marcha a re."
                : "Acelerando...");

        System.out.println("Velocidade: " + velocidade + " km/h");
        System.out.println("RPM: " + rpm);
        System.out.println("Combustivel: " + combustivel + "%");

        if (temperatura >= 100) {
            System.out.println("ALERTA: motor superaquecido!");
        }

        if (combustivel == 0) {
            ignicao = false;
            rpm = 0;
            velocidade = 0;
            marcha = 0;
            luzRe = false;
            System.out.println("Combustivel acabou. Motor desligado.");
        }
    }

    static void frear() {
        if (velocidade <= 0) {
            System.out.println("O carro ja esta parado.");
            return;
        }

        pedalFreio = true;
        luzFreio = true;

        velocidade = Math.max(0, velocidade - 10);
        rpm = velocidade == 0 ? 800 : 1000 + velocidade * 50;

        System.out.println("Freando...");
        System.out.println("Velocidade: " + velocidade + " km/h");

        if (velocidade == 0) {
            luzRe = false;
            System.out.println("Carro completamente parado.");
        }

        pedalFreio = false;
        luzFreio = false;
    }

    // EMBREAGEM E CAMBIO

    static void alternarEmbreagem() {
        if (!ignicao) {
            System.out.println("Ligue o motor primeiro.");
            return;
        }

        embreagem = !embreagem;

        System.out.println(embreagem
                ? "Embreagem pressionada."
                : "Embreagem solta.");
    }

    static void aumentarMarcha() {
        if (!ignicao) {
            System.out.println("Ligue o motor primeiro.");
            return;
        }

        if (!embreagem) {
            System.out.println("Pressione a embreagem.");
            return;
        }

        if (marcha == -1) {
            System.out.println("Saia da marcha a re primeiro.");
            return;
        }

        if (marcha >= 5) {
            System.out.println("Quinta marcha ja selecionada.");
            return;
        }

        marcha++;
        luzRe = false;

        System.out.println("Marcha atual: " + nomeMarcha());
    }

    static void diminuirMarcha() {
        if (!ignicao) {
            System.out.println("Ligue o motor primeiro.");
            return;
        }

        if (!embreagem) {
            System.out.println("Pressione a embreagem.");
            return;
        }

        if (marcha <= 0) {
            System.out.println("Ja esta em ponto morto ou na re.");
            return;
        }

        marcha--;
        System.out.println("Marcha atual: " + nomeMarcha());
    }

    static void alternarMarchaRe() {
        if (!ignicao) {
            System.out.println("Ligue o motor primeiro.");
            return;
        }

        if (!embreagem) {
            System.out.println("Pressione a embreagem.");
            return;
        }

        if (velocidade != 0) {
            System.out.println("Pare completamente antes de engatar a re.");
            return;
        }

        if (marcha == -1) {
            marcha = 0;
            luzRe = false;
            System.out.println("Ponto morto selecionado.");
        } else {
            marcha = -1;
            luzRe = true;
            System.out.println("Marcha a re engatada.");
        }
    }

    static void alternarFreioDeMao() {
        if (freioDeMao) {
            if (velocidade > 0) {
                System.out.println("Carro em movimento. Operacao bloqueada.");
                return;
            }

            if (!ignicao) {
                System.out.println("Ligue a ignicao para liberar o freio.");
                return;
            }

            freioDeMao = false;
            System.out.println("Freio de mao liberado.");
        } else {
            if (velocidade > 0) {
                System.out.println("Pare o carro antes de acionar o freio.");
                return;
            }

            freioDeMao = true;
            marcha = 0;
            luzRe = false;

            System.out.println("Freio de mao acionado.");
        }
    }

    // SEGURANCA

    static void alternarCinto() {
        cinto = !cinto;

        System.out.println(cinto
                ? "Cinto afivelado."
                : "Cinto desafivelado.");
    }

    static void alternarPortas() {
        if (portasAbertas) {
            portasAbertas = false;
            System.out.println("Portas fechadas.");
        } else if (velocidade > 0) {
            System.out.println("Nao abra as portas em movimento.");
        } else {
            portasAbertas = true;
            travas = false;
            System.out.println("Portas abertas.");
        }
    }

    // CONFORTO E ACESSORIOS

    static void alternarLuzInterna() {
        luzInterna = !luzInterna;
        System.out.println("Luz interna " + estado(luzInterna) + ".");
    }

    static void alternarArCondicionado() {
        if (!ignicao) {
            System.out.println("Ligue a ignicao primeiro.");
            return;
        }

        arCondicionado = !arCondicionado;

        if (arCondicionado) {
            ventilacao = true;
        }

        System.out.println("Ar-condicionado "
                + estado(arCondicionado) + ".");
    }

    static void alternarVentilacao() {
        if (!ignicao) {
            System.out.println("Ligue a ignicao primeiro.");
            return;
        }

        ventilacao = !ventilacao;

        if (!ventilacao) {
            arCondicionado = false;
        }

        System.out.println("Ventilacao "
                + estado(ventilacao) + ".");
    }

    static void alternarDesembacador() {
        if (!ignicao) {
            System.out.println("Ligue a ignicao primeiro.");
            return;
        }

        desembacador = !desembacador;

        System.out.println("Desembacador traseiro "
                + estado(desembacador) + ".");
    }

    static void alternarVidros() {
        if (velocidade > 0) {
            System.out.println(
                "Operacao bloqueada nesta simulacao em movimento."
            );
            return;
        }

        vidrosAbertos = !vidrosAbertos;

        System.out.println(vidrosAbertos
                ? "Vidros abertos."
                : "Vidros fechados.");
    }

    static void alternarTravas() {
        if (travas) {
            travas = false;
            System.out.println("Portas destravadas.");
        } else if (portasAbertas) {
            System.out.println("Feche as portas antes de travar.");
        } else {
            travas = true;
            System.out.println("Portas travadas.");
        }
    }

    static void alternarRadio() {
        radio = !radio;
        System.out.println("Radio " + estado(radio) + ".");
    }

    static void controlarDirecao() {
        System.out.println("1 - Virar a esquerda");
        System.out.println("2 - Virar a direita");
        System.out.println("3 - Centralizar volante");
        System.out.print("Escolha: ");

        int lado = lerInteiro();

        if (lado == 1) {
            direcaoEsquerda = true;
            direcaoDireita = false;
            System.out.println("Direcao para esquerda.");
        } else if (lado == 2) {
            direcaoDireita = true;
            direcaoEsquerda = false;
            System.out.println("Direcao para direita.");
        } else if (lado == 3) {
            direcaoEsquerda = false;
            direcaoDireita = false;
            System.out.println("Volante centralizado.");
        } else {
            System.out.println("Opcao invalida.");
        }
    }

    static void alternarLimpador() {
        if (!ignicao) {
            System.out.println("Ligue a ignicao primeiro.");
            return;
        }

        limpador = !limpador;
        System.out.println("Limpador " + estado(limpador) + ".");
    }

    // ABASTECIMENTO

    static void abastecer() {
        if (velocidade > 0) {
            System.out.println("Pare o carro antes de abastecer.");
            return;
        }

        if (ignicao) {
            System.out.println("Desligue o motor antes de abastecer.");
            return;
        }

        System.out.println("Combustivel atual: " + combustivel + "%");
        System.out.print("Quantidade para adicionar (1 a 100): ");

        int quantidade = lerInteiro();

        if (quantidade < 1 || quantidade > 100) {
            System.out.println("Quantidade invalida.");
            return;
        }

        combustivel = Math.min(100, combustivel + quantidade);

        System.out.println("Abastecimento realizado.");
        System.out.println("Combustivel atual: " + combustivel + "%");
    }
}