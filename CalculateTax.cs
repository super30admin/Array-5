using System;
using System.Collections.Generic;
using System.Text;

namespace Array
{
    public class CalculateTax
    {
        public double calculatetax(List<List<double>> levels, double salary)
        {
            int i = 0;
            double left = salary;
            double limit = 0;
            double percentage = 0.0;
            double tax = 0;
            
            while(left > 0)
            {
                List<double> level = levels[i];

                limit = level[0];
                percentage = level[1];

                if(limit == null)
                {
                    tax = tax + left * percentage;
                    break;
                }

                double taxableIncome = Math.Min(level[0] - limit, left);
                tax = tax + taxableIncome * percentage;
                limit = level[0];
                left = left - taxableIncome;
                i++;
            }
        }
    }
}
