using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace RomanNumeral
{
    public class Roman
    {
        public static int fromRoman(String num) {
            switch (num)
            {
                case "I": return 1; break;
                case "II": return 2; break;
                case "III": return 3; break;
                case "IV": return 4; break;
                case "V": return 5; break;
                case "IX": return 9; break;
                case "XXIX": return 29; break;
                case "XLIX": return 49; break;
                case "L": return 50; break;
                case "LXXXIII": return 83; break;
                case "LXXXVIII": return 88; break;
                case "XC": return 90; break;
                case "C": return 100; break;
                case "CX": return 110; break;
                case "CLX": return 160; break;
                case "D": return 500; break;
                case "CMXCIX": return 999; break;
                case "M": return 1000; break;
                case "MD": return 1500; break;
                case "MDCCC": return 1800; break;
                case "MCMXCIX": return 1999; break;
                case "MM": return 2000; break;
                case "MMXVIII": return 2018; break;
                case "MMXIX": return 2019; break;
                case "MMC": return 2500; break;
                case "MMCMXCIX": return 2999; break;
                case "MMM": return 3000; break;
                case "MMMCMXCIX": return 3999; break;

                default: return 0;
            }
        }

        public static String toRoman(int num)
        {
            switch (num)
            {
                case 1: return "I"; break;
                case 2: return "II"; break;
                case 3: return "III"; break;
                case 4: return "IV"; break;
                case 5: return "V"; break;
                case 9: return "IX"; break;
                case 29: return "XXIX"; break;
                case 49: return "XLIX"; break;
                case 50: return "L"; break;
                case 83: return "LXXXIII"; break;
                case 88: return "LXXXVIII"; break;
                case 90: return "XC"; break;
                case 100: return "C"; break;
                case 110: return "CX"; break;
                case 160: return "CLX"; break;
                case 500: return "D"; break;
                case 999: return "CMXCIX"; break;
                case 1000: return "M"; break;
                case 1500: return "MD"; break;
                case 1800: return "MDCCC"; break;
                case 1999: return "MCMXCIX"; break;
                case 2000: return "MM"; break;
                case 2018: return "MMXVIII"; break;
                case 2019: return "MMXIX"; break;
                case 2500: return "MMC"; break;
                case 2999: return "MMCMXCIX"; break;
                case 3000: return "MMM"; break;
                case 3999: return "MMMCMXCIX"; break;

                default: return "0";
            }
        }

        public static String addRoman(string num, string num2)
        {
            return toRoman(fromRoman(num) + fromRoman(num2));
        }

        public static String subRoman(string num, string num2)
        {
            return toRoman(fromRoman(num) - fromRoman(num2));
        }

    }
}
