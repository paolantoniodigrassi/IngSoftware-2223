package it.uniba.app.FloydGame.Controller;

/**
 * Classe che modella le costanti utilizzate nel progetto.
 */
public final class Const {
    private Const() { };
    /**
     * Carattere che rappresenta il mare.
     */
    public static final char SEA = '-';
    /**
     * Carattere che rappresenta i bordi.
     */
    public static final char BOUND = '|';
    /**
     * Carattere che rappresenta le navi.
     */
    public static final char SHIP = '1';
    /**
     * Carattere che rappresenta le navi colpite.
     */
    public static final char HIT = 'X';
    /**
     * Carattere che rappresenta le navi affondate.
     */
    public static final char SUNK = 'Z';
    /**
     * Carattere che rappresenta lo spazio.
     */
    public static final char VOID = ' ';

    /**
     * Righe o colonne occupate da una nave.
     */
    public static final int BORDERCHECK = 3;
    /**
     * Posizione minima nella tabella.
     */
    public static final int MINRANGE_TAB = 0;
    /**
     * Dimensione della griglia di gioco standard.
     */
    public static final int STANDARD_DIM_TABLE = 12;
    /**
     * Dimensione della griglia di gioco grande.
     */
    public static final int LARGE_DIM_TABLE = 20;
    /**
     * Dimensione della griglia di gioco XXL.
     */
    public static final int EXTRA_LARGE_DIM_TABLE = 28;
    /**
     * Valore per la direzione massimo generabile in maniera casuale.
     */
    public static final int MAX_DIRECTION = 2;
    /**
     * Istanze cacciatorpediniere.
     */
    public static final int IST_CACCIATORPEDINIERE = 4;
    /**
     * Istanze incrociatore.
     */
    public static final int IST_INCROCIATORE = 3;
    /**
     * Istanze corazzata.
     */
    public static final int IST_CORAZZATA = 2;
    /**
     * Istanze portaerei.
     */
    public static final int IST_PORTAEREI = 1;
    /**
     * Dimensione portaerei.
     */
    public static final int DIM_PORTAEREI = 5;
    /**
     * Dimensione cacciatorpediniere.
     */
    public static final int DIM_CACCIATORPEDINIERE = 2;
    /**
     * Dimensione incrociatore.
     */
    public static final int DIM_INCROCIATORE = 3;
    /**
     * Dimensione corazzata.
     */
    public static final int DIM_CORAZZATA = 4;
    /**
     * Difficoltà minima.
     */
    public static final int EASY = 50;
    /**
     * Difficoltà media.
     */
    public static final int MEDIUM = 30;
    /**
     * Difficoltà massima.
     */
    public static final int HARD = 10;
    /**
     * Etichettatore delle righe.
     */
    public static final int RLABEL = 10;
    /**
     * Costante che indica il tempo
     * di pausa di 1 minuto in millisecondi.
     */
    public static final int MINUTE = 60000;
    /**
     * Massimo numero di iterazioni raggiungibili.
     */
    public static final int RESETVALUE = 500;
    /**
     * Massimo numero di istanze delle navi.
     */
    public static final int MAX_INSTANCE = 10;
    /**
     * Somma della dimensione di tutte le navi.
     */
    public static final int MAX_DIM = 30;

    /**
     *  Stringa che rappresenta la nave segnata.
     */
    public static final String MARKED_SHIP = "[x]";
    /**
     *  Stringa che rappresenta la portaerei.
     */
    public static final String SHIP1 = "Portaerei";
    /**
     *  Stringa che rappresenta la corazzata.
     */
    public static final String SHIP2 = "Corazzata";
    /**
     *  Stringa che rappresenta l'incrociatore.
     */
    public static final String SHIP3 = "Incrociatore";
    /**
     *  Stringa che rappresenta il cacciatorpediniere.
     */
    public static final String SHIP4 = "Cacciatorpediniere";
    /**
     * Stringa rappresentante un comando errato.
     */
    public static final String COMMAND_ERROR = "\n--- Il comando "
                    + "inserito non è valido ---\n\n";
    /**
     * Stringa del messaggio "acqua".
     */
    public static final String WATER =
    "     _                           _ \n"
  + "    / \\   ___ __ _ _   _  __ _  | |\n"
  + "   / _ \\ / __/ _` | | | |/ _` | | |\n"
  + "  / ___ \\ (_| (_| | |_| | (_| | |_|\n"
  + " /_/   \\_\\___\\__, |\\__,_|\\__,_| (_)\n"
  + "                |_|                 \n\n";
    /**
     * Stringa del messaggio "colpito".
     */
    public static final String HITTEN =
    "   ____      _       _ _          _ \n"
  + "  / ___|___ | |_ __ (_) |_ ___   | |\n"
  + " | |   / _ \\| | '_ \\| | __/ _ \\  | |\n"
  + " | |__| (_) | | |_) | | || (_) | |_|\n"
  + "  \\____\\___/|_| .__/|_|\\__\\___/  (_)\n"
  + "              |_|                   \n\n";
    /**
     * Stringa del messaggio "colpito e affondato".
     */
    public static final String SUNKEN =
    "          ____      _       _ _                        \n"
  + "         / ___|___ | |_ __ (_) |_ ___     ___          \n"
  + "        | |   / _ \\| | '_ \\| | __/ _ \\   / _ \\         \n"
  + "        | |__| (_) | | |_) | | || (_) | |  __/         \n"
  + "     _   \\____\\___/|_| .__/|_|\\__\\___/   \\___|       _ \n"
  + "    / \\   / _|/ _| __|_|_ __   __| | __ _| |_ ___   | |\n"
  + "   / _ \\ | |_| |_ / _ \\| '_ \\ / _` |/ _` | __/ _ \\  | |\n"
  + "  / ___ \\|  _|  _| (_) | | | | (_| | (_| | || (_) | |_|\n"
  + " /_/   \\_\\_| |_|  \\___/|_| |_|\\__,_|\\__,_|\\__\\___/  (_)\n\n";
    /**
     * Stringa del messaggio "Hai vinto".
     */
    public static final String WON =
      "      _   _       _         _       _          _ \n"
    + "     | | | | __ _(_) __   _(_)_ __ | |_ ___   | |\n"
    + "     | |_| |/ _` | | \\ \\ / / | '_ \\| __/ _ \\  | |\n"
    + "     |  _  | (_| | |  \\ V /| | | | | || (_) | |_|\n"
    + "     |_| |_|\\__,_|_|   \\_/ |_|_| |_|\\__\\___/  (_)\n"
    + "                                             \n\n";
    /**
     * Stringa del messaggio "Hai perso".
     */
    public static final String LOST =
      "   _   _       _                               _ \n"
    + "  | | | | __ _(_)  _ __   ___ _ __ ___  ___   | |\n"
    + "  | |_| |/ _` | | | '_ \\ / _ \\ '__/ __|/ _ \\  | |\n"
    + "  |  _  | (_| | | | |_) |  __/ |  \\__ \\ (_) | |_|\n"
    + "  |_| |_|\\__,_|_| | .__/ \\___|_|  |___/\\___/  (_)\n"
    + "                  |_|                            \n\n";
  }
