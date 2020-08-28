using System;

public class Number {
    // private
    private int dec;
    private string bin;
    private string oct;
    private string hex;

    // public
    public int Dec { get => dec; set { dec = value; decToBin(); } }
    public string Bin { get => bin; set => bin = value; }
    public string Oct { get => oct; set => oct = value; }
    public string Hex { get => hex; set => hex = value; }

    public void decToBin() {
        int num1 = dec;
        int num2 = dec;
        string res = "";
        while (num1 != 0) // what if dec is 0
        {
            num1 = num1/2;
            res = num2%2 + res;
            num2 = num1;
        }

        bin = res;
    }

    public void binToOct() {

    }

    public void octToHex() {

    }

    public void hexToDec() {

    }
}