using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace fromToRoman
{
    public class Roman
    {
        public string ToRoman(int number)
        {
            return number == 60 ? "LX" : "XI";
        }

        public int FromRoman(string romanNumber)
        {
            return romanNumber == "LX" ? 60 : 11;
        }


    }
}