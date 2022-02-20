package HW15;

import org.junit.jupiter.api.Test;

import static HW15.Move.*;
import static org.junit.jupiter.api.Assertions.*;

class MoveTest {

    @Test
    void compareMoves() {

        assertEquals(1, ROCK.compareMoves(SCISSORS), "Ножницы не могут бить камень!");
        assertEquals(-1, ROCK.compareMoves(PAPER), "Камень не может бить бумагу!");
        assertEquals(0, ROCK.compareMoves(ROCK), "Почему-то не ничья!");

        assertEquals(1, SCISSORS.compareMoves(PAPER), "Бумага не может бить ножницы!");
        assertEquals(-1, SCISSORS.compareMoves(ROCK), "Ножницы не могут бить камень!");
        assertEquals(0, SCISSORS.compareMoves(SCISSORS), "Почему-то не ничья!");

        assertEquals(1, PAPER.compareMoves(ROCK), "Бумага не может бить камень!");
        assertEquals(-1, PAPER.compareMoves(SCISSORS), "Бумага не может бить ножницы!");
        assertEquals(0, PAPER.compareMoves(PAPER), "Почему-то не ничья!");

    }

    @Test
    void compareMovesNegative() {

        assertNotEquals(false, ROCK.compareMoves(SCISSORS) == 1, "Должен был победить камень!");
        assertNotEquals(false, ROCK.compareMoves(PAPER) == -1, "Должна была победить бумага!");
        assertNotEquals(false, ROCK.compareMoves(ROCK) == 0, "Почему-то не ничья!");

        assertNotEquals(false, SCISSORS.compareMoves(PAPER) == 1, "Должны были победить ножницы!");
        assertNotEquals(false, SCISSORS.compareMoves(ROCK) == -1, "Должен был победить камень!");
        assertNotEquals(false, SCISSORS.compareMoves(SCISSORS) == 0, "Почему-то не ничья!");

        assertNotEquals(false, PAPER.compareMoves(ROCK) == 1, "Должна была победить бумага!");
        assertNotEquals(false, PAPER.compareMoves(SCISSORS) == -1, "Должны были победить ножницы!");
        assertNotEquals(false, PAPER.compareMoves(PAPER) == 0, "Почему-то не ничья!");


    }
}