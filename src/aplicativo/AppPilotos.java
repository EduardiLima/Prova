package aplicativo;

import java.util.Scanner;

import classes.Aeronave;
import classes.Piloto;

public class AppPilotos {
    public static void main(String[] args) throws Exception {
      Scanner sc = new Scanner(System.in);
      
      int opcao = 0;
      int contAlunos = 0;
      int contAeronaves = 0;
      String cpf;
      String modelo;
      Piloto[] listaPilotos = new Piloto[100];
      Aeronave[] listaAeronaves = new Aeronave[50];

      do {
          System.out.print("\\\\033[H\\\\033[2J");
          System.out.flush();

          System.out.println("1 - Cadastrar Piloto");
          System.out.println("2 - Listar Pilotos");
          System.out.println("3 - Localizar Piloto");
          System.out.println("4 - Cadastrar Aeronave");
          System.out.println("0 - Sair");

          opcao = sc.nextInt();

          if (opcao == 1) {
              if (contAlunos < 100) {
                  Piloto piloto = new Piloto();
                  System.out.println("Insira respectivamente nome e CPF do piloto.");
                  piloto.setNome(sc.next());
                  piloto.setCpf(sc.next());
                  listaPilotos[contAlunos] = piloto;
                  contAlunos++;
              } else {
                  System.out.println("A lista de pilotos está cheia.");
                  sc.next();
              }
          } else if (opcao == 2) {
              if (listaPilotos[0] != null) {
                  for (Piloto piloto : listaPilotos) {
                      if (piloto != null) {
                          System.out.println(piloto);
                      }
                  }
              } else {
                  System.out.println("Não há pilotos cadastrados para exibir.");
              }
              sc.next();
          } else if (opcao == 3) {
              Boolean achou = false;
              System.out.println("Informe o CPF do piloto:");
              cpf = sc.next();
              for (Piloto piloto : listaPilotos) {
                  if (piloto != null && cpf.equals(piloto.getCpf())) {
                      System.out.println(piloto);
                      achou = true;
                  }
              }
              if (!achou) {
                  System.out.println("CPF não encontrado.");
              }
              sc.next();
          } else if (opcao == 4) {
              if (contAeronaves < 50) {
                  if (listaPilotos[0] == null) {
                      System.out.println("Não há pilotos cadastrados para cadastrar uma aeronave.");
                      sc.next();
                  } else {
                      Aeronave aeronave = new Aeronave();
                      System.out.println("Insira respectivamente o modelo da aeronave e o CPF do piloto responsável.");
                      modelo = sc.next();
                      cpf = sc.next();
                      for (Piloto piloto : listaPilotos) {
                          if (piloto != null && cpf.equals(piloto.getCpf())) {
                              aeronave.setModelo(modelo);
                              aeronave.setPiloto(piloto);
                              listaAeronaves[contAeronaves] = aeronave;
                              contAeronaves++;
                              break;
                          }
                      }
                      if (aeronave.getPiloto() == null) {
                          System.out.println("CPF de piloto inválido.");
                      }
                  }
              } else {
                  System.out.println("A lista de aeronaves está cheia.");
                  sc.next();
              }
          } else if (opcao == 0) {
              System.out.println("Programa finalizado.");
          } else {
              System.out.println("Opção inválida, tente novamente.");
          }
      } while (opcao != 0);

      sc.close();
  }
}
    

