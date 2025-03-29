using System;

class Program
{
    static void Main()
    {
        while (true)
        {
            string input = Console.ReadLine();
            if (input == "0") break;

            string reversed = ReverseString(input);
            Console.WriteLine(input == reversed ? "yes" : "no");
        }
    }

    static string ReverseString(string s)
    {
        char[] arr = s.ToCharArray();
        Array.Reverse(arr);
        return new string(arr);
    }
}
