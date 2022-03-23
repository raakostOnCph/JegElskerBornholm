package DomæneObjekter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KontoTest
{

    Konto konto = new Konto("navn", "1", 100);

    @Test
    void insert()
    {

        assertEquals(200, konto.insert(100));
    }

    @Test
    void insetNegativ()
    {
        assertEquals(100, konto.insert(-100));

    }

    @Test
    void withdaw()
    {
        assertEquals(50, konto.withdraw(50));
    }

    @Test
    void withdrawNegative()
    {
        assertEquals(100, konto.withdraw(-50));

    }

    @Test
    void withdrawAbove()
    {
        assertEquals(100, konto.withdraw(1200));
    }
}