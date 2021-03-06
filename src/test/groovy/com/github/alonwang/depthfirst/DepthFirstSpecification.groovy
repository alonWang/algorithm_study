package com.github.alonwang.depthfirst

import spock.lang.Specification

/**
 * @author alonwang* @date 2020/6/15 20:57
 * @detail
 */
class DepthFirstSpecification extends Specification {
    def "test Q130"() {
        expect:
        char[][] myboard = board
        new Q130().solve(myboard)
        myboard == result
        where:
        board                                                                                    | result
        [['X', 'X', 'X', 'X'], ['X', 'O', 'O', 'X'], ['X', 'X', 'O', 'X'], ['X', 'O', 'X', 'X']] | [['X', 'X', 'X', 'X'], ['X', 'X', 'X', 'X'], ['X', 'X', 'X', 'X'], ['X', 'O', 'X', 'X']]
    }
}
