using System;
using System.Collections.Generic;
using System.Linq;
using System.Security.Policy;
using System.Text;
using System.Threading.Tasks;
using NUnit.Framework;

namespace fromToRoman.Tests
{
    public class RomanTests
    {
        [Test]
        public static void FromTomanTests()
        {
            Roman Roman = new Roman();

            Assert.AreEqual(11, Roman.FromRoman("XI"));
            Assert.AreEqual(60, Roman.FromRoman("LX"));
        }

        [Test]
        public static void ToRomanTests()
        {
            Roman Roman = new Roman();
            Assert.AreEqual("XI", Roman.ToRoman(11));
            Assert.AreEqual("LX", Roman.ToRoman(60));
        }

        [Test]
        public static void TestBoth()
        {
            Roman Roman = new Roman();
            Assert.AreEqual(11, Roman.FromRoman(Roman.ToRoman(11)));
        }
    }
}