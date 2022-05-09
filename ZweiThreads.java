/**
 * 
 * TwoThreads Klasse mit Main Methode die zwei Threads anlegt und
 * synchronisiert ein Ressource Objekt val attribut 100 inkrementieren bzw dekrementieren
 *
 */
public class ZweiThreads{

    public static void main(String[] args) {
        
        Ressource ressource = new Ressource();
        
        //Verkuerzte Variante mit Runnable und overridener run Methode
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                //Synchronisierung der Threads
                synchronized (ressource) {
                for (int i = 0; i<100; i++) {
                    ressource.decr();
                    }
                }
            }
        });
        
        //Verkuerzte Variante mit Runnable und overridener run Methode
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                //Synchroniserung der Threads
                synchronized (ressource) {
                    for (int i = 0; i<100; i++) {
                        ressource.incr();
                    }
                }
            }
        });
        //Ausfuehrung bzw.Start der beiden Threads
        t1.start();
        t2.start();
        
        //Benoetigt falls man Ressource Value abfragen will
        /**try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
    }
}
