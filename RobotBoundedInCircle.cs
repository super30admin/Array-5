using System;
using System.Collections.Generic;
using System.Text;

namespace Array
{
    public class RobotBoundedInCircle
    {
        public bool IsRobotBounded(string instructions)
        {
            if (instructions == null || instructions.Length == 0) return false;

            int[,] direction = new int[,] { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } }; //N,E,S,W
            int x = 0;
            int y = 0;
            int i = 0;

            for (int j = 0; j < instructions.Length; j++)
            {
                char c = instructions[j];
                if (c == 'G')
                {
                    //Console.WriteLine("Inside if " + i);
                    x += direction[i, 0];
                    y += direction[i, 1];
                }
                else if (c == 'R')
                {
                    i = (i + 1) % 4;
                }
                else
                {
                    i = (i + 3) % 4;
                    //Console.WriteLine("inside else " + i);
                }
            }

            return i != 0 || (x == 0 && y == 0);
        }
    }
}
