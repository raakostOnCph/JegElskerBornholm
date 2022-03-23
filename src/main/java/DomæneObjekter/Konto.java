package DomæneObjekter;

public class Konto
{
    private String navn;
    private String kode;

    private int saldo;

    public Konto(String navn, String kode, int saldo)
    {
        this.navn = navn;
        this.kode = kode;
        this.saldo = saldo;
    }

    public String getNavn()
    {
        return navn;
    }

    public String getKode()
    {
        return kode;
    }

    public int getSaldo()
    {
        return saldo;
    }

    public int insert(int i)
    {


        if (i > 0) {
            saldo = saldo + i;
        }

        return saldo;
    }

    public int withdraw(int i)
    {


        if (i > 0 && i <= saldo ) {
            saldo = saldo - i;
        }

        return saldo;
    }
}
