#include <gtest/gtest.h>
#include "Infrastructure/MD5.hpp"

class MD5_Algorithm_FixtureExample : public ::testing::Test {

protected:

    MD5 createHash(std::string value) {
        return MD5(value);
    }

};

TEST_F(MD5_Algorithm_FixtureExample, test_hash) {
    auto hash = createHash("content");
    ASSERT_EQ("9a0364b9e99bb480dd25e1f0284c8555", hash.getHash());
}

TEST_F(MD5_Algorithm_FixtureExample, test_two_hashes_equal) {
    auto hash1 = createHash("content");
    auto hash2 = createHash("content");
    ASSERT_EQ(hash2.getHash(), hash1.getHash());
    ASSERT_TRUE(hash1.isEqual(hash2));
    ASSERT_TRUE(hash2.isEqual(hash1));
}