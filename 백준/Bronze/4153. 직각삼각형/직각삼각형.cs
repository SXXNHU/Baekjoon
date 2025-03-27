using System;

class Program
{
    static void Main()
    {
        while (true)
        {
            string[] input = Console.ReadLine().Split();
            int a = int.Parse(input[0]);
            int b = int.Parse(input[1]);
            int c = int.Parse(input[2]);

            if (a == 0 && b == 0 && c == 0)
                break;

            int[] sides = { a, b, c };
            Array.Sort(sides); // 오름차순 정렬

            if (sides[0] * sides[0] + sides[1] * sides[1] == sides[2] * sides[2])
                Console.WriteLine("right");
            else
                Console.WriteLine("wrong");
        }
    }
}
