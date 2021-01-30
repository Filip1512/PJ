#include <gtest/gtest.h>

class A {

public:

    A(int value): value(value) { }

    bool operator==(const A& lhs) const {
        return lhs.value == value;
    }

private:

    int value;
};

TEST(OperatorTest, test_equality_operator) {
    A a(10);
    A b(10);
    EXPECT_EQ(a, b);
}