package cursojava.thread;

import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ImplementacaoFilaThread extends Thread {

  private static ConcurrentLinkedQueue<ObjetoFilaThread> pilha_fila =
      new ConcurrentLinkedQueue<ObjetoFilaThread>();

  public static void add(ObjetoFilaThread objetoFilaThread) {
    pilha_fila.add(objetoFilaThread);
  }

  @Override
  public void run() {

    System.out.println("Fila_rodando");


    while (true) {

      synchronized (pilha_fila) {

        Iterator iteracao = pilha_fila.iterator();
        while (iteracao.hasNext()) {

          ObjetoFilaThread processar = (ObjetoFilaThread) iteracao.next();

          /*
           * Processar 10 mil nfe! Gerar uma lista de pdf! Gerar um envio em massa de email!
           */
          System.out.println("----------------");
          System.out.println(processar.getNome());
          System.out.println(processar.getEmail());
          System.out.println("-----------------");

          iteracao.remove();

          try {
            Thread.sleep(100);
          } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
          }

        }
      }
    }
  }

}
