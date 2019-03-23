import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class validaNIETest {

    @Test
    void extraerLetraInicialNIE() {
        String NIE = "Y1234567X";
        char expresult = 'Y';
        char result = validaNIE.extraerLetraInicialNIE(NIE);
        assertEquals(expresult, result);
    }

    @Test
    void extraerLetraFinalNIE() {
        String NIE = "Y1234567X";
        char expResult = 'X';
        char result = validaNIE.extraerLetraFinalNIE(NIE);
        assertEquals(expResult, result);
    }

    @Test
    void extraerNumeroNIE() {
        String NIE = "Y1234567X";
        int expResult = 11234567;
        int result = validaNIE.extraerNumeroNIE(NIE);
        assertEquals(expResult, result);
    }

    @Test
    void calcularLetraNIE() {
        int nie = 11234567;
        char expResult = 'X';
        char result = validaNIE.calcularLetraNIE(nie);
    }

    @Test
    void validarNIE() {
        String NIE = "Y1111111H";
        boolean expResult = true;
        boolean result = validaNIE.validarNIE(NIE);
        assertEquals(expResult, result);
    }
}