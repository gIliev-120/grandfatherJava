package dopulnitelno;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by gIliev-120 on 12/28/2015.
 */
public class Erraten{
    static Scanner sc = new Scanner(System.in);
   public  int StreichHolzernAnzahl,SpielerStreichHolzern, pcStreichHolzern,spRechtHand,pcRechtHand;
   public Random r = new Random();
    static int min=1;
    public void streichHolzernAuswahl() {
        System.out.println("Anzahl von StreichHolzern");
        StreichHolzernAnzahl = sc.nextInt();

        pcStreichHolzern=StreichHolzernAnzahl;
        SpielerStreichHolzern=StreichHolzernAnzahl;
    }

    public void  streichHolzernInRechtHand(){
        System.out.println("Wie viel Streichholzern wollen sie in seiner Hand Stecken");
        do {
            spRechtHand=sc.nextInt();
            if(spRechtHand>SpielerStreichHolzern){
                System.out.println("Sie konnen das nicht machen.Probieren sie noch einmal");
            }
        }while(spRechtHand==0||spRechtHand>SpielerStreichHolzern);

        pcRechtHand = r.nextInt(pcStreichHolzern-min+1)+min;
        System.out.println("pcrechthand="+pcRechtHand);
    }

    public void errat() {
        System.out.println("Erraten sie:");
          int spNum = sc.nextInt();
          int pcNum = r.nextInt(pcStreichHolzern-min+1)+min;
          System.out.println(pcNum);
            if (spNum == pcRechtHand) {
                SpielerStreichHolzern--;
                System.out.println("Pozna");
            }else if (pcNum==spRechtHand){
                pcStreichHolzern--;
                System.out.println("Pc pozna");
            }else{
                System.out.println("Keiner");

            }
    }

    public static void main(String[] args) {
        Erraten e = new Erraten();
        e.streichHolzernAuswahl();
        e.streichHolzernInRechtHand();
        while(true) {
            e.errat();
            if(e.pcStreichHolzern==0){
                System.out.println("Pc Wins");
                break;
            }
            if(e.SpielerStreichHolzern==0){
                System.out.println("Sie haben gewonen");
                break;
            }
            System.out.println("Sie haben=" + e.SpielerStreichHolzern+" StreichHolzern und das PC hat "+e.pcStreichHolzern);
            e.streichHolzernInRechtHand();
        }
    }

}
