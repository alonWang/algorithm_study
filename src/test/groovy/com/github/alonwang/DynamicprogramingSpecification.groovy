package com.github.alonwang

import com.github.alonwang.dynamicprograming.*
import spock.lang.Specification

class DynamicprogramingSpecification extends Specification {
    def "test wordbreak"() {
        expect:
        new Q139().wordBreak(s, wordDict) == result
        where:
        s                                                                                                                                                         | wordDict                                                                                        | result
        "leetcode"                                                                                                                                                | ["leet", "code"]                                                                                | true
        "catsandog"                                                                                                                                               | ["cats", "dog", "sand", "and", "cat"]                                                           | false
        "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab" | ["a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa"] | false
    }

    def "test Q376"() {
        expect:
        new Q376().wiggleMaxLength(nums as int[]) == result
        where:
        nums                                 | result
        [1, 7, 4, 9, 2, 5]                   | 6
        [1, 17, 5, 10, 13, 15, 10, 5, 16, 8] | 7
        [1]                                  | 1
        [1, 1]                               | 1
        []                                   | 0
    }

    def "test Q1024"() {
        expect:
        new Q1024().videoStitching(clips as int[][], T) == result
        where:
        clips                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 | T  | result
        [[0, 2], [4, 6], [8, 10], [1, 9], [1, 5], [5, 9]]                                                                                                                                                                                                                                                                                                                                                                                                                                                     | 10 | 3
        [[0, 1], [1, 2]]                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      | 5  | -1
        [[0, 4], [2, 8]]                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      | 5  | 2
        [[0, 4], [2, 8]]                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      | 0  | -1
        [[0, 1], [6, 8], [0, 2], [5, 6], [0, 4], [0, 3], [6, 7], [1, 3], [4, 7], [1, 4], [2, 5], [2, 6], [3, 4], [4, 5], [5, 7], [6, 9]]                                                                                                                                                                                                                                                                                                                                                                      | 9  | 3
        [[0, 5], [1, 6], [2, 7], [3, 8], [4, 9], [5, 10], [6, 11], [7, 12], [8, 13], [9, 14], [10, 15], [11, 16], [12, 17], [13, 18], [14, 19], [15, 20], [16, 21], [17, 22], [18, 23], [19, 24], [20, 25], [21, 26], [22, 27], [23, 28], [24, 29], [25, 30], [26, 31], [27, 32], [28, 33], [29, 34], [30, 35], [31, 36], [32, 37], [33, 38], [34, 39], [35, 40], [36, 41], [37, 42], [38, 43], [39, 44], [40, 45], [41, 46], [42, 47], [43, 48], [44, 49], [45, 50], [46, 51], [47, 52], [48, 53], [49, 54]] | 50 | 10
        [[5, 7], [1, 8], [0, 0], [2, 3], [4, 5], [0, 6], [5, 10], [7, 10]]                                                                                                                                                                                                                                                                                                                                                                                                                                    | 5  | 1
    }

    def "test Q44"() {
        expect:
        new Q44().isMatch(s, p) == result
        where:
        s       | p       | result
        "aa"    | "a"     | false
        "acdcb" | "a*c?b" | false
    }

    def "test Q312"() {
        expect:
        new Q312().maxCoins(nums as int[]) == result
        where:
        nums         | result
        [3, 1, 5, 8] | 167
    }

    def "test Q62"() {
        expect:
        new Q62().uniquePaths(m, n) == result
        where:
        m | n | result
        7 | 3 | 28
        1 | 1 | 1
    }

    def "test Q53"() {
        expect:
        new Q53().maxSubArray(nums as int[]) == result
        new Q53().maxSubArray2(nums as int[]) == result
        where:
        nums                            | result
        [-2, 1, -3, 4, -1, 2, 1, -5, 4] | 6
    }

    def "test Q877"() {
        expect:
        new Q877().stoneGame(piles as int[]) == result
        where:
        piles | result
        [5, 3, 4, 5] | true
        [3, 2, 10, 4] | true
        [288, 479, 157, 128, 401, 125, 380, 492, 493, 173, 90, 88, 248, 189, 136, 492, 438, 65, 399, 68, 213, 255, 32, 98, 212, 174, 2, 435, 323, 6, 54, 109, 133, 17, 156, 152, 22, 154, 289, 488, 181, 464, 445, 483, 247, 298, 77, 386, 384, 152, 225, 358, 171, 274, 282, 339, 388, 125, 20, 363, 393, 391, 444, 284, 434, 233, 138, 179, 140, 60, 246, 266, 319, 372, 446, 271, 50, 120, 85, 148, 233, 143, 100, 322, 269, 347, 370, 227, 336, 230, 42, 260, 251, 330, 359, 477, 342, 471, 102, 336, 480, 441, 401, 95, 22, 309, 147, 412, 442, 89, 435, 497, 249, 315, 173, 110, 350, 484, 56, 227, 30, 157, 204, 312, 95, 319, 44, 381, 422, 144, 198, 283, 26, 27, 465, 301, 407, 357, 452, 432, 228, 3, 404, 404, 291, 276, 336, 157, 28, 109, 434, 373, 356, 140, 295, 492, 52, 106, 294, 402, 354, 378, 109, 91, 51, 340, 102, 393, 313, 405, 146, 301, 2, 487, 268, 190, 6, 461, 372, 457, 44, 356, 272, 491, 349, 232, 1, 272, 154, 156, 214, 275, 460, 19, 289, 462, 163, 455, 22, 285, 464, 263, 330, 3, 193, 164, 52, 171, 247, 314, 83, 381, 239, 103, 407, 181, 315, 88, 147, 274, 341, 354, 229, 206, 298, 489, 297, 4, 415, 484, 295, 118, 372, 499, 272, 216, 248, 273, 49, 391, 489, 16, 266, 326, 428, 346, 426, 69, 354, 229, 24, 482, 497, 103, 112, 91, 331, 210, 230, 390, 183, 256, 172, 473, 494, 372, 249, 36, 464, 486, 121, 415, 273, 315, 472, 125, 59, 196, 334, 172, 196, 148, 351, 72, 99, 406, 304, 96, 429, 477, 453, 168, 187, 399, 299, 409, 483, 500, 431, 306, 153, 392, 386, 378, 220, 128, 42, 497, 104, 348, 307, 465, 119, 1, 220, 175, 201, 413, 7, 154, 423, 396, 167, 170, 407, 316, 26, 317, 334, 426, 343, 470, 70, 133, 255, 338, 392, 31, 45, 365, 479, 440, 179, 276, 68, 378, 259, 196, 473, 268, 204, 192, 56, 195, 325, 402, 342, 129, 385, 210, 83, 51, 64, 238, 21, 358, 153, 274, 375, 320, 31, 458, 180, 309, 134, 35, 272, 386, 255, 82, 370, 404, 334, 367, 423, 359, 398, 478, 102, 185, 262, 221, 337, 293, 277, 464, 477, 207, 312, 480, 337, 140, 39, 407, 41, 441, 417, 189, 218, 43, 369, 83, 87, 215, 218, 463, 127, 1, 87, 105, 170, 122, 87, 231, 261, 317, 310, 131, 201, 151, 440, 38, 115, 3, 347, 488, 15, 225, 66, 216, 351, 109, 383, 421, 257, 324, 271, 24, 161, 493, 100, 499, 329, 170, 183, 139, 281, 449, 81, 294, 191, 388, 71, 178, 279, 119, 342, 477, 175, 62, 148, 303, 468, 368, 321, 120, 208, 500, 417, 468, 319, 470, 486, 335, 389, 129, 223, 59, 400, 14, 461, 494, 50, 208, 423, 414, 148, 228, 497, 30] | true
    }
}
