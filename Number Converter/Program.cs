using System;

namespace Number_Converter
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Hello World!");
            Number number = new Number();
            number.Dec = 0;
            Console.WriteLine("Decimal: " + number.Dec + " Binary: " + number.Bin);
        }
    }

    
}
