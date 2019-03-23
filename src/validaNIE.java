
import javax.swing.JOptionPane;

public class validaNIE {

    static final String LETRAS_NIE= "TRWAGMYFPDXBNJZSQVHLCKE";

    static char extraerLetraInicialNIE (String NIE) {
        return NIE.charAt(0);
    }

    static char extraerLetraFinalNIE (String NIE) {
        return NIE.charAt(NIE.length()-1);
    }

    static int extraerNumeroNIE (String NIE) {
        char letraInicial = Character.toUpperCase(extraerLetraInicialNIE(NIE));
        String numeroIncompleto = NIE.substring(1, NIE.length()-1);
        int numeroCompleto = 0;
        if (letraInicial == 'X')
            numeroCompleto = Integer.parseInt(numeroIncompleto);
        if (letraInicial == 'Y')
            numeroCompleto = Integer.parseInt("1" + numeroIncompleto);
        if (letraInicial == 'Z')
            numeroCompleto = Integer.parseInt("2" + numeroIncompleto);
        return numeroCompleto;
    }

    static char calcularLetraNIE (int numerosNIE) {
        return LETRAS_NIE.charAt(numerosNIE % 23);
    }

    static boolean validarNIE (String NIE) {
        if (NIE.length() != 9)
            return false;

        char letraInicial = Character.toUpperCase(extraerLetraInicialNIE(NIE));

        int numeroInicial;
        switch (letraInicial) {
            case 'X':
                numeroInicial = 0;
                break;
            case 'Y':
                numeroInicial = 1;
                break;
            case 'Z':
                numeroInicial = 2;
                break;
            default:
                return false;
        }

        for (int i = 1; i < 8; i++) {
            if (!Character.isDigit(NIE.charAt(i)))
                return false;
        }

        if (!Character.isLetter(NIE.charAt(8)))
            return false;

        char letra = Character.toUpperCase(extraerLetraFinalNIE(NIE));
        int numero = extraerNumeroNIE(NIE);

        if (calcularLetraNIE(numero) == letra)
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
        String NIE = JOptionPane.showInputDialog(null, "Inserte el NIE a validar:");
        boolean valido = validarNIE(NIE);
        if (valido)
            JOptionPane.showMessageDialog(null, "El NIE indicado es válido.");
        else
            JOptionPane.showMessageDialog(null, "El NIE indicado no es válido.");
    }
}