using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using RomanNumeral;

namespace UnitTestRomanNum {
    [TestClass]
    public class UnitTest1 {

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
        public void fromRomanTests_D()
        {
            Assert.AreEqual(1000, Roman.fromRoman("M"));
        }
        [TestMethod]
        public void fromRomanTests_1111()
        {
            Assert.AreEqual(1800, Roman.fromRoman("MDCCC"));
        }




        [TestMethod]
        public void toRomanTests()
        {
            




        }

    }
}
