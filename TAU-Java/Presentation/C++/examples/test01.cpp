#include <gtest/gtest.h>
#include "Infrastructure/MD5.hpp"

TEST(MD5_Algorithm, test_hash) {
    MD5 hash("content");
    ASSERT_EQ("9a0364b9e99bb480dd25e1f0284c8555", hash.getHash());
}

TEST(MD5_Algorithm, test_two_hashes_equal) {
    MD5 hash1("content");
    MD5 hash2("content");
    ASSERT_EQ(hash2.getHash(), hash1.getHash());
    ASSERT_TRUE(hash1.isEqual(hash2));
    ASSERT_TRUE(hash2.isEqual(hash1));
}