using System;

class Program {
    static void Main() {
        int n = int.Parse(Console.ReadLine());
        string s = Console.ReadLine();
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += s[i] - '0';
        }
        Console.WriteLine(sum);
    }
}
