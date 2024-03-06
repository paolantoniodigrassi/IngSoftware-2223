package it.uniba.app.FloydGame.Boundaries;

/**
 * <<Boundary>> Classe che contiene il messaggio di aiuto.
 */
public final class Help {
    /**
     * Modificatore di accesso che impedisce la creazione di oggetti di tipo.
     */
    private Help() {
    }
    /**
     * Messaggio che viene mostrato quando viene inserito
     * il comando /help, e quando da terminale
     * viene inserito come -h, --help.
     */
    private static final String HELP_MESSAGE =
        "\nDESCRIZIONE APPLICAZIONE:\n\n"
        + "Nel gioco Battleship il giocatore deve cercare di colpire e "
        + "affondare tutte le navi posizionate sulla griglia da un "
        + "sistema automatico. Il giocatore, prima di iniziare una partita,"
        + " può scegliere la dimensione della griglia e inoltre può "
        + "impostare un livello di difficoltà scegliendo tra facile, medio "
        + "o difficile.\nIl giocatore vince la partita se riesce a colpire "
        + "e affondare tutte le navi. Ha inoltre la possibilità di scegliere "
        + "un tempo di gioco massimo, al termine del quale perderà se non "
        + "avrà colpito e affondato tutte le navi. Ovviamente il giocatore "
        + "può vedere il tempo trascorso il tempo rimanente.\n\n"
        + "OPZIONI:\n\n"
        + "-h, --help  Visualizza questa guida.\n\n"
        + "COMANDI IN APP:\n\n"
        + "/facile"
        + "\t\t\tImposta a 50 il numero massimo di tentativi falliti.\n"
        + "/medio"
        + "\t\t\tImposta a 30 il numero massimo di tentativi falliti.\n"
        + "/difficile"
        + "\t\tImposta a 10 il numero massimo di tentativi falliti.\n"
        + "/facile *numero*"
        + "\tImposta al numero in input il numero "
        + "massimo di tentativi falliti.\n"
        + "/medio *numero*"
        + "\t\tImposta al numero in input il numero "
        + "massimo di tentativi falliti.\n"
        + "/difficile *numero*"
        + "\tImposta al numero in input il numero "
        + "massimo di tentativi falliti.\n"
        + "/tentativi *numero*"
        + "\tImposta a numero in input il numero "
        + "massimo di tentativi falliti.\n"
        + "/mostralivello\t\tVisualizza  il livello di gioco"
        + " e il numero di massimo di tentativi falliti.\n"
        + "/mostratentativi"
        + "\tVisualizza il numero massimo di tentativi falliti.\n"
        + "/mostranavi"
        + "\t\tVisualizza i tipi e il numero di navi.\n"
        + "/standard"
        + "\t\tImposta a 10x10 la dimensione della griglia.\n"
        + "/large"
        + "\t\t\tImposta a 18x18 la dimensione della griglia.\n"
        + "/extralarge"
        + "\t\tImposta a 26x26 la dimensione della griglia.\n"
        + "/tempo *numero*"
        + "\t\tImposta a numero in input il numero di minuti a disposizione.\n"
        + "/mostratempo"
        + "\t\tVisualizza il numero di minuti trascorsi"
        + " e il numero di minuti disponibili.\n"
        + "/gioca"
        + "\t\t\tInizio di una nuova partita.\n"
        + "/svelagriglia"
        + "\t\tSvela la griglia con le navi posizionate.\n"
        + "/mostragriglia"
        + "\t\tVisualizza i tentativi effettuati, i tentativi falliti"
        + " e il massimo dei tentativi falliti.\n"
        + "/help"
        + "\t\t\tVisualizza questa guida.\n"
        + "/esci\t\t\tTermina l'applicazione.\n"
        + "/abbandona\t\tAbbandona la partita.\n"
        + "colonna-riga\t\tSi indicano le coordinate da colpire,"
        + " per esempio 'A-1'.\n";
    /**
     * Stampa il messaggio di aiuto.
     */
    public static void printHelp() {
        System.out.println(HELP_MESSAGE);
    }
}
