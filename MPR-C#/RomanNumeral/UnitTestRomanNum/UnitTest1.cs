using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using RomanNumeral;

namespace UnitTestRomanNum {
    [TestClass]
    public class UnitTest1 {

        // testy fromRoman

        [TestMethod]
        public void fromRomanTests_1()
        {
            Assert.AreEqual(1, Roman.fromRoman("I"));
        }
        [TestMethod]
        public void fromRomanTests_2()
        {
            Assert.AreEqual(2, Roman.fromRoman("II"));
        }
        [TestMethod]
        public void fromRomanTests_3()
        {
            Assert.AreEqual(3, Roman.fromRoman("III"));
        }
        [TestMethod]
        public void fromRomanTests_4()
        {
            Assert.AreEqual(4, Roman.fromRoman("IV"));
        }
        [TestMethod]
        public void fromRomanTests_5()
        {
            Assert.AreEqual(5, Roman.fromRoman("V"));
        }
        [TestMethod]
        public void fromRomanTests_9()
        {
            Assert.AreEqual(9, Roman.fromRoman("IX"));
        }
        [TestMethod]
        public void fromRomanTests_29()
        {
            Assert.AreEqual(29, Roman.fromRoman("XXIX"));
        }
        [TestMethod]
        public void fromRomanTests_49()
        {
            Assert.AreEqual(49, Roman.fromRoman("XLIX"));
        }
        [TestMethod]
        public void fromRomanTests_50()
        {
            Assert.AreEqual(50, Roman.fromRoman("L"));
        }
        [TestMethod]
        public void fromRomanTests_83()
        {
            Assert.AreEqual(83, Roman.fromRoman("LXXXIII"));
        }
        [TestMethod]
        public void fromRomanTests_88()
        {
            Assert.AreEqual(88, Roman.fromRoman("LXXXVIII"));
        }
        [TestMethod]
        public void fromRomanTests_90()
        {
            Assert.AreEqual(90, Roman.fromRoman("XC"));
        }

        [TestMethod]
        public void fromRomanTests_100()
        {
            Assert.AreEqual(100, Roman.fromRoman("C"));
        }

        [TestMethod]
        public void fromRomanTests_110()
        {
            Assert.AreEqual(110, Roman.fromRoman("CX"));
        }

        [TestMethod]
        public void fromRomanTests_160()
        {
            Assert.AreEqual(160, Roman.fromRoman("CLX"));
        }

        [TestMethod]
        public void fromRomanTests_500()
        {
            Assert.AreEqual(500, Roman.fromRoman("D"));
        }
        [TestMethod]
        public void fromRomanTests_999()
        {
            Assert.AreEqual(999, Roman.fromRoman("CMXCIX"));
        }
        [TestMethod]
        public void fromRomanTests_1000()
        {
            Assert.AreEqual(1000, Roman.fromRoman("M"));
        }
        [TestMethod]
        public void fromRomanTests_1500()
        {
            Assert.AreEqual(1500, Roman.fromRoman("MD"));
        }
        [TestMethod]
        public void fromRomanTests_1800()
        {
            Assert.AreEqual(1800, Roman.fromRoman("MDCCC"));
        }
        [TestMethod]
        public void fromRomanTests_2000()
        {
            Assert.AreEqual(2000, Roman.fromRoman("MM"));
        }
        [TestMethod]
        public void fromRomanTests_2500()
        {
            Assert.AreEqual(2500, Roman.fromRoman("MMC"));
        }
        [TestMethod]
        public void fromRomanTests_3000()
        {
            Assert.AreEqual(3000, Roman.fromRoman("MMM"));
        }
        [TestMethod]
        public void fromRomanTests_3999()
        {
            Assert.AreEqual(3999, Roman.fromRoman("MMMCMXCIX"));
        }

        // testy toRoman()

        [TestMethod]
        public void toRomanTests_1()
        {
            Assert.AreEqual("I", Roman.toRoman(1));
        }
        [TestMethod]
        public void toRomanTests_2()
        {
            Assert.AreEqual("II", Roman.toRoman(2));
        }
        [TestMethod]
        public void toRomanTests_3()
        {
            Assert.AreEqual("III", Roman.toRoman(3));
        }
        [TestMethod]
        public void toRomanTests_4()
        {
            Assert.AreEqual("IV", Roman.toRoman(4));
        }
        [TestMethod]
        public void toRomanTests_5()
        {
            Assert.AreEqual("V", Roman.toRoman(5));
        }
        [TestMethod]
        public void toRomanTests_9()
        {
            Assert.AreEqual("IX", Roman.toRoman(9));
        }
        [TestMethod]
        public void toRomanTests_29()
        {
            Assert.AreEqual("XXIX", Roman.toRoman(29));
        }
        [TestMethod]
        public void toRomanTests_49()
        {
            Assert.AreEqual("XLIX", Roman.toRoman(49));
        }
        [TestMethod]
        public void toRomanTests_50()
        {
            Assert.AreEqual("L", Roman.toRoman(50));
        }
        [TestMethod]
        public void toRomanTests_83()
        {
            Assert.AreEqual("LXXXIII", Roman.toRoman(83));
        }
        [TestMethod]
        public void toRomanTests_88()
        {
            Assert.AreEqual("LXXXVIII", Roman.toRoman(88));
        }
        [TestMethod]
        public void toRomanTests_90()
        {
            Assert.AreEqual("XC", Roman.toRoman(90));
        }

        [TestMethod]
        public void toRomanTests_100()
        {
            Assert.AreEqual("C", Roman.toRoman(100));
        }

        [TestMethod]
        public void toRomanTests_110()
        {
            Assert.AreEqual("CX", Roman.toRoman(110));
        }

        [TestMethod]
        public void toRomanTests_160()
        {
            Assert.AreEqual("CLX", Roman.toRoman(160));
        }

        [TestMethod]
        public void toRomanTests_500()
        {
            Assert.AreEqual("D", Roman.toRoman(500));
        }
        [TestMethod]
        public void toRomanTests_999()
        {
            Assert.AreEqual("CMXCIX", Roman.toRoman(999));
        }
        [TestMethod]
        public void toRomanTests_1000()
        {
            Assert.AreEqual("M", Roman.toRoman(1000));
        }
        [TestMethod]
        public void toRomanTests_1500()
        {
            Assert.AreEqual("MD", Roman.toRoman(1500));
        }
        [TestMethod]
        public void toRomanTests_1800()
        {
            Assert.AreEqual("MDCCC", Roman.toRoman(1800));
        }
        [TestMethod]
        public void toRomanTests_2000()
        {
            Assert.AreEqual("MM", Roman.toRoman(2000));
        }
        [TestMethod]
        public void toRomanTests_2500()
        {
            Assert.AreEqual("MMC", Roman.toRoman(2500));
        }
        [TestMethod]
        public void toRomanTests_3000()
        {
            Assert.AreEqual("MMM", Roman.toRoman(3000));
        }
        [TestMethod]
        public void toRomanTests_3999()
        {
            Assert.AreEqual("MMMCMXCIX", Roman.toRoman(3999));
        }


        // testy addRoman()

        [TestMethod]
        public void addRomanTests_r1_r1()
        {
            Assert.AreEqual("II", Roman.addRoman("I", "I"));
        }
        [TestMethod]
        public void addRomanTests_r2_r3()
        {
            Assert.AreEqual("V", Roman.addRoman("II", "III"));
        }
        [TestMethod]
        public void addRomanTests_n2_r2()
        {
            Assert.AreEqual("IV", Roman.addRoman(Roman.toRoman(2), "II"));
        }
        [TestMethod]
        public void addRomanTests_n2_n2()
        {
            Assert.AreEqual("IV", Roman.addRoman(Roman.toRoman(2), Roman.toRoman(2)));
        }
        [TestMethod]
        public void addRomanTests_n3999_nr1()
        {
            Assert.AreEqual("IV", Roman.addRoman(Roman.toRoman(3999), Roman.toRoman(Roman.fromRoman("I"))));
        }
        [TestMethod]
        public void addRomanTests_n1000_n1000_n1000_n999()
        {
            Assert.AreEqual(Roman.toRoman(3999), Roman.addRoman("M", Roman.addRoman(Roman.toRoman(1000), Roman.addRoman("M", "CMXCIX"))));
        }

        // testy subRoman()

        [TestMethod]
        public void subRomanTests_n5_n1()
        {
            Assert.AreEqual("IV", Roman.subRoman(Roman.toRoman(5), Roman.toRoman(1)));
        }
        [TestMethod]
        public void subRomanTests_n2_n5()
        {
            Assert.AreEqual("-3", Roman.subRoman(Roman.toRoman(2), Roman.toRoman(5)));
        }

    }
}
