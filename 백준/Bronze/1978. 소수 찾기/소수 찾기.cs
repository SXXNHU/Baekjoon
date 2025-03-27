using System;

class Program
{
    static void Main()
    {
        int n = int.Parse(Console.ReadLine());
        string[] input = Console.ReadLine().Split();
        int count = 0;

        foreach (string num in input)
        {
            int number = int.Parse(num);
            if (IsPrime(number)) count++;
        }

        Console.WriteLine(count);
    }

    static bool IsPrime(int num)
    {
        if (num < 2) return false;
        for (int i = 2; i * i <= num; i++)
        {
            if (num % i == 0) return false;
        }
        return true;
    }
}
