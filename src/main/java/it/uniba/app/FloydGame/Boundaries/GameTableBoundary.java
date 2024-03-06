package it.uniba.app.FloydGame.Boundaries;

import it.uniba.app.FloydGame.Controller.Const;
import it.uniba.app.FloydGame.GameTable.GameTable;
import it.uniba.app.FloydGame.UserExceptions.NullTableException;

/**
 * <<Boundary>> Classe Boundary che stampa gameTable.
 */
public final class GameTableBoundary {
    private GameTableBoundary() { };

    /**
     * Stampa la tabella passata in input.
     * @param tab tebella da stampare.
     * @throws NullTableException eccezione se la tabella è nulla.
     */
    public static void printTable(final GameTable tab)
        throws NullTableException {
        System.out.println(GameTableBoundary.tabletoString(tab));
    }

    /**
    * Metodo che genera la stringa che verrà
    * utilizzata per visualizzare la tabella.
    * @return s stringa
    */
    private static String tabletoString(final GameTable tab)
     throws NullTableException {
        char cLabel = 'A';
        String s = "\n   ";
        int i;
        int j;

        if (tab == null) {
            throw new NullTableException(("\nPrima di visualizzare la ")
            + ("griglia devi iniziare a giocare!\n")
            + ("Digita /gioca per iniziare una nuova partita.\n"));
        }
        for (i = 0; i < tab.getColumns() - 2; i++) {
            s += " ";
            s += cLabel;
            s += " ";
            cLabel++;
        }

        s += "\n";

        for (i = 1; i < tab.getRows() - 1; i++) {
            if (i < Const.RLABEL) {
              s += " " + i + " ";
            } else {
              s += i + " ";
            }
            for (j = 1; j < tab.getColumns() - 1; j++) {
                s += " " + tab.getValue(i, j) + " ";
            }
            s += "\n";
        }
       return s;
    }
}
